package dontnag.gankdetector.moderation;

import dontnag.gankdetector.common.GankRepository;
import dontnag.gankdetector.moderation.dto.Moderation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ModerationRepository extends GankRepository<Moderation> {

    public ModerationRepository(JdbcTemplate template) {
        super(template);
    }

    @Override
    public int updateEntity(long id, Moderation entity) {
        return 0;
    }

    @Override
    public int addEntity(Moderation entity) {
        String sql = """
            INSERT INTO moderation
            VALUES (NULL, ?, ?, ?, ?, CURRENT_TIMESTAMP);
            """;
        return template.update(
            sql,
            entity.moderator_id(),
            entity.report_id(),
            entity.description(),
            entity.updated_status().toString()
        );
    }

    @Override
    protected String tableName() {
        return "moderation";
    }

    @Override
    protected RowMapper<Moderation> rowMapper() {
        return new ModerationRowMapper() ;
    }
}
