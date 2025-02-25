package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;

import model.Consumer;
import model.Employee;

import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	public static void main(String[] args) {
		

	}
	
	private static EmployeeDaoImpl employeedaoimpl=new EmployeeDaoImpl();

	@Override
	public void addEmployee(Employee employee) {
		employeedaoimpl.add(employee);
		
	}

	@Override
	public Employee Login(String username, String password) {
		Employee employee=null;
		List<Employee> l=employeedaoimpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			employee=l.get(0);
		}		
		
		return employee;
	}

	

	@Override
	public boolean isUsernameBeenUse(String username) {
		return !employeedaoimpl.selectByUsername(username).isEmpty();
	}
	

}
