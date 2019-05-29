package com.shengtian.market.service;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.CustomerCommentContent;
import com.shengtian.market.vo.Comment;

import java.util.List;

public interface CustomerCommentService {
    PageInfo getList(Integer pageNo,Integer pageSize);

    void save(Comment comment);

    List<CustomerCommentContent> getDetail(Integer id);
}
