package com.incubationplatform.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcf
 * @since 2019-03-28
 */
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识符
     */
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 所属学校
     */
    private String belongUniversity;

    /**
     * 所属学院
     */
    private String belongCollege;

    /**
     * 年级
     */
    private String grade;

    /**
     * 专业
     */
    private String specialty;

    /**
     * qq
     */
    private Integer qq;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 是否负责人
     */
    private Integer isMain;

    /**
     * 权限角色
     */
    private String roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Integer isEnable;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBelongUniversity() {
        return belongUniversity;
    }

    public void setBelongUniversity(String belongUniversity) {
        this.belongUniversity = belongUniversity;
    }

    public String getBelongCollege() {
        return belongCollege;
    }

    public void setBelongCollege(String belongCollege) {
        this.belongCollege = belongCollege;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PASSWORD = "password";

    public static final String STUDENT_ID = "student_id";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String BELONG_UNIVERSITY = "belong_university";

    public static final String BELONG_COLLEGE = "belong_college";

    public static final String GRADE = "grade";

    public static final String SPECIALTY = "specialty";

    public static final String QQ = "qq";

    public static final String CLAZZ = "clazz";

    public static final String IS_MAIN = "is_main";

    public static final String ROLE_ID = "role_id";

    public static final String CREATE_TIME = "create_time";

    public static final String IS_ENABLE = "is_enable";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", name=" + name +
        ", password=" + password +
        ", studentId=" + studentId +
        ", phone=" + phone +
        ", email=" + email +
        ", belongUniversity=" + belongUniversity +
        ", belongCollege=" + belongCollege +
        ", grade=" + grade +
        ", specialty=" + specialty +
        ", qq=" + qq +
        ", clazz=" + clazz +
        ", isMain=" + isMain +
        ", roleId=" + roleId +
        ", createTime=" + createTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
