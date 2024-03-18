package hello.hellospring.repository;
import hello.hellospring.controller.AddPoint;
import hello.hellospring.controller.CheckPoint;
import hello.hellospring.controller.CreatePoint;
import hello.hellospring.controller.DateCheck;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class JdbcMemberRepository implements MemberRepository {
    private final DataSource dataSource;
    Date date = Date.valueOf(LocalDate.now());
    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Member save(Member member) throws SQLException {
        String sql = "insert into user(id, pass, email, mdate, totalDate) values(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPass());
            pstmt.setString(3, member.getEmail());
            pstmt.setDate(4, date);
            pstmt.setInt(5, 0);
            pstmt.executeUpdate();
            System.out.println("insert문 성공");
            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn);
            pstmt.close();
        }
    }
    @Override
    public Optional<Member> findById(String id) {
        String sql = "select * from user where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPass(rs.getString("pass"));
                member.setEmail(rs.getString("email"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findByLogin(String id, String pass) {
        String sql = "select * from user where id = ? and pass = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPass(rs.getString("pass"));
                member.setEmail(rs.getString("email"));
                member.setTotalDate(rs.getInt("totalDate"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public DateCheck checkDate(String id) throws SQLException {
        DateCheck dateCheck = new DateCheck();
        String sql = "update user set totalDate = totalDate + 1 where id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("update문 성공");
            dateCheck.setTotalDate("success");
            return dateCheck;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn);
            pstmt.close();
        }
    }

    @Override
    public CheckPoint checkPoint(String id) throws SQLException {
        String sql = "select totalpoint from user_sort_point where user_sort_point.id = ? and user_sort_point.sort = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql1 = "select totalpoint from user_sort_point where user_sort_point.id = ? and user_sort_point.sort = ?";
        Connection conn1 = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs1 = null;
        String sql2 = "select totalpoint from user_sort_point where user_sort_point.id = ? and user_sort_point.sort = ?";
        Connection conn2 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs2 = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, "shoulder_");
            rs = pstmt.executeQuery();

            conn1 = getConnection();
            pstmt1 = conn1.prepareStatement(sql1);
            pstmt1.setString(1, id);
            pstmt1.setString(2, "back_");
            rs1 = pstmt1.executeQuery();

            conn2 = getConnection();
            pstmt2 = conn2.prepareStatement(sql2);
            pstmt2.setString(1, id);
            pstmt2.setString(2, "ankle_");
            rs2 = pstmt2.executeQuery();

            CheckPoint checkPoint = new CheckPoint();
            if(rs.next()) {
                checkPoint.setPoint_shoulder(rs.getString("totalpoint"));
            }
            else{
                checkPoint.setPoint_shoulder("");
            }
            if(rs1.next()) {
                checkPoint.setPoint_back(rs1.getString("totalpoint"));
            }
            else{
                checkPoint.setPoint_back("");
            }
            if(rs2.next()) {
                checkPoint.setPoint_ankle(rs2.getString("totalpoint"));
            }
            else{
                checkPoint.setPoint_ankle("");
            }

            return checkPoint;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
            close(conn1, pstmt1, rs1);
            close(conn2, pstmt2, rs2);
        }
    }

    @Override
    public AddPoint addPoint(String id, String sort, String point) throws SQLException {
        AddPoint addPoint = new AddPoint();
        String sql = "update user_sort_point set totalpoint = ? where id = ? and sort = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, point);
            pstmt.setString(2, id);
            pstmt.setString(3, sort);
            pstmt.executeUpdate();
            System.out.println("update문 성공");
            addPoint.setPoint("success");
            return addPoint;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn);
            pstmt.close();
        }
    }


    @Override
    public CreatePoint createPoint(String id) throws SQLException {
        CreatePoint createPoint = new CreatePoint();
        String sql = "insert into user_sort_point(id, sort) values(?, ?), (?, ?), (?, ?)";
//        String sql = "update user_sort_point set totalpoint = ? where id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, "shoulder_");
            pstmt.setString(3, id);
            pstmt.setString(4, "back_");
            pstmt.setString(5, id);
            pstmt.setString(6, "ankle_");
            pstmt.executeUpdate();
            System.out.println("insert문 성공2");
            createPoint.setStatus("success");
            return createPoint;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn);
            pstmt.close();
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from user";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Member> members = new ArrayList<>();
            while(rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPass(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}