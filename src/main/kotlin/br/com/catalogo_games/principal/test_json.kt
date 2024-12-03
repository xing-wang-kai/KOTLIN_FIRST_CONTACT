import br.com.catalogo_games.modelo.*
import br.com.catalogo_games.services.ConsumoAPI
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate


fun main(){

    val restMethod = ConsumoAPI()
    var listOfGamer: List<Gamer> = restMethod.findGamer()
    var listOfjogo: List<Jogo> = restMethod.findGame()

    var index = 0
    listOfGamer.forEach{

        index++
        println("| ---------------------------------------------------------------------------------------------------------------------- |")
        println("| -- Game $index :\n " + it + " -- |")
    }

    var indextwo: Int = 0
    listOfjogo.forEach{
        indextwo++
        println("| ---------------------------------------------------------------------------------------------------------------------- |")
        println("| -- Jogos $indextwo: \n" + it + "-- |")
    }

    println("+++++++++++++++++++++++++++++++++++++++++++++++++++")
    var gameAna = listOfGamer.get(1)

    gameAna.recomendar(9)
    gameAna.recomendar(9)
    gameAna.recomendar(7)
    gameAna.recomendar(8)

    gameAna.plano = PlanoAssinatura("PRATA", 9.90, 3)
    //gameAna.plano = PlanoAvulso("BRONZE")

    var jogo1 = listOfjogo.get(1)
    var jogo2 = listOfjogo.get(2)
    var jogo3 = listOfjogo.get(3)
    var jogo4 = listOfjogo.get(4)
    var jogo5 = listOfjogo.get(6)
    var jogo6 = listOfjogo.get(7)
    var jogo7 = listOfjogo.get(8)
    var jogo8 = listOfjogo.get(9)
    var jogo9 = listOfjogo.get(10)
    var jogo10 = listOfjogo.get(11)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(12))
    val periodo4 = Periodo(LocalDate.now(), LocalDate.now().plusDays(30))
    val periodo5 = Periodo(LocalDate.now(), LocalDate.now().plusDays(9))


    //var gameRented = gameAna.rendGame(jogo1, periodo).also {
    //    println(it)
    //}

    gameAna.rendGame(jogo1, periodo1)
    gameAna.rendGame(jogo2, periodo2)
    gameAna.rendGame(jogo3, periodo3)
    gameAna.rendGame(jogo4, periodo4)
    gameAna.rendGame(jogo5, periodo5)
    gameAna.rendGame(jogo6, periodo5)
    gameAna.rendGame(jogo7, periodo5)
    gameAna.rendGame(jogo8, periodo5)
    gameAna.rendGame(jogo9, periodo5)
    gameAna.rendGame(jogo10, periodo5)

    gameAna.recomendarJogo(jogo1, 7)
    gameAna.recomendarJogo(jogo2, 4)
    gameAna.recomendarJogo(jogo3, 6)
    gameAna.recomendarJogo(jogo4, 8)
    gameAna.recomendarJogo(jogo5, 9)
    gameAna.recomendarJogo(jogo6, 3)
    gameAna.recomendarJogo(jogo7, 4)
    gameAna.recomendarJogo(jogo8, 5)
    gameAna.recomendarJogo(jogo9, 6)
    gameAna.recomendarJogo(jogo10, 7)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gameAna.listOfRecomededGames)

    println(gameAna)

    println(serializacao)

    val arquivo = File("jogosRecomendados.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}