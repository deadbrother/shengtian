package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
public class SuccessCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerName;
    private Integer customerLogo;
    private Integer casePic;
    private String industry;
    private String caseDesc;
    private Integer status;
}
