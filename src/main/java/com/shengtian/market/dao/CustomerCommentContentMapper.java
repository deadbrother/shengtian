package com.shengtian.market.dao;

import com.shengtian.market.entity.CustomerCommentContent;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CustomerCommentContentMapper extends Mapper<CustomerCommentContent> {
    void insertList(List<CustomerCommentContent> contents);
}
