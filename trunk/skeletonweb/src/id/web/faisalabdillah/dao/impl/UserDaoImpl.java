package id.web.faisalabdillah.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Component;

import id.web.faisalabdillah.dao.IUserDao;
import id.web.faisalabdillah.domain.User;

@Component
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	@Override
	public User findById(String id) {
		return getTemplate().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listAll() {
		return getTemplate().find("from User");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listPagination(int first, int max) {
		return getTemplate().findByCriteria(DetachedCriteria.forClass(User.class),first,max);
	}

	@Override
	public int sizeAll() {
		return DataAccessUtils.intResult(getTemplate().loadAll(User.class));
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findByExample(User user){
		return getTemplate().findByExample(Example.create(user));
	}
	
}
