package com.challenge.insurance.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceDataRepository: JpaRepository<InsuranceEntity, Long>