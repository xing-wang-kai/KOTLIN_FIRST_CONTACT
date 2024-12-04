package br.com.catalogo_games.dados

import javax.persistence.*

@Entity
@Table(name="planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoDTO(
    val tipo: String = "Plano Genérico",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
)

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoDTO(
        tipo: String = "plano Avulso",
        id: Int = 0
    ): PlanoDTO(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaDTO(
    tipo: String = "plano assinatura",
    id: Int = 0,
    val mensalidade: Double= 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double = 0.0): PlanoDTO(tipo, id)