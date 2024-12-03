package br.com.catalogo_games.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota:Int)
}