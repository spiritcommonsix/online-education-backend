package com.coc.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coc.commonutils.ResultData;
import com.coc.member.entity.Order;
import com.coc.member.mapper.OrderMapper;
import com.coc.member.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author cyx
 * @since 2021-05-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResultData buyCourse(String userId, String courseId) {
        QueryWrapper<Order> orderQueryWrapper=new QueryWrapper<>();
        orderQueryWrapper.eq("user_id",userId);
        orderQueryWrapper.eq("course_id",courseId);
        Order orderInfo = baseMapper.selectOne(orderQueryWrapper);
        if(orderInfo!=null)
            return ResultData.error().message("已经购买，无需重复购买");

        Order order=new Order();
        order.setUserId(userId);
        order.setCourseId(courseId);
        try{
            orderMapper.insert(order);
        }catch (Exception error)
        {
            return ResultData.error().message("余额不足");
        }
        return ResultData.ok().message("购买成功");
    }
}
