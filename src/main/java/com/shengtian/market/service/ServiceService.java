package com.shengtian.market.service;

import com.shengtian.market.entity.ServiceDetail;
import com.shengtian.market.entity.ServiceType;

import java.util.List;

public interface ServiceService {
    List<ServiceType> getServiceType();

    ServiceDetail getService(Integer serviceType);

    void save(ServiceDetail serviceDetail);
}
