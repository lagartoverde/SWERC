package exam2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemK {
	public static class Node{
		static int generator=0;
		int id;
		int rank;
		Node parent;
		public Node(){
			id=generator;
			generator++;
			rank=0;
			parent=this;
		}
	}
	public static void main(String[] args){
		int rep=0;
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		HashMap<Integer,Node> threeD=new HashMap();
		HashMap<Integer,Node> twoD=new HashMap();
		int count=0;
		ArrayList<Long> edges=new ArrayList();
		for(int i=0;i<number;i++){
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int z1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int z2=sc.nextInt();
			int key2=x2*1000*1000+y2*1000+z2;
			Node second;
			if(threeD.containsKey(key2)){
				second=threeD.get(key2);
			}else{
				second=new Node();
				threeD.put(key2,second);
			}
			int key1=x1*1000*1000+y1*1000+z1;
			Node first;
			if(threeD.containsKey(key1)){
				first=threeD.get(key1);
			}else{
				first=new Node();
				threeD.put(key1, first);
			}
			if(count<2){
				if(findset(first)!=findset(second)){
					union(first,second);
				}else{
					count+=2;
				}
			}
			int key22D=x2*1000+y2;
			Node second2D;
			if(twoD.containsKey(key22D)){
				second2D=twoD.get(key22D);
			}else{
				second2D=new Node();
				twoD.put(key22D,second2D);
			}
			if(x1==x2&&y1==y2) {
				continue;
			}
			int key12D=x1*1000+y1;
			Node first2D;
			if(twoD.containsKey(key12D)){
				first2D=twoD.get(key12D);
			}else{
				first2D=new Node();
				twoD.put(key12D, first2D);
			}
			if(count%2==0){
				int aux=0;
				if(key12D<key22D){
					aux=key12D;
					key12D=key22D;
					key22D=aux;
				}
				if(edges.contains((long)key12D*1000*1000+key22D)){
					System.out.println("repetido :"+rep+" , "+key12D+" , "+key22D);
					rep++;
					continue;
				}
				if(findset(first2D)!=findset(second2D)){
					union(first2D,second2D);
					edges.add((long)key12D*1000*1000+key22D);
				}else{
					System.out.println("encontrado"+" , "+key12D+" , "+key22D);
					count+=1;
				}
			}
		}
		switch(count){
			case 0:
				System.out.println("No true closed chains");
				System.out.println("No floor closed chains");
				break;
			case 1:
				System.out.println("No true closed chains");
				System.out.println("Floor closed chains");
				break;
			case 2:
				System.out.println("True closed chains");
				System.out.println("No floor closed chains");
				break;
			case 3:
				System.out.println("True closed chains");
				System.out.println("Floor closed chains");
				break;
		}
		
	}
	public static Node findset(Node e){
		if(e.parent.id==e.id){
			return e;
		}else{
			e.parent=findset(e.parent);
			return e.parent;
		}
	}
	public static void union(Node a,Node b){
		Node setA=findset(a);
		Node setB=findset(b);
		if(setA.id==setB.id) return;
		if(setA.rank>=setB.rank){
			setB.parent=setA;
			if(setA.rank==0){
				setA.rank=1;
			}else{
				setA.rank+=setB.rank;
			}
		}else{
			setA.parent=setB;
			if(setB.rank==0){
				setB.rank=1;
			}else{
				setB.rank+=setA.rank;
			}
		}
	}
}
