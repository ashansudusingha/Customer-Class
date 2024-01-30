import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewCustomerDetailsForm extends JFrame{
	private JLabel titleLabel;
	
	private JTable customerDetailsTable;
	private DefaultTableModel dtm;
	
	private JButton reloadButton;
	ViewCustomerDetailsForm(){
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Customer Details");
		
		titleLabel=new JLabel("View Customer Details Form");
		titleLabel.setFont(new Font("",1,25));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		
		//-------------------------------------------
		String columnName[]={"Customer Id","Name","Address","Salary"};
		dtm=new DefaultTableModel(columnName,0);
		customerDetailsTable=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(customerDetailsTable);
		add("Center",tablePane);
		
		reloadButton=new JButton("Reload");
		reloadButton.setFont(new Font("",1,20));
		reloadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				Customer[] customerArray=Main.customerList.toArray();
				for(Customer c1:customerArray){
					Object[] rowData={c1.getId(),c1.getName(),c1.getAddress(),c1.getSalary()};
					dtm.addRow(rowData);
				}
			}
		});
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(reloadButton);
		
		add("South",buttonPanel);
		 
	}
	public static void main(String args[]){
		new ViewCustomerDetailsForm().setVisible(true);
	}
}
