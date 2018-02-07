/**
 * 
 */
package com.learn.dev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author RAJEESH
 *
 */
public class Search {
  
	
	public void seachWithKeyword(String keyWord){
		File folder=new File("C:\\Rajeesh_Work");
		File[] listOfFiles=folder.listFiles();
		File fileObj;
		if(folder.exists()){
			for(int i=0;i<listOfFiles.length;i++){
				fileObj=listOfFiles[i];
				//System.out.println("testing path is--------------------------------- "+fileObj.getAbsolutePath());
				if(fileObj.isFile()){
					OuputGenerator outputGenerator=new OuputGenerator();
					outputGenerator.processFile(fileObj,keyWord);
				}else if(fileObj.isDirectory()){
					FolderSearch fSearchObj=new FolderSearch(fileObj, keyWord);
					fSearchObj.start();
				}
			}
		}else{
			System.out.println("---------------------------------the given path not exists--------------------------");
		}
			
	}
	
	
}
