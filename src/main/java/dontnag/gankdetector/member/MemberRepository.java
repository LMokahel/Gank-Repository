package dontnag.gankdetector.member;

import dontnag.gankdetector.common.GankRepository;
import dontnag.gankdetector.member.dto.Member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends GankRepository<Member> {

    public MemberRepository(JdbcTemplate template){
        super(template);
    }

    @Override
    public int updateEntity(long id, Member entity){
        String sql = """
            UPDATE member
            SET
                name = COALESCE(?, name),
                password = COALESCE(?, password),
                role = COALESCE(?, role),
                valid = COALESCE(?, valid)
            WHERE id = ?;
            """;
        return template.update(sql,
            entity.username(),
            entity.password(),
            entity.safeRole(),
            entity.valid(),
            id
        );
    }

    @Override
    public int addEntity(Member entity){
        String sql = """
            INSERT INTO member
            VALUES (NULL, ?, ?, ?, CURRENT_TIMESTAMP, 1);
            """;
        return template.update(
            sql,
            entity.username(),
            entity.password(),
            entity.role().toString()
        );
    }

    @Override
    protected String tableName() {
        return "member";
    }

    @Override
    protected RowMapper<Member> rowMapper() {
        return new MemberRowMapper();
    }
}
