<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:include page="components/header.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <img class="mb-3 mt-3" src="../../resources/images/logo-svg.svg" height="100">
                <h1 class="jumbotron-heading">VOTRE CONCESSIONNAIRE EN LIGNE</h1>
                <p class="lead text-muted">Détails d'un véhicule</p>
            </div>
        </section>

        <div class="album py-5 bg-light">
            <div class="container">
                <h2 class="jumbotron-heading m-4 txt-underline">Modèle <ins>${currentCar.name}</ins></h2>
            </div>
            <div class="container d-flex justify-content-center">
                <div class="card card-single w-25">
                    <img class="card-img-top img-card" alt="Card image cap" src='<c:url value="../../resources/images/modelProducts/${currentCar.picture}.png/"></c:url>' />
                    <div class="card-body">
                        <p class="card-text">CATEGORIE : ${currentCar.description}</p>
                        <p class="card-text">PRIX : ${currentCar.price} €</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-primary">Ajouter au panier</button>
                            </div>
                            <c:choose>
                                <c:when test="${currentCar.quantity > 1}">
                                    <small class="text-muted">Stock: ${currentCar.quantity} unités</small>
                                </c:when>
                                <c:otherwise>
                                    <small class="text-muted">Stock: ${currentCar.quantity} unité</small>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <jsp:include page="components/footer.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

</body>