package br.com.catalogo_games.modelo

import java.time.LocalDate
import java.time.Period

data class Periodo(var dataInicial: LocalDate, var dataFinal: LocalDate){
    val emDias: Int = Period.between(this.dataInicial, this.dataFinal).days
}
