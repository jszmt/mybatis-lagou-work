package com.wugz.IPersistence.sqlSession;

import com.wugz.IPersistence.config.XMLConfigBuilder;
import com.wugz.IPersistence.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description
 * @Author wugz
 * @Date 2020/2/22 14:36
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {
    
    /**
     * @Description: 读取输入流，解析放到配置文件中，并构建sqlSessionFactory对象
     * @param in
     * @Date: 2020/2/22 14:38
     * @Author: wuguizhen
     * @Return DefaultSqlSessionFactory
     * @Throws
     */
    public DefaultSqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {

        // 第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);


        // 第二：创建sqlSessionFactory对象：工厂类：生产sqlSession:会话对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }
}
