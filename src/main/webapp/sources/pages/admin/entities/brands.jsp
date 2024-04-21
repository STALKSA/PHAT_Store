<%@ page import="com.example.phat_store_112.model.entities.Brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN/BRANDS</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/styles/style.css">
</head>
<body>
<wrapper>
    <header>
        <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/hamburger.png"></div>
        <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/search.png"></div>
        <div class="phat_logo"><img src="${pageContext.request.contextPath}/sources/img/logos/header_logo.jpg"></div>
        <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/admin.png"></div>
        <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/lock.png"></div>
    </header>

    <main>
        <form class="logical_block" method="post" action="${pageContext.request.contextPath}/admin/brands">
            <%Brand brandToUpdate = (Brand) request.getAttribute("brand");%>
            <input type="hidden" name="method" value="<%=request.getAttribute("formMethod")%>">
            <% if (brandToUpdate != null) {%>
                <div>
                    <label for="id">id</label>
                    <input type="text" id="id" name="id" value="<%=brandToUpdate.getId()%>" readonly>
                </div>
            <%}%>
            <div>
                <label for="name">name</label>
                <input type="text" id="name" name="name" value="<%= brandToUpdate != null ? brandToUpdate.getName() : ""%>">
            </div>
            <input type="submit" value="<%=brandToUpdate != null ? "update" : "save"%>">
        </form>
        <table class="logical_block">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <% List<Brand> all = (List<Brand>) request.getAttribute("brands");
                for (Brand brand : all) {
            %>
            <tr>
                <td><%=brand.getId()%></td>
                <td><%=brand.getName()%></td>
<%--                <td><a href="${pageContext.request.contextPath}/admin/brands?id=<%=brand.getId()%>">update</a></td>--%>
                <td><button onclick="update">update</button></td>
<%--                <td>--%>
<%--                    <form method="post" action="${pageContext.request.contextPath}/admin/brands">--%>
<%--                        <input type="hidden" name="id" value="<%=brand.getId()%>">--%>
<%--                        <input type="hidden" name="method" value="DELETE">--%>
<%--                        <input type="submit" value="delete">--%>
<%--                    </form>--%>
<%--                </td>--%>
                <td><button onclick="deleteRequest">delete</button></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </main>
</wrapper>
<script src="${pageContext.request.contextPath}/sources/scripts/admin/brands/clickHandlers.js"></script>
</body>
</html>
