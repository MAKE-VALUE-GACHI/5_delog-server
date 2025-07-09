package com.delog.server.aggregate.order.service.port

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity

interface CreateDeliveryOrderPort {

    fun createOrder(entity: DeliveryOrderEntity): DeliveryOrderEntity

}
