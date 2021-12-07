public class FlexArray {
    private int[] array;
    private int base;
    private int length;
    
    FlexArray() {
        array = new int[0];
        length = 0;
        base = 0;
    }

    FlexArray(int size) {
        array = new int[size];
        length = size;
        base = 0;
    }

    FlexArray(int size, int start) {
        array = new int[size];
        length = size;
        base = start;
    }

    public int length() {
        return length;
    }

    public int base() {
        return base;
    }

    public int[] rawArray() {
        return array.clone();
    }

    public int read(int index) {
        return (isValid(index))? 
        		array[index-base] : 
        		Integer.MIN_VALUE;    		
    }

    public void write(int index, int value) {
        if(isValid(index)) array[index-base] = value;
    }

    public FlexArray copy() {    
        FlexArray temp = new FlexArray();
        temp.array = this.array.clone();
        temp.length = this.length();
        temp.base = this.base();
        return temp;    
    }

    public FlexArray merge(FlexArray f) {
    	int start = Math.min(this.base, f.base());
    	int max = Math.max(this.base + this.length(), f.base() + f.length());
    	// if(this.base + this.length() < f.base() || f.base + f.length() < this.base()) return null;
    	FlexArray mer = new FlexArray(max-start, start);
    	for(int i = start; i < max; i++) {
    		int sum = 0;	
    		// if(!(this.isValid(i) || f.isValid(i))) return null; // De-Morgan's
    		if(!this.isValid(i) && !f.isValid(i)) return null; 
    		if(this.isValid(i)) sum += this.read(i);
    		if(f.isValid(i)) sum += f.read(i);
    		mer.write(i, sum); }
    	return mer;
    }
    
    public boolean isValid(int index) {
        return index >= base && index < base+length;
    }

    @Override
    public boolean equals(Object o) {      
        if(o.getClass() != this.getClass())
            return false;
        FlexArray temp = (FlexArray)o;
        if(temp.length() != this.length())
            return false;
        if(temp.base() != this.base())
            return false;
        for(int i = 0; i < this.length ;i++)
        	if(temp.rawArray()[i] != this.array[i])
        		return false; 
        return true;
    }
    
}