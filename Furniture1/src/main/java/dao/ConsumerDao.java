package dao;

import java.util.List;

import model.Consumer;

public interface ConsumerDao {
	
	//create
	void add(Consumer consumer);
		
	//read
	List<Consumer> selectAll();
	List<Consumer> selectUsernameAndPassword(String username,String password);
	List<Consumer> selectById(int id);
	List<Consumer> selectByUsername(String username);
	List<Consumer> selectByConsumerno(String consumerno);
		
	//update
	void update(Consumer consumer);
		
	//delete
	void delete(int id);

}
