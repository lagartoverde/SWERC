package swerc2014;

import java.util.Scanner;

public class SolutionJ {
	static int hp;
	static int wp;
	static int hm;
	static int wm;
	static String[] paint;
	static String[] mural;
	static int count=0;
	static int[] kmpArray;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		hp=sc.nextInt();
		wp=sc.nextInt();
		hm=sc.nextInt();
		wm=sc.nextInt();
		
		paint=new String[hp];
		for(int i=0;i<hp;i++){
			paint[i]=sc.next();
		}
		mural=new String[hm];
		for(int j=0;j<hm;j++){
			mural[j]=sc.next();
		}
		map=new int[hm][wm];
		System.out.println("pensando");
		String contenida=paint[0];
		int line=0;
		int startIndex=-1;
		kmpArray=new int[contenida.length()];
		for(int i=1;i<contenida.length();i++){
			int k=0;
			if(contenida.charAt(i)==contenida.charAt(k)){
				kmpArray[i]=kmpArray[i-1]+1;
				k++;
			}else{
				k=0;
			}
		}
		while(line+hp<=hm){
			String lineString=paint[0];
			startIndex=kmp(lineString,mural[line],startIndex+1);
			if(startIndex!=-1){
				comprobar(startIndex,line);
			}else{
				line++;
				startIndex=-1;
			}
			
		}
		System.out.println(count);
		
	}
	public static void comprobar(int index, int height){
		int j=height;
		for(int i=0;i<hp;i++){
			int l=index;
			for(int k=0;k<wp;k++){
				if(paint[i].charAt(k)!=mural[j].charAt(l)) return;
				l++;
			}
			j++;
		}
		count++;
	}
	public static int kmp(String contenida, String contenedor,int startIndex){
		int b=0;
		for(int a=startIndex;a<contenedor.length();a++){
			if(contenedor.charAt(a)==contenida.charAt(b)){
				b++;
				if(b==contenida.length()){
					return a-contenida.length()+1;
				}
			}else{
				a=a-kmpArray[b];
				b=0;
			}
		}
		return -1;
	}
}
