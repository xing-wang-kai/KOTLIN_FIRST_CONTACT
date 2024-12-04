package br.com.catalogo_games.dados

import com.google.gson.annotations.Expose
import javax.persistence.*

@Entity
@Table(name = "jogos")
class GameDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    var id: Int = 0,
    var titulo: String = "Game Title",
    var capa: String = "Game thumb",
    var descricao: String? = null,
    var preco: Double = 0.0
) {

}