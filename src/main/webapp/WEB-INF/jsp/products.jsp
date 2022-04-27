<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<body>
    <header class="header">
        <div class="bg-image h-100 w-100" style="background-image: url('../../resources/images/bg-image.png')"></div>
    </header>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <img class="mb-3 mt-3" src="../../resources/images/logo-svg.svg" height="100">
                <h1 class="jumbotron-heading">VOTRE CONCESSIONNAIRE</h1>
                <p class="lead text-muted">Site de vente en ligne de véhicules neufs</p>
                <p>
                    <a href="#" class="btn btn-primary my-2">Acheter tout le stock</a>
                    <a href="#" class="btn btn-secondary my-2">Proposer une vente</a>
                </p>
            </div>
        </section>

        <div class="album py-5 bg-light">
            <div class="container">
                <h2 class="jumbotron-heading m-4">Le catalogue</h2>
            </div>
            <div class="container">
                <div class="row">
                    <c:forEach items="${products}" var="product">
                    <div class="col-md-3 mb-3">
                        <div class="card mb- box-shadow">
                            <img class="card-img-top img-card" alt="Card image cap" src='<c:url value="../../resources/images/modelProducts/${product.picture}.png/"></c:url>' />
                            <div class="card-body">
                                <p class="card-text">MODELE : ${product.name}</p>
                                <p class="card-text">CATEGORIE : ${product.description}</p>
                                <p class="card-text">PRIX : ${product.price} €</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="products/${product.id}" target="_blank">
                                            <button type="button"  class="btn btn-sm btn-outline-primary">Voir la fiche</button>
                                        </a>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Acheter</button>
                                    </div>
                                    <c:choose>
                                        <c:when test="${product.quantity > 1}">
                                            <small class="text-muted">Stock: ${product.quantity} unités</small>
                                        </c:when>
                                        <c:otherwise>
                                            <small class="text-muted">Stock: ${product.quantity} unité</small>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </main>

    <footer class="text-muted bg-dark">
        <div class="container">
            <p class="float-right">
                <a href="#">Back to top</a>
            </p>
            <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
            <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
        </div>
    </footer>

</body>