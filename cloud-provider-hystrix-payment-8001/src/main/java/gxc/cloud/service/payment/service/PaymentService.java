package gxc.cloud.service.payment.service;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:47
 */
public interface PaymentService {

    /**
     * 测试 Hystrix
     */
    String infoOk(Integer id);

    /**
     * 测试 Hystrix
     */
    String infoTimeOut(Integer id);
}
