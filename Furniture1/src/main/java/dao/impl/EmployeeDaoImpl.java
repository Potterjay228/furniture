package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Consumer;
import model.Employee;

import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	public static void main(String[] args) {
		
		Employee em=new Employee("fgh","qwe123","123456","台北","0917");
		new EmployeeDaoImpl().add(em);
		
		/*List<Employee> l=new EmployeeDaoImpl().selectAll();		
		Employee e=l.get(0);
		e.setName("shower");
		e.setAddress("高雄");
		new EmployeeDaoImpl().update(e);*/
		
		/*new EmployeeDaoImpl().delete(2);*/

	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Employee employee) {
		String SQ="insert into employee(name,username,password,address,phone) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQ);
			preparedstatement.setString(1, employee.getName());
			preparedstatement.setString(2, employee.getUsername());
			preparedstatement.setString(3, employee.getPassword());
			preparedstatement.setString(4, employee.getAddress());
			preparedstatement.setString(5, employee.getPhone());			
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> selectAll() {
		String sql="select * from employee";
		List<Employee> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			
			
			
			while(resultset.next())
			{
				Employee e=new Employee();
				e.setId(resultset.getInt("id"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setAddress(resultset.getString("address"));
				e.setPhone(resultset.getString("phone"));								
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Employee> selectUsernameAndPassword(String username, String password) {
		String sql="select * from employee where username=? and password=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Employee e=new Employee();
				e.setId(resultset.getInt("id"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setAddress(resultset.getString("address"));
				e.setPhone(resultset.getString("phone"));				
				
				l.add(e);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Employee> selectById(int id) {
		String sql="select * from employee where id=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Employee e=new Employee();
				e.setId(resultset.getInt("id"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setAddress(resultset.getString("address"));
				e.setPhone(resultset.getString("phone"));			
				
				l.add(e);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Employee> selectByUsername(String username) {
		String sql="select * from employee where username=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Employee e=new Employee();
				e.setId(resultset.getInt("id"));
				e.setName(resultset.getString("name"));
				e.setUsername(resultset.getString("username"));
				e.setPassword(resultset.getString("password"));
				e.setAddress(resultset.getString("address"));
				e.setPhone(resultset.getString("phone"));
				
				l.add(e);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Employee> selectByEmployeeno(String employeeno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee employee) {
String sql="update employee set name=?,password=?,address=?,phone=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,employee.getName());
			preparedstatement.setString(2,employee.getPassword());
			preparedstatement.setString(3,employee.getAddress());
			preparedstatement.setString(4,employee.getPhone());
			preparedstatement.setInt(5,employee.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from employee where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
