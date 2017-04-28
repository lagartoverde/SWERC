package swerc2009;

import java.util.Scanner;

public class ProblemI {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(m==0&&n==0) break;
			int[][] calls=new int[n][2];
			for(int i=0;i<n;i++){
				int caller=sc.nextInt();
				int receiver=sc.nextInt();
				calls[i][0]=sc.nextInt();
				calls[i][1]=sc.nextInt();
			}
			for(int j=0;j<m;j++){
				int start=sc.nextInt();
				int duration=sc.nextInt();
				aux(calls,start,duration);
			}
		}
	}
	public static void aux(int[][] calls,int start, int duration){
		int count=0;
		for(int i=0;i<calls.length;i++){
			int callStart=calls[i][0];
			int callDuration=calls[i][1];
			if(start+duration>callStart&&callStart+callDuration>start) count++;
		}
		System.out.println(count);
	}
}
