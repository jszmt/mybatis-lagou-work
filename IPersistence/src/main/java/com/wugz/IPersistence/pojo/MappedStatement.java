package com.wugz.IPersistence.pojo;

import com.wugz.IPersistence.config.SqlCommandType;

/**
 * @ClassName MappedStatement
 * @Description 解析存放mapper中 每个crud的标签信息
 * @Author wugz
 * @Date 2020/2/22 14:11
 * @Version 1.0
 */
public class MappedStatement {

    //id标识
    private String id;

    /** sql 类型*/
    private SqlCommandType type;
    //返回值类型
    private String resultType;
    //参数值类型
    private String paramterType;
    //sql语句
    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlCommandType getType() {
        return type;
    }

    public void setType(SqlCommandType type) {
        this.type = type;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamterType() {
        return paramterType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }


}
