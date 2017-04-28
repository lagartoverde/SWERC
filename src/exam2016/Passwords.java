package exam2016;
import java.util.*;

public class Passwords {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("a");
		int a=sc.nextInt();
		System.out.println("b");
		int b=sc.nextInt();
		System.out.println("length");
		int blacklistedLength=sc.nextInt();
		System.out.println("blacklisted");
		String[] blacklistedWords=new String[blacklistedLength];
		for(int i=0;i<blacklistedLength;i++){
			blacklistedWords[i]=sc.next();
		}
		long totalCombinations=0;
		for(int i=a; i<=b;i++){
			long blackListedCombinations=0;
			for(int j=0;j<blacklistedLength;j++){
				if(blacklistedWords[j].length()>i){
					continue;
				}
				int lettersAsNumbers=0;
				for(int h=0;h<blacklistedWords[j].length();h++){
					char letter=blacklistedWords[j].charAt(h);
					if(letter=='o'||letter=='i'||letter=='t'||letter=='e'||letter=='s'){
						lettersAsNumbers++;
					}
				}
				int blacklistedWordLength=blacklistedWords[j].length();
				int lettersNotNumbers=blacklistedWordLength-lettersAsNumbers;
				int combinationsOfBlacklisted=(int)Math.pow(2,lettersNotNumbers)*(int)Math.pow(3,lettersAsNumbers);
				int differenceInLength=i-blacklistedWords[j].length();
				if(differenceInLength<0) continue;
					blackListedCombinations+=(combinationsOfBlacklisted*Math.pow(62,differenceInLength))-(Math.pow(2,blacklistedWordLength)-2)*Math.pow(52,differenceInLength)-2*(Math.pow(2, lettersAsNumbers)-1)*Math.pow(26, differenceInLength)-(2*Math.pow(36, differenceInLength));
			}
			System.out.println(blackListedCombinations);
			totalCombinations+=Math.pow(62,i)-Math.pow(52,i)-2*Math.pow(36, i)+2*Math.pow(26, i)+Math.pow(10, i)-blackListedCombinations;
		}
		System.out.println(totalCombinations);
	}

}
