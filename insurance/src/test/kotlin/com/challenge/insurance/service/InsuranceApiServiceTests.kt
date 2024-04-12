package com.challenge.insurance.service

import com.challenge.insurance.domain.InsuranceEntity
import com.challenge.insurance.domain.InsuranceDataRepository
import com.challenge.insurance.dummyInsuranceApiRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InsuranceApiServiceTests {

	private var insuranceRepository: InsuranceDataRepository = mock()
	private var insuranceApiService: InsuranceApiService = InsuranceApiService(insuranceRepository)

	@Test
	fun testSaveInsurance() {
		// Given
		val insuranceDataRequest = dummyInsuranceApiRequest()
		val expectedInsuranceEntity = InsuranceEntity(
			id = 0,
			name = insuranceDataRequest.name,
			category = insuranceDataRequest.category,
			basePrice = insuranceDataRequest.basePrice,
			taxedPrice = 154.8
		)

		`when`(insuranceRepository.save(any())).thenReturn(expectedInsuranceEntity)

		// When
		val savedInsuranceEntity = insuranceApiService.saveInsurance(insuranceDataRequest)

		// Then
		verify(insuranceRepository).save(expectedInsuranceEntity)
		assertEquals(0, savedInsuranceEntity.id)
		assertEquals(insuranceDataRequest, savedInsuranceEntity)
		assertEquals(154.8, savedInsuranceEntity.taxedPrice)
		verify(insuranceRepository, times(1)).save(any())
		verify(insuranceRepository, times(0)).findById(any())
	}
}
