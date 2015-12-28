package id.web.faisalabdillah.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseDao<T> {
	
	private HibernateTemplate template;
	
	private SessionFactory session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		template = new HibernateTemplate(sessionFactory);
		session = sessionFactory;
	}
	public SessionFactory getSessionFactory(){
		return session;
	}
	public HibernateTemplate getTemplate(){
		return template;
	}
	
	public void insert(T entity){
		getTemplate().save(entity);
	}
	
	public void update(T entity){
		getTemplate().save(entity);
	}
	
	public void delete(T entity){
		getTemplate().delete(entity);
	}
	
}
