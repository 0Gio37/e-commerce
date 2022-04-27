<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:include page="components/header.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

    <main role="main">

        <section class="jumbotron text-center">
            <div class="container">
                <img class="mb-3 mt-3" src="../../resources/images/logo-svg.svg" height="100">
                <h1 class="jumbotron-heading">VOTRE CONCESSIONNAIRE</h1>
                <p class="lead text-muted">Tous nos véhicules</p>
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

    <jsp:include page="components/footer.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

</body>