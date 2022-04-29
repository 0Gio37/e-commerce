<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:include page="components/header.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

    <main role="main">
        <section class="jumbotron text-center">
            <div class="container">
                <img class="mb-3 mt-3" src="../../resources/images/logo-svg.svg" height="100">
                <h1 class="jumbotron-heading">VOTRE CONCESSIONNAIRE EN LIGNE</h1>
                <p class="lead text-muted">Site de vente de véhicules neufs</p>
                <p>
                    <a href="products" class="btn btn-primary my-2">Voir le catalogue</a>
                </p>
            </div>
        </section>
        <section class="section-actu">
            <div class="container">
                <h2 class="jumbotron-heading m-4">NOS API</h2>
                <div>
                    <h3 class="jumbotron-heading m-4">Produits</h3>
                        <p class="mx-2 px-4">
                            <a href="api/products" class="btn btn-warning my-2">Afficher</a>
                        </p>
                    <div>
                        <h3 class="jumbotron-heading m-4">Clients</h3>
                        <p class="mx-2 px-4">
                            <a href="api/clients" class="btn btn-warning my-2">Afficher</a>
                        </p>
                </div>
                    <div>
                        <h3 class="jumbotron-heading m-4">Voir un client</h3>
                        <div class="px-4">
                            <c:forEach items="${listeClient}" var="client">
                                <a href="api/client?username=${client.username}" class="btn btn-warning my-2">${client.username}</a>
                            </c:forEach>
                        </div>

                    </div>
                </div>
            </div>

        </section>
    </main>

    <jsp:include page="components/footer.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>

</body>
</html>
