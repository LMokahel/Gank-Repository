package dontnag.gankdetector.report;

import dontnag.gankdetector.common.GankRepository;
import dontnag.gankdetector.report.dto.Report;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository extends GankRepository<Report> {

    public ReportRepository(JdbcTemplate template) {
        super(template);
    }

    @Override
    public int updateEntity(long id, Report entity) {
        return 0;
    }

    @Override
    public int addEntity(Report entity) {
        String sql = """
            INSERT INTO report
            VALUES (NULL, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP);
            """;
        return template.update(
            sql,
            entity.guild_id(),
            entity.member_id(),
            entity.description(),
            entity.status().toString(),
            entity.evidence()
        );
    }

    @Override
    protected String tableName() {
        return "report";
    }

    @Override
    protected RowMapper<Report> rowMapper() {
        return new ReportRowMapper();
    }
}
