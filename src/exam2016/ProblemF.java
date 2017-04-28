package exam2016;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemF {
	public static class Node{
		int id;
		static int generator=0;
		int rank=0;
		int tiempo1;
		int tiempo2;
		Node parent;
		ArrayList<Node> childs;
		boolean explorado;
		public Node(){
			id=generator;
			generator++;
			tiempo1=0;
			tiempo2=0;
			parent=this;
			childs=new ArrayList<Node>();
			explorado=false;
		}
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int numberOfEmployees=sc.nextInt();
		Node[] employees=new Node[numberOfEmployees];
		for(int i=0;i<numberOfEmployees;i++){
			employees[i]=new Node();
		}
		int jefazo=-1;
		for(int j=0;j<numberOfEmployees;j++){
			int padre=sc.nextInt();
			int rango=sc.nextInt();
			int tiempo=sc.nextInt();
			if(padre==-1){
				jefazo=j;
			}else{
				employees[j].parent=employees[padre-1];
				employees[padre-1].childs.add(employees[j]);
			}
			employees[j].rank=rango;
			employees[j].tiempo1=tiempo;
		}
		explorar(employees[jefazo]);
		for(int h=0;h<employees.length;h++){
			System.out.println(employees[h].tiempo2);
		}
	}
	
	public static void explorar(Node node){
		int tiempo=0;
		for(int i=0;i<node.childs.size();i++){
			Node tratando=node.childs.get(i);
			if(!tratando.explorado){
				explorar(tratando);
				tratando.explorado=true;
			}
			if(tratando.rank>=node.rank){
				if(node.parent.id!=node.id){
					tratando.parent=node.parent;
					node.parent.childs.add(tratando);
				}
				continue;
			}
			if(node.rank>node.parent.rank&&tratando.rank<node.parent.rank){
				node.parent.childs.add(tratando);
			}
			tiempo+=tratando.tiempo2;
			tiempo+=tratando.tiempo1;
		}
		node.tiempo2+=tiempo;
	}
}
	