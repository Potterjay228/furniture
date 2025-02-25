package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {
	
	//create
		void add(Porder porder);
		
	//read
		List<Porder> selectAll();
		List<Porder> selectById(int id);
		List<Porder> selectByUsername(String username);
		
	//update
		void update(Porder porder);
		
	//delete
		void delete(int id);

}
