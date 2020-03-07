package gxc.cloud.service.payment.service;

import gxc.cloud.commons.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:47
 */
public interface PaymentService {


    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);


}
