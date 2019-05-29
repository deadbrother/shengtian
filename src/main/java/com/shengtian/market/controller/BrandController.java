package com.shengtian.market.controller;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.Brand;
import com.shengtian.market.entity.ServiceDetail;
import com.shengtian.market.entity.ServiceType;
import com.shengtian.market.service.BrandService;
import com.shengtian.market.service.ServiceService;
import com.shengtian.market.vo.RestResult;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping(value="/brand")
public class BrandController {


    @Autowired
    private BrandService brandService;

    @ResponseBody
    @GetMapping(value="/listData",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo getList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        PageInfo data = brandService.getList(pageNum,pageSize);
        return data;
    }

    @GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = brandService.getList(pageNum,pageSize);
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
        return "/brand/list";
    }


    @ResponseBody
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult save(@RequestBody MultipartFile file){
        RestResult result = new RestResult();
        Brand brand = new Brand();
        try {
            byte[] data;
            data = file.getBytes();
            brandService.save(data);
        }catch (Exception e){
            e.printStackTrace();
            result.unknownError(e.getMessage());
            return result;
        }


        result.success();
        return result;
    }

    @GetMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(){
        return "/brand/edit";
    }
}
