package com.shengtian.market.controller;

import com.shengtian.market.entity.LongData;
import com.shengtian.market.service.LongDataService;
import com.shengtian.market.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping(value="/data")
public class LongDataController {


    @Autowired
    private LongDataService longDataService;


    @GetMapping(value="/getImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public void getIcon(HttpServletResponse httpResponse, @RequestParam("id")Integer id){
        LongData longData = longDataService.getData(id);

        httpResponse.setContentType("image/png");
        try {
            OutputStream output = httpResponse.getOutputStream();
            InputStream in = new ByteArrayInputStream(longData.getContent());
            int len;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                output.write(buf, 0, len);
            }
            output.flush();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult save(@RequestBody MultipartFile file){
        RestResult result = new RestResult();
        try {
            byte[] data;
            data = file.getBytes();
            Integer dataId = longDataService.saveData(data);
            String imgUrl = "/data/getImage?id=" + dataId;
            result.setData(imgUrl);
        }catch (Exception e){
            e.printStackTrace();
            result.unknownError(e.getMessage());
            return result;
        }


        result.success();
        return result;
    }

}
