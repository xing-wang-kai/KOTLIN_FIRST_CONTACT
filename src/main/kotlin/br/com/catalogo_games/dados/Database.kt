package br.com.catalogo_games.dados

import br.com.catalogo_games.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Database {
//    fun tryConnection(): Connection? {
//        return try{
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "1234")
//        } catch (e: SQLException){
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }

}