package swerc2011;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemH {
	public static class Paper{
		String institution;
		ArrayList<Integer> toReview;
		int reviewedBy;
		boolean problem;
		public Paper(String inst){
			institution=inst;
			toReview=new ArrayList<Integer>();
			reviewedBy=0;
			problem=false;
		}
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int numberOfReviews=sc.nextInt();
			int numberOfPapers=sc.nextInt();
			if(numberOfReviews==0&&numberOfPapers==0) break;
			Paper[] papers=new Paper[numberOfPapers];
			for(int i=0;i<numberOfPapers;i++){
				papers[i]=new Paper(sc.next());
				for(int j=0;j<numberOfReviews;j++){
					int paperReview=sc.nextInt();
					if(paperReview==i+1){
						papers[i].problem=true;
					}else{
						papers[i].toReview.add(paperReview);
					}
				}
			}
			for(int h=0;h<numberOfPapers;h++){
				Paper paper=papers[h];
				paper.toReview.sort(null);
				for(int k=0;k<paper.toReview.size();k++){
					if(k>=1&&paper.toReview.get(k)==paper.toReview.get(k-1)){
						papers[paper.toReview.get(k)-1].problem=true;
					}else if(paper.institution.equals(papers[paper.toReview.get(k)-1].institution)){
						papers[paper.toReview.get(k)-1].problem=true;
						//paper.problem=true;
					}else{
						papers[paper.toReview.get(k)-1].reviewedBy+=1;
					}
				}
			}
			int problems=0;
			for(int a=0;a<numberOfPapers;a++){
				if(papers[a].reviewedBy!=numberOfReviews||papers[a].problem) problems++;
			}
			if(problems==0){
				System.out.println("NO PROBLEMS FOUND");
			}else if(problems==1){
				System.out.println("1 PROBLEM FOUND");
			}else{
				System.out.println(problems+" PROBLEMS FOUND");
			}
		}
	}
}
