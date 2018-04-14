import java.sql.*;
import javax.swing.*;
import java.awt.*;

class DbHandler{

	public void addStudent(int rno, String name){

		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

			String sql = "Insert into student values(?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1,rno);
			pst.setString(2, name);

			long r = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), r +" rows inserted");

			con.close();

		}catch(SQLException e){

			JOptionPane.showMessageDialog(new JDialog(),"Issue "+e);

		}
	}

	public String viewStudent(){
		StringBuffer sb = new StringBuffer();

		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

			Statement stmt = con.createStatement();
			String sql = "Select * from student";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				int rno = rs.getInt(1);
				String name = rs.getString(2);

				sb.append("Rno : "+rno+"         Name : "+name+"\n");
			}
			rs.close();
			con.close();

		}catch(SQLException e){

			JOptionPane.showMessageDialog(new JDialog(),"Issue "+e);
		}

		return sb.toString();

	}



		public void updateStudent(int rno, String name){

		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

			String sql = "update student set name = ? where rno = ?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(2,rno);
			pst.setString(1, name);

			long r = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), r +" rows Updated");

			con.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(new JDialog(),"Issue "+e);
		}

	}

	public void deleteStudent(int rno){

		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

			String sql = "delete from student where rno = ?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, rno);

			long r = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), r +" rows Updated");

			con.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(new JDialog(),"Issue "+e);
		}

	}




}