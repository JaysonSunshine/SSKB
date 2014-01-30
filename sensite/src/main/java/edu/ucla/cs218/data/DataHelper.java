package edu.ucla.cs218.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {
	public static final String PHENOMENONS_LIST 	= "phenomenons_list.txt";
	public static final String SENSORS_LIST 		= "sensors_list.txt";
	
	public static List<String> getList(String path)
	{
		List<String> list = new ArrayList<String>();
		BufferedReader reader;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
			    list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
