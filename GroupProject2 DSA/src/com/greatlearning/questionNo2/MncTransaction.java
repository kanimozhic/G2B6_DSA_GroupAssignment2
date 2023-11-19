package com.greatlearning.questionNo2;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class MncTransaction {
	Node node;

	static Node prevNode = null;
	static Node headNode = null;

	static void skewTree(Node root, boolean flag) {

		if (root == null) {
			return;
		}

		if (flag) {
			skewTree(root.right, flag);
		} else {
			skewTree(root.left, flag);
		}

		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {

			headNode = root;
			root.left = null;

			prevNode = root;
		} else {

			prevNode.right = root;
			root.left = null;

			prevNode = root;
		}

		if (flag) {
			skewTree(leftNode, flag);
		} else {
			skewTree(rightNode, flag);
		}
	}

	static void printSkewedTree(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");

		printSkewedTree(root.right);
	}

	public static void main(String[] args) {

		MncTransaction tree = new MncTransaction();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		boolean flag = false;

		skewTree(tree.node, flag);

		printSkewedTree(headNode);
	}
}
