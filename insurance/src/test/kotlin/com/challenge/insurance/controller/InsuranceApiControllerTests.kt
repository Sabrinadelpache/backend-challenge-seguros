package com.challenge.insurance.controller

import com.challenge.insurance.dummyInsuranceApiDto
import com.challenge.insurance.dummyInsuranceApiRequest
import com.challenge.insurance.dummyInsuranceEntity
import com.challenge.insurance.service.InsuranceApiService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(InsuranceApiController::class)
class InsuranceApiControllerTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var insuranceService: InsuranceApiService

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `test saveInsurance endpoint`() {
        // Given
        `when`(insuranceService.saveInsurance(dummyInsuranceApiRequest())).thenReturn(dummyInsuranceApiDto())

        // When
        val result = mockMvc.perform(
            post("/insurance")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dummyInsuranceApiRequest()))
        )

        // Then
        result.andExpect(status().isCreated)
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        result.andExpect(jsonPath("\$.id").value(dummyInsuranceEntity().id))
        result.andExpect(jsonPath("\$.name").value(dummyInsuranceEntity().name))
        result.andExpect(jsonPath("\$.category").value(dummyInsuranceEntity().category))
        result.andExpect(jsonPath("\$.basePrice").value(dummyInsuranceEntity().basePrice))
        result.andExpect(jsonPath("\$.taxedPrice").value(dummyInsuranceEntity().taxedPrice))
    }
}