package com.delog.server.aggregate.order.service

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.persistence.jpa.repository.DeliveryOrderRepository
import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderDto
import com.delog.server.aggregate.order.presentation.mapper.DeliveryOrderMapper
import jakarta.persistence.EntityNotFoundException
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

    fun findOrderById(id:Long): DeliveryOrderEntity {
        return deliveryOrderRepository.findById(id)
            .orElseThrow{ EntityNotFoundException("해당 ID의 주문을 찾을 수 없습니다: $id") }
    }

    fun findAllOrders():List<DeliveryOrderEntity> {
        return deliveryOrderRepository.findAll()
    }

}
