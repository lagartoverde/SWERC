package swerc2014;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemD {
	public static class Node{
		int id;
		static int generator=0;
		ArrayList<Edge> connections;
		public Node(){
			id=generator;
			generator++;
			connections=new ArrayList<Edge>();
		}
		
	}
	public static class Edge{
		int id;
		static int generator=0;
		Node to;
		int capacity;
		Edge inverse;
		public Edge(Node e,int capacity){
			id=generator;
			generator++;
			to=e;
			this.capacity=capacity;
		}
	}
	static int numberOfPersons;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		numberOfPersons=sc.nextInt();
		Node[] personsReceivingBooks=new Node[numberOfPersons];
		Node[] personsGivingBooks=new Node[numberOfPersons];
		Node source=new Node();
		Node sink=new Node();
		for(int i=0;i<numberOfPersons;i++){
			personsReceivingBooks[i]=new Node();
			personsGivingBooks[i]=new Node();
			Edge e1=new Edge(personsReceivingBooks[i],1);
			Edge e2=new Edge(source,0);
			e1.inverse=e2;
			e2.inverse=e1;
			source.connections.add(e1);
			personsReceivingBooks[i].connections.add(e2);
			Edge e3=new Edge(personsGivingBooks[i],0);
			Edge e4=new Edge(sink,1);
			e3.inverse=e4;
			e4.inverse=e3;
			sink.connections.add(e3);
			personsGivingBooks[i].connections.add(e4);
		}
		int numberOfConnections=sc.nextInt();
		for(int j=0;j<numberOfConnections;j++){
			int receiver=sc.nextInt();
			int giver=sc.nextInt();
			Edge e1=new Edge(personsGivingBooks[giver],1);
			Edge e2=new Edge(personsReceivingBooks[receiver],0);
			e1.inverse=e2;
			e2.inverse=e1;
			personsReceivingBooks[receiver].connections.add(e1);
			personsGivingBooks[giver].connections.add(e2);
		}
		procesar(source);
		int matches=0;
		for(Edge e:sink.connections){
			if(e.capacity==1) matches++;
		}
		String response= matches==numberOfPersons ? "YES" : "NO";
		System.out.println(response);
	}
	
	public static void procesar(Node source){
		for(Edge e:source.connections){
			if(e.capacity==0) continue;
			if(procesarAux(e.to)) e.capacity=0;
		}
	}
	
	public static boolean procesarAux(Node node){
		int[] visited=new int[numberOfPersons*2+2];
		visited[node.id]=1;
		if(node.id==1) return true;
		if(node.id==0) return false;
		for(Edge edge:node.connections){
			if(edge.capacity==0) continue;
			if(procesarAux2(edge.to,visited)){
				edge.capacity=0;
				edge.inverse.capacity=1;
				return true;
			}
		}
		
		return false;
	}
	public static boolean procesarAux2(Node node,int[] visited){
		if(visited[node.id]==1) return false;
		if(node.id==1) return true;
		if(node.id==0) return false;
		visited[node.id]=1;
		for(Edge edge:node.connections){
			if(edge.capacity==0) continue;
			if(procesarAux2(edge.to,visited)){
				edge.capacity=0;
				edge.inverse.capacity=1;
				return true;
			}
		}
		return false;
	}
	
}
