package com.delog.server.aggregate.order.presentation.controller

import com.delog.server.aggregate.order.business.usecase.CreateDeliveryOrderUseCase
import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderInfoDTO
import com.delog.server.aggregate.order.presentation.dto.GetDeliveryOrderInfoDTO
import com.delog.server.aggregate.order.service.port.GetDeliveryOrderPort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DeliveryOrderController(
    private val createDeliveryOrderUseCase: CreateDeliveryOrderUseCase,

    private val getDevliveryOrderPort: GetDeliveryOrderPort
) {

    @PostMapping("/api/order")
    fun createOrder(@RequestBody request: CreateDeliveryOrderInfoDTO.Request): ResponseEntity<CreateDeliveryOrderInfoDTO.Response> {

        val createdEntity = createDeliveryOrderUseCase.createOrder(request.mapToCommand());
        return ResponseEntity.ok(CreateDeliveryOrderInfoDTO.Response.mapToResponse(createdEntity));

    }

    @GetMapping("/api/order/{orderId}")
    fun getDeliveryOrder(@PathVariable("orderId") orderId: String): ResponseEntity<GetDeliveryOrderInfoDTO.Response> {

        val findOrderInfo = getDevliveryOrderPort.getOrderInfoByOrderId(orderId)
        return ResponseEntity.ok(GetDeliveryOrderInfoDTO.Response.mapToResponse(findOrderInfo));

    }

}