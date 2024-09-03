package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		comparator = (e1, e2) ->((Comparable) e1).compareTo(e2);
		
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		return add(root, x);
	}
	private boolean add(BinaryNode<E> n, E x) {
		if (comparator.compare(n.element, x)< 0) {
			if (n.right == null) {
				n.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return add(n.right, x);
		}
		if (comparator.compare(n.element, x)> 0) {
			if (n.left == null) {
				n.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return add(n.left, x);
		}
		return false;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	private int height (BinaryNode<E> n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math.max(height(n.left), height(n.right));
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> n) {
		if (n != null) {
			printTree(n.left);
			System.out.println(n.element);
			printTree(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<E>();
		toArray(root, sorted);
		// clear();
		root = buildTree(sorted, 0, sorted.size()-1);

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n != null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first<=last) {
			int mid = first + (last-first)/2;
			BinaryNode<E> n = new BinaryNode<E>(sorted.get(mid));
			n.left = buildTree(sorted,first, mid-1);
			n.right = buildTree(sorted, mid+1, last);
			return n;
		}
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		BSTVisualizer vis = new BSTVisualizer("Tree", 1000, 800);
		for(int i = 0; i<30; i++) {
			intTree.add(i);
		}
		intTree.add(-1);		
		intTree.rebuild();
		vis.drawTree(intTree);


	}
	
}


/* F1 a) 10, 20, 30, 47
 * 
 * b)3
 * 
 * c) 4
 * 
 * F2 a) 0
 * 1+ höjden av högsta subträd
 * b) Math.max()
 * 
 * F3 mid = first + (last-first)/2 för att inte få overflow
 * 
 * Om man använder klassen ska man inte ha tillgång till nodklassen, som behlvs för det rekursiva anropet
 * 
 * Nej, eftersom vi oftast anropar element som inte är först eller sist i listan fungerar arraylist bättre än linked list
 * 
 */
