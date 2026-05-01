package dontnag.gankdetector.member;

import dontnag.gankdetector.member.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    private final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template){
        this.template = template;
    }

    public List<Member> getMembers(long limit, long offset){
        String sql = """
            SELECT *
            FROM member
            ORDER BY id
            LIMIT ? OFFSET ?;
            """;
        return template.query(
            sql,
            new MemberRowMapper(),
            limit,
            offset
        );
    }

    public List<Member> getMembersByUsername(long limit, long offset, String username){
        String sql = """
            SELECT *
            FROM member
            WHERE username LIKE ?
            ORDER BY id
            LIMIT ? OFFSET ?;
            """;
        return template.query(
            sql,
            new MemberRowMapper(),
            "%" + username + "%",
            limit,
            offset
        );
    }

    public List<Member> getMemberById(long id){
        String sql = """
            SELECT *
            FROM member
            WHERE id = ?
            """;
        return template.query(sql, new MemberRowMapper(), id);
    }

    public int updateMember(long id, Member member){
        String sql = """
            UPDATE member
            SET
                username = COALESCE(?, username),
                password = COALESCE(?, password),
                role = COALESCE(?, role),
                valid = COALESCE(?, valid)
            WHERE id = ?;
            """;
        return template.update(sql,
            member.username(),
            member.password(),
            member.safeRole(),
            member.valid(),
            id
        );
    }

    public int addMember(String username, String password, Role role){
        String sql = """
            INSERT INTO member
            VALUES (NULL, ?, ?, ?, CURRENT_TIMESTAMP, 1);
            """;
        return template.update(
            sql,
            username,
            password,
            role.toString()
        );
    }
}
