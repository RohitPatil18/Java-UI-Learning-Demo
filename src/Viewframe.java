import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Viewframe extends JFrame{

	Container c;
	TextArea taView;
	JButton btnBack;


	Viewframe(){

		c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));


		taView = new TextArea(20,10);
		btnBack = new JButton("back");

		c.add(taView);
		c.add(btnBack);


		DbHandler db =  new DbHandler();
		taView.setText(db.viewStudent());

		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae){
				Homeframe af = new Homeframe();
				dispose();
			}

		});





		setTitle("View Student Info");
		setSize(600,405);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




	}

}