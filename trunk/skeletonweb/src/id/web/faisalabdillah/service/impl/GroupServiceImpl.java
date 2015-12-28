package id.web.faisalabdillah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.web.faisalabdillah.dao.impl.GroupDaoImpl;
import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.service.IGroupService;

@Service
@Transactional(readOnly=true)
public class GroupServiceImpl implements IGroupService{
	
	@Autowired
	private GroupDaoImpl groupDao;
	@Override
	@Transactional(readOnly=false)
	public boolean insert(Group entity) {
		boolean result=false;
		try {
			groupDao.insert(entity);
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Group entity) {
		boolean result=false;
		try {
			groupDao.update(entity);
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Object id) {
		boolean result=false;
		try {
			groupDao.insert(findById(id));
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Group> listAll() {
		return groupDao.listAll();
	}

	@Override
	public List<Group> listPagination(int first, int max) {
		return groupDao.listPagination(first, max);
	}

	@Override
	public int sizeAll() {
		return groupDao.sizeAll();
	}

	@Override
	public Group findById(Object id) {
		return groupDao.findById(String.valueOf(id));
	}

}
