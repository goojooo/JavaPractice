out object class name <%= out.getClass() %> <br>

response object class name <%= response.getClass() %><br>

session object class name <%= session.getClass() %><br>

<%!
public void jspInti(){
	//System.out.println("application obj name : " + //config.getCLass());
	//ServletConfig cg = getServletConfig();
	//System.out.println("application obj name : " +// cg.getClass());
	//System.out.println("application obj name : " +//cg.hashCode());
}
%>

<%= config.getClass() %>
<%= config.hashCode() %>