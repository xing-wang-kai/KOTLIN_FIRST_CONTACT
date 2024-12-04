package br.com.catalogo_games.dados

import br.com.catalogo_games.modelo.Plano
import br.com.catalogo_games.modelo.PlanoAssinatura
import br.com.catalogo_games.modelo.PlanoAvulso
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoDTO>(manager, PlanoDTO::class.java) {

    override fun toEntity(objects: Plano): PlanoDTO {
        return if(objects is PlanoAssinatura) {
            PlanoAssinaturaDTO(
                id = objects.id,
                mensalidade = objects.mensalidade,
                jogosIncluidos = objects.jogosIncluidos,
                percentualDescontoReputacao = objects.percentualDescontoReputacao,
                tipo = objects.tipo
            )
        } else{
                PlanoAvulsoDTO(
                    tipo = objects.tipo,
                    id = objects.id
                )
            }
        }

    override fun toModel(entity: PlanoDTO): Plano {
        return if (entity is PlanoAssinaturaDTO){
            PlanoAssinatura(
                id =entity.id,
                tipo = entity.tipo,
                mensalidade = entity.mensalidade,
                jogosIncluidos = entity.jogosIncluidos,
                percentualDescontoReputacao = entity.percentualDescontoReputacao,
            )
        }else{
            PlanoAvulso(
                tipo = entity.tipo,
                id = entity.id
            )
        }
    }
}