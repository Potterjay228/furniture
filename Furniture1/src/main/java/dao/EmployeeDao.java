package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	//create
		void add(Employee employee);
			
		//read
		List<Employee> selectAll();
		List<Employee> selectUsernameAndPassword(String username,String password);
		List<Employee> selectById(int id);
		List<Employee> selectByUsername(String username);
		List<Employee> selectByEmployeeno(String employeeno);
			
		//update
		void update(Employee employee);
			
		//delete
		void delete(int id);

}
