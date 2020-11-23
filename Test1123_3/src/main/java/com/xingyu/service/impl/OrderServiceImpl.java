package com.xingyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.xingyu.dao.IOrderDao;
import com.xingyu.domain.Orders;
import com.xingyu.domain.Traveller;
import com.xingyu.service.IOrderService;
import com.xingyu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import org.junit.jupiter.api.Order;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Orders> findAll(int pageNum, int pageSize) {

        /**
         * 在service层调用Dao接口之前，使用，第几页，每页多少条
         */

        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders=orderDao.findAll();
        System.out.println(orders.size()+"order的数量");
        for (Orders order : orders) {
            //orderTime是date格式的，展示的是orderTimeStr
            if(order.getOrderTime()!=null){
                String orderTime= Utils.date2String(order.getOrderTime());
                order.setOrderTimeStr(orderTime);
            }
            //orderStatus可以从数据库中查询，但展示的过程中，用到的式orderStatusStr，需要进行一个更新
            //order.getOrderStatus()可能为空
            if(order.getOrderStatus()==null){
                order.setOrderStatusStr("未支付");
            }else if(order.getOrderStatus()==1){
                order.setOrderStatusStr("已支付");
            }else{
                order.setOrderStatusStr("未支付");
            }
        }

        return orders;
    }

    @Override
    public Orders findById(int id) {
        Orders order=orderDao.findById(id);
        //orderTime是date格式的，展示的是orderTimeStr
        if(order.getOrderTime()!=null){
            String orderTime= Utils.date2String(order.getOrderTime());
            order.setOrderTimeStr(orderTime);
        }
        //orderStatus可以从数据库中查询，但展示的过程中，用到的式orderStatusStr，需要进行一个更新
        //order.getOrderStatus()可能为空
        if(order.getOrderStatus()==null){
            order.setOrderStatusStr("未支付");
        }else if(order.getOrderStatus()==1){
            order.setOrderStatusStr("已支付");
        }else{
            order.setOrderStatusStr("未支付");
        }
        if(order.getPayType()!=null){
            if(order.getPayType()==1){
                order.setPayTypeStr("在线支付-微信");
            }else if(order.getPayType()==2){
                order.setPayTypeStr("在线支付-支付宝");
            }
        }
        /**
         * Traveller的TravellerType
         * 1：成人
         * 2：儿童
         */
        List<Traveller> travellers=order.getTravellers();
        if(travellers!=null){
            for(Traveller traveller:travellers){
                if(traveller.getTravellerType()==1){
                    traveller.setTravellerTypeStr("成人");
                }else if(traveller.getTravellerType()==2){
                    traveller.setTravellerTypeStr("儿童");
                }
            }
        }

        //orderTime是date格式的，展示的是orderTimeStr
        if(order.getOrderTime()!=null){
            String orderTime= Utils.date2String(order.getOrderTime());
            order.setOrderTimeStr(orderTime);
        }

        if(order.getProduct().getDepartureTime()!=null){
            String departTime= Utils.date2String(order.getProduct().getDepartureTime());
            order.getProduct().setDepartureTimeStr(departTime);
        }
        return order;
    }
}
