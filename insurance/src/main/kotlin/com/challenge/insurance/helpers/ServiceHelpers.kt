package com.challenge.insurance.helpers

import com.challenge.insurance.controller.request.InsuranceApiRequest
import com.challenge.insurance.domain.InsuranceEntity

fun getCategoryTaxes(category: String): List<Double> {
        return when(category) {
            "VIDA" -> listOf(0.01, 0.022, 0.00)
            "AUTO" -> listOf(0.055, 0.04, 0.01)
            "VIAGEM" -> listOf(0.02, 0.04, 0.01)
            "RESIDENCIAL" -> listOf(0.04, 0.0, 0.03)
            "PATRIMONIAL" -> listOf(0.05, 0.03, 0.00)
            else -> throw RuntimeException("Invalid insurance")
        }
    }

    fun calculateTax(
        basePrice: Double, taxes: List<Double>)
            : Double = basePrice + (basePrice * taxes[0]) + (basePrice * taxes[1]) + (basePrice * taxes[2])

    //code refactored with ChatGPT
    fun updateInsuranceValues(oldInsuranceInfo: InsuranceEntity, newInsuranceInfo: InsuranceApiRequest): InsuranceEntity {
        oldInsuranceInfo.apply {
            name = newInsuranceInfo.name
            category = newInsuranceInfo.category
            //caso exista um valor para a propriedade "preco_base" o valor é atualizado e o valor de preco_tarifado é atualizado
            basePrice = if (newInsuranceInfo.basePrice.isNaN()) basePrice else {
                taxedPrice = calculateTax(basePrice, getCategoryTaxes(category))
                newInsuranceInfo.basePrice
            }
        }
        return oldInsuranceInfo
    }