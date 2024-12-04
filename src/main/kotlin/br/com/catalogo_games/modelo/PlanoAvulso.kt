package br.com.catalogo_games.modelo

class PlanoAvulso(tipo: String): Plano(tipo) {

    constructor(tipo:String, id:Int): this(tipo){
                    this.id = id
                }
    override fun obterValor(rent: Rent): Double {
        var valorOriginal = super.obterValor(rent)

        if (rent.gamer.media > 8){
            println("DISCONTO *--* ")
            valorOriginal -= valorOriginal * 0.1

        }
        return valorOriginal
    }

}
