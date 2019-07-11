package com.shengtian.market.vo;

public enum ArticlePageMap {
    AD_INTRO(1,"ad-intro"),
    AD(2,"ad"),
    AD_QUESTION(3,"ad-question"),
    CUSTOM_CASE(4,"custom-case"),
    NEWS(5,"news");

    private Integer value;
    private String pageName;

    ArticlePageMap(Integer value, String pageName) {
        this.value = value;
        this.pageName = pageName;
    }

    public Integer getValue() {
        return value;
    }

    public String getPageName() {
        return pageName;
    }

    public static String getNameByValue(Integer value){
        for(ArticlePageMap ad:ArticlePageMap.values()){
            if(ad.getValue().equals(value)){
                return ad.getPageName();
            }
        }
        return null;
    }
}
