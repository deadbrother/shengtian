package com.shengtian.market.service;

import com.shengtian.market.entity.LongData;
import org.springframework.web.multipart.MultipartFile;

public interface LongDataService {
    LongData getData(Integer id);
    Integer saveData(byte[] data);
    Integer saveData(MultipartFile file);
}
