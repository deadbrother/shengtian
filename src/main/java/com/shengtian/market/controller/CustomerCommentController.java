package com.shengtian.market.controller;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.CustomerCommentContent;
import com.shengtian.market.entity.ServiceDetail;
import com.shengtian.market.entity.ServiceType;
import com.shengtian.market.service.CustomerCommentService;
import com.shengtian.market.service.ServiceService;
import com.shengtian.market.vo.Comment;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value="/customerComment")
public class CustomerCommentController {


    @Autowired
    private CustomerCommentService customerCommentService;

    @ResponseBody
    @GetMapping(value="/listData",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo getList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        PageInfo data = customerCommentService.getList(pageNum,pageSize);
        return data;
    }

    @ResponseBody
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult save(@RequestParam String title, @RequestParam List<MultipartFile> contents){
        RestResult result = new RestResult();
        Comment comment = new Comment();
        comment.setContents(contents);
        comment.setTitle(title);
        customerCommentService.save(comment);
        result.success();
        return result;
    }

    @GetMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(){
        return "/customerComment/edit";
    }

    @GetMapping(value="/detail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getService(Model model, @PathVariable("id")Integer id){
        List<CustomerCommentContent> data = customerCommentService.getDetail(id);
        model.addAttribute("data",data);
        return "/service/detail";
    }


    @GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = customerCommentService.getList(pageNum,pageSize);
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

        return "/customerComment/list";
    }

}
