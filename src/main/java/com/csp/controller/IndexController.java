package com.csp.controller;

import com.csp.common.FileUtils;
import com.csp.core.CreatePage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author csp
 * @date 2021/12/19 16:20
 * @description 首页
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/html")
    public String generateHtml(){
        List<String> markdown = FileUtils.readInList("C:\\Users\\97674\\Desktop\\mdFile.md");
        return CreatePage.generateHtml(markdown);

    }
}
