
public class Node<E extends Comparable<Node<E>>> implements Comparable<Node<E>> {
	Node<E> left;
	Node<E> right;
	private E data;
	
	public Node(E data)
	{
		this.data = data;
	}
	
	public E getData()
	{
		return data;
	}

/*	@Override
	public int compareTo(Object other) {
		// TODO Auto-generated method stub
		Node tstOther = (Node) other;
		return data.compareTo(tstOther.data);
	}*/
	
	public String toString()
	{
		return data.toString();
	}

	@Override
	public int compareTo(Node<E> o) {
		// TODO Auto-generated method stub
		return data.compareTo((Node<E>) o.data);
	}

}
