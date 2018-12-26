<%@ page language="java" import="java.util.*,com.xue.utils.*" pageEncoding="utf-8"%>
<%
	// 图像src值
	String path = request.getParameter("path");
	// 拼接服务器路径
	String realPath = request.getRealPath("/") + path;
	// 获取图像审核的方法
	String result = ImageAuditUtil.imageCensor(realPath);
	
	out.print(result);
	
%>