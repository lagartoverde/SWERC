package swerc2015;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemI {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String text=sc.next();
		int tests=sc.nextInt();
		int width=sc.nextInt();
		for(int i=0;i<tests;i++){
			int start=sc.nextInt();
			System.out.println(aux(text,start,width));
		}
	}
	public static int aux(String text, int start, int width){
		String substring=text.substring(start-1,start-1+width);
		ArrayList resultado=new ArrayList();
		for(int i=0;i<substring.length();i++){
			aux2(i,i+1,substring,resultado);
		}
		return resultado.size();
	}
	public static void aux2(int startIndex,int endIndex,String totalString,ArrayList resultado){
		String subString=totalString.substring(startIndex,endIndex);
		if(resultado.indexOf(subString)==-1){
			resultado.add(subString);
		}
		if(endIndex==totalString.length()) return;
		aux2(startIndex,endIndex+1,totalString,resultado);
		
	}
}
