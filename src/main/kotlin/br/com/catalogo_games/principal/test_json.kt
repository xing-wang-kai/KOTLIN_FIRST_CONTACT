import br.com.catalogo_games.modelo.*
import br.com.catalogo_games.services.ConsumoAPI
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
    var residentEvil = listOfjogo.get(10)

    gameAna.plano = PlanoAssinatura("PRATA", 9.90, 3)
    // gameAna.plano = PlanoAvulso("BRONZE")

    var jogo2 = listOfjogo.get(2)
    var jogo3 = listOfjogo.get(3)
    var jogo4 = listOfjogo.get(4)
    var jogo5 = listOfjogo.get(5)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(12))
    val periodo4 = Periodo(LocalDate.now(), LocalDate.now().plusDays(30))
    val periodo5 = Periodo(LocalDate.now(), LocalDate.now().plusDays(9))


    //var gameRented = gameAna.rendGame(residentEvil, periodo).also {
    //    println(it)
    //}

    gameAna.rendGame(residentEvil, periodo1)
    gameAna.rendGame(jogo2, periodo2)
    gameAna.rendGame(jogo3, periodo3)
    gameAna.rendGame(jogo4, periodo4)
    gameAna.rendGame(jogo5, periodo5)



    println(gameAna)


}