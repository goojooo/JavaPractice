<%@ page import ="java.sql.*" %>

<%!
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	private static final String INSERT_QUERY = "insert into person_info values(?,?,?,?)"; 
	private static final String SELECT_QUERY = "select pname,page,paddess,pemial from person_info"; 
	
	public void jspInit()
	{
		// Access container created ServletConfig object directly
		ServletConfig cg = getServletConfig();
		// Read init param values(jdbc properties) from ServletConfig object
		String driver = cg.getInitParameter("driverClass");
		String url = cg.getInitParameter("jdbcurl");
		String user = cg.getInitParameter("dbuser");
		String pwd = cg.getInitParameter("dbpwd");
		
		try
		{
			Class.forName(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
%>