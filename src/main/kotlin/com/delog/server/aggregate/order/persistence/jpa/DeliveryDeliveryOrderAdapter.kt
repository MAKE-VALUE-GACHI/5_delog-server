package com.delog.server.aggregate.order.persistence.jpa

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.persistence.jpa.repository.DeliveryOrderRepository
import com.delog.server.aggregate.order.service.port.CreateDeliveryOrderPort
import com.delog.server.aggregate.order.service.port.GetDeliveryOrderPort
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class DeliveryDeliveryOrderAdapter(
    private val deliveryOrderRepository: DeliveryOrderRepository
) : CreateDeliveryOrderPort, GetDeliveryOrderPort {

    override fun createOrder(entity: DeliveryOrderEntity): DeliveryOrderEntity {

        val createdEntity = deliveryOrderRepository.save(entity);
        return createdEntity;
    }

    override fun getOrderInfoByOrderId(orderId: String): DeliveryOrderEntity {
        return deliveryOrderRepository.findById(orderId)
            .orElseThrow {
                EntityNotFoundException("해당 하는 id로 된 엔티티 data가 없습니다. : $orderId")
            }
    }
}
