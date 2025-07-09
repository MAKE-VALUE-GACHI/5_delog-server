package com.delog.server.aggregate.order.business.usecase

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.presentation.dto.command.DeliveryOrderCommand

interface CreateDeliveryOrderUseCase {

    fun createOrder(command: DeliveryOrderCommand): DeliveryOrderEntity

}
