package com.csp.core;

import com.csp.common.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2021/12/19 15:30
 * @description 创建页面
 */
public class CreatePage {

    /**
     * @Author csp
     * @Description //TODO
     * @Date 2021/12/19 16:09
     * @Param [fileName]
     **/
    public void create(String fileName){

        String content = FileUtils.read(fileName);
        System.out.println(content);
    }
    /**
     * @Author csp
     * @Description 创建html
     * @Date 2021/12/19 16:15
     * @Param []
     * @Return void
     **/
    public void createHtml(){

    }

    /**
     * @Author csp
     * @Description 生产html
     * @Date 2021/12/19 16:22
     * @Param []
     * @Return java.lang.String
     **/
    public static String generateHtml(List<String> markdown){
        MdParser mdParser = new MdParser();
        return mdParser.parse(markdown);
    }


    /**
     * 更新首页
     * @param modelFile 模板文件
     * @param markDownDirectory markdown文件夹路径
     * @param target 目标文件
     * @param basePath 目标库路径
     */
    public static void updateIndexHtml(String modelFile,String markDownDirectory,String target,String basePath){
        String html =  FileUtils.read(basePath+modelFile);
        StringBuilder contentStringBuilder = new StringBuilder();

        List<File> fileList = new ArrayList<>();
        FileUtils.getFileList(basePath+markDownDirectory,fileList);
        for (File file:fileList){
            String fileName =  file.getName();
            fileName = fileName.substring(0,fileName.lastIndexOf("."));
            String relativePath = file.getPath().replace(basePath,"");
            String li = "<li><a href=\"./blog.html?path="+relativePath+"\">"+fileName+"</a></li>";
            contentStringBuilder.append(li).append(System.lineSeparator());
        }

        String  newHtml = html.replace("{{blog-list}}",contentStringBuilder.toString());

        FileUtils.write(newHtml,basePath+target,false);
    }


}
