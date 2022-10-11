public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    public E[] toArray() {
    	int length = this.size;
    	
    	//tutor michael fu helped me figure out this line
    	@SuppressWarnings("unchecked")
		E[] ra = (E[])new Object[length]; 
    	
    	for(int i = 0; i < length; i++) {
    		ra[i] = elements[i];
    	}
    	
    	return ra;
    }
    
	@SuppressWarnings("unchecked")
	public void transformAll(MyTransformer mt) {
		
		for(int i = 0; i < this.size; i++) {
			
			//WHY DO i HAVE TO TYPECAST
			elements[i] = (E)mt.transformElement(elements[i]);
		}
	}
	public void chooseAll(MyChooser mc){
		int chosen = 0, j = 0;
		
		for(int i = 0; i < this.size; i++)
			if(mc.chooseElement(elements[i]))
				chosen++;
		
		@SuppressWarnings("unchecked")
		E[] ra =(E[]) new Object[chosen];
		
		//cooperated with Annabelle Min
		for(int i = 0; i < this.size; i++) {
			if(mc.chooseElement(elements[i])) { 
				ra[j] = elements[i];
				j++;
			}			
		}
		
		elements = ra;
	}
		
	public boolean isEmpty() {
		
		if(this.size == 0) return true;
		else return false;
		
	}
	
}