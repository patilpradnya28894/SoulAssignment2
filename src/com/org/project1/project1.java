package com.org.project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.*;
public class project1 {
	public static void main(String[] args) {
     try {
         project1.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "http://data.fixer.io/api/2017-01-01?access_key=401b813f53bc48488e308cb9a13e06fb";
     String url1 = "http://data.fixer.io/api/2018-01-01?access_key=401b813f53bc48488e308cb9a13e06fb";
     URL obj = new URL(url);
     URL obj1 = new URL(url1);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     //int responseCode1 = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("\nSending 'GET' request to URL : " + url1);
     System.out.println("Response Code : " + responseCode);
     
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     
     BufferedReader in1 = new BufferedReader(
             new InputStreamReader(con1.getInputStream()));
     
     
     String inputLine;
     String inputLine1;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
    	response.append(inputLine);
     }
     
    StringBuffer response1 = new StringBuffer();
     while ((inputLine1 = in1.readLine()) != null) {
     	response1.append(inputLine1);	
     }
    
     
     in.close();
     //print in String
     System.out.println(response.toString());
     System.out.println(response1.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     JSONArray ja = (JSONArray) myResponse.get("rates");
     System.out.println(myResponse.toString());
     System.out.println(myResponse.get("rates"));
     
     JSONArray rates = ja.getJSONArray("rates");
     for (int i = 0; i < rates.length(); i++) {
       String pet = rates.getString(i);
       long res=pet.indexOf(i)-pet.indexOf(i1)*100;
       
       System.out.println(res);
     }
    
   }
}
