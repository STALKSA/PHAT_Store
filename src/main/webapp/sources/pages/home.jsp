<%@ page import="java.util.List" %>
<%@ page import="com.example.phat_store_112.model.entities.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sources/styles/style.css">
</head>
<body>
    <wrapper>
        <header>
            <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/hamburger.png"></div>
            <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/search.png"></div>
            <div class="phat_logo"><img src="${pageContext.request.contextPath}/sources/img/logos/header_logo.jpg"></div>
            <div class="nav_icon">
                <a href="${pageContext.request.contextPath}/admin">
                    <img src="${pageContext.request.contextPath}/sources/img/header/admin.png">
                </a>
            </div>
            <div class="nav_icon"><img src="${pageContext.request.contextPath}/sources/img/header/lock.png"></div>
        </header>

        <main>
            <div class="shop">
                <div class="categories">
                    <%  List<Category> categories = (List<Category>) request.getAttribute("categories");
                        for (int i = 0; i < categories.size(); i++) {
                            Category category = categories.get(i);
                    %>
                    <a href="${pageContext.request.contextPath}/category?id=<%=category.getId()%>">
                        <div class="category">
                            <%--                    photo--%>
                            <div class="category_img">
                                <%String categoryCaption = category.getName();%>
                                <img src="${pageContext.request.contextPath}/sources/img/categories/<%=categoryCaption%>.jpg">
                            </div>
                            <%--                    caption--%>
                            <div class="category_caption"><%=categoryCaption%></div>
                        </div>
                    </a>
                    <%}%>

                </div>
<%--                <div class="brands">--%>

<%--                </div>--%>
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/sources/img/logos/main_logo.jpg">
                </div>
            </div>
        </main>
    </wrapper>
</body>
</html>
