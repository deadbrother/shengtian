package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@Data
public class AdvertisementDetail {
    private Integer id;
    private String content;
    private String editor;
    private String sourceFrom;
    private Date createTime;
    private Date updateTime;
    private Integer platFormId;
    private Integer mediaTypeId;
    private Integer SourceTypeId;
    private String adYear;
    private Integer cover;
    private String headline;
    private String description;
}
