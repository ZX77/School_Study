package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dao.IDepartmentDAO;

import vo.Department;
import vo.Employee;

public class DepartmentAction extends DispatchAction{
	public ActionForward toList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		String departid = request.getParameter("departid");
		Resource r = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory f = new XmlBeanFactory(r);
		IDepartmentDAO dao = (IDepartmentDAO)f.getBean("DepartmentDAO");
		List emps = new ArrayList();
		
		if(departid!=null&&!departid.equals("")){
			DetachedCriteria dc = DetachedCriteria.forClass(Employee.class);
			dc.add(Restrictions.eq("depart.oid",Integer.parseInt(departid)));
			emps = dao.findByDetached(dc);
		}
		
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		List departs = dao.findByDetached(dc);
		
		String str_departs = "";
		for (Iterator iter = departs.iterator(); iter.hasNext();) {
			Department d = (Department) iter.next();
			str_departs+=d.getDeptName()+":"+d.getOid()+",";
		}
		request.setAttribute("str_departs", str_departs);
		
		String str_emps = "";
		for (Iterator iter = emps.iterator(); iter.hasNext();) {
			Employee emp = (Employee) iter.next();
			str_emps+=emp.getEmpName()+":"+emp.getOid()+",";			
		}
		
		out.println(str_departs+";"+str_emps);
		out.close();
		return null;
	}
	
	/**
	 * 查询所有部门
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAllDepart(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		String departid = request.getParameter("departid");
		Resource r = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory f = new XmlBeanFactory(r);
		IDepartmentDAO dao = (IDepartmentDAO)f.getBean("DepartmentDAO");
	
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		List departs = dao.findByDetached(dc);
		
		String str_departs = "";
		for (Iterator iter = departs.iterator(); iter.hasNext();) {
			Department d = (Department) iter.next();
			str_departs+=d.getDeptName()+":"+d.getOid()+",";
		}
		
		
		out.println(str_departs);
		out.close();
		return null;
	}

	public ActionForward findDepartById(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		String departid = request.getParameter("departid");
		Resource r = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory f = new XmlBeanFactory(r);
		IDepartmentDAO dao = (IDepartmentDAO)f.getBean("DepartmentDAO");
	
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		dc.add(Restrictions.eq("oid", Integer.parseInt(departid)));
		List departs = dao.findByDetached(dc);
		Department d = (Department)departs.get(0);
		
		String str_departs = d.getDeptName()+":"+d.getAddress()+":"+d.getPhone()+":"+d.getZipcode();
		
		System.out.println("str = "+str_departs);
		out.println(str_departs);
		out.close();
		return null;
	}
	public ActionForward searchDepart(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String departName = request.getParameter("departName");
		response.setContentType("text/html;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		
		System.out.println("departName = "+departName);
		Resource r = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory f = new XmlBeanFactory(r);
		IDepartmentDAO dao = (IDepartmentDAO)f.getBean("DepartmentDAO");
	
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		dc.add(Restrictions.like("deptName", departName, MatchMode.START));
		List departs = dao.findByDetached(dc);
		
		String str_departs = "";
		for (Iterator iter = departs.iterator(); iter.hasNext();) {
			Department d = (Department) iter.next();
			str_departs+=d.getDeptName()+",";
		}
		
		
		out.println(str_departs);
		out.close();
		return null;
	}

}
