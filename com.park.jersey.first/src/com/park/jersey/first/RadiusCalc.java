package com.park.jersey.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class RadiusCalc {

	public List<Park> findDistance(List<Park> prks,String zip)
	{
		List<Park> NeareastParksList= new ArrayList<Park>();
		String zip1;String zip2;
		BufferedReader bufferedReader = null;
		for(int i=0;i<prks.size();i++)
		{
			   zip1 = prks.get(i).park_zip;
			   System.out.println(zip1);
			   System.out.println(zip);
			   
			try{
				
				
				
				//URL url1 = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins="+zip1+"&destinations="+zip2);
		
				URL url = new URL("http://www.zipcodeapi.com/rest/pJuRQ3lCA17L2D7Awot7IWUDo6r5Q0jfKN6BRsdsukdxYl7uJABsxw5VDw1txkIh/distance.json/"+zip1+"/"+zip+"/mile");
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				InputStream inputStream = conn.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuffer stringBuffer = new StringBuffer();
				int charRead=0;
				char[] buffer = new char[1024];
				while ((charRead = bufferedReader.read(buffer)) > 0) {
		            stringBuffer.append(buffer, 0, charRead);
		        }
				//conn.setRequestMethod("GET");
				//NeareastParksList.add(prks.get(i));
				String line, outputString = "";
				outputString = stringBuffer.toString();
				//BufferedReader reader = new BufferedReader(
				//new InputStreamReader(conn.getInputStream()));
				//while ((line = reader.readLine()) != null) {
				     //outputString += line;
				//}
				inputStream.close();
				System.out.println(outputString);
				String str = outputString.substring(12, outputString.length()-1);
			    Double distance = (Double.parseDouble(str));
			    int distance1 = distance.intValue();
			    
			    if(distance<=10)
			    {
			    	prks.get(i).park_distance = distance1;
			    	NeareastParksList.add(prks.get(i));
			    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return NeareastParksList;
	}
	
	public  void close(Reader reader) {
	    if (reader != null) {
	        try {
	            reader.close();
	        } catch (IOException exp) {
	            System.out.println(exp);
	        }
	    }
	}
	
}
