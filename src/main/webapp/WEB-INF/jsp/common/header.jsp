<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Urban Farms of Central Ohio | Produce Ordering</title>
	
	<c:url var="bootstrapCSSHREF" value="/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="${bootstrapCSSHREF}" />
	
	<c:url var="mainCSS" value="/css/main.css"/>	
	<link rel="stylesheet" href="${mainCSS}" />

	<c:url var="jqueryHREF" value="/js/jquery.min.js"/>
	<script type="text/javascript" src="${jqueryHREF}"></script>

	<c:url var="bootstrapJS" value="/js/bootstrap.min.js"/>	
	<script type="text/javascript" src="${bootstrapJS}"></script>
	
	<c:url var="jqueryJS" value="/js/jquery.validate.min.js"/>		
	<script type="text/javascript" src="${jqueryJS}"></script>
	
	<c:url var="applicationJS" value="/js/application-main.js"/>		
	<script type="text/javascript" src="${applicationJS }"></script>
	
	<c:url var="anonymousJS" value="/js/anonymous-view.js"/>		
	<script type="text/javascript" src="${anonymousJS}"></script>
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	
	<c:url var="imagePath" value="/img/" />
	
</head>
<body>

<div class="container-fluid">

<div id="nav-header" class="hidden-xs">
	<a href="welcome"><img src="${imagePath}/cropped-UFCO-logo.png" alt="Urban farms of central ohio logo" id="logo-image"/></a>
</div>

<nav class="navbar navbar-default">
  
    <!-- Hamburger button -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>

    <!-- Left-side links -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
    <ul class="nav navbar-nav">
        <li class="active"><a href="welcome">Home<span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">View Current Orders</a></li>
            <li><a href="#">View Pending Orders</a></li>
            <li><a href="#">View Past Orders</a></li>
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> View Cart</a></li>
        <li><a href="login">Login</a></li>
    </ul>

	
    </div><!-- /.navbar-collapse -->
</nav>

<div class="center-block col-sm-10">