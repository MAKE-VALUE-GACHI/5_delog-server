package com.delog.server.aggregate.order.service

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.persistence.jpa.repository.DeliveryOrderRepository
import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderDto
import com.delog.server.aggregate.order.presentation.mapper.DeliveryOrderMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DeliveryOrderService(
    private val deliveryOrderRepository: DeliveryOrderRepository,
    private val deliveryOrderMapper: DeliveryOrderMapper
) {

    @Transactional
    fun createOrder(request: CreateDeliveryOrderDto): DeliveryOrderEntity {
        val entity = deliveryOrderMapper.toEntity(request)
        return deliveryOrderRepository.save(entity)
    }

}
