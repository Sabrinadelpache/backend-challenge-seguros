package com.challenge.insurance.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class InsuranceEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,
    var name: String = "",
    var category: String = "",
    var basePrice: Double = 0.00,
    var taxedPrice: Double = 0.00
)