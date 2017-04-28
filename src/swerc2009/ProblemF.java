package swerc2009;

import java.util.Scanner;

public class ProblemF {
	static int[][] map;
	static int[][] holes;
	static Nodo[] queue;
	static int queueLength=0;
	static int solution=Integer.MAX_VALUE;
	static int minPortal=0;
	static Nodo anterior1;
	static Nodo anterior2;
	public static class Nodo{
		int x;
		int y;
		int coming;
		int seconds;
		public Nodo(int x, int y, int coming, int seconds){
			this.x=x;
			this.y=y;
			this.coming=coming;
			this.seconds=seconds;
		}
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int width=sc.nextInt();
			int height=sc.nextInt();
			if(width==0&&height==0) break;
			queueLength=0;
			solution=Integer.MAX_VALUE;
			minPortal=0;
			map=new int[width][height];
			int numberOfGraves=sc.nextInt();
			for(int i=0;i<numberOfGraves;i++){
				int widthCoor=sc.nextInt();
				int heightCoor=sc.nextInt();
				map[widthCoor][heightCoor]=-1;
			}
			int numberOfHoles=sc.nextInt();
			holes=new int[numberOfHoles][3];
			for(int j=0;j<numberOfHoles;j++){
				int widthCoor=sc.nextInt();
				int heightCoor=sc.nextInt();
				map[widthCoor][heightCoor]=j+1;
				holes[j][0]=sc.nextInt();
				holes[j][1]=sc.nextInt();
				holes[j][2]=sc.nextInt();
				if(holes[j][2]<minPortal) minPortal=holes[j][2];
			}
			queue=new Nodo[width*height];
			if(width==1&&height==1) {
				System.out.print(0);
				continue;
			}
			inicio();
		}
	}
	static void inicio(){
		queue[0]=new Nodo(0,0,0,0);
		queueLength++;
		djisktra();
	}
	static void djisktra(){
		Nodo nodo=null;
		while(true){
			anterior1=anterior2;
			anterior2=nodo;
			nodo=queue[0];
			if(anterior1!=null&&nodo.x==anterior1.x&&nodo.y==anterior1.y&&nodo.seconds==anterior1.seconds){
				popFirstElement();
				continue;
			}
			if(nodo.seconds>900){
				System.out.println("impossible");
				return;
			}
			if(nodo.seconds<-900){
				System.out.println("never");
				return;
			}
			if(nodo.x==map.length-1&&nodo.y==map[0].length-1){
				if(nodo.seconds<solution) solution=nodo.seconds;
				if(solution<-900) {
					System.out.println("never");
					return;
				}
				popFirstElement();
				if(queue[0]==null){
					System.out.println(solution);
					return;
				}else{
					nodo=queue[0];
				}
			}
			if(nodo.seconds+minPortal>solution){
				System.out.println(solution);
				return;
			}
			popFirstElement();
			int seconds=nodo.seconds;
			int x=nodo.x;
			int y=nodo.y;
			int coming=nodo.coming;
			if(map[x][y]>0){
				int hole=map[x][y]-1;
				seconds+=holes[hole][2];
				pushElement(seconds,holes[hole][0],holes[hole][1],-1);
				continue;
			}
			seconds+=1;
			if(!(coming==0)){
				if(!(x>=map.length||x<0||y-1<0||y-1>=map[0].length)){
					norte(seconds,x,y);
				}
			}
			if(!(coming==1)){
				if(!(x>=map.length||x<0||y+1<0||y+1>=map[0].length)){
					sur(seconds,x,y);
				}
			}
			if(!(coming==2)){
				if(!(x+1>=map.length||x+1<0||y<0||y>=map[0].length)){
					este(seconds,x,y);
				}
			}
			if(!(coming==3)){
				if(!(x-1>=map.length||x-1<0||y<0||y>=map[0].length)){
					oeste(seconds,x,y);
				}
			}
		}
	}
	
	static void norte(int tiempo,int x, int y){
		if(map[x][y-1]==-1) return;
		if(map[x][y-1]>0){
			int hole=map[x][y-1]-1;
			tiempo+=holes[hole][2];
			pushElement(tiempo,holes[hole][0],holes[hole][1],-1);
			return;
		}
		pushElement(tiempo,x,y-1,1);
	}
	
	static void sur(int tiempo,int x, int y){
		if(map[x][y+1]==-1) return;
		if(map[x][y+1]>0){
			int hole=map[x][y+1]-1;
			tiempo+=holes[hole][2];
			pushElement(tiempo,holes[hole][0],holes[hole][1],-1);
			return;
		}
		pushElement(tiempo,x,y+1,0);
	}
	
	static void este(int tiempo,int x, int y){
		if(map[x+1][y]==-1) return;
		if(map[x+1][y]>0){
			int hole=map[x+1][y]-1;
			tiempo+=holes[hole][2];
			pushElement(tiempo,holes[hole][0],holes[hole][1],-1);
			return;
		}
		pushElement(tiempo,x+1,y,3);
	}
	
	static void oeste(int tiempo,int x, int y){
		if(map[x-1][y]==-1) return;
		if(map[x-1][y]>0){
			int hole=map[x-1][y]-1;
			tiempo+=holes[hole][2];
			pushElement(tiempo,holes[hole][0],holes[hole][1],-1);
			return;
		}
		pushElement(tiempo,x-1,y,2);
	}
	
	static void pushElement(int tiempo,int x,int y,int coming){
		int i=0;
		while(queue[i]!=null&&queue[i].seconds<tiempo){
			i++;
		}
		Nodo aux=null;
		Nodo acambiar=new Nodo(x,y,coming,tiempo);
		int cambiar=1;
		for(;i<=queueLength;i++){
			if(i==queueLength){
				queue[i]=acambiar;
				break;
			}
			if(queue[i].x==x&&queue[i].y==y){
				cambiar=0;
				queue[i]=acambiar;
				break;
			}else{
				aux=queue[i];
				queue[i]=acambiar;
				acambiar=aux;
			}
		}
		queueLength+=cambiar;
		
	}
	public static void popFirstElement(){
		for(int i=1;i<queueLength+1;i++){
			queue[i-1]=queue[i];
		}
		queueLength--;
	}
}
