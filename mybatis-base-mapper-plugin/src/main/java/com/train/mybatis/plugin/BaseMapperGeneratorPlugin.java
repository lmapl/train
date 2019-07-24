package com.train.mybatis.plugin;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

public class BaseMapperGeneratorPlugin extends PluginAdapter {

    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 生成dao
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {

        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("mybatis-generator.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取key对应的value值
        System.out.println(properties.getProperty("base.mapper"));
        /**
         * 主键默认采用java.lang.Integer
         */
        String pkType = "?";
        if (introspectedTable.getPrimaryKeyColumns() != null && introspectedTable.getPrimaryKeyColumns().size() > 0) {
            FullyQualifiedJavaType fullyQualifiedJavaType = introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType();
            pkType = fullyQualifiedJavaType.toString();
        }

        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<"
                + introspectedTable.getBaseRecordType() + ","
                + introspectedTable.getExampleType() + ","
                + pkType + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(properties.getProperty("base.mapper"));

        FullyQualifiedJavaType rep = new FullyQualifiedJavaType(
                "org.springframework.stereotype.Repository");
        /**
         * 添加 extends MybatisBaseMapper
         */
        interfaze.addSuperInterface(fqjt);

        /**
         * 添加import my.mabatis.example.base.MybatisBaseMapper;
         */
        interfaze.addImportedType(imp);

        /**
         * 添加import org.springframework.stereotype.Repository;
         */
        interfaze.addImportedType(rep);
        interfaze.addAnnotation("@Repository");

        /**
         * 方法不需要
         */
        interfaze.getMethods().clear();
        // interfaze.getAnnotations().clear();
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
