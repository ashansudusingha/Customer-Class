public class CustomerList{
	private Customer[] customerArray;
	private int nextIndex;
	private int intSize;
	private double loadFact;
	
	CustomerList(int intSize, double loadFact){
		this.intSize=intSize;
		this.loadFact=loadFact;
		customerArray=new Customer[intSize];
		nextIndex=0; 
	}
	private boolean isEmpty(){
		return nextIndex==0;
	}
	private boolean isFull(){
		return nextIndex>=customerArray.length;
	}
	public int size(){
		return nextIndex;
	}
	public void clear(){
		nextIndex=0;
		customerArray=new Customer[intSize];
	}
	public String toString(){
		String list="{";
		for (int i = 0; i < nextIndex; i++){
			list+=customerArray[i]+", "; //customerArray[i].toString()
		}
		return isEmpty()? "{empty}":list+"\b\b}";
	}	 
	public boolean add(Customer customer){
		if(isFull()){
			extendArray();
		}
		customerArray[nextIndex++]=customer;
		return true;
	}
	private void extendArray(){
		Customer[] tempCustomerArray=new Customer[customerArray.length+(int)(customerArray.length*loadFact)];
		for (int i = 0; i < customerArray.length; i++){
			tempCustomerArray[i]=customerArray[i];
		}
		customerArray=tempCustomerArray;
	}
	public boolean add(int index, Customer customer){
		if(!isValidIndex(index)){
			return false;
		}
		if(isFull()){
			extendArray();
		}
		for (int i = nextIndex-1; i >=index; i--){
			customerArray[i+1]=customerArray[i];
		}
		customerArray[index]=customer;
		nextIndex++;
		return true;
	}
	private boolean isValidIndex(int index){
		return index>=0 && index<nextIndex;
	}
	public Customer[] toArray(){
		Customer[] tempCustomerArray=new Customer[nextIndex];
		for (int i = 0; i < nextIndex; i++){
			tempCustomerArray[i]=customerArray[i];
		}
		return tempCustomerArray;
		
	}
	
}
