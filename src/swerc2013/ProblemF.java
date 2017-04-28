package swerc2013;

import java.util.Scanner;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ProblemF {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int result=calculate(num);
		System.out.println(result);
		while(num!=-1){
			num=sc.nextInt();
			result=calculate(num);
			System.out.println(result);
		}
	}
	public static int calculate(int num){
		long[] memo=new long[num+1];
		int count=0;
		for(int i=0;i<=num;i++){
			count+=evaluate(aux(i,memo));
		}
		return count;
	}
	public static long aux(long num,long[] memo){
		if(num==1) return 1;
		if(num<=0) return 0; 
		if(memo[(int) num]!=0 ) return memo[(int) num];
		memo[(int) num]=num*aux(num-1,memo);
		return memo[(int) num];
	}
	public static int evaluate(long num){
		int ceros=0;
		while(num%10==0&&num>=10){
			ceros++;
			num/=10;
		}
		if(ceros%2==0) return 1;
		return 0;
	}
}

