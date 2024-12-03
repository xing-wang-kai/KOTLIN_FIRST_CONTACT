package br.com.catalogo_games.modelo

abstract class Plano (val tipo: String) {

    open fun obterValor(rent: Rent): Double{
        return (rent.jogo.preco?:0.0) * rent.periodo.emDias
    }

}