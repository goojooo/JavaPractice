package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utility.DBUtility.getConnection;

public class TutorialDaoImpl implements ITutorialDao {

	
	private Connection con;
	private PreparedStatement pst1;
	
	
	public TutorialDaoImpl() throws ClassNotFoundException, SQLException
	{
		con=getConnection();
    	pst1=con.prepareStatement("select t1.name from tutorials t1 inner join topics t2 on topic_id=id where t2.name=? ");
    	System.out.println("TutorialDao Created");
		
	}
	
	@Override
	public List<String> getAllTopicsByName(String topicname) throws SQLException {
		
		List<String> tutNames=new ArrayList<>();
		pst1.setString(1, topicname);
		try(ResultSet rs=pst1.executeQuery()){
			while(rs.next()) {
				tutNames.add(rs.getString(1));
			}
		}
		return tutNames;
	}

}