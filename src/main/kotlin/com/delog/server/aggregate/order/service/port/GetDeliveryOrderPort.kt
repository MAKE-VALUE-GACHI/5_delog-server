package com.delog.server.aggregate.order.service.port

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity

interface GetDeliveryOrderPort {

    fun getOrderInfoByOrderId(orderId: String) : DeliveryOrderEntity

}
