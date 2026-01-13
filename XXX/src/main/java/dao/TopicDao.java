package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;
import utility.DBUtil;

public class TopicDao {

    public List<Topic> getAllTopics() {

        List<Topic> list = new ArrayList<>();

        String sql = "SELECT * FROM topics";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {
                Topic t = new Topic();
                t.setId(rs.getInt("id"));
                t.setTopicName(rs.getString("topic_name"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
