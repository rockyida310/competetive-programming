import java.io.*;
import java.util.*;

public class F {
	static final long MAX_VAL = (long)1e17;
	
	static boolean good(int k,long c,int d,int[] arr) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
		for(int x : arr)
			queue.add(x);
		
		long score = 0;
		
		int[] store = new int[d+1];
		
		for(int i=1;i<=d;++i) {
			if(store[i]!=0)
				queue.add(store[i]);
			if(queue.isEmpty())
				continue;
			int val = queue.poll();
			
			if(i+k+1 <= d)
				store[i+k+1] = val;
			
			score += val;
			
			if(score >= c)
				break;
		}
		
		return score >= c;
	}
	public static void solve() {
		int n = fs.nextInt();
		long c = fs.nextLong();
		int d = fs.nextInt();
		int[] arr = fs.readArray(n);
		
		ruffleSort(arr);
		
		if((long)arr[n-1]*d < c) {
			out.println("Impossible");
			return;
		}
		
		long res = 0;
		int low = 0,high = d+1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(good(mid,c,d,arr)) {
				res = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		if(res == d+1) {
			out.println("Infinity");
		}else {
			out.println(res);
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