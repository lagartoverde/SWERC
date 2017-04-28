package swerc2013;

import java.util.HashMap;
import java.util.Scanner;

public class ProblemC {
	public static class Nodo{
		int id;
		int x;
		int y;
		int z;
		HashMap<Nodo,Integer> adj;
		Nodo pre;
		double dist=0;
		public Nodo(int id, int x, int y, int z){
			this.id=id;
			this.x=x;
			this.y=y;
			this.z=z;
			adj=new HashMap();
			dist=0;
		}
		public Nodo(Nodo e){
			id=e.id;
			x=e.x;
			y=e.y;
			z=e.z;
			adj=new HashMap(e.adj);
			pre=e.pre;
			dist=e.dist;
		}
	}
	static double[][] adj;
	static Nodo[] queue;
	static Nodo[] nodes;
	static int queueLength=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int numberOfNodes=sc.nextInt();
		queue=new Nodo[numberOfNodes];
		adj=new double[numberOfNodes][numberOfNodes];
		int numberOfConnections=sc.nextInt();
		nodes=new Nodo[numberOfNodes];
		for(int i=0;i<numberOfNodes;i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			nodes[i]=new Nodo(i,x,y,z);
		}
		for(int j=0;j<numberOfConnections;j++){
			int first=sc.nextInt();
			int second=sc.nextInt();
			String type=sc.next();
			if(type.equals("walking")||type.equals("stairs")){
				double distance=distance(nodes[first],nodes[second]);
				adj[first][second]=distance;
				adj[second][first]=distance;
			}else if(type.equals("lift")){
				adj[first][second]=1;
				adj[second][first]=1;
			}else{
				double distance=distance(nodes[first],nodes[second]);
				adj[first][second]=1;
				adj[second][first]=distance*3;
			}
		}
		int numberOfQuerys=sc.nextInt();
		for(int a=0;a<numberOfQuerys;a++){
			int source=sc.nextInt();
			int dest=sc.nextInt();
			queue=new Nodo[numberOfNodes];
			queueLength=0;
			djisktra(nodes[source],nodes[dest]);
		}
	}
	
	public static double distance(Nodo node1, Nodo node2){
		int powx=(int) Math.pow(node1.x-node2.x, 2);
		int powy=(int) Math.pow(node1.y-node2.y, 2);
		int powz=(int) Math.pow(node1.z-node2.z, 2);
		return Math.sqrt(powx+powy+powz);
	}
	
	public static void djisktra(Nodo source, Nodo dest){
		queue[0]=new Nodo(source);
		queueLength++;
		auxdjisktra(source,dest);
	}
	public static void auxdjisktra(Nodo source,Nodo dest){
		Nodo node=queue[0];
		if(node.id==dest.id){
			while(node.id!=source.id){
				System.out.print(node.id+" ");
				node=node.pre;
			}
			System.out.print(source.id);
			return;
		}
		popFirstElement();
		for(int i=0;i<adj.length;i++){
			double distance=adj[node.id][i];
			if(distance!=0){
				Nodo newNode=new Nodo(nodes[i]);
				newNode.dist=node.dist+distance;
				newNode.pre=node;
				pushElement(newNode);
			}
		}
		auxdjisktra(source,dest);
	}
	public static void popFirstElement(){
		System.out.println("queue: "+queueLength);
		for(int i=1;i<queueLength;i++){
			queue[i-1]=queue[i];
		}
		queueLength--;
	}
	public static void pushElement(Nodo e){
		System.out.println("queue: "+queueLength);
		int i=0;
		while(!(queue[i]==null)&&queue[i].dist<=e.dist){
			if(queue[i].id==e.id) return;
			i++;
		}
		Nodo aux=null;
		Nodo acambiar=e;
		int cambio=1;
		for(;i<queueLength;i++){
			if(!(queue[i]==null)&&queue[i].id==e.id){
				aux=null;
				queue[i]=acambiar;
				cambio=0;
			}else{
				aux=queue[i];
				queue[i]=acambiar;
				acambiar=aux;
			}
		}
		queueLength+=cambio;
	}
}
