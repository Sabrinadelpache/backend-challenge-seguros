package com.challenge.insurance.service

import com.challenge.insurance.controller.request.InsuranceApiRequest
import com.challenge.insurance.controller.response.InsuranceApiDto
import com.challenge.insurance.domain.InsuranceEntity
import com.challenge.insurance.domain.InsuranceDataRepository
import com.challenge.insurance.helpers.calculateTax
import com.challenge.insurance.helpers.getCategoryTaxes
import com.challenge.insurance.helpers.updateInsuranceValues
import org.springframework.stereotype.Service
import java.util.*

@Service
class InsuranceApiService(
    val insuranceRepository: InsuranceDataRepository
) {

    fun saveInsurance(insuranceData: InsuranceApiRequest): InsuranceApiDto {
        val insuranceTaxes = getCategoryTaxes(insuranceData.category)

        val taxedPrice =  calculateTax(insuranceData.basePrice, insuranceTaxes)

        val savedInsurance =  insuranceRepository.save(
            InsuranceEntity(name = insuranceData.name, category = insuranceData.category,
            basePrice = insuranceData.basePrice, taxedPrice = taxedPrice))

        return InsuranceApiDto(id = savedInsurance.id,
            name = savedInsurance.name,
            category = savedInsurance.category,
            basePrice = savedInsurance.basePrice,
            taxedPrice = savedInsurance.taxedPrice)
    }


    //code refactored with ChatGPT
    fun updateInsurance(id: Long, insuranceData: InsuranceApiRequest): InsuranceApiDto {
        val foundInsurance = insuranceRepository.findById(id)
            .orElseThrow { NoSuchElementException("Insurance with id $id not found") }

        // Update insurance properties with new data
        updateInsuranceValues(foundInsurance, insuranceData)

        // Save and return the updated insurance
        val updatedInsurance = insuranceRepository.save(foundInsurance)
        return InsuranceApiDto(id = updatedInsurance.id,
            name = updatedInsurance.name,
            category = updatedInsurance.category,
            basePrice = updatedInsurance.basePrice,
            taxedPrice = updatedInsurance.taxedPrice)
    }

}

