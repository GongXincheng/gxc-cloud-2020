package gxc.cloud.service.payment.service.impl;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.service.payment.service.PaymentService;
import gxc.cloud.service.payment.dao.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:47
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
