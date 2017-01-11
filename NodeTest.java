import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NodeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreatingNodeOfTypeString() {
		assertNotNull("should not be null", new Node("2/3"));
	}

	@Test
	public void testGetNodeData() {
		assertEquals("failure - strings are not equal", "2/3", new Node("2/3").toString());
	}

	@Test
	public void testCompareTo() {
		Node tstNode = new Node(7);
		Node tstCmpNode = new Node(10);
		boolean isGreater = tstCmpNode.compareTo(tstNode) > 0;
		assertTrue("failure - should be true", isGreater);
	}

	@Test
	public void testToString() {
		Node tstNode = new Node(10);
		assertEquals("failure - strings are not equal", "10", tstNode.toString());
	}

}
