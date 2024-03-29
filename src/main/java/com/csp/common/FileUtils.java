package com.csp.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2021/12/19 15:30
 * @description 文件工具类
 */
public class FileUtils {

    /**
     * 按行读文件到ArrayList中
     * @param fileName 文件名
     * @return ArrayList
     */
    public static List<String> readInList(String fileName){
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<String> stringArrayList = new ArrayList<>();
        try{
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while((str = bufferedReader.readLine())!=null){
                stringArrayList.add(str);
            }
            fileReader.close();
            bufferedReader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return stringArrayList;
    }
    
    /**
     * @Author csp
     * @Description  将文件读到String
     * @Date 2021/12/25 16:05
     * @Param [fileName] 文件
     * @Return java.lang.String
     **/
    public static String read(String fileName){

        FileReader fileReader;
        BufferedReader bufferedReader;
        StringBuilder  sb = new StringBuilder();
        try{
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while((str = bufferedReader.readLine())!=null){
                sb.append(str);
                sb.append(System.lineSeparator());
            }
            fileReader.close();
            bufferedReader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 写入到文件中（追加）
     * @param str string
     * @param fileName 文件名
     */
    public static void write(String str,String fileName){
        FileWriter out;
        BufferedWriter bufferedWriter;
        try{
            out =  new FileWriter(fileName,true);
            bufferedWriter = new BufferedWriter(out);
            bufferedWriter.write(str);
            //bufferedWriter.flush();
            bufferedWriter.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    /**
     * 写入到文件中
     * @param str string
     * @param fileName 文件名
     * @param append 是否追加写入
     */
    public static void write(String str,String fileName,boolean append){
        FileWriter out;
        BufferedWriter bufferedWriter;
        try{
            out =  new FileWriter(fileName,append);
            bufferedWriter = new BufferedWriter(out);
            bufferedWriter.write(str);
            //bufferedWriter.flush();
            bufferedWriter.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /***
     * 获取路径下的所有文件
     * @param path 路径
     * @param fileList 文件列表
     */
    public static void getFileList(String path,List<File> fileList){
        File file = new File(path);
        if (file.exists()){
            File[] files = file.listFiles();
            if (files!=null){
                for (File f:files){
                    if (f.isFile()){
                        fileList.add(f);
                    }else if (f.isDirectory()){
                        getFileList(f.getPath(),fileList);
                    }
                }
            }
        }

    }


}
