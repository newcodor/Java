package com.newcodor.test;

import  java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main1{
    

public static void main(String [] args) throws Exception{
   Scanner sc=new Scanner(System.in);
   int begin=100,end=999;
   String line;
   while(sc.hasNextLine()){
	   line=sc.nextLine();
	   String [] str=line.split(" ");
	   begin=Integer.parseInt(str[0]);
	   end=Integer.parseInt(str[1]);
	   //end=sc.nextInt();
	   getNum(begin,end);
   }
   sc.close();
}
    
    public  static void getNum(int begin,int end) {
    	   List<Integer> result=new ArrayList<Integer>();
    	   for(int i=begin;i<end;i++){
    	       if(i==Math.pow((i-i%100)/100,3)+Math.pow((i%100)/10,3)+Math.pow((i%100)%10,3))
    	           result.add(i);
    	   }
    	  
    	    if(result.size()>0){
    	        for(Integer i:result){
    	            System.out.print(i+" ");
    	        }
    	        System.out.println();
    	    }
    	    else
    	        System.out.println("no");
    }
    }