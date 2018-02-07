/**
 * 
 */
package com.learn.dev;

import java.io.File;

/**
 * @author c_rajees
 * This class is to be executed as a thread.
 * 
 * 
 * 
 * 
	/* Each folder encounter will create a thread for searching , and that thread will stop until it finishes all the files in that folder
	That is basically each folder thread will create another folder thread and it will die when it reaches the end of searching all the files.
	 *
	 */	


public class FolderSearch implements Runnable  {

	   private Thread threadObj;
	   File folder;
	   String keyWord;
	   
	   


	public FolderSearch(File folder, String keyword) {
		super();
		this.folder = folder;
		this.keyWord = keyword;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		File[] listOfFiles=folder.listFiles();
		File fileObj;
		
		for(int i=0;i<listOfFiles.length;i++){
			fileObj=listOfFiles[i];
			//System.out.println("testing path is--------------------------------- "+fileObj.getAbsolutePath());
			if(fileObj.isFile()){
				 OuputGenerator outputGenerator=new OuputGenerator();
				 outputGenerator.processFile(fileObj,this.keyWord);
			}else if(fileObj.isDirectory()){
				new FolderSearch(fileObj, keyWord).start();
			}
		}
		
	}
	
	

	public void start(){
		//System.out.println("Starting thread ........."  );
		if (threadObj == null) {
			threadObj = new Thread (this);
			threadObj.start ();
	      }
	}
	

}
