package project1;

public class Main {

	public static void main(String[] args)
	{
		Node<Integer> list = new Node<>(1, 
                new Node<>(2, 
                 new Node<>(3, 
                  new Node<>(4, 
                   new Node<>(5, 
                    new Node<>(6, 
                     new Node<>(7, 
                      new Node<>(8, 
                       new Node<>(9)))))))));

System.out.println(list); 
		System.out.println("hello project1");
		Node<Integer> p = tr1(list);
		System.out.println(p);
		
		
		

	
	}
	public static Node<Integer> tr1(Node<Integer> p) {
	    if (p == null) return null;

	    Node<Integer> dummyHead = new Node<>(null); 
	    Node<Integer> currentNew = dummyHead;       
	    
	    int count = 0;
	    int max_num = p.getValue();
	    
	    while (p != null) {
	        count++;
	        
	        if (p.getValue() > max_num) {
	            max_num = p.getValue();
	        }

	        if (count == 3 || p.getNext() == null) {
	            currentNew.setNext(new Node<>(max_num));
	            currentNew = currentNew.getNext(); 
	            
	            count = 0;
	            if (p.getNext() != null) {
	                max_num = p.getNext().getValue(); 
	            }
	        }
	        p = p.getNext();
	    }
	    
	    return dummyHead.getNext(); 
	}
	public static void tr2(Node<Integer> list, Node<Integer> indices)
	{
	    if (list == null || indices == null)
	    	return;

	    Node<Integer> current = list;
	    Node<Integer> idxNode = indices;
	    int currentIndex = 0;

	    while (current != null && idxNode != null)
	    {
	        int target = idxNode.getValue();

	        if (currentIndex + 1 == target)
	        {
	            if (current.hasNext())
	            {
	                current.setNext(current.getNext().getNext());
	            }
	            idxNode = idxNode.getNext();
	        } 
	        else 
	        {
	            current = current.getNext();
	            currentIndex++;
	        }
	    }
	}
}
