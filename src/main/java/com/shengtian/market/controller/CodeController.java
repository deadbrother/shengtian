package com.shengtian.market.controller;

import com.shengtian.market.dao.*;
import com.shengtian.market.entity.PlatForm;
import com.shengtian.market.entity.ReviewInfoType;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/code")
public class CodeController {


    @Autowired
    private IndustryCategoryMapper industryCategoryMapper;

    @Autowired
    private MediaTypeMapper mediaTypeMapper;
    @Autowired
    private NewsClassificationMapper newsClassificationMapper;
    @Autowired
    private PlatFormMapper platFormMapper;
    @Autowired
    private QuestionTypeMapper questionTypeMapper;
    @Autowired
    private ReviewInfoTypeMapper reviewInfoTypeMapper;
    @Autowired
    private ServiceTypeMapper serviceTypeMapper;
    @Autowired
    private SourceTypeMapper sourceTypeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping(value="/industryCategory",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getIndustryCategory(){
        RestResult result = new RestResult();
        result.setData(industryCategoryMapper.selectAll());
        result.success();
        return result;
    }

    @GetMapping(value="/mediaType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getMediaType(){
        RestResult result = new RestResult();
        result.setData(mediaTypeMapper.selectAll());
        result.success();
        return result;
    }

    @GetMapping(value="/newsClassification",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getNewsClassification(){
        RestResult result = new RestResult();
        result.setData(newsClassificationMapper.selectAll());
        result.success();
        return result;
    }

    @GetMapping(value="/platForm",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getPlatForm(@RequestParam(value = "mediaTypeId",required = false) Integer mediaTypeId){
        RestResult result = new RestResult();
        List<PlatForm> data;
        if(mediaTypeId != null){
            PlatForm example = new PlatForm();
            example.setMediaTypeId(mediaTypeId);
            data = platFormMapper.select(example);
        }else{
            data = platFormMapper.selectAll();
        }
        result.setData(data);
        result.success();
        return result;
    }

    @GetMapping(value="/questionType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getQuestionType(){
        RestResult result = new RestResult();
        result.setData(questionTypeMapper.selectAll());
        result.success();
        return result;
    }



    @GetMapping(value="/reviewInfoType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getReviewInfoType(@RequestParam("questionTypeId") Integer questionTypeId){
        RestResult result = new RestResult();
        List<ReviewInfoType> data;
        if(questionTypeId != null){
            ReviewInfoType example = new ReviewInfoType();
            example.setQuestionTypeId(questionTypeId);
            data = reviewInfoTypeMapper.select(example);
        }else{
            data = reviewInfoTypeMapper.selectAll();
        }
        result.setData(data);
        result.success();
        return result;
    }


    @GetMapping(value="/serviceType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getServiceType(){
        RestResult result = new RestResult();
        result.setData(serviceTypeMapper.selectAll());
        result.success();
        return result;
    }

    @GetMapping(value="/sourceType",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getSourceType(){
        RestResult result = new RestResult();
        result.setData(sourceTypeMapper.selectAll());
        result.success();
        return result;
    }

    @GetMapping(value="/adYear",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult getAdYear(){
        RestResult result = new RestResult();
        result.setData(articleMapper.customSelectAllAdYear());
        result.success();
        return result;
    }

}
