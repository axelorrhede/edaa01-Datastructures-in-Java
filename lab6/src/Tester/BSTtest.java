package Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;

class BSTtest {
	private BinarySearchTree<Integer> BST;
	private BinarySearchTree<Integer> BSTc;
	private BinarySearchTree<String> sBST;
	private BinarySearchTree<String> sBSTc;

	@BeforeEach
	void setUp() throws Exception {
		BST = new BinarySearchTree<Integer>();
		BSTc = new BinarySearchTree<Integer>((i1, i2) -> i1 - i2);
		sBST = new BinarySearchTree<String>();
		sBSTc = new BinarySearchTree<String>((s1, s2) -> s1.compareTo(s2));
		System.out.println("Next test:");
	}

	@AfterEach
	void tearDown() throws Exception {
		BST = null;
		BSTc = null;
		sBST = null;
		sBSTc = null;
	}

	@Test
	void Integer() {
		assertTrue(BST.add(5), "Cant add first");
		assertTrue(BST.add(4), "Cant add");
		assertTrue(BST.add(6), "Cant add");
		assertTrue(BST.add(1), "Cant add");
		assertTrue(BST.add(2), "Cant add");
		assertTrue(BST.add(3), "Cant add");
		assertFalse(BST.add(3), "Cant add same");
		assertEquals(6, BST.size(), "Wrong size after add");
		BST.printTree();
		assertEquals(5, BST.height(), "Wrong height after add");
		BST.clear();
		assertEquals(0, BST.size(), "Wrong size after clear");
		BST.printTree();
		assertEquals(0, BST.height(), "Wrong height after clear");
	}

	@Test
	void Integerc() {
		assertTrue(BSTc.add(5), "Cant add first");
		assertTrue(BSTc.add(4), "Cant add");
		assertTrue(BSTc.add(6), "Cant add");
		assertTrue(BSTc.add(1), "Cant add");
		assertTrue(BSTc.add(2), "Cant add");
		assertTrue(BSTc.add(3), "Cant add");
		assertFalse(BSTc.add(3), "Cant add same");
		assertEquals(6, BSTc.size(), "Wrong size after add");
		BSTc.printTree();
		assertEquals(5, BSTc.height(), "Wrong height after add"); // är detta rätt höjd?
		BSTc.clear();
		assertEquals(0, BST.size(), "Wrong size after clear");
		BSTc.printTree();
		assertEquals(0, BST.height(), "Wrong height after clear");

	}
	@Test
	void String() {
		assertTrue(sBST.add("a"), "Cant add first");
		assertTrue(sBST.add("b"), "Cant add");
		assertTrue(sBST.add("1"), "Cant add");
		assertTrue(sBST.add("2"), "Cant add");
		assertTrue(sBST.add("c"), "Cant add");
		assertTrue(sBST.add("ö"), "Cant add");
		assertFalse(sBST.add("ö"), "Cant add same");
		assertEquals(6, sBST.size(), "Wrong size after add");
		sBST.printTree();
		assertEquals(4, sBST.height(), "Wrong height after add"); // är detta rätt höjd?
		sBST.clear();
		assertEquals(0, sBST.size(), "Wrong size after clear");
		sBST.printTree();
		assertEquals(0, sBST.height(), "Wrong height after clear");
	}
	@Test
	void Stringc() {
		assertTrue(sBSTc.add("a"), "Cant add first");
		assertTrue(sBSTc.add("b"), "Cant add");
		assertTrue(sBSTc.add("1"), "Cant add");
		assertTrue(sBSTc.add("2"), "Cant add");
		assertTrue(sBSTc.add("c"), "Cant add");
		assertTrue(sBSTc.add("ö"), "Cant add");
		assertFalse(sBSTc.add("ö"), "Cant add same");
		assertEquals(6, sBSTc.size(), "Wrong size after add");
		sBSTc.printTree();
		assertEquals(4, sBSTc.height(), "Wrong height after add"); // är detta rätt höjd?
		sBSTc.clear();
		assertEquals(0, sBSTc.size(), "Wrong size after clear");
		sBSTc.printTree();
		assertEquals(0, sBSTc.height(), "Wrong height after clear");
	}


}
