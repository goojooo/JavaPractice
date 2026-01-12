import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static utility.DBUtility.getConnection;
public class TopicDaoImpl implements ITopicDao {
    private Connection con;
    private PreparedStatement pst1;
    public TopicDaoImpl () throws ClassNotFoundException,SQLException
    {
    	con=getConnection();
    	pst1=con.prepareStatement("select name from topics");
    	System.out.println("TopicDao Created");
    }
	
	
	public List<String> getAllTopics() throws SQLException {
		List<String> topicName=new ArrayList<>();
		try(ResultSet rs=pst1.executeQuery())
		{
			while(rs.next())
			{
				topicName.add(rs.getString(1));
				
			}
		}
		// TODO Auto-generated method stub
		return topicName;
	}

}