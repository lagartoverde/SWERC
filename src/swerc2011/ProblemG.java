package swerc2011;

import java.util.Scanner;

public class ProblemG {
	static int count=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int length=sc.nextInt();
			if(length==0) return;
			int[] array=new int[length];
			for(int i=0;i<length;i++){
				array[i]=sc.nextInt();
			}
			int[][] memo=new int[length][length];
			aux(array,memo);
			System.out.println(count);
			count=0;
		}
	}
	public static void aux(int[] array,int[][] memo){
		for(int k=0;k<array.length;k++){
			boolean biggerThanZero=true;
			for(int i=0;i<array.length;i++){
				if(aux2(array,memo,i,k)<0){
					biggerThanZero=false;
					break;
				}
			}
			if(biggerThanZero) count++;
		}
	}
	public static int aux2(int[] array, int[][] memo,int i, int k){
		if(i==0){
			memo[i][k]=array[k];
			return memo[i][k];
		}
		else{
			memo[i][k]=memo[i-1][k]+array[(i+k)%array.length];
			return memo[i][k];
		}
	}
}
