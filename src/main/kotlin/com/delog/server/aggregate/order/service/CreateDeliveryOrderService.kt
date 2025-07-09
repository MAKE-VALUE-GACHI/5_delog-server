package com.delog.server.aggregate.order.service

import com.delog.server.aggregate.order.business.usecase.CreateDeliveryOrderUseCase
import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.presentation.dto.command.DeliveryOrderCommand
import com.delog.server.aggregate.order.service.port.CreateDeliveryOrderPort
import org.springframework.stereotype.Service

@Service
class CreateDeliveryOrderService(
    private val createDeliveryOrderPort: CreateDeliveryOrderPort
) : CreateDeliveryOrderUseCase {

    override fun createOrder(command: DeliveryOrderCommand): DeliveryOrderEntity {

        val createEntity = DeliveryOrderEntity.createEntity(
            command.title,
            command.price,
            command.count,
            command.peopleNumber,
            command.category,
            command.imageUrl,
            command.description,
            command.willReorder
        )

        return createDeliveryOrderPort.createOrder(createEntity)

    }
}