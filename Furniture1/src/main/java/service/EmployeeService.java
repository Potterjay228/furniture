package service;

import model.Employee;

public interface EmployeeService {
	
	//create
		void addEmployee(Employee employee);
		
		
		//read
		Employee Login(String username,String password);
		boolean isUsernameBeenUse(String username);
		
		//update
		
		
		//delete

}
