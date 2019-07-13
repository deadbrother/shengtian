package com.shengtian.market.vo;

import com.shengtian.market.entity.Article;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
public class ArticleVo extends Article {
    private MultipartFile coverFile;

    public ArticleVo(String content, String editor, String sourceFrom, Integer platFormId, Integer mediaTypeId, Integer sourceTypeId, String adYear, String headline, String description, Integer serviceTypeId, Integer questionTypeId, Integer reviewInfoTypeId, Integer industryCategoryId, Integer newsClassificationId, Integer type, MultipartFile coverFile) {
        super(content, editor, sourceFrom, platFormId, mediaTypeId, sourceTypeId, adYear, headline, description, serviceTypeId, questionTypeId, reviewInfoTypeId, industryCategoryId, newsClassificationId, type);
        this.coverFile = coverFile;
    }
}
