package com.zs.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.google.gson.Gson;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.Result;


/**2017-2-27，张顺
 * 权限拦截器，与IT_BDM对接，结果来自IT_BDM的权限拦截器
 * 2017-3-6，张顺
 * 时间轴拦截器也整合其中
 * @author it023
 */
public class RoleInter extends HandlerInterceptorAdapter{

	/*
	private Gson gson=new Gson();
	@Resource
	private UserSer userSer;
	@Resource
	private PowerSer powerSer;
	private Logger log=Logger.getLogger(RoleInter.class);
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String url;
	String reqPamrs;
	private String method;
	HttpSession session;
	StaffUser user;
	StaffRole role;
	
	private void init(HttpServletRequest request, HttpServletResponse response){
		req=request;
		resp=response;
		resp.reset();
		resp.setCharacterEncoding("utf-8");
		String lId=request.getHeader("licence");
		method=req.getMethod();
		//获取其他信息
	    session = req.getSession();  
	    //获得url
	    url=req.getRequestURI();
	    reqPamrs = req.getQueryString();//后面的参数
    	//获取登录者信息
    	user =(StaffUser) session.getAttribute("user");
    	if (user!=null) {
    		role=user.getRole();
		}
	}
	*/
	
	/*权限*/
	/*时间轴*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		init(request, response);
		//例外列表
		if (url.contains("/framework")
				|| url.contains("/file")
				|| url.contains("/login")
				|| url.contains("/logout")
				|| url.contains("/system/setting/target")
				|| url.contains("/api/receive/zm")
				|| url.contains("/api/receive/tp")
				|| url.contains("/api/sourimport/isLoading")
				|| url.contains("/api/sourceZm/isLoading")
				|| url.contains("/check/api/module")
				|| url.contains("/check/customer")
				|| url.contains("/check/api/customer/style")
				|| url.equals("/check/api/customer")
				|| url.equals("/check/api/reportDate/style")
				|| url.equals("/check/api/reportMonth/style")
				|| url.contains("/api/provinceCode/province")
				|| url.contains("/api/version")
				|| url.contains("/api/sourceTp/isLoading")
				|| url.contains("/api/zmReturnData/isLoading")
				) {
			return true;
		}
		if (user==null) {
			if (url.contains("/api/")) {
				PrintWriter pw=resp.getWriter();
				pw.write("错误代码：691\n您还没有登录，请先登录。");
				pw.flush();
				pw.close();
			}else{
				resp.sendRedirect("/check/jsp/part/error1.jsp");
			}
			return false;
		}else if(role==null){
			if (url.contains("/api/")) {
				PrintWriter pw=resp.getWriter();
				pw.write("错误代码：300\n您的权限不够，请联系管理员。");
				pw.flush();
				pw.close();
			}else{
				resp.sendRedirect("/check/jsp/part/error2.jsp");
			}
			return false;
		}
		StaffPower power=powerSer.selectByUrlAndMethodEqual(url, method);
		if (power==null) {
			power=powerSer.selectByUrlAndMethodLike(url, method);
		}
		if (power!=null) {
			boolean isPass=role.getPowers()!=null && (","+role.getPowers()+",").contains(","+power.getStpId()+",");
			if (isPass==false) {
				Result<String> result=new Result<String>(BaseRestController.ERROR, Code.ROLE_NO_PERMISSION, "您没有权限,请联系管理员");
				PrintWriter pw=resp.getWriter();
				pw.print(gson.toJson(result));
				pw.flush();
				pw.close();
				return false;
			}
			return isPass;
		}else{
			log.error("没有这个权限   "+url+"  "+method);
			Result<String> result=new Result<String>(BaseRestController.ERROR, Code.PERMISSION_NO_EXIST, "该模块还没有设计权限，暂时不能操作");
			PrintWriter pw=resp.getWriter();
			if(pw!=null){
				pw.print(gson.toJson(result));
				pw.flush();
				pw.close();
			}
			return false;
		}
		*/
		return true;
	}

	/*
    private boolean isEqual(String someurl,String me) {
    	return url.equals("/quota"+someurl) && me.equals(method);
	}
    private boolean isContain(String someurl,String me) {
    	return url.contains("/quota"+someurl) && me.equals(method);
	}
    private String getId(String someurl) {
    	String ss[]=url.split(someurl);
    	if (ss.length>0) {
    		return ss[ss.length-1];
		}else {
			return null;
		}
    	
	}
    */
    
	/**
	 * 权限判断+最后的跳转处理
	 * @return
	 */
	/*
	private boolean gotoHadle(String id,String pId){
		int re=0;
		if (re==100) {
			return true;
		}else {
			try {
				Result<String> result=new Result<String>("error", re, "权限验证不通过");
				log.error(gson.toJson(result));
				if (url.contains("/api")) {
					resp.setCharacterEncoding("utf-8");
					resp.getWriter().print(gson.toJson(result));
					resp.getWriter().flush();
					resp.getWriter().close();
				}else {
					resp.sendRedirect("/quota/jsp/part/noRole.jsp");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	*/
	
	
	/**
	 * 获取指定字符串出现的次数
	 * 
	 * @param srcText 源字符串
	 * @param findText 要查找的字符串
	 * @return
	 */
	/*
	public static int appearNumber(String srcText, String findText) {
	    int count = 0;
	    Pattern p = Pattern.compile(findText);
	    Matcher m = p.matcher(srcText);
	    while (m.find()) {
	        count++;
	    }
	    return count;
	}
	*/
}
