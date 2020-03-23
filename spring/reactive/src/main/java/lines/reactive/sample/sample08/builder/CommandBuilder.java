package lines.reactive.sample.sample08.builder;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.Map;

public class CommandBuilder {

    private final String storedProcedureName;
    private final String packageName;
    private final DataSource dataSource;
    private final SqlParameter[] sqlParameters;
    private final Map<String, Object> parameterMap;
    private final RowMapper<?> rowMapper;
    private final String query;

    public static class Builder{
        private String storedProcedureName;
        private String packageName;
        private DataSource dataSource;
        private SqlParameter[] sqlParameters;
        private Map<String, Object> parameterMap;
        private String query;
        private RowMapper<?> rowMapper;

        public Builder setStoredProcedureName(String storedProcedureName) {
            this.storedProcedureName = storedProcedureName;
            return this;
        }

        public Builder setPackageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public Builder setSqlParameters(SqlParameter[] sqlParameters) {
            this.sqlParameters = sqlParameters;
            return this;
        }

        public Builder setParameterMap(Map<String, Object> parameterMap) {
            this.parameterMap = parameterMap;
            return this;
        }

        public Builder setQuery(String query) {
            this.query = query;
            return this;
        }

        public Builder setRowMapper(RowMapper<?> rowMapper) {
            this.rowMapper = rowMapper;
            return this;
        }


        public CommandBuilder build(){
            return new CommandBuilder(this);
        }

    }


    private CommandBuilder(Builder builder){
        this.dataSource = builder.dataSource;
        this.packageName = builder.packageName;
        this.parameterMap = builder.parameterMap;
        this.sqlParameters = builder.sqlParameters;
        this.storedProcedureName = builder.storedProcedureName;
        this.query = builder.query;
        this.rowMapper = builder.rowMapper;
    }

    public String getStoredProcedureName() {
        return storedProcedureName;
    }

    public String getPackageName() {
        return packageName;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public SqlParameter[] getSqlParameters() {
        return sqlParameters;
    }

    public Map<String, Object> getParameterMap() {
        return parameterMap;
    }

    public String getQuery() {
        return query;
    }

    public RowMapper<?> getRowMapper() {
        return rowMapper;
    }
}
