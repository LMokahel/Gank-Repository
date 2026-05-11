package dontnag.gankdetector.guild;

import dontnag.gankdetector.common.GankRepository;
import dontnag.gankdetector.guild.dto.Guild;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GuildRepository extends GankRepository<Guild> {

    public GuildRepository(JdbcTemplate template){
        super(template);
    }

    @Override
    public int updateEntity(long id, Guild entity) {
        String sql = """
            UPDATE guild
            SET
                name = COALESCE(?, name),
                threat_score = COALESCE(?, threat_score)
            WHERE id = ?;
            """;
        return template.update(sql,
            entity.name(),
            entity.threat_score(),
            id
        );
    }

    @Override
    public int addEntity(Guild entity) {
        String sql = """
            INSERT INTO guild
            VALUES (NULL, ?, ?, CURRENT_TIMESTAMP);
            """;
        return template.update(
            sql,
            entity.name(),
            entity.threat_score()
        );
    }

    @Override
    protected String tableName() {
        return "member";
    }

    @Override
    protected RowMapper<Guild> rowMapper() {
        return new GuildRowMapper();
    }
}
