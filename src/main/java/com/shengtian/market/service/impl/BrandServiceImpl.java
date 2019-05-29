package com.shengtian.market.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shengtian.market.dao.BrandMapper;
import com.shengtian.market.entity.Brand;
import com.shengtian.market.service.BrandService;
import com.shengtian.market.service.LongDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    private static final Integer BRAND_NORMAL_STATUS = 0;
    @Autowired
    private LongDataService longDataService;
    @Override
    public PageInfo getList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Brand> data = brandMapper.selectAll();
        return new PageInfo(data);
    }

    @Override
    public void save(byte[] data) {
        Integer id = longDataService.saveData(data);
        Brand brand = new Brand();
        brand.setStatus(BRAND_NORMAL_STATUS);
        brand.setIcon(id);
        brandMapper.insertSelective(brand);
    }

    @Override
    public Brand getOne(Integer id) {
        Brand example = new Brand();
        example.setId(id);
        return brandMapper.selectOne(example);
    }
}
