package cn.rain.character7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * description: 演示通过PropertyPlaceHolderConfigurer（Property占位符配置器）将自己编写的properties配置文件通过
 * 占位符的形式注入到bean的属性中。
 * 友情提醒：连接数据库别忘了加入mysql-connector-java的jar包！
 * @author 任伟
 * @date 2018/4/5 14:05
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("character7/applicationContext.xml");

        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
