import br.com.catalogo_games.dados.Database
import br.com.catalogo_games.dados.PlanosDAO
import br.com.catalogo_games.modelo.PlanoAssinatura
import br.com.catalogo_games.modelo.PlanoAvulso

fun main(){

    val avulso = PlanoAvulso("BRONZE")
    val prata = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    val ouro = PlanoAssinatura("OURO", 19.90, 5, 0.20)
    val platina = PlanoAssinatura("PLATINA", 29.90, 10, 0.30)
    val diamante = PlanoAssinatura("DIAMANTE", 49.90, 20, 0.50)

    val manager = Database.getEntityManager()

    val planoDAO = PlanosDAO(manager)

    planoDAO.persisteMethod(avulso)
    planoDAO.persisteMethod(prata)
    planoDAO.persisteMethod(ouro)
    planoDAO.persisteMethod(platina)
    planoDAO.persisteMethod(diamante)

    val listOfPlans = planoDAO.getMethod()

    println(listOfPlans)

    manager.close()
}