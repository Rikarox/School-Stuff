package projekt2;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class hodina6 {
public static String infopath = "info.txt";
public static String infot = "";
	public static void Graph(){
		
     	read();	
     	
     	String[] infoSplit = infot.split(","); 
		int ax=0;
		int bx=100;
		int n=0;
		int finalis=0;
		int inf = 0;
		int inf2 = 0;
		int n2=0;
		String Graph="";

		while (bx>0){
			
		n=0;
		ax=0;
		
		while(ax<100){	
		n2 = n+1;
		inf = Integer.parseInt(infoSplit[n]);
		inf2 = Integer.parseInt(infoSplit[n+1]);
		
		//System.out.println(inf);
		//System.out.println(inf2);
		
		
		
 		if(inf == ax && inf2 == bx){
 			
 			System.out.print("X");
 			
 		}
 		else{
 			System.out.print("-");	
 		}
 		
 		n=n+2;
		ax++;
		}
		System.out.println("");
		bx--;
		}
	
			
			/*	while (bx>0){
			
		ax=0;
			
 		
			while(ax!=200){
				n2=n+1;
     		//inf = Integer.parseInt(infoSplit[n]);
     		

     		
     		//inf2 = Integer.parseInt(infoSplit[n2]);

     		
     		
     		if(inf == ax && inf2 == bx){
     			
     			System.out.print("X");
     			
     		}
     		else{
     			System.out.print(".");	
     		}
     		
     		
     		ax++;
     		n++;
     		
			}
			
			System.out.println("");		
		bx--;	
		}
		*/
     	
     	
     	
	}
	public static void read() {
		try {
    		String infogain = "";

    		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
    		while ((infogain = br.readLine()) != null) {
    		infot = infot + infogain;
    		}
    		br.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	public static void RandomInfo(){


 				Random rand = new Random();
 				
 				int a=0;
 				int b=0;
 				String info="";
 				while(a!=201){
 					b=rand.nextInt(100) + 1;
 				
 					info= info + a + "," + b + ",";
                   
 					
 					a++;
 				}
 				
 				
	            File file = new File(infopath);	            
	    		try {
	    			if (file.createNewFile()) {
	    				System.out.println("File created.");		
	    				

	    				try (BufferedWriter bw = new BufferedWriter(new FileWriter(infopath, true))) {
	    					

	    					bw.write(info);
	    					bw.newLine();				
	    					bw.flush();
	    					bw.close();
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}

	
	    			} else {
	    				System.out.println("");
	    			}
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
 				
 				

	 }
	public static void RandomInfo2(){


			Random rand = new Random();
			
			int a=0;
			int b=0;
			int c=50;
			String info="";
			while(a!=201){
				b=rand.nextInt(3) + 1;
			if(b == 1){
				c=c+1;
				info= info + a + "," + c + ",";
           
			
			}
			else{
				c=c-1;
				if(c<0){
					c=c+3;
				}
				info= info + a + "," + c + ",";	
			}
				
				a++;
			}
			
			
        File file = new File(infopath);	            
		try {
			if (file.createNewFile()) {
				System.out.println("File created.");		
				

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(infopath, true))) {
					

					bw.write(info);
					bw.newLine();				
					bw.flush();
					bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}


			} else {
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			

}
	public static void main(String[] args) {
		
		//RandomInfo(); To make file
		//RandomInfo2();
		
		Graph();
		

	}

}
