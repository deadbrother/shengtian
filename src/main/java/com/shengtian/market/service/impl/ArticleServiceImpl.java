package com.shengtian.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shengtian.market.dao.ArticleMapper;
import com.shengtian.market.entity.Article;
import com.shengtian.market.service.ArticleService;
import com.shengtian.market.service.LongDataService;
import com.shengtian.market.vo.ArticlePageMap;
import com.shengtian.market.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private LongDataService longDataService;

    @Override
    public PageInfo getList(Integer pageNum, Integer pageSize, Article query) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Article.class);
        Example.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(query.getHeadline())){
            criteria.andLike(Article.HEADLINE,"%" + query.getHeadline() + "%");
        }
        if(query.getServiceTypeId() != null){
            criteria.andEqualTo(Article.SERVICETYPEID,query.getServiceTypeId());
        }
        if(query.getAdYear() != null){
            criteria.andEqualTo(Article.ADYEAR,query.getAdYear());
        }
        if(query.getIndustryCategoryId() != null){
            criteria.andEqualTo(Article.INDUSTRYCATEGORYID,query.getIndustryCategoryId());
        }
        if(query.getMediaTypeId() != null){
            criteria.andEqualTo(Article.MEDIATYPEID,query.getMediaTypeId());
        }
        if(query.getNewsClassificationId() != null){
            criteria.andEqualTo(Article.NEWSCLASSFICATIONID,query.getNewsClassificationId());
        }
        if(query.getPlatFormId() != null){
            criteria.andEqualTo(Article.PLATFORMID,query.getPlatFormId());
        }
        if(query.getType() != null){
            criteria.andEqualTo(Article.TYPE,query.getType());
        }
        if(query.getQuestionTypeId() != null){
            criteria.andEqualTo(Article.QUESTIONTYPEID,query.getQuestionTypeId());
        }
        if(query.getReviewInfoTypeId() != null){
            criteria.andEqualTo(Article.REVIEWINFOTYPEID,query.getReviewInfoTypeId());
        }
        if(query.getSourceTypeId() != null){
            criteria.andEqualTo(Article.SOURCETYPEID,query.getSourceTypeId());
        }
        List<Article> data = articleMapper.selectByExample(example);
        return new PageInfo(data);
    }

    @Override
    public void save(ArticleVo article) {
        if(article.getType() != null){
            if(article.getType().equals(ArticlePageMap.AD_INTRO.getValue())){
                Article example = new Article();
                example.setType(article.getType());
                Article old = articleMapper.selectOne(example);
                Article articleInfo = new Article();
                BeanUtils.copyProperties(article,articleInfo);
                if(old != null){
                    articleInfo.setId(old.getId());
                    articleMapper.updateByPrimaryKeySelective(articleInfo);
                }else{
                    article.setCreateTime(new Date());
                    articleMapper.insertSelective(articleInfo);
                }
            }else{
                Integer cover = longDataService.saveData(article.getCoverFile());
                Article articleInfo = new Article();
                BeanUtils.copyProperties(article,articleInfo);
                articleInfo.setCover(cover);
                articleInfo.setCreateTime(new Date());
                articleMapper.insertSelective(articleInfo);
            }
        }
    }

    @Override
    public Article getDetail(Integer type, Integer id) {
        Article result = new Article();
        Article example = new Article();
        example.setType(type);
        if(type.equals(ArticlePageMap.AD_INTRO.getValue())){
        }else{
            example.setId(id);
        }
        result = articleMapper.selectOne(example);

        return result;
    }
}
