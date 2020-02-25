package com.wugz.IPersistence.sqlSession;

import com.wugz.IPersistence.pojo.Configuration;
import com.wugz.IPersistence.pojo.MappedStatement;

import java.util.List;


public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    int update(Configuration configuration, MappedStatement mappedStatement, Object params) throws Exception;
}
