package br.com.catalogo_games.modelo

class InfoGame(val gamer: GamerApiShark) {
    override fun toString(): String{
        return gamer.toString()
    }
}