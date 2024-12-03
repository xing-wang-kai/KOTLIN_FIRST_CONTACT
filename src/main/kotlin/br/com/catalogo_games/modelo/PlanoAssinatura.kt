package br.com.catalogo_games.modelo

class PlanoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogosIncluidos: Int
): Plano(tipo) {

    override fun obterValor(rent: Rent): Double {

        val totalGamePerMonth = rent.gamer.listRentGames.size

        return if(totalGamePerMonth < jogosIncluidos){
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