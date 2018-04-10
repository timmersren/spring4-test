package cn.rain.character1.pojo;

/**
 * description: 数据库spring4中employees表的pojo对象。
 * @author 任伟
 * @date 2018/4/10 10:06
 */
public class Employees {
    private Integer id;
    private String lastName;
    private String email;
    private Integer deptId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
