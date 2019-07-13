package com.shengtian.market.vo;

public enum ArticleStatusEnum {
    NORMAL(0),DELETE(1);

    private Integer value;

    ArticleStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
