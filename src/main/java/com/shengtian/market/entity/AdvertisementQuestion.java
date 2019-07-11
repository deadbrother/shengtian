package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class AdvertisementQuestion {
    private Integer id;
    private String content;
    private String editor;
    private String sourceFrom;
    private Date createTime;
    private Date updateTime;
    private String headline;
    private String description;
}
