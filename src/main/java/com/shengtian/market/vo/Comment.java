package com.shengtian.market.vo;

import com.shengtian.market.entity.CustomerComment;
import com.shengtian.market.entity.CustomerCommentContent;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
public class Comment{
    private String title;
    private List<MultipartFile> contents;
}
