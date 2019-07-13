package com.shengtian.market.controller;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.Article;
import com.shengtian.market.service.ArticleService;
import com.shengtian.market.vo.ArticlePageMap;
import com.shengtian.market.vo.ArticleVo;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping(value="/listData",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo getList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                            @RequestParam(value = "type",required = false)Integer type,
                            @RequestParam(value = "platFormId",required = false) Integer platFormId,
                            @RequestParam(value = "mediaTypeId",required = false) Integer mediaTypeId,
                            @RequestParam(value = "sourceTypeId",required = false) Integer sourceTypeId,
                            @RequestParam(value = "adYear",required = false) String adYear,
                            @RequestParam(value = "serviceTypeId",required = false) Integer serviceTypeId,
                            @RequestParam(value = "questionTypeId",required = false) Integer questionTypeId,
                            @RequestParam(value = "reviewInfoTypeId",required = false) Integer reviewInfoTypeId,
                            @RequestParam(value = "industryCategoryId",required = false) Integer industryCategoryId,
                            @RequestParam(value = "newsClassficationId",required = false) Integer newsClassficationId,
                            @RequestParam(value = "headline",required = false) String headline){
        Article query = new Article();
        query.setAdYear(adYear);
        query.setIndustryCategoryId(industryCategoryId);
        query.setMediaTypeId(mediaTypeId);
        query.setNewsClassificationId(newsClassficationId);
        query.setPlatFormId(platFormId);
        query.setQuestionTypeId(questionTypeId);
        query.setReviewInfoTypeId(reviewInfoTypeId);
        query.setServiceTypeId(serviceTypeId);
        query.setSourceTypeId(sourceTypeId);
        query.setType(type);
        query.setHeadline(headline);
        PageInfo data = articleService.getList(pageNum,pageSize,query);
        return data;
    }

    @ResponseBody
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult save(@RequestParam(value = "type",required = false)Integer type,
                           @RequestParam(value = "platFormId",required = false) Integer platFormId,
                           @RequestParam(value = "mediaTypeId",required = false) Integer mediaTypeId,
                           @RequestParam(value = "sourceTypeId",required = false) Integer sourceTypeId,
                           @RequestParam(value = "adYear",required = false) String adYear,
                           @RequestParam(value = "serviceTypeId",required = false) Integer serviceTypeId,
                           @RequestParam(value = "questionTypeId",required = false) Integer questionTypeId,
                           @RequestParam(value = "reviewInfoTypeId",required = false) Integer reviewInfoTypeId,
                           @RequestParam(value = "industryCategoryId",required = false) Integer industryCategoryId,
                           @RequestParam(value = "newsClassficationId",required = false) Integer newsClassficationId,
                           @RequestParam(value = "editor",required = false) String editor,
                           @RequestParam(value = "sourceFrom",required = false) String sourceFrom,
                           @RequestParam(value = "content",required = false) String content,
                           @RequestParam(value = "headline",required = false) String headline,
                           @RequestParam(value = "description",required = false) String description,
                           @RequestParam(value="coverFile",required = false) MultipartFile coverFile
                           ){
        ArticleVo article = new ArticleVo(content,editor,sourceFrom,platFormId,mediaTypeId,sourceTypeId,adYear,headline,description,serviceTypeId,questionTypeId,reviewInfoTypeId,industryCategoryId,newsClassficationId,type,coverFile);
        RestResult result = new RestResult();
        articleService.save(article);
        result.success();
        return result;
    }

    @GetMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(Model model,@RequestParam("type") Integer type){
        model.addAttribute("type",type);
        if(type.equals(ArticlePageMap.AD_INTRO.getValue())){
            Article data = articleService.getDetail(type,null);
            if (data == null){
                data = new Article();
            }
            model.addAttribute("data",data);
        }
        return "article/"+ ArticlePageMap.getNameByValue(type) +"-edit";
    }

    @GetMapping(value="/detail/{type}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getService(Model model,@PathVariable("type")Integer type, @PathVariable("id")Integer id){
        Article data = articleService.getDetail(type,id);
        model.addAttribute("data",data);
        return "article/detail";
    }

    @ResponseBody
    @GetMapping(value="/detailData/{type}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getService(@PathVariable("type")Integer type, @PathVariable("id")Integer id){
        RestResult result = new RestResult();
        Article data = articleService.getDetail(type,id);
        result.setData(data);
        result.success();
        return result;
    }


    @GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                        @RequestParam(value = "type",required = false)Integer type,
                       @RequestParam(value = "platFormId",required = false) Integer platFormId,
                       @RequestParam(value = "mediaTypeId",required = false) Integer mediaTypeId,
                       @RequestParam(value = "sourceTypeId",required = false) Integer sourceTypeId,
                       @RequestParam(value = "adYear",required = false) String adYear,
                       @RequestParam(value = "serviceTypeId",required = false) Integer serviceTypeId,
                       @RequestParam(value = "questionTypeId",required = false) Integer questionTypeId,
                       @RequestParam(value = "reviewInfoTypeId",required = false) Integer reviewInfoTypeId,
                       @RequestParam(value = "industryCategoryId",required = false) Integer industryCategoryId,
                       @RequestParam(value = "newsClassficationId",required = false) Integer newsClassficationId){
        Article query = new Article();
        query.setAdYear(adYear);
        query.setIndustryCategoryId(industryCategoryId);
        query.setMediaTypeId(mediaTypeId);
        query.setNewsClassificationId(newsClassficationId);
        query.setPlatFormId(platFormId);
        query.setQuestionTypeId(questionTypeId);
        query.setReviewInfoTypeId(reviewInfoTypeId);
        query.setServiceTypeId(serviceTypeId);
        query.setSourceTypeId(sourceTypeId);
        query.setType(type);
        PageInfo pageInfo = articleService.getList(pageNum,pageSize,query);
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

        return "article/"+ ArticlePageMap.getNameByValue(type) +"-list";
    }

    @GetMapping(value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                       @RequestParam("headline") String headline
                       ){
        Article query = new Article();
        query.setHeadline(headline);
        PageInfo pageInfo = articleService.getList(pageNum,pageSize,query);
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

        return "article/search-list";
    }


}
