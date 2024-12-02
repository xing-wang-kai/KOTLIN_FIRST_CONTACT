package br.com.catalogo_games.principal

/**
 * Este programa faz uma solicitação HTTP para a API do CheapShark para buscar informações
 * sobre um jogo específico, utilizando o ID fornecido no endpoint. Ele utiliza a biblioteca
 * HTTP do Java para realizar a requisição e imprimir a resposta em formato JSON no console.
 */

import br.com.catalogo_games.modelo.Gamer
import br.com.catalogo_games.modelo.InfoJogo
import br.com.catalogo_games.modelo.Jogo
import br.com.catalogo_games.services.ConsumoAPI
import transformarEmIdade
import java.util.Scanner

fun main() {

    val leitura: Scanner = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    println("Idade do Gamer: " + gamer.dataNascimento?.transformarEmIdade() + "|")

    do{
        println("Digite o Código do Game: ")
        val busca = leitura.nextLine()

        var infoJogo: InfoJogo = ConsumoAPI().findGame(busca)

        var meuJogo: Jogo? = null

        val resultados = runCatching {
            meuJogo = Jogo(
                infoJogo.info.title,
                infoJogo.info.thumb
            )

            print(meuJogo)
        }

        resultados.onFailure {
            println("Jogo inexistente, tente novamente! ")
        }

        resultados.onSuccess {
            println("Você deseja uma descrição personalizada? S/N")
            val option = leitura.nextLine()

            if(option.equals("S", true)){
                println("insira a discrição personalizada para o Game")
                val description = leitura.nextLine()
                meuJogo?.descricao = description
            }
            else{
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar outro Game? S/N")

        val resposta = leitura.nextLine()

    } while(resposta.equals("S", true))

    println("Jogos Buscados: ")
    println(gamer.jogosBuscados)

    println("\n\nJogos ordenados por Títulos: ")

    gamer.jogosBuscados.sortBy{
       it?.titulo
    }
    gamer.jogosBuscados.forEach{
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("Batman", true) ?: false
    }

    println("Jogos Filtrados")
    print(jogosFiltrados)

    println("deseja escluir algum jogo da lista? (S/N)")

    val sn_exclud = leitura.nextLine()
    if(sn_exclud.equals("S", true)){

        print("informe o id do jogo que deseja remover")
        val gameId = leitura.nextInt()

        gamer.jogosBuscados.removeAt(gameId)
    }


    println("Busca Realizada com sucesso")
}