package com.shengtian.market.service.impl;

import com.shengtian.market.dao.LongDataMapper;
import com.shengtian.market.entity.LongData;
import com.shengtian.market.service.LongDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LongDataServiceImpl implements LongDataService {
    @Autowired
    private LongDataMapper longDataMapper;

    @Override
    public Integer saveData(byte[] data){
        LongData longData = new LongData();
        longData.setContent(data);
        longDataMapper.insertSelective(longData);
        return longData.getId();
    }

    @Override
    public Integer saveData(MultipartFile file) {
        try {
            byte[] data;
            data = file.getBytes();
            return this.saveData(data);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("blod 数据保存失败");
        }
    }

    @Override
    public LongData getData(Integer id){
        LongData example = new LongData();
        example.setId(id);
        return longDataMapper.selectOne(example);
    }
}
