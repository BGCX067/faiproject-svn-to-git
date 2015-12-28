package id.web.faisalabdillah.dao;

import java.util.List;

import id.web.faisalabdillah.domain.User;

public interface IUserDao{

	User findById(String id);

	List<User> listAll();

	List<User> listPagination(int first, int max);
	
	int sizeAll();
}
