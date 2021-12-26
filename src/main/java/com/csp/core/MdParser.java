package com.csp.core;

import java.util.List;

/**
 * @author csp
 * @date 2021/12/19 16:43
 * @description markdown文件解析器入口
 */
public class MdParser {

    public String parse(List<String> src){
        System.out.println("源文件:"+src);
        StringBuilder sb = new StringBuilder();
        for (String line:src){
            if (!line.isEmpty()){
                if (line.charAt(0)=='#'){
                    int count = 1;
                    while(line.charAt(count)=='#'){
                        count++;
                    }
                    sb.append("<h").append(count).append(">");
                    sb.append(lineParse(line.substring(count))).append("</h").append(count).append(">");
                } else if (line.charAt(0)=='-'&&line.charAt(1)=='-'&&line.charAt(2)=='-'){
                    int index = 0;
                    while (line.charAt(index)=='-'){
                        index++;
                    }
                    if (index!=line.length()-1){
                        sb.append("<p>").append(line).append("</p>");
                    }else {
                        sb.append("<hr/>");
                    }

                } else if (line.charAt(0)=='*'&&line.charAt(1)=='*'&&line.charAt(2)=='*'){
                    sb.append("<hr/>");
                } else if (line.charAt(0)=='_'&&line.charAt(1)=='_'&&line.charAt(2)=='_'){
                    sb.append("<hr/>");
                }else {
                    sb.append(lineParse(line));
                    sb.append("<br/>");
                }
            }else {
                sb.append(lineParse(line));
                //sb.append(System.lineSeparator());
            }

        }
        System.out.println("转换后"+ sb);
        return sb.toString();
    }
    
    /**
     * @Author csp
     * @Description  行类解析
     * @Date 2021/12/25 20:57
     * @Param [str]
     * @Return java.lang.String
     **/
    public String lineParse(String str){
        StringBuilder sb = new StringBuilder();
        if (str.isEmpty()){
            sb.append(System.lineSeparator());
            return sb.toString();
        }
        // 粗体
        if (str.contains("**")){
            int open = str.indexOf("**");
            int close = str.indexOf("**",open+1);
            if (close>open){
                sb.append("<b>").append(str, open+2, close).append("</b>");
            }
        }
        if (str.contains("__")){
            int open = str.indexOf("__");
            int close = str.indexOf("__",open+1);
            if (close>open){
                sb.append("<b>").append(str, open+2, close).append("</b>");
            }
        }



        else{
            sb.append(str);
        }
        return sb.toString();
    }
}
