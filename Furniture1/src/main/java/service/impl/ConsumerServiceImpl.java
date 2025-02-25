package service.impl;

import java.util.List;

import dao.impl.ConsumerDaoImpl;

import model.Consumer;

import service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static ConsumerDaoImpl consumerDaoImpl=new ConsumerDaoImpl();


	@Override
	public void addConsumer(Consumer consumer) {
		consumerDaoImpl.add(consumer);
		
	}

	@Override
	public Consumer Login(String username, String password) {
		Consumer consumer=null;
		List<Consumer> l=consumerDaoImpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			consumer=l.get(0);
		}		
		
		return consumer;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		return !consumerDaoImpl.selectByUsername(username).isEmpty();
	}

}
