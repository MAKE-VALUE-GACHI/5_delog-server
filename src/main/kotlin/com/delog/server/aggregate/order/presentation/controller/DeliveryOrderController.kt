package com.delog.server.aggregate.order.presentation.controller

import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderRequest
import com.delog.server.aggregate.order.presentation.dto.GetDeliveryOrderResponse
import com.delog.server.aggregate.order.presentation.dto.UpdateDeliveryOrderRequest
import com.delog.server.aggregate.order.presentation.mapper.DeliveryOrderMapper
import com.delog.server.aggregate.order.service.DeliveryOrderService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun createOrder(@Valid @RequestBody request: CreateDeliveryOrderRequest): ResponseEntity<GetDeliveryOrderResponse> {
        val createdEntity = deliveryOrderService.createOrder(request)
        val response = deliveryOrderMapper.toResponse(createdEntity)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id:Long): ResponseEntity<GetDeliveryOrderResponse> {
        val entity = deliveryOrderService.findOrderById(id)
        val response = deliveryOrderMapper.toResponse(entity)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun getAllOrders(): ResponseEntity<List<GetDeliveryOrderResponse>> {
        val orders = deliveryOrderService.findAllOrders()
        val response = orders.map { deliveryOrderMapper.toResponse(it) }
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id:Long): ResponseEntity<Void> {
        deliveryOrderService.deleteOrder(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateOrder(
        @PathVariable id:Long,
        @Valid @RequestBody request: UpdateDeliveryOrderRequest
    ): ResponseEntity<GetDeliveryOrderResponse> {
        val updatedEntity = deliveryOrderService.updateOrder(id, request)
        val response = deliveryOrderMapper.toResponse(updatedEntity)
        return ResponseEntity.ok(response)
    }
}
