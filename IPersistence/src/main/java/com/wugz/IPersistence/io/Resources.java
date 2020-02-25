package com.wugz.IPersistence.io;

import java.io.InputStream;

/**
 * @ClassName Resources
 * @Description 根据路径获取输入流
 * @Author wugz
 * @Date 2020/2/22 12:20
 * @Version 1.0
 */
public class Resources {

    public static InputStream getResourceAsSteam(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }

}
