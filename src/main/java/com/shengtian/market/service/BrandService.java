package com.shengtian.market.service;

import com.github.pagehelper.PageInfo;
import com.shengtian.market.entity.Brand;

public interface BrandService {
    PageInfo getList(Integer pageNo, Integer pageSize);

    void save(byte[] data);

    Brand getOne(Integer id);
}
