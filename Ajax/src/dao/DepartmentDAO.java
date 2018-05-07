package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DepartmentDAO extends HibernateDaoSupport implements IDepartmentDAO{

	public List findByDetached(DetachedCriteria dc) {
		
		return getHibernateTemplate().findByCriteria(dc);
	}

}
