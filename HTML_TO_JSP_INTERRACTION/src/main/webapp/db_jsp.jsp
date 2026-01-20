<%@ page import="java.sql.*" %>

<%!
Connection con = null;
PreparedStatement ps = null;
PreparedStatement ps2 = null;

private static final String INSERT_QUERY =
    "INSERT INTO person_info VALUES(?,?,?,?)";

private static final String SELECT_QUERY =
    "SELECT pname, page, paddress, pemail FROM person_info";

public void jspInit() {
    ServletConfig cg = getServletConfig();

    String driver = cg.getInitParameter("driverClass");
    String url = cg.getInitParameter("jdbcurl");
    String user = cg.getInitParameter("dbuser");
    String pwd = cg.getInitParameter("dbpwd");

    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, pwd);
        ps = con.prepareStatement(INSERT_QUERY);
        ps2 = con.prepareStatement(SELECT_QUERY);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>

<%
String pVal = request.getParameter("p1");

if ("REGISTER".equalsIgnoreCase(pVal)) {

    String name = request.getParameter("pname");
    int age = Integer.parseInt(request.getParameter("page"));
    String addrs = request.getParameter("paddress");
    String email = request.getParameter("pmail");

    ps.setString(1, name);
    ps.setInt(2, age);
    ps.setString(3, addrs);
    ps.setString(4, email);

    int result = ps.executeUpdate();

    if (result == 0) {
%>
        <h1 style="color:red; text-align:center">Record not inserted</h1>
<%
    } else {
%>
        <h1 style="color:green; text-align:center">Record inserted</h1>
<%
    }

} else {

    ResultSet rs = ps2.executeQuery();
%>

<table border="1" bgcolor="cyan" align="center">
<tr>
    <th>Name</th>
    <th>Age</th>
    <th>Address</th>
    <th>Email</th>
</tr>

<%
    while (rs.next()) {
%>
<tr>
    <td><%= rs.getString(1) %></td>
    <td><%= rs.getInt(2) %></td>
    <td><%= rs.getString(3) %></td>
    <td><%= rs.getString(4) %></td>
</tr>
<%
    }
%>
</table>

<%
}
%>
