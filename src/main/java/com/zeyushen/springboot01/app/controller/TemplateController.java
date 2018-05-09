package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.ContractTemplatePojo;
import com.zeyushen.springboot01.app.services.FileServices;
import com.zeyushen.springboot01.app.services.TemplateServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    public TemplateServices templateServices;
    @Autowired
    private FileServices fileServices;

    @RequestMapping("/template.html")
    public ModelAndView getTemplateByTerm(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                          @RequestParam(required = true,defaultValue = "false") Boolean onlyData,
                                          @RequestParam(required=true,defaultValue = "") String ctName){
        ModelAndView mv = new ModelAndView("/pactmanagement/template/template");
        PagingUtil.paging("allTemplate",mv,pageNum,onlyData,()->templateServices.getTemplateByTerm(ctName));
        return mv;
    }

    @RequestMapping("/addTemplate.html")
    public ModelAndView addTemplate(){
        ModelAndView mv=new ModelAndView("/pactmanagement/template/addTemplate");
        return mv;
    }

    @PostMapping("/insert.html")
    public String insertSelective(String ctName, @RequestParam("fileForTemplate") MultipartFile fileForTemplate){
        String path="";
        if(!fileForTemplate.isEmpty()){
            path=fileServices.upload(fileForTemplate,"/template/");
        }
        ContractTemplatePojo templatePojo=new ContractTemplatePojo();
        templatePojo.setCtName(ctName);
        templatePojo.setCtFile(path);
        templateServices.insertSelective(templatePojo);
        return "forward:/template/template.html";
    }

    @RequestMapping("/delete.html")
    @ResponseBody
    public boolean deleteBySId(Integer id){
        return templateServices.deleteById(id);
    }

    @RequestMapping("/getOne")
    public ModelAndView selectById(Integer id){
        ModelAndView mv=new ModelAndView("/pactmanagement/template/alterTemplate");
        ContractTemplatePojo templatePojo=templateServices.selectById(id);
        mv.addObject("templatePojo",templatePojo);
        return mv;
    }

    @PostMapping("/alter.html")
    public String updateById(ContractTemplatePojo templatePojo, @RequestParam("fileForTemplate") MultipartFile fileForTemplate) {
        String path="";
        if(!fileForTemplate.isEmpty()){
            path=fileServices.upload(fileForTemplate,"/template/");
        }
        templatePojo.setCtFile(path);
        templateServices.updateById(templatePojo);
        return "forward:/template/template.html";
    }

    /**
     * 文件预览
     * @param filePath
     * @return
     */
    @RequestMapping("/preview.html")
    public String filePreview(String filePath){
        String htmlFile=fileServices.preview(filePath);
        return "redirect:"+htmlFile;
    }
}
