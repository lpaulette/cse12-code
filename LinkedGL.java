public class LinkedGL<E> implements MyList<E> {
	//HELLO2
    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;
    
    
    public LinkedGL(E[] contents) {
    	
      	this.front = new Node(null, null);
      	this.size = contents.length;
      	
      	Node temp = this.front;
        
    	for (int i = 0; i < this.size; i++)
    	{
    		temp.value = contents[0];
    		temp.next = new Node(null, null);
    		temp = temp.next;
    	}
    }

    @Override
    public E[] toArray() {
    	
    	int length = this.size;
    	
    	//Tutor Michael Fu helped me figure out how to initialize a generic array    	
    	@SuppressWarnings("unchecked")
    	E[] ra = (E[])new Object[length]; 
    	   	
    	Node temp = this.front.next;
    	
    	for (int i = 0; i < length; i++) {
    		
    		ra[i] = temp.value;
    		temp = temp.next;
    	} 
    	  			
    	return ra; 
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public void transformAll(MyTransformer mt) {
    	
    	Node temp = this.front.next;
		
    	while (temp.next != null){
    		
    		if(temp.value == null)
    			temp = temp.next;
    	 		
    		else   		
    			//java advised me to typecast as E
    			//WHY DO I HAVE TO TYPECAST
    			temp.value = (E)mt.transformElement(temp.value);
    				
    	}
	}
    
    /*tutor michael fu double checked this method, 
    previously I thought the chooseElement method
    would only accept Strings, as in the implementation*/
    @SuppressWarnings("unchecked")
	@Override
	public void chooseAll(MyChooser mc) {
    	
    	Node temp = this.front;
    	Node newTemp;
    	
    	while(temp.next != null)
    	{
    		//collaborated with Annabelle Min
    		if(temp.next.value == null || !mc.chooseElement(temp.next.value)){
    			newTemp = temp.next;
    			temp.next = temp.next.next;
    			newTemp.next = null;
    			temp = temp.next;
    			
    			this.size--;
    		}    			
    		
    		else    			
    			temp = temp.next;
     	}
    }
    
    @Override
	public boolean isEmpty() {
    	
    	if(this.size == 0)
    		return true;
    	else    	
    		return false;
    }
    
    /*public String toString() {
    	
    	Node temp = this.front;
    	
    	System.out.print("front -->");
    	
    	for(int i = 0; i < this.size; i++) {
    		System.out.print(temp + " ");
    		temp = temp.next;
    	}
    		
    	return "<-- back";
   }*/
    

}