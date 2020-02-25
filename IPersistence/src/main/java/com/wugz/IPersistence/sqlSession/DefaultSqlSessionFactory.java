package com.wugz.IPersistence.sqlSession;

import com.wugz.IPersistence.pojo.Configuration;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description
 * @Author wugz
 * @Date 2020/2/22 14:40
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements ISqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
