import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Deleteframe extends JFrame{

	Container c;
	JButton btnDelete, btnBack;
	JLabel lblRno;
	JTextField txtRno;
	JPanel p1, p2;


	Deleteframe(){

		c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		p1 = new JPanel();
		p1.setLayout(new FlowLayout());

		lblRno = new JLabel("Roll No.");
		txtRno = new JTextField(5);

		p1.add(lblRno);
		p1.add(txtRno);

		p2 = new JPanel();
		p2.setLayout(new FlowLayout());

		btnDelete = new JButton("Delete");
		btnBack = new JButton("Back");

		p2.add(btnDelete);
		p2.add(btnBack);

		c.add(p1);
		c.add(p2);



		btnDelete.addActionListener(new ActionListener() {

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

				DbHandler db = new DbHandler();
				db.deleteStudent(r);

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




		setTitle("Add Student Info");
		setSize(400,200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}