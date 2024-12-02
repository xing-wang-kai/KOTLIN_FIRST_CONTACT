package br.com.catalogo_games.utilitarios

import br.com.catalogo_games.modelo.Gamer
import br.com.catalogo_games.modelo.InfoGamerJson

fun InfoGamerJson.createGame(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}