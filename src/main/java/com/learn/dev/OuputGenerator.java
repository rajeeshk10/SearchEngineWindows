/**
 * 
 */
package com.learn.dev;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author Rajeesh
 *
 */
public class OuputGenerator implements SearchEngineConstants{

	
	
	public void processFile(File file,String keyWord){
		FileFormatProcessor fileFormatProcessor=new  FileFormatProcessor();
	    String typeOfFile=fileFormatProcessor.extractFileExtension(file.getName());
	    	if(typeOfFile.equalsIgnoreCase(TEXT_FORMAT)){
	    		try {
					textFileKeyWordSearch(file,keyWord);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("--------------Exception Occured While processing the Text  file-------------");
				}
	    	}else if(typeOfFile.equalsIgnoreCase(PDF_FORMAT)){
	    		try {
					pdfFileKeywordSearch(file,keyWord);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("--------------Exception Occured While processing the pdf  file-------------");
				}
	    	}
	}
	
	
	private boolean textFileKeyWordSearch(File fileObj,String keyWord) throws IOException{
		
		String line;
		boolean flag=false;
		BufferedReader fileContentObj=new BufferedReader(new FileReader(fileObj));
		StringBuilder lineObj=new StringBuilder();
			while((line=fileContentObj.readLine()) !=null){
					lineObj.append(line);
			}
			fileContentObj.close();
			String fileContent=lineObj.toString();
			
			if(fileContent.toLowerCase().contains(keyWord.toLowerCase())){
				flag=true;
				System.out.println("file Path --- "+fileObj.getAbsolutePath()+"----with -------------"+keyWord);
			}
		return flag;
	}
	
	
	/***
	 * 
	 * To open a pdf file from command prompt 
	 * start "" /max "C:\Rajeesh_Work\Personal\Resume\Sunil\Sunil Kumar Resume Complete.pdf"
	 * 
	 * */
	private void pdfFileKeywordSearch(File fileObj,String keyWord) throws IOException{
		PDDocument pdfDocument = PDDocument.load(fileObj);
		PDFTextStripper stripper = new PDFTextStripper();
		String pdfContent = stripper.getText(pdfDocument);
		
		if(pdfContent.toLowerCase().contains(keyWord.toLowerCase())){
			System.out.println("file Path --- "+fileObj.getAbsolutePath()+"----with -------------"+keyWord);
		}
		pdfDocument.close();
	}
	
	
}
