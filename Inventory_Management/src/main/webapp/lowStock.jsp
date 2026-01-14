<%@ page import="java.util.List" %>
<%@ page import="pojos.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Low Stock Products</title>
</head>
<body>

<h2 style="color:red;">⚠ Low Stock Products</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
    </tr>

<%
    List<Product> list = (List<Product>) request.getAttribute("lowStockList");

    if (list.isEmpty()) {
%>
    <tr>
        <td colspan="3">No low stock products</td>
    </tr>
<%
    } else {
        for (Product p : list) {
%>
    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getProductName() %></td>
        <td style="color:red;"><%= p.getQuantity() %></td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>
