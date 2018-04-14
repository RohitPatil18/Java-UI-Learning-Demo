import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Homeframe extends JFrame{

	Container c;
	JButton btnAdd, btnView, btnUpdate, btnDelete;

	Homeframe(){

		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");

		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);

		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Addframe af = new Addframe();
				dispose();
			}

		});

		btnView.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Viewframe vf = new Viewframe();
				dispose();
			}

		});

		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Updateframe uf = new Updateframe();
				dispose();
			}

		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Deleteframe df = new Deleteframe();
				dispose();
			}

		});

		setTitle("Student management System");
		setSize(400,200);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		
		Homeframe hf = new Homeframe();

		
	}

}