package com.challenge.insurance.controller.response

import com.fasterxml.jackson.annotation.JsonProperty

data class InsuranceApiDto(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("nome")
    val name: String,
    @JsonProperty("categoria")
    val category: String,
    @JsonProperty("preco_base")
    val basePrice: Double,
    @JsonProperty("preco_tarifado")
    val taxedPrice: Double
)

