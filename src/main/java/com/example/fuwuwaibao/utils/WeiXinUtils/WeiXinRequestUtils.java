package com.example.fuwuwaibao.utils.WeiXinUtils;


import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 * @Author: Pan Jiaxiang
 * @Date: 2023/4/5
 * @Modified by Pan Jiaxiang
 */
public class WeiXinRequestUtils {

    private static final String appId = "wx595c6669834889a9";
    private static final String appSecret = "e29a4b740ff81c3a9bdad17cea4135e0";
    private static final String grant_type = "authorization_code";

    private WeiXinRequestUtils() {}

    // 发送GET请求
    public static String sendGet(String js_code) {
        System.out.println(js_code);
        if (js_code == null) {
            System.out.println("js_code is null");
            return null;
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ appId + "&secret=" + appSecret + "&js_code="+ js_code+ "&grant_type=" + grant_type ;

        String result = null;
        System.out.println("url : " + url);
        //  https://api.weixin.qq.com/sns/jscode2session?appid=wx935e54762f136094&secret=f647aa91285a8a64efc3d70e621c0154&js_code=0a1Uob1w3r0au037pa2w3u16ic2Uob1b&grant_type=authorization_code

        try {
            // 与微信小程序后台进行连接
            URL realUrl = new URL(url);
            final URLConnection connection = realUrl.openConnection();
            connection.connect();
            // 获取字符输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 读取数据
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            result = builder.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
