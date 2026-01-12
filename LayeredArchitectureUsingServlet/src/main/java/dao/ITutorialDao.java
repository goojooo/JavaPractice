package dao;

import java.sql.SQLException;
import java.util.List;

public interface ITutorialDao {
   List<String>getAllTopicsByName(String topicname)throws SQLException;
}