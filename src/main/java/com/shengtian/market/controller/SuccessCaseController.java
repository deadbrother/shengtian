package com.shengtian.market.controller;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.SuccessDetail;
import com.shengtian.market.service.SuccessService;
import com.shengtian.market.vo.RestResult;
import com.shengtian.market.vo.SuccessCaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/successCase")
public class SuccessCaseController {


    @Autowired
    private SuccessService successService;

    @ResponseBody
    @GetMapping(value="/listData",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo getList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        PageInfo result = successService.getList(pageNum,pageSize);
        return result;
    }

    @GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,Model model){
        PageInfo pageInfo = successService.getList(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "/successCase/list";
    }

    @ResponseBody
    @PostMapping(value="/save")
    //public RestResult save(@RequestBody SuccessCaseVo successCaseVo){
    public RestResult save(@RequestParam MultipartFile casePic,@RequestParam MultipartFile customerLogo,@RequestParam String customerName,@RequestParam String caseDesc,
                    @RequestParam String industry,@RequestParam String  content,@RequestParam String title
                ){
        RestResult result = new RestResult();
        SuccessCaseVo successCaseVo = new SuccessCaseVo();
        successCaseVo.setCasePic(casePic);
        successCaseVo.setCustomerLogo(customerLogo);
        successCaseVo.setCustomerName(customerName);
        successCaseVo.setCaseDesc(caseDesc);
        successCaseVo.setContent(content);
        successCaseVo.setIndustry(industry);
        successCaseVo.setTitle(title);
        successService.save(successCaseVo);
        result.success();
        return result;
    }

    @GetMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(){
        return "/successCase/edit";
    }

    @GetMapping(value="/detail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getService(Model model, @PathVariable("id")Integer id){
        SuccessDetail data = successService.getDetail(id);
        model.addAttribute("data",data);
        return "/successCase/detail";
    }
}
