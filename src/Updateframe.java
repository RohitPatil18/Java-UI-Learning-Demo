import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Updateframe extends JFrame{

	Container c;
	JButton btnSave, btnBack;
	JLabel lblName, lblRno;
	JTextField txtName, txtRno;
	JPanel p1, p2;


	Updateframe(){

		c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		p1 = new JPanel();
		p1.setLayout(new FlowLayout());

		lblName = new JLabel("Name");
		lblRno = new JLabel("Roll No.");
		txtName = new JTextField(20);
		txtRno = new JTextField(5);

		p1.add(lblRno);
		p1.add(txtRno);
		p1.add(lblName);
		p1.add(txtName);

		p2 = new JPanel();
		p2.setLayout(new FlowLayout());

		btnSave = new JButton("Save");
		btnBack = new JButton("Back");

		p2.add(btnSave);
		p2.add(btnBack);

		c.add(p1);
		c.add(p2);

		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){

				int r = 0;
				try{	
					r = Integer.parseInt(txtRno.getText());
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(new JDialog(),"Invalid number");
				}

				if(txtRno.getText() == null){
					JOptionPane.showMessageDialog(new JDialog(),"Roll no is empty");
					txtRno.requestFocus();
					return;
				}

				String n = txtName.getText();
				if(n.length()==0){
					JOptionPane.showMessageDialog(new JDialog(),"Name field is empty");
					txtName.requestFocus();
					return;
				}

				DbHandler db = new DbHandler();
				db.updateStudent(r,n);

				txtName.setText("");
				txtRno.setText("");
				txtRno.requestFocus();
				
			}

		});


		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Homeframe af = new Homeframe();
				dispose();
			}

		});




		setTitle("Update Student Info");
		setSize(400,200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}