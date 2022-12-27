import java.io.*;
import java.util.*;

public class C {
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
		int[] arr = fs.readArray(n);
		ruffleSort(arr);
		
		if(arr[0]==arr[n-1]) {
			System.out.println(n/2);
			return;
		}
		
		long ans = 0;
		
		for(int i=1;i<n;++i) {
			if(arr[i] != arr[i-1]) {
				ans = Math.max(ans , (long)i * (n-i) );
			}
		}
		
		System.out.println(ans);
	}
}