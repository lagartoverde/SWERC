
public class Primes {

	public static void main(String[] args) {
		long[] primes=new long[2000000];
		int i;
		long total=0;
		for(i=2;i<primes.length;i++){
			primes[i]=i;
			//total+=i;
		}
		System.out.println(total);
		System.out.println("Array rellenado");
		for(int j=2;j<=Math.floor(Math.sqrt(primes.length))+1;j++){
			if(primes[j]==0) continue;
			for(int h=2;h<(primes.length)/j;h++){
				//total-=primes[j*h];
				primes[j*h]=0;
			}
		}
		System.out.println("Criba realizada");
		for(int k=1;k<primes.length;k++){
			total+=primes[k];
		}
		
		System.out.println(total);
	}

}
