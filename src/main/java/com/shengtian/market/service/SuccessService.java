package com.shengtian.market.service;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.SuccessDetail;
import com.shengtian.market.vo.SuccessCaseVo;

public interface SuccessService {
    PageInfo getList(Integer pageNo, Integer pageSize);

    void save(SuccessCaseVo successCaseVo);

    SuccessDetail getDetail(Integer id);
}
