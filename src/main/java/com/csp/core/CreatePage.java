package com.csp.core;

import com.csp.common.FileUtils;

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
}
