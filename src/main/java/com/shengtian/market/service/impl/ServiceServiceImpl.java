package com.shengtian.market.service.impl;

import com.shengtian.market.dao.ServiceDetailMapper;
import com.shengtian.market.dao.ServiceTypeMapper;
import com.shengtian.market.entity.ServiceDetail;
import com.shengtian.market.entity.ServiceType;
import com.shengtian.market.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceTypeMapper serviceTypeMapper;
    @Autowired
    private ServiceDetailMapper serviceDetailMapper;
    private static final Integer SERVICE_NORMAL_STATUS = 0;
    @Override
    public List<ServiceType> getServiceType() {
        ServiceType example = new ServiceType();
        example.setStatus(SERVICE_NORMAL_STATUS);
        return serviceTypeMapper.select(example);
    }

    @Override
    public ServiceDetail getService(Integer serviceType) {
        ServiceDetail example = new ServiceDetail();
        example.setServiceTypeId(serviceType);
        ServiceDetail serviceDetail = serviceDetailMapper.selectOne(example);
        return serviceDetail;
    }

    @Override
    public void save(ServiceDetail serviceDetail) {
        ServiceDetail example = new ServiceDetail();
        example.setServiceTypeId(serviceDetail.getServiceTypeId());
        ServiceDetail oldRecord = serviceDetailMapper.selectOne(example);
        if(oldRecord == null){
            serviceDetailMapper.insertSelective(serviceDetail);
        }else{
            serviceDetail.setId(oldRecord.getId());
            serviceDetailMapper.updateByPrimaryKeySelective(serviceDetail);
        }
    }


}
