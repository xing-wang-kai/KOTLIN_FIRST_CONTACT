package br.com.catalogo_games.dados
import br.com.catalogo_games.modelo.Jogo
import javax.persistence.EntityManager

class GamesDAO (manager: EntityManager) : DAO<Jogo, GameDTO>(manager, GameDTO::class.java) {

    override fun toEntity(objects: Jogo): GameDTO{
        return GameDTO(
                        titulo = objects.titulo,
                        capa = objects.capa,
                        preco = objects.preco,
                        descricao = objects.descricao
                    )
    }

    override  fun toModel(entity: GameDTO): Jogo{
        return Jogo(
                    titulo = entity.titulo,
                    capa = entity.capa,
                    preco = entity.preco,
                    descricao = entity.descricao,
                    id = entity.id
            )
    }

}