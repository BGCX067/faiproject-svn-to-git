package id.web.faisalabdillah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.dao.impl.RoleDaoImpl;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.service.IRoleService;

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDaoImpl roleDao;

	@Override
	@Transactional(readOnly=false)
	public boolean insert(Role entity) {
		boolean result = true;
		try {
			roleDao.insert(entity);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Role entity) {
		boolean result = true;
		try {
			roleDao.update(entity);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Object id) {
		boolean result = true;
		try {
			roleDao.delete(findById(id));
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public List<Role> listAll() {
		return roleDao.listAll();
	}

	@Override
	public List<Role> listPagination(int first, int max) {
		return roleDao.listAllPaging(first, max);
	}

	@Override
	public int sizeAll() {
		return roleDao.sizeAll();
	}

	@Override
	public Role findById(Object id) {
		return roleDao.findByCode(String.valueOf(id));
	}

}
