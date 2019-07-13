package com.shengtian.market.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String editor;
    private String sourceFrom;
    private Date createTime;
    private Date updateTime;
    private Integer platFormId;
    private Integer mediaTypeId;
    private Integer sourceTypeId;
    private String adYear;
    private Integer cover;
    private String headline;
    private String description;
    private Integer serviceTypeId;
    private Integer questionTypeId;
    private Integer reviewInfoTypeId;
    private Integer industryCategoryId;
    private Integer newsClassificationId;
    private Integer type;
    private Integer status;


    public Article() {
    }

    public Article(String content, String editor, String sourceFrom, Integer platFormId, Integer mediaTypeId, Integer sourceTypeId, String adYear, String headline, String description, Integer serviceTypeId, Integer questionTypeId, Integer reviewInfoTypeId, Integer industryCategoryId, Integer newsClassificationId, Integer type) {
        this.content = content;
        this.editor = editor;
        this.sourceFrom = sourceFrom;
        this.platFormId = platFormId;
        this.mediaTypeId = mediaTypeId;
        this.sourceTypeId = sourceTypeId;
        this.adYear = adYear;
        this.headline = headline;
        this.description = description;
        this.serviceTypeId = serviceTypeId;
        this.questionTypeId = questionTypeId;
        this.reviewInfoTypeId = reviewInfoTypeId;
        this.industryCategoryId = industryCategoryId;
        this.newsClassificationId = newsClassificationId;
        this.type = type;
    }

    public static final String ID = "id";
    public static final String CONTENT = "content";
    public static final String EDITOR = "editor";
    public static final String SOURCEFROM = "sourceFrom";
    public static final String CREATETIME = "createTime";
    public static final String UPDATETIME = "updateTime";
    public static final String PLATFORMID = "platFormId";
    public static final String MEDIATYPEID = "mediaTypeId";
    public static final String SOURCETYPEID = "sourceTypeId";
    public static final String ADYEAR = "adYear";
    public static final String COVER = "cover";
    public static final String HEADLINE = "headline";
    public static final String DESCRIPTION = "description";
    public static final String SERVICETYPEID = "serviceTypeId";
    public static final String QUESTIONTYPEID = "questionTypeId";
    public static final String REVIEWINFOTYPEID = "reviewInfoTypeId";
    public static final String INDUSTRYCATEGORYID = "industryCategoryId";
    public static final String NEWSCLASSFICATIONID = "newsClassficationId";
    public static final String TYPE = "type";
    public static final String STATUS = "status";





}
