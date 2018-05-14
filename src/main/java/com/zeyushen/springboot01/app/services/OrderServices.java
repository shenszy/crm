package com.zeyushen.springboot01.app.services;

import com.sun.codemodel.internal.JBlock;
import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import com.zeyushen.springboot01.app.mapper.OrderInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactInfoPojoMapper;
import com.zeyushen.springboot01.app.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.security.Principal;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    UserServices userServices;

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

    public List<Map<String, Object>> getMyOrder(Principal user, String oId, String oState) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (oState == "已审核") {
            oState = "审核";
        }
        //判断权限
        String role = userServices.getRole(user.getName());
        List<OrderInfoPojo> order = null;
        if (role.equals("员工")) {
            order = orderInfoPojoMapper.getMyOrder(user.getName(), oId, oState);
        }
        if (role.equals("经理")) {
            if (oState == null || oState.isEmpty()) {
                oState = null;
            }
            order = orderInfoPojoMapper.getMyCheckOrder(user.getName(), oId, oState);
        }
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


            map.put("approvalSId", userServices.getSId(user.getName()));//经理编号

            StaffPojo staffPojo = staffServices.selectBySId(orderInfoPojo.getsId());
            map.put("sName", staffPojo.getsTname());//订单创建人
            if (orderInfoPojo.getApprovalSid() != null && !orderInfoPojo.getApprovalSid().equals("")) {
                StaffPojo staff = staffServices.selectBySId(orderInfoPojo.getApprovalSid());
                map.put("approvalName", staff.getsTname());//审核人
            } else {
                map.put("approvalName", "");//审核人
            }
            CustomerInfoPojo customerInfoPojo = customerInfoPojoMapper.selectById(orderInfoPojo.getcId());
            map.put("cName", customerInfoPojo.getcName());//客户
            PactInfoPojo pactInfoPojo = pactInfoPojoMapper.selectById(orderInfoPojo.getpId());
            map.put("PactFilePath", pactInfoPojo.getpFilepath());//合同文件路径
            GoodsPojo goodsPojo = goodsPojoMapper.selectByPrimaryKey(orderInfoPojo.getgId());
            map.put("cost", goodsPojo.getgCosting());//产品成本
        });
        return mapList;
    }

    public boolean updateOfState(OrderInfoPojo orderInfoPojo) {
        return orderInfoPojoMapper.updateOfState(orderInfoPojo) == 1;
    }

    /**
     * 所有员工的全部销售额
     */
    public List<Map<String, Object>> getAllStaffSale(Integer year) {
        try {
            List<Map<String, Object>> mapList = orderInfoPojoMapper.getAllStaffSale(year);
            return mapList;
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }


    }

    /**
     * 所有员工的每月销售情况
     */
    public Map<String, Double[]> getAllSaleEveryMonth(Integer year) {
        try {
            List<Map<String, Object>> mapList = orderInfoPojoMapper.getAllStaffMonthSale(year);
            //将不同的员工区分出来
            Map<Object, List<Map<String, Object>>> m = mapList.stream().collect(Collectors.groupingBy(v -> v.get("name")));

            Map<String, Double[]> result = new HashMap<>();
            Integer now_month = Calendar.getInstance().get(Calendar.MONTH);
            if (year != null && year != Calendar.getInstance().get(Calendar.YEAR)) {
                now_month=11;
            }
            Integer finalNow_month = now_month;
            m.forEach((k, v) -> {
                Double[] sal = new Double[12];
                result.put((String) k, sal);
                for (int i = 0; i < finalNow_month + 1; i++) {
                    sal[i] = 0.0;
                }
                v.forEach(vl -> {
                    try {
                        sal[Integer.parseInt((String) vl.get("month")) - 1] = Double.valueOf((Float) vl.get("money"));
                    } catch (Exception e) {
                        LOGGER.error(e.toString());
                    }

                });

            });
            return result;
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }

    public String getStateById(Integer id) {
        return orderInfoPojoMapper.getStateById(id);
    }

    public List<Map<String, Object>> getAllProductSale(Integer year) {
        try {
            return  orderInfoPojoMapper.getAllProductSale(year);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }


    /**
     * 所有产品的每月销售情况
     */
    public Map<String, Double[]> getAllProductEveryMonth(Integer year) {
        try {
            List<Map<String, Object>> mapList = orderInfoPojoMapper.getAllProductMonthSale(year);
            //将不同的产品区分出来
            Map<Object, List<Map<String, Object>>> m = mapList.stream().collect(Collectors.groupingBy(v -> v.get("name")));

            Map<String, Double[]> result = new HashMap<>();
            Integer now_month = Calendar.getInstance().get(Calendar.MONTH);
            if (year != null && year != Calendar.getInstance().get(Calendar.YEAR)) {
                now_month=11;
            }
            Integer finalNow_month = now_month;
            m.forEach((k, v) -> {
                Double[] sal = new Double[12];
                result.put((String) k, sal);
                for (int i = 0; i < finalNow_month + 1; i++) {
                    sal[i] = 0.0;
                }
                v.forEach(vl -> {
                    try {
                        sal[Integer.parseInt((String) vl.get("month")) - 1] = Double.valueOf((Float) vl.get("money"));
                    } catch (Exception e) {
                        LOGGER.error(e.toString());
                    }

                });

            });
            return result;
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }

}
