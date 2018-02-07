/**
 * 
 */
package com.learn.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RAJEESH
 *
 */
public class StartSearch {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Do you want to search with Options ?");
		System.out.println("1. Yes ");
		System.out.println("2. No ");
		String input=bufferedReader.readLine();
		if(input.equalsIgnoreCase("Yes")){
			//new OuputGenerator().pdfFileKeywordSearch(null,"This is the keyword to search");
		}else{
			Search searchObj=new Search();
			System.out.println("keyWord is -- sunee_kerala@yahoo.com");
			searchObj.seachWithKeyword("sunee_kerala@yahoo.com");
		}
		
	}

}
