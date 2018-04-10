package cn.rain.character1;

import cn.rain.character1.pojo.Employees;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/9 23:20
 */
public class JdbcTest {

    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate = null;


    @org.junit.Before
    public void testInit() { // 所有测试方法执行前的初始化代码。
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @Test
    public void testJdbcConnect() throws SQLException { // 测试数据库是否已经连接
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testUpdate() { // 执行 INSERT, UPDATE, DELETE


        // 这里一直报一个警告，如下：
        // SQL dialect is not configured. less... (Ctrl+F1)
        // Detects the best matching SQL dialect for files in <Generic> dialect.
        // 大致意思是，没有配置sql的方言（即没有配置你在用什么数据库的sql语句）因此无法为你识别sql的正确性。
        // 解决办法，setting -> 搜索SQL dialect -> 将global sql和project sql都选为mysql。
        String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "Jack", 5);
    }

    /**
     * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
     * 最后一个参数是 Object[]类型的List : 因为修改一条记录需要一个 Object 的数组, 那么多条就需要多个Object数组
     */
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(?,?,?)";

        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{"AA", "aa@qq.com", 1});
        batchArgs.add(new Object[]{"BB", "bb@qq.com", 2});
        batchArgs.add(new Object[]{"CC", "cc@qq.com", 3});
        batchArgs.add(new Object[]{"DD", "dd@qq.com", 3});
        batchArgs.add(new Object[]{"EE", "ee@qq.com", 2});

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 从数据库中获取一条记录, 实际得到对应的一个对象
     * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
     * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
     * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 last_name lastName
     * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id, last_name lastName, email, dept_id FROM employees WHERE id = ?";
        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
        Employees employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(employee);
    }

    /**
     * 查到实体类的集合
     * 注意调用的不是 queryForList 方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id, last_name lastName, email FROM employees WHERE id > ?";
        RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<>(Employees.class);
        List<Employees> employees = jdbcTemplate.query(sql, rowMapper,5);
        System.out.println(employees);
    }

    /**
     * 获取单个列的值, 或做统计查询
     * 使用 queryForObject(String sql, Class<Long> requiredType)
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) FROM employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
