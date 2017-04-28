package swerc2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashMap<Integer,Integer> veces=new HashMap();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(!veces.containsKey(i+j)){
					veces.put(i+j, 1);
				}else{
					veces.put(i+j, veces.get(i+j)+1);
				}
			}
		}
		ArrayList<Integer> probables=new ArrayList();
		int mayor=0;
		for(int j=2;j<n+m;j++){
			int contenidoVeces=veces.get(j);
			if(contenidoVeces>=mayor){
				if(contenidoVeces>mayor){
					probables.clear();
					probables.add(j);
					mayor=contenidoVeces;
				}else{
					probables.add(j);
				}
			}
		}
		for(int i:probables){
			System.out.println(i);
		}

	}

}
