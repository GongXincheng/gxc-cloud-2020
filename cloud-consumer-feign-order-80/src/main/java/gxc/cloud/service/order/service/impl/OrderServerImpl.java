package gxc.cloud.service.order.service.impl;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import gxc.cloud.service.order.feign.PaymentFeign;
import gxc.cloud.service.order.service.OrderServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author GongXincheng
 * @date 2020-03-07 02:17
 */
@Slf4j
@Service
public class OrderServerImpl implements OrderServer {

    @Resource
    private PaymentFeign paymentFeign;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentFeign.getPaymentById(id).getData();
    }

    @Override
    public void create(Payment payment) {
        ServerResponse serverResponse = paymentFeign.create(payment);
        if (serverResponse.isSuccess()) {
            log.info("添加成功");
        }
    }

    @Override
    public Map<String, Object> discovery() {
        return paymentFeign.discovery().getData();
    }
}
