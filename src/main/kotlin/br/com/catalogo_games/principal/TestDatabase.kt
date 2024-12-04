package br.com.catalogo_games.principal

import br.com.catalogo_games.dados.Database
import br.com.catalogo_games.dados.GamesDAO
import br.com.catalogo_games.modelo.Jogo

fun main(){

    val manager = Database.getEntityManager()
    val gamesDao = GamesDAO(manager)

    val jogo = Jogo("novos contos genéricos", "nothaveone", 3.99, "novos contos genericos")

    gamesDao.persisteMethod(jogo)

    var singleGame = gamesDao.getByID(23)
    println(singleGame)

    gamesDao.deleteByID(23)

    val listGame: List<Jogo> =gamesDao.getMethod()
    println(listGame)

    manager.close()
}