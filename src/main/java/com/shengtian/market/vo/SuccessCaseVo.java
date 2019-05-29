package com.shengtian.market.vo;

import com.shengtian.market.entity.SuccessCase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
public class SuccessCaseVo {
    private String customerName;
    private MultipartFile customerLogo;
    private MultipartFile casePic;
    private String industry;
    private String caseDesc;
    private Integer status;
    private String content;
    private String title;
}
