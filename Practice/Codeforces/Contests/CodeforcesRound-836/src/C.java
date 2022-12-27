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
		 int n = fs.nextInt(),x=  fs.nextInt();
		 
		 if(n%x != 0) {
			 out.println(-1);
			 return;
		 }
		 
		 int v = n/x;
		 ArrayList<Integer> factors = new ArrayList<>();
		 
		 while(v > 1) {
			 for(int f=2;f<=v;++f) {
				 while(v%f == 0) {
					 factors.add(f);
					 v /= f;
				 }
			 }
		 }
		 
		 boolean[] isPart = new boolean[n+1];
		 int[] nextVal = new int[n+1];
		 
		 int curr = x;
		 for(int f : factors) {
			 isPart[curr] = true;
			 nextVal[curr] = f*curr;
			 curr = curr*f;
		 }
		 
		 assert(curr == n);
		 
		 for(int i=1;i<=n;++i) {
			 if(i==1) {
				 out.print(x+" ");
			 }else if(i==n) {
				 out.print(1+" ");
			 }else if(isPart[i]) {
				 out.print(nextVal[i]+" ");
			 }else {
				 out.print(i+" ");
			 }
		 }
		 
		 out.println();
	}
}