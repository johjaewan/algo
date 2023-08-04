import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {

		Node root;

		void createNode(char data, char Ldata, char Rdata) {
			if (root == null) {
				root = new Node(data);
				if (Ldata != '.') {
					root.left = new Node(Ldata);
				}
				if (Rdata != '.') {
					root.right = new Node(Rdata);
				}
			} else {
				searchNode(root, data, Ldata, Rdata);
			}
		}

		void searchNode(Node node, char data, char Ldata, char Rdata) {
			if (node == null) {
				return;
			} else if (node.data == data) {
				if (Ldata != '.') {
					node.left = new Node(Ldata);
				}
				if (Rdata != '.') {
					node.right = new Node(Rdata);
				}
			} else {
				searchNode(node.left, data, Ldata, Rdata);
				searchNode(node.right, data, Ldata, Rdata);
			}
		}

		void preOrder(Node node) {
			if (node != null) {
				System.out.print(node.data);
				if (node.left != null) {
					preOrder(node.left);
				}
				if (node.right != null) {
					preOrder(node.right);
				}
			}
		}

		void inOrder(Node node) {
			if (node != null) {
				if (node.left != null) {
					inOrder(node.left);
				}
				System.out.print(node.data);
				if (node.right != null) {
					inOrder(node.right);
				}
			}
		}

		public void postOrder(Node node) {
			if (node != null) {
				if (node.left != null) {
					postOrder(node.left);
				}
				if (node.right != null) {
					postOrder(node.right);
				}
				System.out.print(node.data);
			}
		}
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		Tree t = new Tree();
		
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			t.createNode(root, left, right);
		}
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
	}

}
