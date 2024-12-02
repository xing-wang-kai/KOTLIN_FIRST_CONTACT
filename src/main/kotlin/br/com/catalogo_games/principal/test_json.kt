import br.com.catalogo_games.modelo.Gamer
import br.com.catalogo_games.modelo.Jogo
import br.com.catalogo_games.modelo.Periodo
import br.com.catalogo_games.modelo.Rent
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

    var game2 = listOfGamer.get(2)
    var jogo2 = listOfjogo.get(2)
    var jogo3 = listOfjogo.get(3)
    var jogo4 = listOfjogo.get(4)
    var jogo5 = listOfjogo.get(5)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))

    var gameRented = gameAna.rendGame(residentEvil, periodo).also {
        println(it)
    }

    gameAna.rendGame(jogo2, periodo)
    gameAna.rendGame(jogo3, periodo)
    gameAna.rendGame(jogo4, periodo)
    gameAna.rendGame(jogo5, periodo)

    println(gameAna)


}