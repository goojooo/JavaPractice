package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;
import utility.DBUtil;

public class TutorialDao {

    // Fetch tutorials by topic (ORDER BY visits DESC)
    public List<Tutorial> getTutorialsByTopic(int topicId) {

        List<Tutorial> list = new ArrayList<>();

        String sql = "SELECT * FROM tutorials WHERE topic_id=? ORDER BY visits DESC";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, topicId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tutorial t = new Tutorial();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setAuthor(rs.getString("author"));
                t.setVisits(rs.getInt("visits"));
                t.setTopicId(rs.getInt("topic_id"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Fetch single tutorial by id
    public Tutorial getTutorialById(int id) {

        Tutorial t = null;
        String sql = "SELECT * FROM tutorials WHERE id=?";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = new Tutorial();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setAuthor(rs.getString("author"));
                t.setContent(rs.getString("content"));
                t.setPublishedDate(rs.getDate("published_date"));
                t.setVisits(rs.getInt("visits"));
                t.setTopicId(rs.getInt("topic_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    // Increment visit count
    public void incrementVisits(int id) {

        String sql = "UPDATE tutorials SET visits = visits + 1 WHERE id=?";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
