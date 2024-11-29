class Jogo(val titulo: String, val capa: String) {

    var descricao: String? = null
    override fun toString(): String {
        return "-----------------------------------------------------------------\n" +
                "Meu Jogo: '\n" +
                "Titulo='$titulo',\n" +
                "Capa='$capa',\n" +
                "Descrição='$descricao'\n" +
                "-----------------------------------------------------------------\n"

    }
}