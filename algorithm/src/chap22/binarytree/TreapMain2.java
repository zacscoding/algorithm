package chap22.binarytree;

/*
 * 이진 검색 트리의 조건 : 모든 노드에 대해 왼쪽 서브트리에 있는 노드들의 원소는 해당 노드의 원소보다 작고, 오른쪽 서브트리에 있는 노드들의 원소는 해당 노드의 원소보다 큼.
 * 힙의 조건 : 모든 노드의 우선순위는 각자의 자식 노드보다 크거나 같습니다.
 */

/*
class Node {
	int key;	//노드에 저장된 원소
	int priority,size; //노드의 우선순위(priority),이 노드를 루트로 하는 서브트리의 크기(size)
	//size => k번째 원소찾는 연산 or X보다 작은 원소를 세는 연산 등을 쉽게 구현할 수 있음
	
	Node left,right;
	
	Node(int key) {
		this.key = key;
		priority = (int)(Math.random()); //난수 우선순위 생성
		size = 1;		
	}
	
	void setLeft(Node left) {
		this.left = left;
		calcSize();		
	}
	void setRight(Node right) {
		this.right = right;
		calcSize();
	}
	
	//size 갱신
	private void calcSize() {
		size = 1;
		if(left!=null)
			size += left.size;
		if(right!=null)
			size += right.size;
	}
	@Override
	public int hashCode() {
		return Integer.valueOf(key).hashCode();
	}	
}

//class Pair<F,S> {
class Pair {
	Node first;
	Node second;
	public Pair(Node f,Node s) {
		first = f;
		second = s;
	}
}

public class TreapMain2 {
	public static void main(String[] args) {
		
	}
	
	///////////////////
	// 노드의 추가와 쪼개기 연산
	///////////////////
	public static Pair split(Node root,int key) {		
		if(root == null) {			
			return new Pair(null,null);
		}
		
		if(root.key < key) { //root의 key보다 큰 경우
			//root의 오른쪽 서브트리중 key값 보다 작은 값 | 큰 값으로 나누고
			//작은 값들을 오른쪽 서브트리, 큰값들을 리턴
			Pair rs = split(root.right,key);
			root.setLeft(rs.first);
			return new Pair(root,rs.second);			
		}
		
		//root의 key 보다 작은 경우
		Pair ls = split(root.left,key); //왼쪽 서브트리를 쪼개고
		root.setLeft(ls.second); //key보다 큰 서브트리는 왼쪽 유지
		return new Pair(ls.first,root);	//key보다 작은 서브트리는 리턴
	}
	//root를 루트로하는 트립에 새 노드 node를 삽입한 뒤 결과의 트립의 루트를 반환.
	public static Node insert(Node root,Node node) {
		if(root == null) //루트가 널이면
			return node; //새로 삽입하는 노드가 루트
		
		if(root.priority < node.priority ) { //새 노드의 우선순위가 높은 경우 -> 새노드가 루트를 대체
			Pair splitted = split(root,node.key); //기존 root를 node.key를 기준으로 쪼갬
			node.setLeft(splitted.first); //작은 것들은 왼쪽 서브트리
			node.setRight(splitted.second); //큰 것들은 오른쪽 서브트리
			return node; //새로운 node가 root가 됨
		} else if(node.key < root.key) { //새 노드의 우선순위가 낮고, 루트의 key보다 작은 경우
			root.setLeft(insert(root.left,node)); //새 node가 자리 찾아가도록 재귀			
		} else {
			root.setRight(insert(root.right,node));			
		}
		return root;
	}
	
	///////////////////
	// 노드의 삭제와 합치기 연산
	///////////////////
	//a,b가 두 개의 트립이고, max(a) < max(b)일 때 이 둘을 합친다.
	public static Node merge(Node a,Node b) {
		if(a==null) return b;
		if(b==null) return a;
		
		if(a.priority < b.priority) {
			b.setLeft(merge(a,b.left));
			return b;
		}
		
		a.setRight(merge(a.right,b));
		return a;	
	}
	
	//root를 루트로 하는 트립에서 key를 지우고 결과 트립의 루트를 반환
	public static Node erase(Node root,int key) {
		if(root==null) return root;
		
		//root를 지우고 양 서브트리를 합친 뒤 반환
		if(root.key == key) {
			Node ret = merge(root.left, root.right);
			return ret;
		}
		
		if(key < root.key) {
			root.setLeft(erase(root.left,key));
		} else {
			root.setRight(erase(root.right,key));
		}
		return root;		
	}
	
	
	///////////////////
	// 트립의 활용
	///////////////////
	
	//k번째 찾기
	public Node kth(Node root,int k) {
		//왼쪽 트리 계산
		int leftSize = 0;
		if(root.left!=null) leftSize = root.left.size;
		
		if(k<=leftSize) return kth(root.left,k); //왼쪽 트리에 존재하는 경우
		if(k==leftSize+1) return root; //root가 k번째 인 경우
		return kth(root.right,k-leftSize-1); //오른쪽에 있는 경우 k번째 -> k-leftSize(왼쪽서브트리)-1(root)번째로 바뀜
	}
	
	//X보다 작은 원소 개수 찾기 [a,b)는 countLessThan(b) - countLessThan(a)하면 됨
	public static int countLessThan(Node root,int key) {
		if(root==null) return 0;
		if(root.key>=key) //root의 key가 찾는 key보다 크거나 같으면
			return countLessThan(root.left,key); //왼쪽 서브트리 조사
		
		//root의 key가 찾는 key보다 작으면
		int ls = (root.left==null)?0:root.left.size; //왼쪽 서브트리 계산
		return ls+1+countLessThan(root.right,key); // (왼쪽) + (root) + (오른쪽트리 중 key보다 큰 거 계산)
	}
	
	
}

*/













