package gxc.cloud.service.order.service;

import gxc.cloud.service.order.feign.PaymentFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GongXincheng
 * @date 2020-03-13 01:39
 */
@Service
public class OrderService {

    @Resource
    private PaymentFeign paymentFeign;

    public String info(Integer id) {
        return paymentFeign.infoOk(id);
    }

    public String infoTimeOut(Integer id) {
        return paymentFeign.infoTimeOut(id);
    }
}
