package chap22.binarytree;


class Node {
	//노드에 저장된 원소
	int key;
	
	//이 노드의 우선순위(priority) , 이 노드를 루트로 하는 서브 트리의 크기(size)
	//size는 k번째 원소 찾는 연산 or X보다 작은 원소를 세는 연산 등을 쉽게 구현하도록 도와줌
	int priority,size;
	
	//두 자식 노드
	Node left;
	Node right;
	
	//생성자에서 난수 우선 순위 생성 & size,left,right 초기화
	public Node(int key) {
		this.key = key;
		this.size = 1;
		priority = (int)(Math.random()*100); //0~100
	}
	
	public void setLeft(Node left) {
		this.left = left;
		calcSize();
	}
	
	public void setRight(Node right) {
		this.right = right;
		calcSize();
	}		
	private void calcSize() {
		size = 1;
		if(left != null)
			size +=left.size;
		if(right != null)
			size +=right.size;
	}	
}

class NodePair {
	Node first;
	Node second;
	public NodePair(Node f,Node s) {
		first = f;
		second = s;
	}
}


public class TreapMain {
	
	// shifted[i] = A[i]가 왼쪽으로 몇 칸 움직이는가
	static int n;
	static int[] shifted = new int[50000];
	static int[] A = new int[50000];
	public static void main(String[] args) {
		
	}
	
	public static void solve() {
		// 1~N까지의 모든 숫자를 모두 저장하는 트립을 만듬		
		
	}
	
	
	
	
	/*		insert node		*/
	//root를 루트로 하는 트립에 새 노드(node)를 삽입 & 결과 트립의 루트를 반환
	public static Node insert(Node root,Node node) {
		if(root == null) return node;
		
		//node가 루트를 대체해야 한다. 해당 서브트리를 반으ㅏ로 잘라 각각 자손으로 함.
			if(root.priority < node.priority) {
			NodePair pair = split(root,node.key);
			node.setLeft(pair.first);
			node.setRight(pair.second);
			return node;
		} else if(node.key < root.key) {
			root.setLeft(insert(root.left,node));
		} else {
			root.setRight(insert(root.right,node));
		}
		return root;
	}	
	//root를 루트로 하는 트립을 key미만의 값(first)과 이상의 값(second)을 갖는 두개의 트립으로 분리
	public static NodePair split(Node root, int key) {
		if(root == null) return new NodePair(null,null);
		
		//루트가 key 미만이면 오른쪽 서브트리를 쪼갬.
		if(root.key < key) {
			NodePair rs = split(root.right,key);
			root.setRight(rs.first);
			return new NodePair(root,rs.second);			
		}
		
		// 루트가 key 이상이면 왼쪽 서브트리를 쪼갠다
		NodePair ls = split(root.left,key);
		root.setLeft(ls.second);
		return new NodePair(ls.first,root);
	}
	
	/*		merge		*/
	public static Node merge(Node a,Node b) {
		if(a == null) return b;
		if(b == null) return a;
		
		if(a.priority < b.priority) {
			b.setLeft(merge(a,b.left));
			return b;
		}
		
		a.setRight(merge(a.right,b));
		return a;			
	}
	
	
	/*		erase		*/
	// root를 루트로 하는 트립에서 key를 지우고 결과 트립의 루트를 반환
	public static Node erase(Node root,int key) {
		if(root == null) return root;
		
		//root를 지우고 양 서브트리를 합친 뒤 반환
		if(root.key == key) {
			return merge(root.left,root.right);
		}
		
		if(key < root.key)
			root.setLeft(erase(root.left,key));
		else
			root.setRight(erase(root.right,key));
		return root;
	}
	
	
	
	/**		활용		*/
	//k번째 원소 찾기
	public static Node kth(Node root,int k) {
		int leftSize = 0;
		if(root.left != null)
			leftSize = root.left.size;
		
		//1)왼쪽 서브트리에 있는 경우
		if(k <= leftSize) return kth(root.left,k);
		//2)루트인 경우
		if(k == leftSize+1) return root;
		//3)오른쪽 서브트리에 있는 경우
		return kth(root.right,k-leftSize-1);		
	}
	
	//X보다 작은 원소 세기
	public static int countLessThan(Node root,int key) {
		if(root==null) return 0;
		
		if(root.key >= key) {
			return countLessThan(root.left,key);
		}		
		int ls = (root.left != null) ? root.left.size : 0;
		return ls + 1 + countLessThan(root.right,key);		
	}
	
	
	
	
	
	
	
	
	
	
	
}














