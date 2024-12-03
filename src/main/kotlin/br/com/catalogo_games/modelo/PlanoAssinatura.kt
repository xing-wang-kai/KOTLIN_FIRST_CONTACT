package br.com.catalogo_games.modelo

class PlanoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogosIncluidos: Int
): Plano(tipo) {

    override fun obterValor(rent: Rent): Double {

        val totalGamePerMonth = rent.gamer.listRentGames.size

        return if(totalGamePerMonth <= jogosIncluidos){
            0.0
        } else {
            super.obterValor(rent)
        }
    }

}