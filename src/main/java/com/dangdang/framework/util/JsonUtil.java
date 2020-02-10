package com.dangdang.framework.util;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


/**
 * Created by qiankai02 on 2017/11/9.
 */
public class JsonUtil {

    //return object from JSON string
    public static <T> T getTestObject(String rs, Class<T> clazz) {
        try {
            T t = JSON.parseObject(readSourceFile(rs), clazz);
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    //return object list from JSON array string
    public static <T> List<T> getTestList(String rs, Class<T> clazz) throws Exception {
        return JSON.parseArray(readSourceFile(rs), clazz);
    }

    //return JSON string from json file
    public static String readSourceFile(String rs) throws Exception {
        Class<JsonUtil> testHelperClass = JsonUtil.class;
        ClassLoader classLoader = testHelperClass.getClassLoader();
        URL resource = classLoader.getResource(rs);
        InputStream inputStream = resource.openStream();
        int size = inputStream.available();

        //URI uri = resource.toURI();
        //byte[] bytes = Files.readAllBytes(Paths.get(uri));
        byte[] bytes = new byte[size];
        inputStream.read(bytes);

        return new String(bytes, "UTF-8");
    }

}
