import java.io.*;
import java.util.*;

public class D {
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
		/*
		 
		 (sum)^(1/2) == range == max-min
		 sum == range^2
		 
		 1+3 = 4 = 2*2   , range = 3-1 = 2 , range^2 = 4
		 1+3+5 = 9 = 3*3 , range = 5-1 = 4 , range^2 = 16
		 1+3+5+7 = 16 = 4*4 , range = 7-1 = 6 , range^2 = 36
		 
		 we want sum == range^2
		 we cannot change range , but we can increase sum
		 
		 sequence , originally
		 1,3,5,7...n times
		 
		 1+(n-1)*2 = 1+2*n-2 = 2*n-1
		 range = 2n-2
		 range square = 4*n*n+4-8*n
		 
		 diff = (4*n*n+4-8n) - (n*n)
		 	  = 3*n*n+4-8*n
		 	  = n*(3*n-8)+4
		 
		 add 3*n+8 to each number and 4 to some middle number
		 
		 sum = n*n
		 range square = 
		 
		 */
		
		int n = fs.nextInt();
		
		long diff = (long)n*(3*n-8)+4;
		long each = diff / n;
		long extra = diff - each*n;
		
		long[] ans = new long[n];
		
		for(int i=0;i<n;++i) {
			ans[i] = 2*i+1 + each;
		}
		
		if(extra == 1) {
			assert(n!=1 && n!=2);
			ans[1]++;
			--extra;
		}
		
		int l=0,r=n-1;
		while(extra > 0) {
			ans[l]++;
			++l;
			extra--;
			if(extra > 0) {
				ans[r]++;
				--r;
				extra--;
			}
		}
		
		for(int i=0;i<n;++i) {
			out.print(ans[i]+" ");
		}
		
		out.println();
	}
}