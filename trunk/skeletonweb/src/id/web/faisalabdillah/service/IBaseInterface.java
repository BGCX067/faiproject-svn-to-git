package id.web.faisalabdillah.service;

import java.util.List;

public interface IBaseInterface<T> {

	boolean insert(T entity);

	boolean update(T entity);

	boolean delete(Object id);
	
	List<T> listAll();
	
	List<T> listPagination(int first,int max);
	
	int sizeAll();
	
	T findById(Object id);
	
	
}
