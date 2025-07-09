package com.delog.server.aggregate.order.presentation.controller

import com.delog.server.aggregate.order.business.usecase.CreateDeliveryOrderUseCase
import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderInfoDto
import com.delog.server.aggregate.order.presentation.dto.GetDeliveryOrderInfoDto
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

    private val getDeliveryOrderPort: GetDeliveryOrderPort

) {

    @PostMapping("/api/order")
    fun createOrder(@RequestBody request: CreateDeliveryOrderInfoDto.Request)
    : ResponseEntity<CreateDeliveryOrderInfoDto.Response> {

        val createdEntity = createDeliveryOrderUseCase.createOrder(request.mapToCommand());
        return ResponseEntity.ok(CreateDeliveryOrderInfoDto.Response.mapToResponse(createdEntity));

    }

    @GetMapping("/api/order/{orderId}")
    fun getDeliveryOrder(@PathVariable("orderId") orderId: String)
    : ResponseEntity<GetDeliveryOrderInfoDto.Response> {

        val findOrderInfo = getDeliveryOrderPort.getOrderInfoByOrderId(orderId)
        return ResponseEntity.ok(GetDeliveryOrderInfoDto.Response.mapToResponse(findOrderInfo));

    }

}