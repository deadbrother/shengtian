package com.shengtian.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shengtian.market.dao.SuccessCaseMapper;
import com.shengtian.market.dao.SuccessDetailMapper;
import com.shengtian.market.entity.SuccessCase;
import com.shengtian.market.entity.SuccessDetail;
import com.shengtian.market.service.LongDataService;
import com.shengtian.market.service.SuccessService;
import com.shengtian.market.vo.SuccessCaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessServiceImpl implements SuccessService {

    @Autowired
    private SuccessCaseMapper successCaseMapper;
    @Autowired
    private SuccessDetailMapper successDetailMapper;
    @Autowired
    private LongDataService longDataService;

    @Override
    public PageInfo getList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<SuccessCase> data = successCaseMapper.selectAll();
        return new PageInfo(data);
    }

    @Override
    public void save(SuccessCaseVo successCaseVo) {
        Integer customerLogo = longDataService.saveData(successCaseVo.getCustomerLogo());
        Integer casePic = longDataService.saveData(successCaseVo.getCasePic());
        SuccessCase successCase = new SuccessCase();
        BeanUtils.copyProperties(successCaseVo,successCase);
        successCase.setCasePic(casePic);
        successCase.setCustomerLogo(customerLogo);
        successCaseMapper.insertSelective(successCase);
        SuccessDetail successDetail = new SuccessDetail();
        BeanUtils.copyProperties(successCaseVo,successDetail);
        successDetail.setSuccessCaseId(successCase.getId());
        successDetailMapper.insertSelective(successDetail);

    }

    @Override
    public SuccessDetail getDetail(Integer id) {
        SuccessDetail example = new SuccessDetail();
        example.setSuccessCaseId(id);
        return successDetailMapper.selectOne(example);
    }
}
