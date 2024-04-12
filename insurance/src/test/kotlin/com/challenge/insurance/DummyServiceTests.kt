package com.challenge.insurance

import com.challenge.insurance.controller.request.InsuranceApiRequest
import com.challenge.insurance.controller.response.InsuranceApiDto
import com.challenge.insurance.domain.InsuranceEntity


fun dummyInsuranceApiRequest() = InsuranceApiRequest(
    name = "Insurance Test", category = "VIDA", basePrice = 150.00
)
fun dummyInsuranceEntity(): InsuranceEntity = InsuranceEntity(
        id = 1, name = "Insurance Test", category = "VIDA",
        basePrice = 150.00, taxedPrice = 154.08
)
fun dummyInsuranceApiDto(): InsuranceApiDto = InsuranceApiDto(
        id = 1, name = "Insurance Test", category = "VIDA",
        basePrice = 150.00, taxedPrice = 154.08
)