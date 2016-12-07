<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Urban Farms of Central Ohio | Produce Ordering</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/application-main.js"></script>
	<script type="text/javascript" src="js/anonymous-view.js"></script>
</head>
<body>

<div class="container-fluid">

<div id="nav-header" class="hidden-xs">
	<a href="welcome"><img src="img/cropped-UFCO-logo.png" alt="Urban farms of central ohio logo" id="logo-image"/></a>
</div>

<nav class="navbar navbar-default">
  <div class="container-fluid">
  
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
  </div><!-- /.container-fluid -->
</nav>

<div class="center-block col-sm-10">