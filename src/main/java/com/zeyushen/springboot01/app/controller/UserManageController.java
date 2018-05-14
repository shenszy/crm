package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.User;
import com.zeyushen.springboot01.app.services.StaffServices;
import com.zeyushen.springboot01.app.services.UserServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/userManage")
public class UserManageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManageController.class);
    @Autowired
    private StaffServices staffServices;
    @Autowired
    private UserServices userServices;

    @RequestMapping("/user.html")
    public ModelAndView index(@RequestParam(defaultValue = "false") Boolean onlyData,
                              @RequestParam(defaultValue = "1") Integer pageNum) {
      // List<Map<String,Object>> mapList =  userServices.getAll();
        ModelAndView mv = new ModelAndView("/filemanagement/userManage/user");

        PagingUtil.paging("allUser", mv, pageNum, onlyData, () -> userServices.getAll());

        return mv;
    }

    @GetMapping("/addUser.html")
    public ModelAndView addHtml() {
        ModelAndView mv = new ModelAndView("/filemanagement/userManage/addUser");
        mv.addObject("staffs",staffServices.getAllStaff());
        return mv;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public boolean add(User user) {
        return userServices.addUser(user);
    }

    @GetMapping("/update.html")
    public ModelAndView updateHtml(Integer id) {

        User user = userServices.getUser(id);
        ModelAndView mv = new ModelAndView("/filemanagement/userManage/updateUser");
        mv.addObject("user",user);
        mv.addObject("staffs",staffServices.getAllStaff());

        return mv;
    }
    @PostMapping("/update")
    @ResponseBody
    public boolean update(User user) {
        return  userServices.alert(user);
        }

    @GetMapping("/delete")
    public ModelAndView delete() {
        return new ModelAndView("/filemanagement/userManage/updateUser");
    }
}
