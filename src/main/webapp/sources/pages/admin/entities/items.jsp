
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<h1>Items</h1>

<form action="${pageContext.request.contextPath}/admin/items" method="POST">
    <input type="text" name="model" placeholder="Model">
    <input type="text" name="price" placeholder="Price">
    <input type="text" name="amount" placeholder="Amount">
    <input type="text" name="size" placeholder="Size">
    <button type="submit">Add Item</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Size</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.model}</td>
            <td>${item.price}</td>
            <td>${item.amount}</td>
            <td>${item.size}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/items?id=${item.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/admin/items?id=${item.id}&method=DELETE">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
