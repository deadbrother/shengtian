package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class News {
    private Integer id;
    private Integer cover;
    private String headline;
    private String description;
    private Date createTime;
    private Date updateTime;
    private String sourceFrom;
    private String editor;
    private String content;
}
