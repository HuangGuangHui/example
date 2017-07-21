package com.zs.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 2017-7-19
 * 在web启动时设置一些参数
 * @author 张顺
 *
 */
public class PathListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("path", arg0.getServletContext().getContextPath());
	}


}
