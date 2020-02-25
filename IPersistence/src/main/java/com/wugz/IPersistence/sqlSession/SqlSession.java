package com.wugz.IPersistence.sqlSession;

import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementid, Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementid, Object... params) throws Exception;


    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);
    
    /**
     * @Description: 保存方法，返回新增数量
     * @param statementid
     * @param params
     * @Date: 2020/2/25 21:05
     * @Author: wuguizhen
     * @Return int
     * @Throws
     */
    public int insert(String statementid, Object params) throws Exception;

    /**
     * @Description: 保存方法，返回新增数量
     * @param statementid
     * @param params
     * @Date: 2020/2/25 21:05
     * @Author: wuguizhen
     * @Return int
     * @Throws
     */
    public int update(String statementid, Object params) throws Exception;


    /**
     * @Description: 保存方法，返回新增数量
     * @param statementid
     * @param params
     * @Date: 2020/2/25 21:05
     * @Author: wuguizhen
     * @Return int
     * @Throws
     */
    public int delete(String statementid, Object params) throws Exception;


}
