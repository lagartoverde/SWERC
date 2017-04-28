package swerc2015;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionG {
	static ArrayList<ArrayList<Integer>> piles=new ArrayList();
	static int maximumCardsToRemove;
	static int[] endPiles;
	static int numberOfPiles;
	
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		numberOfPiles=sc.nextInt();
		maximumCardsToRemove=sc.nextInt();
		endPiles=new int[numberOfPiles];
		for(int i=0;i<numberOfPiles;i++){
			endPiles[i]=sc.nextInt();
			ArrayList<Integer> pile=new ArrayList();
			for(int j=0;j<endPiles[i];j++){
				pile.add(sc.nextInt());
			}
			piles.add(pile);
		}
		System.out.println(max());
	}
	
	public static boolean max(){
		for(int i=0;i<numberOfPiles;i++){
			if(endPiles[i]==0){
				continue;
			}
			for(int j=1;j<=maximumCardsToRemove;j++){
				if(endPiles[i]-j<=0) continue;
				int savedState=endPiles[i];
				endPiles[i]=endPiles[i]-j;
				int drawnCard=piles.get(i).get(endPiles[i]);
				endPiles[i]=endPiles[i]-1;
				if(endPiles[i]-drawnCard<0){
					endPiles[i]=savedState;
					continue;
				}else{
					if(min()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean min(){
		for(int i=0;i<numberOfPiles;i++){
			if(endPiles[i]==0){
				continue;
			}
			for(int j=1;j<=maximumCardsToRemove;j++){
				if(endPiles[i]-j<=0) continue;
				int savedState=endPiles[i];
				endPiles[i]=endPiles[i]-j;
				int drawnCard=piles.get(i).get(endPiles[i]);
				endPiles[i]=endPiles[i]-1;
				if(endPiles[i]-drawnCard<0){
					endPiles[i]=savedState;
					continue;
				}else{
					if(!max()){
						return false;
					}
				}
			}
		}
		return true;
	}
}
