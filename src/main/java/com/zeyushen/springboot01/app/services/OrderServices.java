package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import com.zeyushen.springboot01.app.mapper.OrderInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactInfoPojoMapper;
import com.zeyushen.springboot01.app.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderServices")
public class OrderServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServices.class);

    @Autowired
    GoodsPojoMapper goodsPojoMapper;
    @Autowired
    CustomerInfoPojoMapper customerInfoPojoMapper;
    @Autowired
    PactInfoPojoMapper pactInfoPojoMapper;
    @Autowired
    OrderInfoPojoMapper orderInfoPojoMapper;
    @Autowired
    StaffServices staffServices;

    public List<GoodsPojo> getProduct() {
        return goodsPojoMapper.getProduct();
    }

    public List<CustomerInfoPojo> getCustomer() {
        return customerInfoPojoMapper.getAllCustomer();
    }

    public List<PactInfoPojo> getPact() {
        return pactInfoPojoMapper.getAll();
    }

    public boolean insert(OrderInfoPojo orderInfoPojo) {
        try {
            if (orderInfoPojo.getcId() == null) {
                return false;
            }
            if (orderInfoPojo.getoExecutetime() == null) {
                return false;
            }
            if (orderInfoPojo.getpId() == null) {
                return false;
            }
            if (orderInfoPojo.getgId() == null || orderInfoPojo.getgId().isEmpty()) {
                return false;
            }
            if (orderInfoPojo.getoGnum() == null) {
                return false;
            }
            if (orderInfoPojo.getSellPrice() == null) {
                return false;
            }

            return orderInfoPojoMapper.insertSelective(orderInfoPojo) == 1;
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return false;
        }
    }

    public List<Map<String, Object>> getMyOrder(Principal user) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<OrderInfoPojo> order = orderInfoPojoMapper.getMyOrder(user.getName());
        order.forEach(orderInfoPojo -> {
            Map<String, Object> map = new HashMap<>();
            mapList.add(map);

            map.put("oId", orderInfoPojo.getoId());//订单id
            map.put("oAddtime", orderInfoPojo.getoAddtime());//订单创建时间
            map.put("oExecutetime", orderInfoPojo.getoExecutetime());//订单执行时间
            map.put("pId", orderInfoPojo.getpId());//订单对应合同id
            map.put("gId", orderInfoPojo.getgId());//订单产品ID
            map.put("oGnum", orderInfoPojo.getoGnum());//产品数量
            map.put("sellPrice", orderInfoPojo.getSellPrice());//销售单价
            map.put("oMoney", orderInfoPojo.getoMoney());//总销售金额
            map.put("oGprofit", orderInfoPojo.getoGprofit());//销售毛利润
            map.put("oState", orderInfoPojo.getoState());//订单状态

            StaffPojo staffPojo = staffServices.selectBySId(orderInfoPojo.getsId());
            map.put("sName", staffPojo.getsTname());//订单创建人
            CustomerInfoPojo customerInfoPojo = customerInfoPojoMapper.selectById(orderInfoPojo.getcId());
            map.put("cName", customerInfoPojo.getcName());//客户
            PactInfoPojo pactInfoPojo = pactInfoPojoMapper.selectById(orderInfoPojo.getpId());
            map.put("PactFilePath", pactInfoPojo.getpFilepath());//合同文件路径
            GoodsPojo goodsPojo = goodsPojoMapper.selectByPrimaryKey(orderInfoPojo.getgId());
            map.put("cost", goodsPojo.getgCosting());//产品成本
        });
        return mapList;
    }


}
