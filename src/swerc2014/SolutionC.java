package swerc2014;
import java.util.*;
public class SolutionC {
	static int[] distances;
	static int[] holes;
	static int[] memo;
	static int count=0;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int distancesLength=sc.nextInt();
		distances=new int[distancesLength];
		for(int i=0;i<distancesLength;i++){
			distances[i]=sc.nextInt();
		}
		int holesLength=sc.nextInt();
		holes=new int[holesLength];
		for(int j=0;j<holesLength;j++){
			holes[j]=sc.nextInt();
		}
		memo=new int[distances[distances.length-1]*2+1];
		for(int h=0;h<distancesLength;h++){
			checkDistance(distances[h]);
			aux(distances[h]);
		}
		System.out.println(count);
	}
	public static void aux(int distance){
		if(memo[distance]==0){
			checkDistance(distance);
		}
		for(int h=0;h<distances.length;h++){
			if(memo[distance+distances[h]]!=0) continue;
			checkDistance(distance+distances[h]);
		}
	}
	public static void checkDistance(int totalDistance){
		for(int i=0;i<holes.length;i++){
			if(holes[i]==totalDistance){
				count+=1;
				holes[i]=-1;
			}
		}
		memo[totalDistance]=1;
	}
	

}
