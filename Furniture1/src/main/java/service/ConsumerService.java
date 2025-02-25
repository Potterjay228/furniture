package service;

import model.Consumer;

public interface ConsumerService {
	
	//create
		void addConsumer(Consumer consumer);
		
		
		//read
		Consumer Login(String username,String password);
		boolean isUsernameBeenUse(String username);
		
		//update
		
		
		//delete
		

}
