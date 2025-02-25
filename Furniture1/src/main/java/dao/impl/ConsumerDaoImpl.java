package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConsumerDao;
import model.Consumer;
import model.Employee;
import util.DbConnection;

public class ConsumerDaoImpl implements ConsumerDao{

	public static void main(String[] args) {
		Consumer cn=new Consumer("fff","fff123","123456","台北","0917");
		new ConsumerDaoImpl().add(cn);
		/*List<Consumer> l=new ConsumerDaoImpl().selectAll();		
		Consumer m=l.get(1);
		m.setName("shower");
		m.setAddress("高雄");
		new ConsumerDaoImpl().update(m);
		
		/*new ConsumerDaoImpl().delete(7);*/
	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Consumer consumer) {
		String SQ="insert into consumer(name,username,password,address,phone) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQ);
			preparedstatement.setString(1, consumer.getConsumerno());
			preparedstatement.setString(1, consumer.getName());
			preparedstatement.setString(2, consumer.getUsername());
			preparedstatement.setString(3, consumer.getPassword());
			preparedstatement.setString(4, consumer.getAddress());
			preparedstatement.setString(5, consumer.getPhone());
		
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Consumer> selectAll() {
		String sql="select * from consumer";
		List<Consumer> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			
			
			
			while(resultset.next())
			{
				Consumer c=new Consumer();
				c.setId(resultset.getInt("id"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setAddress(resultset.getString("address"));
				c.setPhone(resultset.getString("phone"));
				
				
				l.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public List<Consumer> selectUsernameAndPassword(String username, String password) {
		String sql="select * from consumer where username=? and password=?";
		List<Consumer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Consumer c=new Consumer();
				c.setId(resultset.getInt("id"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setAddress(resultset.getString("address"));
				c.setPhone(resultset.getString("phone"));
	
				
				l.add(c);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return l;
	}

	@Override
	public List<Consumer> selectById(int id) {
		String sql="select * from consumer where id=?";
		List<Consumer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Consumer c=new Consumer();
				c.setId(resultset.getInt("id"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setAddress(resultset.getString("address"));
				c.setPhone(resultset.getString("phone"));
		
				
				l.add(c);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Consumer> selectByUsername(String username) {
		String sql="select * from consumer where username=?";
		List<Consumer> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Consumer c=new Consumer();
				c.setId(resultset.getInt("id"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setAddress(resultset.getString("address"));
				c.setPhone(resultset.getString("phone"));
			
				
				l.add(c);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return l;
	}

	@Override
	public List<Consumer> selectByConsumerno(String consumerno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Consumer consumer) {
String sql="update consumer set name=?,password=?,address=?,phone=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,consumer.getName());
			preparedstatement.setString(2,consumer.getPassword());
			preparedstatement.setString(3,consumer.getAddress());
			preparedstatement.setString(4,consumer.getPhone());		
			preparedstatement.setInt(5,consumer.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from consumer where id=?";
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
