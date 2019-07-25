
------------------插件说明---------------------------
这个插件是扩展mybatis-generator生成mapper相关代码的插件
使用：
在generatorConfig.xml添加以下配置
 <plugin type="com.biyao.mybatis.plugin.BaseMapperGeneratorPlugin"></plugin>


------------------------代码生成--------------------------------------
方法一：

1. 可直接运行TestGenerator中的generateCode方法生成mybaits代码

方法二：
在maven中使用mybatis-generator-maven-plugin生成代码, 根据插件说明添加添加插件即可

--------------------------配置说明---------------------------------------------
2.mybaits代码配置在resource下，修改如下属性
  a. driver.classPath
  b. generator.dao.targetProject
  c.generator.domain.targetProject
 其他属性根据实际情况修改，说明见mybatis-generator.properties文件
 
 
