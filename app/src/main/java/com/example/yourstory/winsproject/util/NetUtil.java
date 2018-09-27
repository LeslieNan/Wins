package com.example.yourstory.winsproject.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo on 2018/9/19.
 * 网络类的工具类
 */

public class NetUtil {

    /**
     * 获取网络数据,使用的httpConnect
     * @param path
     * @return
     */
    public static String getWebData(String path){
        HttpURLConnection connection=null;
        try {
            URL url=new URL(path);
            connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8*1000);
            connection.setReadTimeout(8*1000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            InputStream in=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder response=new StringBuilder();
            while ((line=reader.readLine())!=null){
                response.append(line);
            }
            return String.valueOf(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
