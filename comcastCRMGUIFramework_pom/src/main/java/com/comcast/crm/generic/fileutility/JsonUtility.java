package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.mysql.cj.xdevapi.JsonParser;



public class JsonUtility 
{

	public String getDataFromJsonFile(String key) throws FileNotFoundException
	{
		FileReader fileR=new FileReader("./configAppData/appCommonData.json");
		String value="value";
		return value;
	}
}
