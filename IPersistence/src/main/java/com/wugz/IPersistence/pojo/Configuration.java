package com.wugz.IPersistence.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Configuration
 * @Description 存放解析 sqlMapConfig.xml的参数
 * @Author wugz
 * @Date 2020/2/22 14:10
 * @Version 1.0
 */
public class Configuration {

    private DataSource dataSource;

    /** 存放dao方法sql信息 key为： dao接口 className + . + methodName */
    private Map<String,MappedStatement> mappedStatementMap = new HashMap<String, MappedStatement>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
