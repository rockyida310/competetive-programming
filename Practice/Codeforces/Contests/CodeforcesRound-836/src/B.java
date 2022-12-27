import java.io.*;
import java.util.*;

public class B {
	static FastScanner fs;
	static PrintWriter out;
	static final Random random=new Random();
	static final int mod=1_000_000_007;
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	public static void main(String[] args) {
		fs=new FastScanner();
		out=new PrintWriter(System.out);
		
		int T=1;
		T = fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			solve();
		}
		out.close();
	}
	
	static void swap(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	@SuppressWarnings("unused")
	private static int gcd(int a,int b) {
		if(a < b)
			swap(a,b);
		return b==0 ? a : gcd(b,a%b);
	}
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	
	public static void solve() {
		int n = fs.nextInt();
		
		if(n%2==1) {
			for(int i=0;i<n;++i) {
				out.print(1+" ");
			}
			out.println();
			return;
		}
		
		/*
		 sum = xor * n
		 
		 
		 
//		 x^y == ( (n-1)*x+y ) / n
//		 
//		 */
//		
//		for(int x=0;x<1000;++x) {
//			boolean flag = false;
//			for(int y=0;y<1000;++y) {
//				if((x^y)*n == ((n-1)*x+y) ) {
//					out.println(x+" "+y);
//				}
//			}
//		}
		
		for(int i=0;i<n;++i) {
			if(i==n-1)
				out.print(1);
			else out.print( (n+1)+" ");
		}
		
		out.println();
	}
}