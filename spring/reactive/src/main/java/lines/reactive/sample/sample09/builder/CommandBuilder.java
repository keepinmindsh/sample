package lines.reactive.sample.sample09.builder;

import javax.sql.DataSource;

public class CommandBuilder {

    private final DataSource dataSource;

    public static class Builder {

        private DataSource dataSource;

        public Builder setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public CommandBuilder build(){
            return new CommandBuilder(this);
        }
    }

    private CommandBuilder(Builder builder){
        this.dataSource = builder.dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
