import java.io.*;
import java.util.*;

public class C {
	public static void solve() {
		int n = fs.nextInt();
		char[] a = fs.next().toCharArray();
		char[] b = fs.next().toCharArray();
		
		ArrayList<int[]> ans = new ArrayList<>();
		
		//at max n+5 operations
		int inv = 0,same = 0 , ones = 0;
		
		for(int i=0;i<n;++i) {
			inv += a[i]!=b[i] ? 1 : 0;
			same += a[i]==b[i] ? 1 : 0;
			if(a[i]=='1') {
				ones++;
				ans.add(new int[]{i+1,i+1});
			}	
		}
		
		if(same!=n && inv!=n) {
			out.println("NO");
			return;
		}
		
		int flips = (ones+1)%2;
		
		if((inv==n && flips==1) || (flips==0 && inv==0) ) { /* all '11111' */
			ans.add(new int[]{1,n});
			ans.add(new int[]{2,n});
			ans.add(new int[]{1,1});
		}
		
		out.println("YES");
		out.println(ans.size());
		
		ans.forEach( arr -> {
			out.println(arr[0]+" "+arr[1]);
		});
		
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