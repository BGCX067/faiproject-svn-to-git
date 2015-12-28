package id.web.faisalabdillah.dao;


import id.web.faisalabdillah.domain.Group;

import java.util.List;

public interface IGroupDao {
	Group findById(String id);

	List<Group> listAll();

	List<Group> listPagination(int first, int max);
	
	int sizeAll();
}
