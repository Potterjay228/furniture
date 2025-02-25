package service;

import java.util.List;

import model.Porder;

public interface PorderService {
	
	//create
		void addPorder(Porder porder);
		
	//read
		String AllPorder();
		List<Porder> findAllPorder();
		Porder findById(int id);
		String findUsername(String username);
	//update
		void updatePorder(String name,int id);
		void updatePorder(int desk,int gamingChair,int wardrobe,int id);
		void updatePorder(Porder porder);
		
	//delete
		void deletePorderById(int id);

}
