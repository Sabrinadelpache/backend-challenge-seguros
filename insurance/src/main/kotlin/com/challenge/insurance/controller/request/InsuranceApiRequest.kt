package com.challenge.insurance.controller.request

import com.fasterxml.jackson.annotation.JsonProperty

data class InsuranceApiRequest(
    @JsonProperty("nome")
    val name: String,
    @JsonProperty("categoria")
    val category: String,
    @JsonProperty("preco_base")
    val basePrice: Double
)
