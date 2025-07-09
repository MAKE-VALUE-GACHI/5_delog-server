package com.delog.server.aggregate.order.domain.entity

import com.delog.server.aggregate.order.domain.FoodType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
class DeliveryOrderEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val orderId: String? = null,

    val menuTitle: String,
    val price: BigDecimal,
    val count: Int = 1,
    val peopleNumber: Int = 1,
    val category: FoodType,
    val imageUrl: String,
    val description: String,
    val willReorder: Boolean = false

) {

    companion object {
        fun createEntity(
            menuTitle: String,
            price: BigDecimal,
            count: Int = 1,
            peopleNumber: Int = 1,
            category: FoodType,
            imageUrl: String,
            description: String,
            willReorder: Boolean = false
        ): DeliveryOrderEntity {
            return DeliveryOrderEntity(
                menuTitle    = menuTitle,
                price        = price,
                count        = count,
                peopleNumber = peopleNumber,
                category     = category,
                imageUrl     = imageUrl,
                description  = description,
                willReorder      = willReorder
            )
        }
    }
}