package dontnag.gankdetector.member;

import dontnag.gankdetector.member.dto.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Member(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("password"),
            Role.valueOf(rs.getString("role")),
            rs.getString("date_created"),
            rs.getBoolean("valid")
        );
    }
}
