package dontnag.gankdetector.moderation;

import dontnag.gankdetector.moderation.dto.Moderation;
import dontnag.gankdetector.report.ReportStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModerationRowMapper implements RowMapper<Moderation> {

    @Override
    public Moderation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Moderation(
            rs.getLong("id"),
            rs.getLong("moderator_id"),
            rs.getLong("report_id"),
            rs.getString("description"),
            ReportStatus.valueOf(rs.getString("updated_status")),
            rs.getString("date_created")
        );
    }
}
