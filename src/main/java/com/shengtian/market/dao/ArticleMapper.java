package com.shengtian.market.dao;

import com.shengtian.market.entity.Article;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    List<String> customSelectAllAdYear();
}
