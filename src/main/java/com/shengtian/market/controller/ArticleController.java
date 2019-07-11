package com.shengtian.market.controller;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.Article;
import com.shengtian.market.service.ArticleService;
import com.shengtian.market.vo.ArticlePageMap;
import com.shengtian.market.vo.ArticleVo;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping(value="/listData",produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo getList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                            @RequestParam(value = "articleType",required = false)Integer articleType,
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
        query.setNewsClassficationId(newsClassficationId);
        query.setPlatFormId(platFormId);
        query.setQuestionTypeId(questionTypeId);
        query.setReviewInfoTypeId(reviewInfoTypeId);
        query.setServiceTypeId(serviceTypeId);
        query.setSourceTypeId(sourceTypeId);
        query.setType(articleType);
        query.setHeadline(headline);
        PageInfo data = articleService.getList(pageNum,pageSize,query);
        return data;
    }

    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult save(@RequestBody ArticleVo article){
        RestResult result = new RestResult();
        articleService.save(article);
        result.success();
        return result;
    }

    @GetMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestParam("articleType") Integer articleType){
        return "/article/"+ ArticlePageMap.getNameByValue(articleType) +"-edit";
    }

    @GetMapping(value="/detail/{type}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getService(Model model,@PathVariable("type")Integer type, @PathVariable("id")Integer id){
        Article data = articleService.getDetail(type,id);
        model.addAttribute("data",data);
        return "/article/detail";
    }


    @GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                        @RequestParam(value = "articleType",required = false)Integer articleType,
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
        query.setNewsClassficationId(newsClassficationId);
        query.setPlatFormId(platFormId);
        query.setQuestionTypeId(questionTypeId);
        query.setReviewInfoTypeId(reviewInfoTypeId);
        query.setServiceTypeId(serviceTypeId);
        query.setSourceTypeId(sourceTypeId);
        query.setType(articleType);
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

        return "/article/"+ ArticlePageMap.getNameByValue(articleType) +"-list";
    }

    @GetMapping(value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(Model model,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,
                       @RequestParam("healine") String headline
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

        return "/article/search-list";
    }


}
