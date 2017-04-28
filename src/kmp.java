
public class kmp {
	
	public static String contenedor="xxxoxxoxxo";
	public static String contenida="oxxo";
	
	public static void main(String[] args){
		int[] kmpArray=new int[contenida.length()];
		for(int i=1;i<contenida.length();i++){
			int k=0;
			if(contenida.charAt(i)==contenida.charAt(k)){
				kmpArray[i]=kmpArray[i-1]+1;
				k++;
			}else{
				k=0;
			}
		}
		int b=0;
		for(int a=0;a<contenedor.length();a++){
			System.out.println(a+" "+b);
			if(contenedor.charAt(a)==contenida.charAt(b)){
				b++;
				if(b==contenida.length()){
					System.out.println(a-contenida.length()+1);
					return;
				}
			}else{
				a=a-kmpArray[b];
				b=0;
			}
		}
	}
	
}
