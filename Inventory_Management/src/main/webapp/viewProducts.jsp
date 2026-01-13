<%@ page import="java.util.List" %>
<%@ page import="pojos.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Products</title>
</head>
<body>

<h2>Product List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product p : products) {
%>
    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQuantity() %></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
