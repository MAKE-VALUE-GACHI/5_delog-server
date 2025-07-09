package com.delog.server.aggregate.order.persistence.jpa.repository

import com.delog.server.aggregate.order.domain.entity.DeliveryOrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryOrderRepository : JpaRepository<DeliveryOrderEntity, String> {

}
