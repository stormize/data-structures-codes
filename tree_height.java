import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
    class Node{
        public int data;
      ArrayList<Node> children= new ArrayList<Node>();
      Node parent ;
 public void addChild(Node child){
      this.children.add(child);
 }
 public void addparent(Node myparent){
     this.parent = myparent;
 }
 public int height(Node root){
     if (root==null) return 0;
     int h=0;
     for(Node n : root.children)
         h=Math.max(h, height(n));
     return h+1;
 }
    }
	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                    int root;
                      Node[] nodes = new Node[n];
                      for (int i = 0; i <n; i++) {
                     nodes[i] = new Node();
                              }
                  for(int i=0 ; i<n;i++){
                      if(parent[i]==-1){
                            root=i;
                      }
                      else{
                      nodes[parent[i]].addChild(nodes[i]);
                      nodes[i].addparent(nodes[parent[i]]);
                      }
                      
                  }
                 
                  
                           Node test = new Node();
                   for(int i=0;i<n;i++){
                       if(nodes[i].parent==null)
                           return test.height(nodes[i]);
                   }
                   return 0;
                              
                }
                  
                       
                 
        
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
