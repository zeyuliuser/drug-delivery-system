package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import net.sf.json.JSONObject;

public class MyClass {
	
	@Test
	public  void  getweb(){
		/*3724b7049c6b24cd82342d05afdaccd5*/
		
		
		String info = "";
		


        try {
            //创建一个URL实例
            URL url = new URL("http://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&key=3724b7049c6b24cd82342d05afdaccd5");

            try {
                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
                InputStream is =  url.openStream();              
                InputStreamReader isr = new InputStreamReader(is,"utf-8");

                //为字符输入流添加缓冲
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据

                while (data!=null){//循环读取数据
                    System.out.println(data);//输出数据
                    info = info + data ;
                    data = br.readLine();
                }
                System.out.println(info);
                JSONObject jsonObject = new JSONObject(info);
                
                br.close();
                isr.close();
                is.close();
                System.out.println(jsonObject);
                System.out.println(jsonObject.getJSONArray("geocodes").getJSONObject(0).getString("location"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
	

}
