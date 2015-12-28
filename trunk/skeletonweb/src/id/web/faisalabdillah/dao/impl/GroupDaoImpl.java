package id.web.faisalabdillah.dao.impl;

import java.util.List;

import id.web.faisalabdillah.dao.IGroupDao;
import id.web.faisalabdillah.domain.Group;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Component;

@Component
public class GroupDaoImpl extends BaseDao<Group> implements IGroupDao {

	@Override
	public Group findById(String id) {
		return getTemplate().load(Group.class, id);
	}

	@Override
	public List<Group> listAll() {
		return getTemplate().loadAll(Group.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> listPagination(int first, int max) {
		return getTemplate().findByCriteria(DetachedCriteria.forClass(Group.class), first, max);
	}

	@Override
	public int sizeAll() {
		return DataAccessUtils.intResult(listAll());
	}

}
