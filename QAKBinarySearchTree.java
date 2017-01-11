
public class QAKBinarySearchTree<E> {

    Node<?> root;
    
    public QAKBinarySearchTree(){
    	root = null;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public QAKBinarySearchTree(Comparable<?> data)
    {
    	root = new Node(data);   
    }
    
    @SuppressWarnings("unchecked")
	public void addNode(@SuppressWarnings("rawtypes") Node newNode,@SuppressWarnings("rawtypes") Node parentNode, @SuppressWarnings("rawtypes") Node currentNode)
    {
    	if ( root == null)
    	{
    		root = newNode;
    	}
      
    	if (currentNode == null)
    	{
    		if ( newNode.getData().compareTo(parentNode.getData()) < 0)
    		{
    			parentNode.left = newNode;
    		}
    		else
    		{
    			parentNode.right = newNode;
    		} 
    		return;
    	}
    	else if ( newNode.getData().compareTo(currentNode.getData()) < 0 )
    	{
    		parentNode = currentNode;
    		currentNode = currentNode.left;
    		addNode(newNode,parentNode,currentNode);
    	}
    	else
    	{
    		parentNode = currentNode;
    		currentNode = currentNode.right;
    		addNode(newNode,parentNode,currentNode);
    	}
    	
    }
    
    @SuppressWarnings("rawtypes")
	public void inOrderTraversal(Node start)
    {
    	if (start == null)
    	{
    		return;
    	}
    	if ( start != null)
    	{
    		inOrderTraversal(start.left);
    		System.out.println(start.toString());
    		inOrderTraversal(start.right);
    	}
    }

    public String inOrderString(@SuppressWarnings("rawtypes") Node start, String rtnString)
    {
    	if ( start == null)
    	{
    		return rtnString;
    	}
    	if ( start != null)
    	{
    		rtnString = inOrderString(start.left, rtnString);
   // 		inOrderString(start, rtnString);
    		rtnString += " " + start.toString();
    		rtnString = inOrderString(start.right, rtnString);
    	}
    	return rtnString.trim();
    }
    
    public String revOrderString(@SuppressWarnings("rawtypes") Node start, String rtnString)
    {
    	if ( start == null)
    	{
    		return rtnString;
    	}
    	if ( start != null)
    	{
    		rtnString = revOrderString(start.right, rtnString);
   // 		inOrderString(start, rtnString);
    		rtnString += " " + start.toString();
    		rtnString = revOrderString(start.left, rtnString);
    	}
    	return rtnString.trim();
    }
}

