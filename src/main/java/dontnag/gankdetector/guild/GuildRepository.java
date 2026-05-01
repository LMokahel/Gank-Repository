package dontnag.gankdetector.guild;

import org.springframework.jdbc.core.JdbcTemplate;

public class GuildRepository {

    private final JdbcTemplate template;

    public GuildRepository(JdbcTemplate template){
        this.template = template;
    }


}
