package br.com.catalogo_games.modelo

import java.time.LocalDate
import java.time.Period

class Rent(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo

) {

    val valorALuguel: Double = (jogo.preco?:0.0) * periodo.emDias

    override fun toString(): String {
        return """
            
        | ----------------------------------------------------------------------------------------------------------|
        |   ALUGUEL DO JOGO :  ${jogo.titulo}             
        |   ALUGADO POR     :  ${gamer.nome}
        |   DATA INICIAL    :  ${this.periodo.dataInicial}
        |   DATA FINAL      :  ${this.periodo.dataFinal}
        |   VALOR ALUGUEL   :  ${this.valorALuguel}
        | ----------------------------------------------------------------------------------------------------------|
        """.trimIndent()
    }

}