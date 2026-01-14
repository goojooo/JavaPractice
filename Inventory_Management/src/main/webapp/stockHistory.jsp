<%@ page import="java.util.List" %>
<%@ page import="pojos.StockTransaction" %>

<!DOCTYPE html>
<html>
<head>
    <title>Stock History</title>
</head>
<body>

<h2>Stock History</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Product ID</th>
        <th>Quantity</th>
        <th>Type</th>
        <th>Date</th>
    </tr>

<%
    List<StockTransaction> list =
        (List<StockTransaction>) request.getAttribute("historyList");

    if (list.isEmpty()) {
%>
    <tr>
        <td colspan="5">No stock transactions found</td>
    </tr>
<%
    } else {
        for (StockTransaction st : list) {
%>
    <tr>
        <td><%= st.getTransactionId() %></td>
        <td><%= st.getProductId() %></td>
        <td><%= st.getChangeQty() %></td>
        <td><%= st.getTransactionType() %></td>
        <td><%= st.getTransactionDate() %></td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>
