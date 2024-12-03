package br.com.catalogo_games.modelo

import java.time.LocalDate
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String): Recomendavel{
    public var dataNascimento: String? = null
    public var usuario: String? = null
        set(value) {
            field = value
            if(this.idInterno.isNullOrBlank()){
                this.createIdInterno()
            }
        }
    var idInterno: String? = null
        get
        private set

    public val jogosBuscados = mutableListOf<Jogo?>()
    public val listRentGames = mutableListOf<Rent>()
    private val listOfNotas = mutableListOf<Int>()
    public val listOfRecomededGames = mutableListOf<Jogo>()

    public var plano: Plano = PlanoAvulso("BRONZE")

    public var totalAPagar: Double = 0.0
    override val media: Double
        get() = listOfNotas.average()

    constructor(nome:String, email:String, dataNascimento: String, usuario: String):
            this(nome,email){
                this.dataNascimento = dataNascimento ?: null
                this.usuario = usuario ?: null
                this.createIdInterno()
            }

    init {
        if(this.nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome não pode ser em branco")
        }
        this.email = validarEmail()
    }

    override fun recomendar(nota: Int) {
        listOfNotas.add(nota)
    }

    fun recomendarJogo(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        listOfRecomededGames.add(jogo)
    }
    override fun toString(): String {

        listRentGames.forEach{
            totalAPagar += it.valorALuguel
        }
        return """
            Gamer(
                -nome =                '${this.nome}'
                -email =               '${this.email}'
                -dataNascimento =       ${this.dataNascimento}'
                - usuario =             ${this.usuario}
                - idInterno=            ${this.idInterno})
                - Alugados =            ${this.listRentGames}
                - Total A Pagar =       ${this.totalAPagar}
                - Reputação =           ${this.media}
                - JOGOS RECOMENDADOS:   ${this.listOfRecomededGames}
        """.trimIndent()
    }

    fun rendGame(game: Jogo, periodo: Periodo): Rent {
        val rent = Rent(this, game, periodo)
        listRentGames.add(rent)

        return rent
    }
    fun createIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        this.idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9._%+-]+\\.[A-Za-z0-9._%+-]{2,6}$")

        if (regex.matches(email)){
            return email
        }
        else {
            throw IllegalArgumentException("Email é inválido")
        }
    }

    companion object{
        fun criarGamer(leitura: Scanner): Gamer{
            println("Bem vindo ao sistema de busca de Games")
            println("Digite seu nome: ")
            val nome = leitura.nextLine()
            println("Digite seu e-mail: ")
            val email = leitura.nextLine()
            println("Deseja completar o cadastro com data de nascimento e nome de usuário? S/N")
            val opcao = leitura.nextLine()

            if(opcao.equals("S", true)){
                println("Digite sua data de nascimento fnt = dd/mm/aaaa")
                val nascimento = leitura.nextLine()
                println("Digite o nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else{
                return Gamer(nome, email)
            }
        }
    }
}
