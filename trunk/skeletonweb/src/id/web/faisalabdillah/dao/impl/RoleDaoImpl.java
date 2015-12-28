package id.web.faisalabdillah.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Component;
import id.web.faisalabdillah.dao.IRoleDao;
import id.web.faisalabdillah.domain.Role;

@Component
public class RoleDaoImpl extends BaseDao<Role> implements IRoleDao{

	@Override
	public Role findByCode(String code) {
		return getTemplate().load(Role.class, code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listAllPaging(int first,int max) {
		return getTemplate().findByCriteria(DetachedCriteria.forClass(Role.class),first,max);
	}

	@Override
	public int sizeAll() {
		return DataAccessUtils.intResult(getTemplate().find("from Role"));

	}

	@Override
	public List<Role> listAll() {
		return getTemplate().loadAll(Role.class);
	}

}
