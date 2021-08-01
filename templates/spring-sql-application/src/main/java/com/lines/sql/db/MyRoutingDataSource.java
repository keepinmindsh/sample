package com.lines.sql.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private CircularList<String> dataSourceNameList;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return Optional.ofNullable(DBThreadLocal.get()).orElse("LINES").toString();
    }
}
