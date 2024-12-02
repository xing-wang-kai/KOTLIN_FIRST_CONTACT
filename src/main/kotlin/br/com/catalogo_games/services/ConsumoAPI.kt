package br.com.catalogo_games.services

import br.com.catalogo_games.modelo.*
import br.com.catalogo_games.utilitarios.createGame
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import createJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

class ConsumoAPI {

    private fun generalRequest(url: String): HttpResponse<String>? {

        val client: HttpClient = HttpClient.newHttpClient()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        return response
    }

    fun findGame(id: String): InfoJogo{

        val apiAddress: String = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val response = generalRequest(apiAddress)

        val json = response?.body()

        val gson = Gson()
        val infoJogo = gson.fromJson( json, InfoJogo::class.java)

        return infoJogo
    }

    fun findGamer(): List<Gamer> {

        val apiAddress: String = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val response = generalRequest(apiAddress)

        val json = response?.body()

        val gson = Gson()

        val listGamerProps = object: TypeToken<List<InfoGamerJson>>(){}.type
        val listGamer: List<InfoGamerJson> = gson.fromJson( json, listGamerProps)

        val listAllGamer: List<Gamer> = listGamer.map {
                infoGameJson -> infoGameJson.createGame()
        }

        return listAllGamer
    }

    fun findGame(): List<Jogo>{
        val apiAddress: String = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val response = generalRequest(apiAddress)

        val json = response?.body()

        val gson = Gson()

        val listJogoProps = object: TypeToken<List<InfoJogoJson>>(){}.type
        val listGame: List<InfoJogoJson> = gson.fromJson( json, listJogoProps)

        println("***" + listGame)

        val listAllGame: List<Jogo> = listGame.map {
                item -> item.createJogo()
        }

        return listAllGame

    }

}