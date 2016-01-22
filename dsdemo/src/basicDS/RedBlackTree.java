package basicDS;

public class RedBlackTree<T extends Comparable<T>> {
	private Node<T> root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public class Node<T extends Comparable<T>>{
		T key;
		Node<T> left;
		Node<T> right;
		Node<T> parent;
		boolean color;
		
		
		public Node(T key, Node<T> left, Node<T> right, Node<T> parent, Boolean color){
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.color = color;
		}
		
		public T getKey(){
			return key;
		}
		
		public String toString(){
			return "" + key + " " + color;
		}
	}
	
	public RedBlackTree(){
		root = null;
	}
	
	private Node<T> parentOf(Node<T> node){
		return (node != null) ? node.parent : null;
	}
	private boolean colorOf(Node<T> node){
		return (node != null) ? node.color : BLACK;
	}
	private boolean isRed(Node<T> node){
		return (node != null) && (node.color == RED) ? true : false;
	}
	private boolean isBlack(Node<T> node){
		return !isRed(node);
	}
	
	private Node<T> miNode(Node<T> node){
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	private void inOrder(Node<T> tree){
		if(tree != null) {
			inOrder(tree.left);
			System.out.print(tree.key + "\t");
			inOrder(tree.right);
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	private Node<T> maxNode(Node<T> node){
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	// ǰ��
	private Node<T> succussor(Node<T> node){
		if (node.right != null) {
			return miNode(node.right);
		}
		Node<T> parent = node.parent;
		while (parent != null && node == parent.right) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	// ���
	private Node<T> preDecessor(Node<T> node){
		if (node.left != null) {
			return maxNode(node.left);
		}
		Node<T> parent = node.parent;
		while (parent != null && node == parent.left) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	//	����
	private void leftRotate(Node<T> x){
		//consider the left child of y
		Node<T> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		//consider the node y
		y.parent = x.parent;
		if (x.parent == null) {
			root = y;
		}else{
			if(x == x.parent.left)
			x.parent.left = y;
			else 
			x.parent.right = y;
		}
		//consider the Node x
		y.left = x;
		x.parent = y;
	}
	//	����
	private void rightRotate(Node<T> x){
		Node<T> y= x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}
		
		y.parent = x.parent;
		if (x.parent == null) {
			root = y;
		}else{
			if (x == x.parent.left)
			x.parent.left = y;
			else 
			x.parent.right = y;
		}
		
		y.right = x;
		x.parent =y;
	}
	//�ݹ����
	public Node<T> search(Node<T> tree, T key){
		if (tree == null || key == tree.key) {
			return tree;
		}
		
		if (key.compareTo(tree.key) <= 0) {
			return search(tree.left, key);
		}else {
			return search(tree.right, key);
		}
	}
	//�ǵݹ����
	public Node<T> searchNode(Node<T> tree, T key){
		while (tree != null && tree.key != key) {
			if (key.compareTo(tree.key) <= 0) {
				tree = tree.left;
			}else {
				tree = tree.right;
			}
		}
		return tree;
	}
	
	/**
	 * �������뵽�������
	 * @param node : ����Ľ��
	 */
	private void insert(Node<T> node){
		Node<T> y = null;
		Node<T> x = this.root;
		while (x != null) {
			y = x;
			if (node.key.compareTo(x.key) <= 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		node.parent = y;
		if (y == null) {
			root = node;
			node.color = BLACK;
		} else {
			if (node.key.compareTo(y.key) <= 0) {
				y.left = node;
				node.color = RED;
			} else {
				y.right = node;
				node.color = RED;
			}
		}
		
		
		insertFixUp(node);
	}
	/**
	 * 
	 * @param key : ����ڵ�ļ�ֵ
	 */
	public void insert(T key){
		Node<T> node = new Node<T>(key, null, null, null, BLACK);
		if (node != null) {
			insert(node);
		}
	}
	
	private void insertFixUp(Node<T> node){
		//	�����ڵ���ڣ����Ҹ��ڵ����ɫ�Ǻ�ɫ
		while(node.parent != null && isRed(node.parent)) {
			// �����ڵ㡱�ǡ��游�ڵ������
			if (parentOf(node) == parentOf(parentOf(node)).left) {
				Node<T> uncle = parentOf(parentOf(node)).right;		//����ڵ㣬�����ڵ���ֵܽڵ�
				if (isRed(uncle)) {									//���һ���������ڵ��Ǻ�ɫ����Ϊ���ڵ��Ǻ�ɫ����Ȼ�游�ڵ��Ǻ�ɫ
					parentOf(node).color = BLACK;
					uncle.color = BLACK;
					parentOf(parentOf(node)).color = RED;
					node = parentOf(parentOf(node));
				}
				else {	
					if (parentOf(node).right == node) {				//�����������ڵ��Ǻ�ɫ����Z���Һ���
						 node = parentOf(node);
						 leftRotate(node);
					}
					
					parentOf(node).color = BLACK;					//�����������ڵ��ɫ��Z������
					parentOf(parentOf(node)).color = RED;
					rightRotate(parentOf(parentOf(node)));
				}
			}
			// �����ڵ㡱�ǡ��游�ڵ���Һ���
			else {
				Node<T> uncle = parentOf(parentOf(node)).left;
				if (isRed(uncle)) {
					parentOf(node).color = BLACK;
					uncle.color = BLACK;
					parentOf(parentOf(node)).color = RED;
					node = parentOf(parentOf(node));
				}
				else {
					if (parentOf(node).left == node) {
						 node = parentOf(node);
						 rightRotate(node);
					}
					parentOf(node).color = BLACK;
					parentOf(parentOf(node)).color = RED;
					leftRotate(parentOf(parentOf(node)));
				}
			}
		}
		/* 1.��ֹ����ڵ�Ϊ���ڵ�        
		 * 2.��ֹ����Ƚϵ�ʱgrandparentΪroot�ڵ�,�Ӷ������һuncleΪredʱ����root�ڵ���Ϊred 	 */
		if (node == root) {
			node.color = BLACK;
		}
	}
	/**
	 * ɾ���ڵ�
	 * @param node : ��ɾ���ڵ�
	 * @return
	 */
	private Node<T> remove(Node<T> node){
		Node<T> replace = null;
		if (node.left == null || node.right == null) {
			replace = node;
		}else {
			replace = succussor(node);
		}
		Node<T> child = replace.left != null ? replace.left : replace.right; 
		
		if (child == null) {
			child = new Node<T>(null, null, null, replace.parent, BLACK);
		}
		child.parent = replace.parent;
		
		if (replace.parent == null) {
			root = child;
		}else {
			if(replace == replace.parent.left)
				replace.parent.left = child;
			else
				replace.parent.right = child;
		}
		
		if (replace != node) {
			node.key = replace.key;
		}
		if (isBlack(replace)) {
			removeFixUp(child);
		}
		return replace;
	}
	/**
	 * ɾ��ĳһ��ֵ
	 * @param key : ��ɾ��ֵ
	 */
	public void remove(T key){
		Node<T> node = null;
		if ((node = searchNode(root, key)) != null) {
			remove(node);
		}
	}
	
	private void removeFixUp(Node<T> node){
	
		while (node != this.root && node.color == BLACK) {
			// ���ڵ��Ǹ��ڵ������
			if (node == parentOf(node).left) {
				Node<T> uncle = parentOf(node).right;		
				if (isRed(uncle)) {							//���һ������ڵ�Ϊ��ɫ
					parentOf(node).color = RED;
					uncle.color = BLACK;
					leftRotate(parentOf(node));
					uncle = parentOf(node).right;
				}
				//�����������ڵ�Ϊ��ɫ�����������ں���
				if (isBlack(uncle.left) && isBlack(uncle.right)) {
					uncle.color = RED;
					node = parentOf(node);
				}else {										
					if (isBlack(uncle.right)) {				//�����������ڵ������Ϊ��ɫ���Һ���Ϊ��ɫ
						uncle.left.color = BLACK;
						uncle.color = RED;
						rightRotate(uncle);
						uncle = parentOf(node).right;
					}
					uncle.color = parentOf(node).color;		//����ģ�����ڵ���Һ���Ϊ��ɫ
					parentOf(node).color = BLACK;
					uncle.right.color = BLACK;
					leftRotate(parentOf(node));
					node = root;
				}
			}else {
				Node<T> uncle = parentOf(node).left;
				if (isRed(uncle)) {
					parentOf(node).color = RED;
					uncle.color = BLACK;
					rightRotate(parentOf(node));
					uncle = parentOf(node).left;
				}
				if (isBlack(uncle.left) && isBlack(uncle.right)) {
					uncle.color = RED;
					node = parentOf(node);
				}else {
					if (isBlack(uncle.left)) {
						uncle.right.color = BLACK;
						uncle.color = RED;
						leftRotate(uncle);
						uncle = parentOf(node).left;
					}
					uncle.color = parentOf(node).color;
					parentOf(node).color = BLACK;
					uncle.left.color = BLACK;
					rightRotate(parentOf(node));
					node = root;
				}
			}
		}
		node.color = BLACK;
	}
	
	public static void main(String[] args){
		int[] arr = {10, 40, 30, 60, 90, 70, 20, 50, 80};
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		
		for(int i : arr){
			tree.insert(i);
		}
		tree.inOrder();
		tree.remove(20);
		System.out.println();
		tree.inOrder();
//		System.out.println();
//		tree.insert(20);
//		tree.inOrder();
	}
}