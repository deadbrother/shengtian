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
}
