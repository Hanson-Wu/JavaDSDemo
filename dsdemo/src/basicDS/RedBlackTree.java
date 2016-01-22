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
	// 前趋
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
	// 后继
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
	//	左旋
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
	//	右旋
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
	//递归查找
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
	//非递归查找
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
	 * 将结点插入到红黑树中
	 * @param node : 插入的结点
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
	 * @param key : 插入节点的键值
	 */
	public void insert(T key){
		Node<T> node = new Node<T>(key, null, null, null, BLACK);
		if (node != null) {
			insert(node);
		}
	}
	
	private void insertFixUp(Node<T> node){
		//	若父节点存在，并且父节点的颜色是红色
		while(node.parent != null && isRed(node.parent)) {
			// 若父节点”是“祖父节点的左孩子
			if (parentOf(node) == parentOf(parentOf(node)).left) {
				Node<T> uncle = parentOf(parentOf(node)).right;		//叔叔节点，即父节点的兄弟节点
				if (isRed(uncle)) {									//情况一：如果叔叔节点是红色，因为父节点是红色，显然祖父节点是黑色
					parentOf(node).color = BLACK;
					uncle.color = BLACK;
					parentOf(parentOf(node)).color = RED;
					node = parentOf(parentOf(node));
				}
				else {	
					if (parentOf(node).right == node) {				//情况二：叔叔节点是黑色，而Z是右孩子
						 node = parentOf(node);
						 leftRotate(node);
					}
					
					parentOf(node).color = BLACK;					//情况三：叔叔节点黑色，Z是左孩子
					parentOf(parentOf(node)).color = RED;
					rightRotate(parentOf(parentOf(node)));
				}
			}
			// 若父节点”是“祖父节点的右孩子
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
		/* 1.防止插入节点为根节点        
		 * 2.防止树深度较低时grandparent为root节点,从而在情况一uncle为red时，把root节点置为red 	 */
		if (node == root) {
			node.color = BLACK;
		}
	}
	/**
	 * 删除节点
	 * @param node : 待删除节点
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
	 * 删除某一数值
	 * @param key : 待删除值
	 */
	public void remove(T key){
		Node<T> node = null;
		if ((node = searchNode(root, key)) != null) {
			remove(node);
		}
	}
	
	private void removeFixUp(Node<T> node){
	
		while (node != this.root && node.color == BLACK) {
			// 若节点是父节点的左孩子
			if (node == parentOf(node).left) {
				Node<T> uncle = parentOf(node).right;		
				if (isRed(uncle)) {							//情况一：叔叔节点为红色
					parentOf(node).color = RED;
					uncle.color = BLACK;
					leftRotate(parentOf(node));
					uncle = parentOf(node).right;
				}
				//情况二：叔叔节点为黑色，且有两个黑孩子
				if (isBlack(uncle.left) && isBlack(uncle.right)) {
					uncle.color = RED;
					node = parentOf(node);
				}else {										
					if (isBlack(uncle.right)) {				//情况三：叔叔节点的左孩子为红色，右孩子为黑色
						uncle.left.color = BLACK;
						uncle.color = RED;
						rightRotate(uncle);
						uncle = parentOf(node).right;
					}
					uncle.color = parentOf(node).color;		//情况四：叔叔节点的右孩子为红色
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