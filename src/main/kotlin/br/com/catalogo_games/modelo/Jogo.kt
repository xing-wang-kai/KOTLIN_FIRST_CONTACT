package br.com.catalogo_games.modelo

import com.google.gson.annotations.Expose

class Jogo(
    @Expose
    var titulo: String,
    @Expose
    var capa: String
): Recomendavel {

    var descricao: String? = null
    var preco: Double?= null
    var listOfNotas = mutableListOf<Int>()

    override val media: Double
        get() = listOfNotas.average()

    override fun toString(): String {
        return """
            
            JOGO 
                 - Titulo:      ${this.titulo}
                 - Capa:        ${this.capa}
                 - PRECO:       ${this.preco}
                 - DESCRIPTION: ${this.descricao}
                 - NEDIA        ${this.media}
                 
        """.trimIndent()

    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String): this(titulo, capa){
        this.titulo = titulo
        this.capa = capa
        this.preco = preco
        this.descricao = descricao
    }

    fun createGame(){

    }

    override fun recomendar(nota: Int) {
        listOfNotas.add(nota)
    }
}