package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ReviewInfoType {
    private Integer id;
    private String name;
    private Integer questionTypeId;
}
