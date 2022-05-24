<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="FR-fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="site e-commerce">
    <meta name="author" content="MG">
    <link rel="icon" href="../../resources/images/favico/favicon.ico">
    <title>Mon eCommerce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css">
</head>

<header class="header">
    <a href="../">
        <div class="bg-image h-100 w-100" style="background-image: url('../../resources/images/bg-image.png')"></div>
    </a>
</header>

<form:form name='f' action="perform_logout" method='POST'>
    <div class="d-flex justify-content-center">
        <div>
            Tapez ok pour se deconnecter
            <input class="btn btn-primary my-2" name="submit" type="submit" value="OK" />
        </div>
    </div>
</form:form>