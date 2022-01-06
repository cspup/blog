package com.csp.controller;

import com.csp.common.FileUtils;
import com.csp.common.R;
import com.csp.core.CreatePage;
import com.csp.entiy.Blog;
import com.csp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2021/12/19 16:20
 * @description 首页
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/html")
    public String generateHtml(){
        List<String> markdown = FileUtils.readInList("C:\\Users\\97674\\Desktop\\mdFile.md");

        String modelFile  = "\\model\\index.html";
        String markDownDirectory = "\\md";
        String targetFile = "\\index.html";
        String basePath = "D:\\WorkSpace\\yemuc.github.io";

        CreatePage.updateIndexHtml(modelFile,markDownDirectory,targetFile,basePath);

        return CreatePage.generateHtml(markdown);

    }
    
    /**
     * @Author csp
     * @Description  获取markdown内容
     * @Date 2021/12/26 14:43
     * @Param []
     * @Return java.lang.String
     **/
    @GetMapping("/markdown")
    public String getMarkDown(){
        return FileUtils.read("C:\\Users\\97674\\Desktop\\mdFile.md");
    }
    
    /**
     * @Author csp
     * @Description  获取博客
     * @Date 2021/12/26 16:13
     * @Param []
     * @Return java.lang.Object
     **/
    @GetMapping("/getBlogs")
    public R<List<Blog>> getBlogs(){
        List<Blog> blogs = new ArrayList<>();
        String path = "D:/blog";
        blogService.getBlogs(path,blogs);
        return R.ok(blogs);
    }
    
    /**
     * @Author csp
     * @Description  获取markdown内容
     * @Date 2021/12/26 17:25
     * @Param []
     * @Return java.lang.String
     **/
    @GetMapping("/getMarkdown")
    public String getMarkDown(String filename){
        return FileUtils.read(filename);
    }
}
