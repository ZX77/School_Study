package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IDepartmentDAO {
	public List findByDetached(DetachedCriteria dc);

}
