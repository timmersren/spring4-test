package cn.rain.pojo;

/**
 * description: 数据库spring4中departments表的pojo对象。
 * @author 任伟
 * @date 2018/4/10 10:08
 */
public class Departments {
    private Integer id;
    private String deptName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
