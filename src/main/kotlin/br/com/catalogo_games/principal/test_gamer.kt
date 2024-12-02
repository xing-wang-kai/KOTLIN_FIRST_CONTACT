import br.com.catalogo_games.modelo.Gamer


fun main(){


    val gamer_1 = Gamer(
        "kaiwang",
        "kaiwang@algumacoisa.com")
    println(gamer_1)
    val gamer_2 = Gamer(
        "judity",
        "judity@email.com",
        "19/09/1990",
        "forbbiden")
    println(gamer_2)

    gamer_2.let {
        it.dataNascimento = "12/12/1900"
        it.usuario = "judityskywalker"
    }
    println(gamer_2)
    gamer_1.let {
        it.dataNascimento = "15/12/1800"
        it.usuario = "kaiwang"
    }
    println(gamer_1)
}