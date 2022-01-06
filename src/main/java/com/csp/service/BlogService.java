package com.csp.service;

import com.csp.entiy.Blog;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author csp
 * @date 2021/12/26 16:13
 * @description
 */
@Service
public class BlogService {
    public void getBlogs(String path,List<Blog> blogs){
        File file = new File(path);
        if (file.exists()){
            File[] files = file.listFiles();
            if (files!=null){
                for (File f:files){
                    if (f.isFile()){
                        Blog blog = new Blog();
                        String prefix = f.getName().substring(f.getName().lastIndexOf("."));
                        String headline = f.getName().substring(0,f.getName().length()-prefix.length());
                        blog.setHeadline(headline);
                        blog.setPath(f.getPath());
                        blog.setUpdateTime(String.valueOf(f.lastModified()));
                        blogs.add(blog);
                    }else if (f.isDirectory()){
                        getBlogs(f.getPath(),blogs);
                    }
                }
            }
        }

    }
}
