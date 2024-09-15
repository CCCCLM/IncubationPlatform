package com.incubationplatform.vo;

import com.incubationplatform.pojo.Project;
import com.incubationplatform.pojo.Student;
import com.incubationplatform.pojo.Teacher;

import java.util.List;

/**
 * @author liaochaofan
 * @date 2019/3/28 10:39
 */
public class SubmitProjectVo {
    public Project project;
    //放置学生Id
    public List<String> team;
    //放置老师Id
    public List<String> teacherList;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<String> getTeam() {
        return team;
    }

    public void setTeam(List<String> team) {
        this.team = team;
    }

    public List<String> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<String> teacherList) {
        this.teacherList = teacherList;
    }
}
