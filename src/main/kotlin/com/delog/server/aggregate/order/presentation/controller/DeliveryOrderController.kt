package com.delog.server.aggregate.order.presentation.controller

import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderDto
import com.delog.server.aggregate.order.presentation.dto.GetDeliveryOrderDto
import com.delog.server.aggregate.order.presentation.mapper.DeliveryOrderMapper
import com.delog.server.aggregate.order.service.DeliveryOrderService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/orders")
class DeliveryOrderController(
    private val deliveryOrderService: DeliveryOrderService,
    private val deliveryOrderMapper: DeliveryOrderMapper
) {

    @PostMapping
    fun createOrder(@Valid @RequestBody request: CreateDeliveryOrderDto): ResponseEntity<GetDeliveryOrderDto> {
        val createdEntity = deliveryOrderService.createOrder(request)
        val response = deliveryOrderMapper.toResponse(createdEntity)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}
