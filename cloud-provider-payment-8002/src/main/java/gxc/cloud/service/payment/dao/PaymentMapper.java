package gxc.cloud.service.payment.dao;

import gxc.cloud.commons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:37
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
