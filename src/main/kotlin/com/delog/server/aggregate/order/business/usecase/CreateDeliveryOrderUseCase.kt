package com.delog.server.aggregate.order.business.usecase

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.presentation.dto.command.CreateDeliveryOrderCommand

interface CreateDeliveryOrderUseCase {

    fun createOrder(command: CreateDeliveryOrderCommand): DeliveryOrderEntity

}
