package com.delog.server.aggregate.order.presentation.dto.command

import com.delog.server.aggregate.order.domain.FoodType
import java.math.BigDecimal

data class DeliveryOrderCommand(
    val title: String,
    val price: BigDecimal,
    val count: Int = 1,
    val peopleNumber: Int = 1,
    val category: FoodType,
    val imageUrl: String = "",
    val description: String = "",
    val willReorder: Boolean = false
)