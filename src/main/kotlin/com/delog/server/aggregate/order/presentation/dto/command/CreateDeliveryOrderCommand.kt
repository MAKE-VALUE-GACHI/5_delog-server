package com.delog.server.aggregate.order.presentation.dto.command

import com.delog.server.aggregate.order.domain.FoodType
import java.math.BigDecimal
import java.math.BigInteger

data class CreateDeliveryOrderCommand(
    val title: String,
    val price: BigDecimal,
    val count: Int = 1,
    val peopleNumber: Int = 1,
    val category: FoodType,
    val imageUrl: String = "",
    val description: String = "",
    val willReorder: Boolean = false
) {

    init {

        require(price.scale() <= 0) {
            "해당 금액은 소수점이 들어와있습니다. : $price"
        }

        val priceInt = price.toBigIntegerExact()

        val valid = listOf(
            BigInteger.valueOf(100),
            BigInteger.valueOf(1_000),
            BigInteger.valueOf(10_000),
            BigInteger.valueOf(100_000),

        ).any { divisor ->
            priceInt % divisor == BigInteger.ZERO
        }

        require(valid) {
            "가격은 100보다 크고 10의 배수여야 합니다. : $priceInt"
        }
        TODO(" 가격 관련 test 작성")
    }
}
