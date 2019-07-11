package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class CustomCase {
    private Integer id;
    private String headline;
    private String description;
    private String caseType;
    private String editor;
    private String sourceFrom;
    private Date createTime;
    private Date updateTime;
    private Integer industryCategoryId;
    private Integer serviceType;
    private Integer cover;
    private String content;
}
