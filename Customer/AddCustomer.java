import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerForm extends JFrame{
	private JLabel titleLabel;
	
	private JButton addButton;
	private JButton cancelButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel salaryLabel;
	
	private JTextField idText;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField salaryText;
	
	AddCustomerForm(){
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Add Customer Form");
	
		
		titleLabel=new JLabel("Add Customer Form");
		titleLabel.setFont(new Font("",1,35));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		
		//---------------------------------------------
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		addButton=new JButton("Add Customer");
		addButton.setFont(new Font("",1,18));
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=idText.getText();
				String name=nameText.getText();
				String address=addressText.getText();
				double salary=Double.parseDouble(salaryText.getText());
				Customer customer=new Customer(id,name,address,salary);
				CustomerList customerList=DBConnection.getCustomerList();
				boolean isAdded=customerList.add(customer);
				if(isAdded){
					JOptionPane.showMessageDialog(AddCustomerForm.this,"Added Sccuess");
				}
			}
		});
		buttonPanel.add(addButton);
		
		cancelButton=new JButton("Cancel"); 
		cancelButton.setFont(new Font("",1,18));
		buttonPanel.add(cancelButton);
		
		add("South",buttonPanel);
		//---------------------------------------------
		
		JPanel labelPanel=new JPanel(new GridLayout(4,1));
		idLabel=new JLabel("Customer ID");
		idLabel.setFont(new Font("",1,18));
		labelPanel.add(idLabel);
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("",1,18));
		labelPanel.add(nameLabel);
		addressLabel=new JLabel("Address");
		addressLabel.setFont(new Font("",1,18));
		labelPanel.add(addressLabel);
		salaryLabel=new JLabel("Salary");
		salaryLabel.setFont(new Font("",1,18));
		labelPanel.add(salaryLabel);
		add("West",labelPanel);
		
		JPanel textFieldPanel=new JPanel(new GridLayout(4,1));
		idText=new JTextField(4);
		idText.setFont(new Font("",1,18));
		textFieldPanel.add(idText);
		
		nameText=new JTextField(10);
		nameText.setFont(new Font("",1,18));
		textFieldPanel.add(nameText);
		
		addressText=new JTextField(12);
		addressText.setFont(new Font("",1,18));
		textFieldPanel.add(addressText);
		
		salaryText=new JTextField(6);
		salaryText.setFont(new Font("",1,18));
		textFieldPanel.add(salaryText);
		
		add("East",textFieldPanel);
	}

}
