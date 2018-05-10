package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.ContractTemplatePojo;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import com.zeyushen.springboot01.app.services.FileServices;
import com.zeyushen.springboot01.app.services.PactServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pact")
public class PactController {
    @Autowired
    private PactServices pactServices;
    @Autowired
    private FileServices fileServices;

    @RequestMapping("/pact.html")
    public ModelAndView getPactByTerm(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = true,defaultValue = "false") Boolean onlyData,
                                      @RequestParam(required = true,defaultValue = "") String pTitle,
                                      @RequestParam(required = true,defaultValue = "") String execStatus){
        ModelAndView mv=new ModelAndView("/pactmanagement/pact/pact");
        PagingUtil.paging("allPact",mv,pageNum,onlyData,()->pactServices.getPactByTerm(pTitle,execStatus));
        return mv;
    }

    @RequestMapping("/addPact.html")
    public ModelAndView addPact(){
        List<CustomerInfoPojo> customer=pactServices.getCustomer();
        List<ContractTemplatePojo> template=pactServices.getTemplate();
        ModelAndView mv=new ModelAndView("/pactmanagement/pact/addPact");
        mv.addObject("customer",customer);
        mv.addObject("template",template);
        return mv;
    }

    @PostMapping("/insert.html")
    public String insert(PactInfoPojo pactInfoPojo, @RequestParam("fileForPact") MultipartFile fileForPact,
                         @RequestParam("signingDate") String signingDate,
                         @RequestParam("execDate") String execDate,
                         @RequestParam("endDate") String endDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date signingToDate=null;
        Date execToDate=null;
        Date endToDate=null;
        try {
            signingToDate=sdf.parse(signingDate);
            execToDate=sdf.parse(execDate);
            endToDate=sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String path="";
        if(!fileForPact.isEmpty()){
            path=fileServices.upload(fileForPact,"/pact/");
        }
        pactInfoPojo.setpFilepath(path);
        pactInfoPojo.setpSigningdate(signingToDate);
        pactInfoPojo.setpExecdate(execToDate);
        pactInfoPojo.setpEnddate(endToDate);
        pactServices.insert(pactInfoPojo);
        return "forward:/pact/pact.html";
    }

    @RequestMapping("/getOne")
    public ModelAndView getOnePact(Integer id){
        ModelAndView mv=new ModelAndView("/pactmanagement/pact/alterPact");
        PactInfoPojo pactInfoPojo=pactServices.selectById(id);
        mv.addObject("onePact",pactInfoPojo);
        return mv;
    }

    @RequestMapping("/alter.html")
    public String updateById(PactInfoPojo pactInfoPojo){
        pactServices.updateById(pactInfoPojo);
        return "forward:/pact/pact.html";
    }

    @RequestMapping("/delete.html")
    public String delete(Integer id){
        PactInfoPojo pactInfoPojo=new PactInfoPojo();
        pactInfoPojo.setpExecuteinfo("废弃");
        pactInfoPojo.setpId(id);
        pactServices.updateById(pactInfoPojo);
        return "forward:/pact/pact.html";
    }
}
