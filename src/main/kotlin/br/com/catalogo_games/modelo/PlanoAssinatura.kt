package br.com.catalogo_games.modelo

class PlanoAssinatura(
    tipo: String,
    mensalidade: Double,
    jogosIncluidos: Int,
    percentualDescontoReputacao: Double,
): Plano(tipo, mensalidade, jogosIncluidos, percentualDescontoReputacao) {


    constructor(
        tipo: String,
        mensalidade: Double,
        jogosIncluidos: Int,
        percentualDescontoReputacao: Double,
        id: Int
    ): this(tipo, mensalidade, jogosIncluidos, percentualDescontoReputacao){

        this.id = id
    }
    override fun obterValor(rent: Rent): Double {

        val totalGamePerMonth = rent.gamer.listRentGames.size

        return if(totalGamePerMonth < this.jogosIncluidos!!){
            0.0
        } else {
            var valorOriginal = super.obterValor(rent)

            if(rent.gamer.media > 8){
                println("DISCONTO *--* ")
                valorOriginal -= valorOriginal * 0.1
            }
            valorOriginal
        }
    }

}