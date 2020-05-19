<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner ">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="/index" class="logo-default">上海市通信管理局<br/><span>市场业务报表综合分析管理</span>
			</a>
			<div class="menu-toggler sidebar-toggler">
				<span></span>
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler"
			data-toggle="collapse" data-target=".navbar-collapse"> <span></span>
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
				<li class="dropdown dropdown-user"><a href="javascript:;"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> <span
						class="username">您好，${curUser.realname} </span> <i
						class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li><a href="/user/profile"> <i
								class="icon-user"></i>编辑我的资料
						</a></li>
						<li><a href="/logout"> <i class="icon-key"></i>
								登出
						</a></li>
					</ul></li>
				<!-- END USER LOGIN DROPDOWN -->
			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->