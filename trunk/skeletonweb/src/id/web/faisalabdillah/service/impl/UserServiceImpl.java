package id.web.faisalabdillah.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.dao.impl.UserDaoImpl;
import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.service.IUserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Override
	@Transactional(readOnly=false)
	public boolean insert(User entity) {
		try {
			userDao.insert(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(User entity) {
		try {
			userDao.update(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Object id) {
		try {
			userDao.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> listAll() {
		return userDao.listAll();
	}

	@Override
	public List<User> listPagination(int first, int max) {
		return userDao.listPagination(first, max);
	}

	@Override
	public int sizeAll() {
		return userDao.sizeAll();
	}

	@Override
	public User findById(Object id) {
		return userDao.findById(String.valueOf(id));
	}
	@Override
	public User findByIdEager(Object id) {
		User user=userDao.findById(String.valueOf(id));
		Hibernate.initialize(user.getGroup());
		Set<Group> group=user.getGroup();
		for (Iterator iterator = group.iterator(); iterator.hasNext();) {
			Group group2 = (Group) iterator.next();
			Hibernate.initialize(group2.getRoles());
		}
		return user;
	}
}
