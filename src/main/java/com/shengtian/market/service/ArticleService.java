package com.shengtian.market.service;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.Article;
import com.shengtian.market.vo.ArticleVo;

public interface ArticleService {
    PageInfo getList(Integer pageNum, Integer pageSize, Article query);

    void save(ArticleVo article);

    Article getDetail(Integer type, Integer id);
}
