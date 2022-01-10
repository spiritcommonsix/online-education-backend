package com.coc.member.service;

import com.coc.commonutils.ResultData;
import com.coc.member.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author cyx
 * @since 2021-05-11
 */
public interface OrderService extends IService<Order> {
    public ResultData buyCourse(String userId,String courseId);
}
