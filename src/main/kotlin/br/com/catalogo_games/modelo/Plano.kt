package br.com.catalogo_games.modelo

abstract class Plano (val tipo: String) {

    var mensalidade: Double = 0.0
    var jogosIncluidos: Int = 0
    var percentualDescontoReputacao: Double = 0.0
    var id: Int = 0

    constructor(tipo: String,
                mensalidade: Double,
                jogosIncluidos: Int,
                percentualDescontoReputacao: Double): this(tipo){

                    this.mensalidade = mensalidade
                    this.jogosIncluidos = jogosIncluidos
                    this.percentualDescontoReputacao = percentualDescontoReputacao

                }

    constructor(tipo: String,
                mensalidade: Double,
                jogosIncluidos: Int,
                percentualDescontoReputacao: Double,
                id: Int): this(tipo){

                    this.mensalidade = mensalidade
                    this.jogosIncluidos = jogosIncluidos
                    this.percentualDescontoReputacao = percentualDescontoReputacao
                    this.id = id
    }

    open fun obterValor(rent: Rent): Double{
        return (rent.jogo.preco?:0.0) * rent.periodo.emDias
    }



}