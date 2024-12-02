import br.com.catalogo_games.modelo.InfoJogoJson
import br.com.catalogo_games.modelo.Jogo

fun InfoJogoJson.createJogo(): Jogo {
        return Jogo(
            this.titulo,
            this.capa,
            this.preco.toDouble(),
            this.descricao
        )
}