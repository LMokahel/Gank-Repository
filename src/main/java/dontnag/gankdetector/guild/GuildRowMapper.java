package dontnag.gankdetector.guild;

import dontnag.gankdetector.guild.dto.Guild;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuildRowMapper implements RowMapper<Guild> {

    @Override
    public Guild mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Guild(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getFloat("threat_score"),
            rs.getString("date_created")
        );
    }
}
