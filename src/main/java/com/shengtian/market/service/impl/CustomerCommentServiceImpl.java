package com.shengtian.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shengtian.market.dao.CustomerCommentContentMapper;
import com.shengtian.market.dao.CustomerCommentMapper;
import com.shengtian.market.entity.CustomerComment;
import com.shengtian.market.entity.CustomerCommentContent;
import com.shengtian.market.service.CustomerCommentService;
import com.shengtian.market.service.LongDataService;
import com.shengtian.market.vo.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerCommentServiceImpl implements CustomerCommentService {
    @Autowired
    private CustomerCommentContentMapper customerCommentContentMapper;
    @Autowired
    private CustomerCommentMapper customerCommentMapper;

    @Autowired
    private LongDataService longDataService;

    private static final Integer CUSTOMERCOMMENT_NORMAL_STATUS = 0;
    @Override
    public PageInfo getList(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<CustomerComment> data = customerCommentMapper.selectAll();
        return new PageInfo(data);
    }

    @Override
    public void save(Comment comment) {
        CustomerComment customerComment = new CustomerComment();
        BeanUtils.copyProperties(comment,customerComment);
        customerComment.setStatus(CUSTOMERCOMMENT_NORMAL_STATUS);
        customerCommentMapper.insertSelective(customerComment);
        List<CustomerCommentContent> contents = new ArrayList<>();
        for(MultipartFile content:comment.getContents()){
            CustomerCommentContent customerCommentContent =  new CustomerCommentContent();
            Integer contentId = longDataService.saveData(content);
            customerCommentContent.setContent(contentId);
            customerCommentContent.setCustomerId(customerComment.getId());
            contents.add(customerCommentContent);
        }
        customerCommentContentMapper.insertList(contents);
    }

    @Override
    public List<CustomerCommentContent> getDetail(Integer id) {
        CustomerCommentContent example = new CustomerCommentContent();
        example.setCustomerId(id);
        return customerCommentContentMapper.select(example);
    }
}
