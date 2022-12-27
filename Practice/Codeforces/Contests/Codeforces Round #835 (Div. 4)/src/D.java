import java.io.*;
import java.util.*;

public class D {
	public static void solve() {
		int n = fs.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(Integer.MAX_VALUE);
		
		for(int i=0;i<n;++i) {
			int x = fs.nextInt();
			if(arr.isEmpty() || arr.get(arr.size()-1)!=x) {
				arr.add(x);
			}
		}
		
		arr.add(Integer.MAX_VALUE);
		
		int cnt = 0;
		for(int i=1;i+1<arr.size() && cnt<=1 ;++i) {
			if(arr.get(i-1) > arr.get(i) && arr.get(i)<arr.get(i+1)) {
				++cnt;
			}
		}
		
		if(cnt > 1)
			out.println("NO");
		else out.println("YES");
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
	
}