package com.shengtian.market.controller;

import com.shengtian.market.entity.ServiceDetail;
import com.shengtian.market.entity.ServiceType;
import com.shengtian.market.service.ServiceService;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/service")
public class ServiceController {


    @Autowired
    private ServiceService serviceService;

    @ResponseBody
    @PostMapping(value="/getServiceType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getServiceType(){
        RestResult result = new RestResult();
        List<ServiceType> data = serviceService.getServiceType();
        result.success();
        result.setData(data);
        return result;
    }

    @ResponseBody
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    //public RestResult save(@RequestBody ServiceDetail serviceDetail){
    public RestResult save(@RequestParam String title,@RequestParam String content,@RequestParam Integer serviceTypeId){
        RestResult result = new RestResult();
        ServiceDetail serviceDetail = new ServiceDetail();
        serviceDetail.setServiceTypeId(serviceTypeId);
        serviceDetail.setContent(content);
        serviceDetail.setTitle(title);
        serviceService.save(serviceDetail);
        result.success();
        return result;
    }

    @GetMapping(value="/edit/{serviceType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@PathVariable("serviceType") Integer serviceType,Model model){
        ServiceDetail data = serviceService.getService(serviceType);
        if(data == null){
            data = new ServiceDetail();
            data.setServiceTypeId(serviceType);
        }
        model.addAttribute("data",data);
        return "/service/edit";
    }

    @GetMapping(value="/detail/{serviceType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getService(Model model, @PathVariable("serviceType")Integer serviceType){
        ServiceDetail data = serviceService.getService(serviceType);

        model.addAttribute("data",data);
        return "/service/detail";
    }


}
