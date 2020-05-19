<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String url = request.getRequestURI();%>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu  page-header-fixed "
			data-keep-expanded="false" data-auto-scroll="true"
			data-slide-speed="200" style="padding-top: 20px">
			<li class="sidebar-toggler-wrapper hide">
				<div class="sidebar-toggler">
					<span></span>
				</div>
			</li>
			<!-- END SIDEBAR TOGGLER BUTTON -->
			<li class="nav-item"><a href="/index"
				class="nav-link"> <i class="fa fa-home"></i> <span
					class="title">仪表盘</span>
			</a></li>
		    <li class="nav-item"><a href="/report/under"
				class="nav-link"> <i class="fa fa-calendar"></i> <span
					class="title">未填写报表</span>
			</a></li>
			<li class="nav-item"><a href="/report/history"
				class="nav-link"> <i class="fa fa-calendar"></i> <span
					class="title">历史报表</span>
			</a></li>
			<c:if test="${curUser.role.code=='SUBADMIN'||curUser.role.code=='ADMIN'}">
			<li class="nav-item"><a href="/schedule"
				class="nav-link"> <i class="fa fa-line-chart"></i> <span
					class="title">报表计划</span>
			</a>
			</li>
			<li class="nav-item"><a href="/summary"
				class="nav-link"> <i class="fa fa-line-chart"></i> <span
					class="title">汇总报表</span>
			</a></li>
			<li class="nav-item"><a href="/administration"
				class="nav-link"> <i class="fa fa-line-chart"></i> <span
					class="title">管理处统计表</span>
			</a></li>
			<li class="nav-item"><a href="/form/summary"
				class="nav-link"> <i class="fa fa-line-chart"></i> <span
					class="title">管理处统计表（总表）</span>
			</a></li>
			</c:if>
			<li class="nav-item"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="fa fa-user"></i> <span
					class="title">用户管理</span> <span class="arrow"></span>
			</a>
				<ul class="sub-menu">
					<li class="nav-item"><a href="/user/profile"
						class="nav-link"> <span class="title">编辑个人资料</span>
					</a></li>
					<c:if test="${curUser.role.code=='ADMIN'}">
					<li class="nav-item"><a href="/user/list"
						class="nav-link"> <span class="title">所有用户</span>
					</a></li>
					</c:if>
				</ul></li>
			<c:if test="${curUser.role.code=='ADMIN'}">	
			<li class="nav-item"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="fa fa-cogs"></i> <span
					class="title">系统设置</span> <span class="arrow"></span>
			</a>
			<ul class="sub-menu">
					<li class="nav-item"><a href="/system/roles"
						class="nav-link"> <span class="title">角色管理</span>
					</a></li>
					<li class="nav-item"><a href="/system/operators"
						class="nav-link"> <span class="title">运营商管理</span>
					</a></li>
					<li class="nav-item"><a href="/system/reports"
						class="nav-link"> <span class="title">报表模板管理</span>
					</a></li>
					<li class="nav-item"><a href="/sys/sms/setting"
						class="nav-link"> <span class="title">短消息管理</span>
					</a></li>
					</ul>
			</li>
			</c:if>
		</ul>
	</div>
</div>