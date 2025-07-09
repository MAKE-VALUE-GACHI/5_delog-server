package com.delog.server.aggregate.order.presentation.dto

import com.delog.server.aggregate.order.domain.FoodType
import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import com.delog.server.aggregate.order.presentation.dto.command.CreateDeliveryOrderCommand
import java.math.BigDecimal

class CreateDeliveryOrderInfoDto {

    data class Request(
        val title: String,
        val price: String,
        val count: Int = 1,
        val peopleNumber: Int = 1,
        val category: FoodType,
        val imageUrl: String = "",
        val description: String = "",
        val willReorder: Boolean = false
    ) {

        fun mapToCommand(): CreateDeliveryOrderCommand =
            CreateDeliveryOrderCommand(
                title = title,
                price = BigDecimal(price),
                count = count,
                peopleNumber = peopleNumber,
                category = category,
                imageUrl = imageUrl,
                description = description,
                willReorder = willReorder
            )
    }

    data class Response(
        val orderId: String?,
        val title: String,
        val price: String,
        val count: Int,
        val peopleNumber: Int,
        val category: FoodType,
        val imageUrl: String,
        val description: String,
        val willReorder: Boolean
    ) {

        companion object {
            fun mapToResponse(entity: DeliveryOrderEntity): Response =
                Response(
                    orderId = entity.orderId,
                    title = entity.menuTitle,
                    price = entity.price.toBigInteger().toString(),
                    count = entity.count,
                    peopleNumber = entity.peopleNumber,
                    category = entity.category,
                    imageUrl = entity.imageUrl,
                    description = entity.description,
                    willReorder = entity.willReorder
                )
        }
    }
}