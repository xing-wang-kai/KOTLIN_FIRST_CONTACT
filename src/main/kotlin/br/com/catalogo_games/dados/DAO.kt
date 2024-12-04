package br.com.catalogo_games.dados

import br.com.catalogo_games.modelo.Jogo
import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(protected val manager: EntityManager, protected val entityType: Class<TEntity>) {

    abstract fun toEntity(objects: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getMethod(): List<TModel>{

        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)

        return query.resultList.map{ entity -> toModel(entity) }
    }
    open fun persisteMethod(objects: TModel){
        try {
            val entity = toEntity(objects)
            manager.transaction.begin()
            manager.persist(entity)
            manager.transaction.commit()

            println("jogo salvo com sucesso!!")
        } catch (e: Exception){
            println("OCORREU UM ERROR")
        }
    }

    open fun getByID(id: Int): TModel{
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun deleteByID(id: Int){
        try{

            val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
            query.setParameter("id", id)
            val entity = query.singleResult

            if(entity != null){
                manager.transaction.begin()
                manager.remove(entity)
                manager.transaction.commit()
                println("$id REMOVIDO COM SUCESSO DO BANCO DE DADOS")
            }
            else{
                println("não foi encontrado o id informado $id")
            }

        }catch (e: Exception){
            println("Ocorreu um error")
            println(e.message)
        }
    }
}