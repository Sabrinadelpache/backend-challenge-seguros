package com.challenge.insurance.controller

import com.challenge.insurance.controller.request.InsuranceApiRequest
import com.challenge.insurance.service.InsuranceApiService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus.CREATED

@RestController("/insurance")
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class InsuranceApiController(
    private val insuranceService: InsuranceApiService
) {

    @ResponseStatus(code = CREATED)
    @PostMapping
    fun saveInsurance(
        @RequestBody insuranceData :InsuranceApiRequest
    ) = insuranceService.saveInsurance(insuranceData)

    @PutMapping("/{id}")
    fun updateInsurance(
        @PathVariable("id") id: Long,
        @RequestBody insuranceData :InsuranceApiRequest
    ) =  insuranceService.updateInsurance(id, insuranceData)
}