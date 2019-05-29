package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ServiceType {
    private Integer id;
    private String name;
    private Integer status;
}
