package swerc2012;

import java.util.HashMap;
import java.util.Scanner;

public class problemD {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int numberOfCases=sc.nextInt();
		for(int k=0;k<numberOfCases;k++){
			String x=sc.next();
			int[] map=new int[4];
			String key=x.substring(0,1);
			int start=1;
			int i=2;
			for(;i<x.length();i++){
				if(isNumeric(x.substring(start, i))){
					continue;
				}else{
					if(key.equals("A")){
						map[0]=map[0]+Integer.parseInt(x.substring(start,i-1));
					}else if(key.equals("U")){
						map[1]=map[1]+Integer.parseInt(x.substring(start,i-1));
					}else if(key.equals("C")){
						map[2]=map[2]+Integer.parseInt(x.substring(start,i-1));
					}else if(key.equals("G")){
						map[3]=map[3]+Integer.parseInt(x.substring(start,i-1));
					}
					key=x.substring(i-1,i);
					start=i;
				}
			}
			if(key.equals("A")){
				map[0]=map[0]+Integer.parseInt(x.substring(start,i));
			}else if(key.equals("U")){
				map[1]=map[1]+Integer.parseInt(x.substring(start,i));
			}else if(key.equals("C")){
				map[2]=map[2]+Integer.parseInt(x.substring(start,i));
			}else if(key.equals("G")){
				map[3]=map[3]+Integer.parseInt(x.substring(start,i));
			}
			int pairs=0;
			int maxCG=sc.nextInt();
			int C=map[2];
			int G=map[3];
			if(C>G){
				if(G>maxCG) pairs+=maxCG;
				else pairs+=G;
			}else{
				if(C>maxCG) pairs+=maxCG;
				else pairs+=C;
			}
			int A=map[0];
			int U=map[1];
			if(A>U){
				pairs+=U;
			}else{
				pairs+=A;
			}
			System.out.println(pairs);
		}
	}
	public static boolean isNumeric(String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	
}
