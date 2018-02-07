/**
 * 
 */
package com.learn.dev;

/**
 * @author c_rajees
 *good reference for pdf parsing check this link http://stackoverflow.com/questions/5449903/advanced-pdf-parser-for-java
 */
public class FileFormatProcessor implements SearchEngineConstants{

	public FileFormatProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*
	 * This method let it be public because it's not modifying any data, just checking only
	 * 
	 * */
	public String extractFileExtension(String fileName){
		String fileFormat;
		String typeOfFile=new String();
		if(fileName != null && fileName.length()>4){
			fileFormat=fileName.substring(fileName.length()-4);
			if(fileFormat.equalsIgnoreCase(".txt")){
				typeOfFile=TEXT_FORMAT;
			}else if(fileFormat.equalsIgnoreCase(".pdf")){
				typeOfFile=PDF_FORMAT;
			}
		}else{
			typeOfFile="Unknown";
		}
		return typeOfFile;
	}

}
