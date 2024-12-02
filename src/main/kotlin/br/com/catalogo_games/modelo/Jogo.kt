package br.com.catalogo_games.modelo

class Jogo(var titulo: String, var capa: String) {

    var descricao: String? = null
    var preco: Double?= null

    override fun toString(): String {
        return """
            JOGO - Titulo:      ${this.titulo}
                 - Capa:        ${this.capa}
                 - PRECO:       ${this.preco}
                 - DESCRIPTION: ${this.descricao}
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
}