package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import net.sf.json.JSONObject;

public class GetLocationUtil {
	private double x;
	private double y;
	
	
	
	public GetLocationUtil() {
		
	}

	

    
	public GetLocationUtil(String address) {
		String locationinfo = getLocationString(address);
		String[] array = locationinfo.split(",");
		this.x = Double.parseDouble(array[0]);
		this.y = Double.parseDouble(array[1]);
	}




	public String getLocationString(String address) {
		String info="";
		 try {
			URL url = new URL("http://restapi.amap.com/v3/geocode/geo?address="+address+"&key=3724b7049c6b24cd82342d05afdaccd5");
			try { 
				
				InputStream is =  url.openStream();              
                InputStreamReader isr = new InputStreamReader(is,"utf-8");
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据
                while (data!=null){//循环读取数据
                    info = info + data ;
                    data = br.readLine();
                }            
                @SuppressWarnings("deprecation")
				JSONObject jsonObject = new JSONObject(info);
                info = jsonObject.getJSONArray("geocodes").getJSONObject(0).getString("location");
                br.close();
                isr.close();
                is.close();
                
                
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	
	
	public double getX() {		
		return x;
	}



	public double getY() {
		return y;
	}


}
