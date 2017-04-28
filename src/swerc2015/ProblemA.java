package swerc2015;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemA {
	public static class Nodo{
		int id;
		ArrayList<Nodo> precedence=new ArrayList();
		ArrayList<Nodo> post=new ArrayList();
		boolean marcado=false;
		public Nodo(int id){
			this.id=id;
		}
		public Nodo(Nodo a){
			id=a.id;
			precedence=new ArrayList(a.precedence);
			post=new ArrayList(a.post);
			marcado=a.marcado;
		}
	}
	static ArrayList<Nodo> empleados;
	static ArrayList<Nodo> ascendidos;
	static int aValue=0;
	static int bValue=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int empleadosLength=sc.nextInt();
		empleados=new ArrayList();
		for(int i=0;i<empleadosLength;i++){
			empleados.add(new Nodo(i));
		}
		int precedenceRules=sc.nextInt();
		for(int j=0;j<precedenceRules;j++){
			int empleadoA=sc.nextInt();
			int empleadoB=sc.nextInt();
			empleados.get(empleadoB).precedence.add(empleados.get(empleadoA));
			empleados.get(empleadoA).post.add(empleados.get(empleadoB));
		}
		ascendidos=new ArrayList();;
		for(int h=0;h<empleadosLength;h++){
			if(empleados.get(h).precedence.size()==0){
				ascendidos.add(empleados.get(h));
				empleados.get(h).marcado=true;
			}
		}
		seleccionar(a,b);
	}
	public static void seleccionar(int a, int b){
		boolean cambio=true;
		ArrayList<Nodo> ascendidosCopy=new ArrayList(ascendidos);
		while(ascendidos.size()<=b){
			ArrayList<Integer> added=new ArrayList();
			ascendidos=new ArrayList(ascendidosCopy);
			if(ascendidos.size()<=a){
				aValue=ascendidos.size();
			}
			if(ascendidos.size()<=b){
				bValue=ascendidos.size();
				if(ascendidos.size()==b){
					break;
				}
			}
			ascendidosCopy=new ArrayList(ascendidos);
			cambio=false;
			for(Nodo empleado:ascendidos){
				for(Nodo empleadoCandidato:empleado.post){
					boolean candidato=true;
					for(Nodo empleadoPrecedence:empleadoCandidato.precedence){
						if(!empleadoPrecedence.marcado){
							candidato=false;
							break;
						}
					}
					if(candidato) {
						Nodo nuevo=new Nodo(empleadoCandidato);
						nuevo.marcado=true;
						if(added.indexOf(nuevo.id)==-1){
							added.add(nuevo.id);
							ascendidosCopy.add(nuevo);
						}
					}
				}
			}
		}
		System.out.println(aValue);
		System.out.println(bValue);
		System.out.println(empleados.size()-ascendidosCopy.size());
	}
}
