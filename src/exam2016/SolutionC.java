package exam2016;

import java.util.Scanner;

public class SolutionC {
	static int solutionRita;
	static int solutionTheo;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ageOfRita=4;
		int differenceInAges=sc.nextInt();
		int ageOfTheo=ageOfRita-differenceInAges;
		solutionRita=sc.nextInt();
		solutionTheo=sc.nextInt();
		System.out.println(aux(ageOfRita,ageOfTheo,0,0));
	}
	
	public static int aux(int ageOfRita,int ageOfTheo,int candleOfRita,int candleOfTheo){
		if(candleOfRita>solutionRita) return 0;
		if(solutionRita-candleOfRita==candleOfTheo-solutionTheo) return solutionRita-candleOfRita;
		if(ageOfTheo>=3) candleOfTheo+=ageOfTheo;
		candleOfRita+=ageOfRita;
		return aux(ageOfRita+1,ageOfTheo+1,candleOfRita,candleOfTheo);
	}

}
