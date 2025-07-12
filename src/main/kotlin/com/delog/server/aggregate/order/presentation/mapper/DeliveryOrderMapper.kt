package com.delog.server.aggregate.order.presentation.mapper

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.presentation.dto.CreateDeliveryOrderDto
import com.delog.server.aggregate.order.presentation.dto.GetDeliveryOrderDto
import org.springframework.stereotype.Component

@Component
class DeliveryOrderMapper {

    fun toEntity(dto: CreateDeliveryOrderDto): DeliveryOrderEntity {
        return DeliveryOrderEntity(
            menuName = dto.menuName,
            price = dto.price,
            quantity = dto.quantity,
            peopleCount = dto.peopleCount,
            orderDateTime = dto.orderDateTime,
            category = dto.category,
            imageUrl = dto.imageUrl,
            platform = dto.platform,
            memo = dto.memo,
            rating = dto.rating
        )
    }

    fun toResponse(entity: DeliveryOrderEntity): GetDeliveryOrderDto {
        return GetDeliveryOrderDto(
            id = entity.id,
            menuName = entity.menuName,
            price = entity.price,
            quantity = entity.quantity,
            peopleCount = entity.peopleCount,
            orderDateTime = entity.orderDateTime,
            category = entity.category,
            imageUrl = entity.imageUrl,
            platform = entity.platform,
            memo = entity.memo,
            rating = entity.rating,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }
}
