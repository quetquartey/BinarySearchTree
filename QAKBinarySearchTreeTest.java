import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QAKBinarySearchTreeTest {
	QAKBinarySearchTree tree, tree2;

	@Test
	public void testQAKBinarySearchTree() {
		assertNotNull("should not be null", new QAKBinarySearchTree());
	}

	@Test
	public void testQAKBinarySearchTreeComparable() {
		assertEquals("failure - strings are not equal", "Red",
				new QAKBinarySearchTree("Red").root.toString());
	}

	@Test
	public void testAddStringNodes() {
		tree = new QAKBinarySearchTree("Red");
		tree.addNode(new Node("Orange"), tree.root, tree.root);
		tree.addNode(new Node("Yellow"), tree.root, tree.root);
		tree.addNode(new Node("Green"), tree.root, tree.root);
		tree.addNode(new Node("Blue"), tree.root, tree.root);
		tree.addNode(new Node("Indigo"), tree.root, tree.root);
		tree.addNode(new Node("Violet"), tree.root, tree.root);
		String expStr = "Blue Green Indigo Orange Red Violet Yellow";
		assertEquals("failure - strings are not equal", expStr, tree.inOrderString(tree.root,""));
	}

	@Test
	public void testAddFractionNodes() throws NumberFormatExpressionException {
		tree2 = new QAKBinarySearchTree(new Fraction("1/2"));
		System.out.println("Kim this is a good place to pause");
		tree2.addNode(new Node(new Fraction("3/4")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("3/2")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("5/8")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("4/9")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("7/16")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("5/32")), tree2.root, tree2.root);
		tree2.addNode(new Node(new Fraction("1/8")), tree2.root, tree2.root);
		String expStr = "3/2 3/4 5/8 1/2 4/9 7/16 5/32 1/8";
		assertEquals("failure - strings are not equal", expStr, tree2.revOrderString(tree2.root,""));
	}
	
	@Test
	public void testAddIntegerNodes() {
		tree = new QAKBinarySearchTree(4);
		tree.addNode(new Node(8), tree.root, tree.root);
		tree.addNode(new Node(2), tree.root, tree.root);
		tree.addNode(new Node(1), tree.root, tree.root);
		tree.addNode(new Node(23), tree.root, tree.root);
		tree.addNode(new Node(16), tree.root, tree.root);
		tree.addNode(new Node(14), tree.root, tree.root);
/*		String expStr = "Blue Green Indigo Orange Red Violet Yellow";
		assertEquals("failure - strings are not equal", expStr, tree.inOrderString(tree.root,""));*/
	}


}
