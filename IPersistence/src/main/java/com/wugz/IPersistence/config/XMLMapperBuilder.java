package com.wugz.IPersistence.config;


import com.wugz.IPersistence.pojo.Configuration;
import com.wugz.IPersistence.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");
        //解析查询方法
        parse(namespace,rootElement,SqlCommandType.SELECT);
        //解析修改方法
        parse(namespace,rootElement,SqlCommandType.UPDATE);
        //解析新增方法
        parse(namespace,rootElement,SqlCommandType.INSERT);
        //解析删除方法
        parse(namespace,rootElement,SqlCommandType.DELETE);
    }

    public void parse(String namespace,Element rootElement,SqlCommandType type){
        List<Element> list = rootElement.selectNodes("//" + type.toString().toLowerCase());
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setType(type);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);
            String key = namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);

        }

    }

}
