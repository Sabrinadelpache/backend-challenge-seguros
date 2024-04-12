package com.challenge.insurance.domain

import com.challenge.insurance.dummyInsuranceEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class InsuranceDataRepositoryTests {

    @Autowired
    private lateinit var repository: InsuranceDataRepository

    @Test
    fun `should save an insurance`() {
        // Given
        val insuranceEntity = dummyInsuranceEntity()

        // When
        val insuranceSaved = repository.save(insuranceEntity)

        // Then
        assertEquals(insuranceEntity, insuranceSaved)
    }

}