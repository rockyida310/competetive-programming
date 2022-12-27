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
	
	static class Graph{
		List<List<Integer>> adj;
		Graph(int n){
			adj = new ArrayList<>();
			for(int i=0;i<n;++i) {
				adj.add(new ArrayList<>());
			}
		}
		public void addEdge(int u,int v) {
			adj.get(u).add(v);
		}
		public List<Integer> edgeTo(int u){
			return adj.get(u);
		}
	}
	
	public static void solve() {
		int n = fs.nextInt();
		String[] arr = new String[n];
		ArrayList<TreeSet<Integer>> res = new ArrayList<>();
		
		for(int i=0;i<n;++i) {
			arr[i] = fs.next();
			res.add(new TreeSet<>());
			res.get(i).add(i+1);
		}
		
		
		Graph g = new Graph(n);
		int[] indegree = new int[n];
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int j=0;j<n;++j) {
			for(int i=0;i<n;++i) {
				if(arr[i].charAt(j)=='1') {
					g.addEdge(i, j);
					indegree[j]++;
				}	
			}
			if(indegree[j]==0) {
				q.offer(j);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int neigh : g.adj.get(curr)) {
				indegree[neigh]--;
				if(indegree[neigh]==0) {
					q.offer(neigh);
				}
				
				for(int x : res.get(curr)){
					res.get(neigh).add(x);
				}
				
			}
		}
		
		
		for(int i=0;i<n;++i) {
			out.print(res.get(i).size()+" ");
			while(!res.get(i).isEmpty()) {
				out.print(res.get(i).pollFirst()+" ");
			}
			out.println();
		}
		
		
	}
}