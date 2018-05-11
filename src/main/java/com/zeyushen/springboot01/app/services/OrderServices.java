package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import com.zeyushen.springboot01.app.mapper.OrderInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactInfoPojoMapper;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import com.zeyushen.springboot01.app.model.OrderInfoPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderServices")
public class OrderServices {
    @Autowired
    GoodsPojoMapper goodsPojoMapper;
    @Autowired
    CustomerInfoPojoMapper customerInfoPojoMapper;
    @Autowired
    PactInfoPojoMapper pactInfoPojoMapper;
    @Autowired
    OrderInfoPojoMapper orderInfoPojoMapper;

    public List<GoodsPojo> getProduct(){ return goodsPojoMapper.getProduct(); }

    public List<CustomerInfoPojo> getCustomer(){return customerInfoPojoMapper.getAllCustomer();}

    public List<PactInfoPojo> getPact(){return pactInfoPojoMapper.getAll();}

    public boolean insert(OrderInfoPojo orderInfoPojo){return orderInfoPojoMapper.insertSelective(orderInfoPojo)==1;}

    public List<Map<String,Object>> getMyOrder(Integer sId){
        List<Map<String,Object>> mapList=new ArrayList<>();
        List<OrderInfoPojo> order=orderInfoPojoMapper.getMyOrder(sId);
        order.forEach(orderInfoPojo -> {
            Map<String,Object> map=new HashMap<>();
            mapList.add(map);

            map.put("oId",orderInfoPojo.getoId());//订单id
            map.put("oAddtime",orderInfoPojo.getoAddtime());//订单创建时间
            map.put("oExecutetime",orderInfoPojo.getoExecutetime());//订单执行时间
            map.put("pId",orderInfoPojo.getpId());//订单对应合同id
            map.put("gId",orderInfoPojo.getgId());//订单产品ID
            map.put("oGnum",orderInfoPojo.getoGnum());//产品数量
            map.put("sellPrice",orderInfoPojo.getSellPrice());//销售单价
            map.put("oMoney",orderInfoPojo.getoMoney());//总销售金额
            map.put("oGprofit",orderInfoPojo.getoGprofit());//销售毛利润
            map.put("oState",orderInfoPojo.getoState());//销售毛利润
        });
        return mapList;
    }



}
