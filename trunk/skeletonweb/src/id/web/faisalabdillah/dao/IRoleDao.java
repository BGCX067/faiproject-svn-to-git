package id.web.faisalabdillah.dao;

import java.util.List;

import id.web.faisalabdillah.domain.Role;

public interface IRoleDao {
	Role findByCode(String code);
	List<Role> listAllPaging(int first,int max);
	List<Role> listAll();
	int sizeAll();
}
