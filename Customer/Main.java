public class Main{
	public static final CustomerList customerList=new CustomerList(100,0.5f);
	
	public static void main(String args[]){
		new AddCustomerForm().setVisible(true);
		new ViewCustomerDetailsForm().setVisible(true);
	}
}
