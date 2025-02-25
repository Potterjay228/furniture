package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Consumer;
import model.Employee;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.DbConnection;
import util.Tool;

public class PorderDaoImpl implements PorderDao {
	private static Consumer consumer = (Consumer) Tool.read("consumer.txt");
	private static Employee employee = (Employee) Tool.read("employee.txt");
	
    private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
	public static void main(String[] args) {
		List<Porder> l=new PorderDaoImpl().selectAll();
		System.out.println(l.get(0).getDesk()+"\n"+l.get(0).getGamingChair());
		//List<Porder> l=new PorderDaoImpl().selectByUsername("abc123");
		//System.out.println(l.get(0).getDesk());
		//List<Porder> l=new PorderDaoImpl().selectById(1);		
		//System.out.println(l.get(1).getDesk());		
		//new PorderDaoImpl().delete(3);

	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Porder porder) {
		
		String Sql="insert into porder(name,desk,gamingChair,wardrobe,username) values(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(Sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getDesk());
			preparedstatement.setInt(3, porder.getGamingChair());
			preparedstatement.setInt(4, porder.getWardrobe());
			preparedstatement.setString(5, porder.getUsername());
			
			preparedstatement.executeUpdate();
			
			insertProduct(porder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void insertProduct(Porder porder) {
		
		String name = "";
	    
		if (consumer.getUsername().equals(porder.getUsername())) {
            name = consumer.getName(); // 使用 consumer 的名稱
        }
        // 判斷是否是 employee 訂購
        else if (employee.getUsername().equals(porder.getUsername())) {
            name = employee.getName(); // 使用 employee 的名稱
        }
		
		if (porder.getDesk() > 0) {
            insertSingleProduct("p001", name, 1999, porder.getDesk());
        }

        // 插入電競椅（p002）到 products 表
        if (porder.getGamingChair() > 0) {
            insertSingleProduct("p002", name, 4999, porder.getGamingChair());
        }

        // 插入衣櫃（p003）到 products 表
        if (porder.getWardrobe() > 0) {
            insertSingleProduct("p003", name, 5799, porder.getWardrobe());
        }
    }
	
	private void updateOrInsertProduct(String productno, String name, int price, int amount) {
	    String sql = "INSERT INTO products (productno, name, price, amount) "
	               + "VALUES (?, ?, ?, ?) "
	               + "ON DUPLICATE KEY UPDATE amount = amount + VALUES(amount)";

	    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
	        preparedStatement.setString(1, productno);
	        preparedStatement.setString(2, name);
	        preparedStatement.setInt(3, price * amount);
	        preparedStatement.setInt(4, amount);

	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

    // 向 products 表插入單個商品
    private void insertSingleProduct(String productno, String name, int price, int amount) {
        String sql = "insert into products (productno, name, price, amount) values(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, productno);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, price * amount);
            preparedStatement.setInt(4, amount); 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		
	

	@Override
	public List<Porder> selectAll() {
		
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setDesk(resultset.getInt("desk"));
				porder.setGamingChair(resultset.getInt("gamingChair"));
				porder.setWardrobe(resultset.getInt("wardrobe"));
				porder.setUsername(resultset.getString("username"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectById(int id) {
		
		String Sql="select * from porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setDesk(resultset.getInt("desk"));
				porder.setGamingChair(resultset.getInt("gamingChair"));
				porder.setWardrobe(resultset.getInt("wardrobe"));
				porder.setUsername(resultset.getString("username"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		
		String sql="update porder set name=?,desk=?,gamingChair=?,wardrobe=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getDesk());
			preparedstatement.setInt(3, porder.getGamingChair());
			preparedstatement.setInt(4, porder.getWardrobe());
			preparedstatement.setInt(5, porder.getId());
			//preparedstatement.setString(6, porder.getUsername());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectByUsername(String username) {
	    String sql = "select * from porder where username=?";
	    List<Porder> l = new ArrayList<>();
	    try {
	        PreparedStatement preparedstatement = conn.prepareStatement(sql);
	        
	        preparedstatement.setString(1, username);
	        

	        ResultSet resultset = preparedstatement.executeQuery();
	        

	        while (resultset.next()) {
	            Porder porder = new Porder();
	            porder.setId(resultset.getInt("id"));
	            porder.setName(resultset.getString("name"));
	            porder.setDesk(resultset.getInt("desk"));
	            porder.setGamingChair(resultset.getInt("gamingChair"));
	            porder.setWardrobe(resultset.getInt("wardrobe"));
	            porder.setUsername(resultset.getString("username"));
	            l.add(porder);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return l;
	}

	
}
