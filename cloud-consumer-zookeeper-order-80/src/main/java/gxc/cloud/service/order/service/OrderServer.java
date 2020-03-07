package gxc.cloud.service.order.service;

import gxc.cloud.commons.entity.Payment;

/**
 * @author GongXincheng
 * @date 2020-03-07 02:17
 */
public interface OrderServer {
    Payment getPaymentById(Long id);

    void create(Payment payment);
}
