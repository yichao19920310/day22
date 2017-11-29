/**  
 * @Title: Weather.java  
 * @Package com.example.Homework  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author Administrator  
 * @date 2017年11月28日  
 * @version V1.0  
 */  
package com.example.Homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**  
 * @ClassName: Weather  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Administrator  
 * @date 2017年11月28日  
 *    
 */
public class Weather {

	int weaid;
    String days;
    String week;
    String cityno;
    String citynm;
    int cityid;
    String temperature;
    String humidity;
    String weather;
    String wind;
    String winp;
    int temp_high;
    int temp_low;
    int humi_high;
    int humi_low;
    int weatid;
    int weatid1;
    int windid;
    int winpid;
	public Weather(int weaid, String days, String week, String cityno, String citynm, int cityid, String temperature,
			String humidity, String weather, String wind, String winp, int temp_high, int temp_low, int humi_high,
			int humi_low, int weatid, int weatid1, int windid, int winpid) {
		this.weaid = weaid;
		this.days = days;
		this.week = week;
		this.cityno = cityno;
		this.citynm = citynm;
		this.cityid = cityid;
		this.temperature = temperature;
		this.humidity = humidity;
		this.weather = weather;
		this.wind = wind;
		this.winp = winp;
		this.temp_high = temp_high;
		this.temp_low = temp_low;
		this.humi_high = humi_high;
		this.humi_low = humi_low;
		this.weatid = weatid;
		this.weatid1 = weatid1;
		this.windid = windid;
		this.winpid = winpid;
	}
	public Weather() {
		
		
	}
	
	
	@Override
	public String toString() {
		return "Weather [weaid=" + weaid + ", days=" + days + ", week=" + week + ", cityno=" + cityno + ", citynm="
				+ citynm + ", cityid=" + cityid + ", temperature=" + temperature + ", humidity=" + humidity
				+ ", weather=" + weather + ", wind=" + wind + ", winp=" + winp + ", temp_high=" + temp_high
				+ ", temp_low=" + temp_low + ", humi_high=" + humi_high + ", humi_low=" + humi_low + ", weatid="
				+ weatid + ", weatid1=" + weatid1 + ", windid=" + windid + ", winpid=" + winpid + "]";
	}
	public static void main(String[] args) throws IOException {
		
		URL	url = new URL("http://api.k780.com/?app=weather.future&weaid=36&appkey=12897&sign=ad041abb874869a9764b5891234459b3&format=json");
	
		URLConnection conn = url.openConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		
		String line = "";
		
		StringBuilder sb = new StringBuilder();
		
		while(null != (line = br.readLine())) {
			sb.append(line);
		}
		line = sb.toString();
		
		JSONObject allObject = new JSONObject(line);
		JSONArray objectArray = allObject.getJSONArray("result");
		ArrayList<Weather> weather = new ArrayList<>();
		JSONObject [] array = new JSONObject [7];
		for (int i = 0; i < objectArray.length(); i++) {
			array[i] = objectArray.getJSONObject(i);
			Weather w=new Weather(array[i].getInt("weaid"),array[i].getString("days"),array[i].getString("week"),
					array[i].getString("cityno"),array[i].getString("citynm"),array[i].getInt("cityid"),
					array[i].getString("temperature"),array[i].getString("humidity"),array[i].getString("weather"),
					array[i].getString("wind"),array[i].getString("winp"),array[i].getInt("temp_high"),
					array[i].getInt("temp_low"),array[i].getInt("humi_high"),array[i].getInt("humi_low"),
					array[i].getInt("weatid"),array[i].getInt("weatid1"),array[i].getInt("windid"),
					array[i].getInt("winpid"));
			weather.add(w);
			System.out.println(weather.get(i));
		}
		System.out.println("ha");
		
	}
}
