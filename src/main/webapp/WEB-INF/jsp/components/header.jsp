<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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

<body>
<header class="header">

    <a href="../">
    <div class="bg-image h-100 w-100" style="background-image: url('../../../resources/images/bg-image.png')"></div>
    </a>

    <div class="d-flex justify-content-around">
        <security:authorize access="isAuthenticated()">
            <div>
                Bonjour <security:authentication property="principal.username" />
            </div>
            <div>
                <a href="/logout"><span class="btn btn-danger my-2">Deconnexion</span></a>
            </div>
        </security:authorize>
    </div>

    <div class="d-flex justify-content-end">
        <div>
            <security:authorize access="isAnonymous()">
                <a href="/login"><span class="btn btn-success my-2">Se connecter</span></a>
            </security:authorize>
        </div>
    </div>

</header>