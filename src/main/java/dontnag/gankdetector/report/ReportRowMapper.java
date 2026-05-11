package dontnag.gankdetector.report;

import dontnag.gankdetector.report.dto.Report;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<Report> {

    @Override
    public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Report(
            rs.getLong("id"),
            rs.getLong("guild_id"),
            rs.getLong("member_id"),
            rs.getString("description"),
            ReportStatus.valueOf(rs.getString("status")),
            rs.getString("evidence"),
            rs.getString("date_created")
        );
    }
}
