package dontnag.gankdetector.common;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@SuppressWarnings("SqlSourceToSinkFlow")
public abstract class GankRepository<T> {

    protected final JdbcTemplate template;

    public GankRepository(JdbcTemplate template){
        this.template = template;
    }

    public List<T> getEntities(long limit, long offset){
        String sql = String.format("""
            SELECT *
            FROM %s
            ORDER BY id
            LIMIT ? OFFSET ?;
            """, this.tableName());
        return template.query(
            sql,
            this.rowMapper(),
            limit,
            offset
        );
    }

    public List<T> getEntitiesByName(long limit, long offset, String name){
        String sql = String.format("""
            SELECT *
            FROM %s
            WHERE name LIKE ?
            ORDER BY id
            LIMIT ? OFFSET ?;
            """, this.tableName());
        return template.query(
            sql,
            this.rowMapper(),
            "%" + name + "%",
            limit,
            offset
        );
    }

    public List<T> getEntityById(long id){
        String sql = String.format("""
            SELECT *
            FROM %s
            WHERE id = ?;
            """, this.tableName());
        return template.query(
            sql,
            this.rowMapper(),
            id
        );
    }

    public abstract int updateEntity(long id, T entity);
    public abstract int addEntity(T entity);
    protected abstract String tableName();
    protected abstract RowMapper<T> rowMapper();
}
