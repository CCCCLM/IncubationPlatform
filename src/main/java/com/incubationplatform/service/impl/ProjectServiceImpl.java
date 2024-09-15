package com.incubationplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.incubationplatform.common.Const;
import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.dao.*;
import com.incubationplatform.pojo.*;
import com.incubationplatform.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.incubationplatform.vo.ProjectExcelVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, Project> implements IProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private StudentProjectDao studentProjectDao;

    @Autowired
    private ProjectTecherDao projectTecherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AwardDao awardDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private FileDao fileDao;

    public ServerResponse reviewProject(Integer projectId, Integer adminId, String opinion, Integer status){
        Project project = projectDao.selectById(projectId);
        Admin admin = adminDao.selectById(adminId);
        if (admin != null){
            if (status == Const.ProjectStatus.CollegePass.getCode() || status == Const.ProjectStatus.CollegeNoPass.getCode()){
                project.setCollegeOpinionDetail(opinion);
                project.setCollegeOpinionHandlerTime(LocalDateTime.now());
                project.setCollegeOpinionHandler(admin.getName());
                project.setStatus(Const.ProjectStatus.getStatusByCode(status));
            }else if (status == Const.ProjectStatus.CollegePass.getCode() || status == Const.ProjectStatus.CollegeNoPass.getCode()){
                project.setUniversityOpinionDetail(opinion);
                project.setUniversityOpinionHandingTime(LocalDateTime.now());
                project.setUniversityOpinionHandler(admin.getName());
                project.setStatus(Const.ProjectStatus.getStatusByCode(status));
            }else {
                return ServerResponse.createByErrorMessage("项目状态无效");
            }
            int resultCount = projectDao.insert(project);
            if (resultCount > 0){
                return ServerResponse.createBySuccessMessage("审核状态保存成功");
            }
            return ServerResponse.createBySuccessMessage("审核状态保存失败");
        }
        return ServerResponse.createByErrorMessage("此管理员不存在");
    }

    public ServerResponse submitProject(Project project, List<String> team, List<String> teacherList){
        if (project != null){
            String uuid = UUID.randomUUID().toString();
            project.setId(uuid);
            int resultCount = projectDao.insert(project);
            if(resultCount == 0){
                return ServerResponse.createByErrorMessage("项目提交失败");
            }
            for (String studentId : team){
                uuid = UUID.randomUUID().toString();
                StudentProject studentProject = new StudentProject();
                studentProject.setId(uuid);
                studentProject.setUserId(studentId);
                studentProject.setProductId(project.getId());
                studentProject.setCreateTime(LocalDateTime.now());
                studentProjectDao.insert(studentProject);
            }
            for (String teacherId : teacherList){
                uuid = UUID.randomUUID().toString();
                ProjectTecher projectTecher = new ProjectTecher();
                projectTecher.setId(uuid);
                projectTecher.setTeacherId(teacherId);
                projectTecher.setProjectId(project.getId());
                projectTecher.setCreateTime(LocalDateTime.now());
                projectTecherDao.insert(projectTecher);
            }
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("项目参数有误");
    }

    public ServerResponse getProjectByStatus(Integer page,Integer status){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",status);
        if (page!=null){
            IPage projects = projectDao.selectPage(new Page<>(page,10),queryWrapper);
            return ServerResponse.createBySuccess(projects);
        }else {
            IPage projects = projectDao.selectPage(new Page<>(1,10),queryWrapper);
            return ServerResponse.createBySuccess(projects);
        }
    }

    public ServerResponse getProjectDetail(String projectId){
        if (StringUtils.isBlank(projectId)){
            return ServerResponse.createByErrorMessage("id无效");
        }
        Project project = projectDao.selectById(projectId);
        if (project == null){
            return ServerResponse.createByErrorMessage("项目不存在");
        }
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("project",project);
        List<Object> memberIdList = new ArrayList<>();
        memberIdList = studentProjectDao.selectObjs(new QueryWrapper<StudentProject>().select("user_id").eq("product_id",project.getId()));
        List<Student> studentList = new ArrayList<>();
        List<Award> awardList = new ArrayList<>();

        for (Object memberId : memberIdList){
            Student student = studentDao.selectById((String)memberId);
            awardList.addAll(awardDao.selectList(new QueryWrapper<Award>().eq("winner_id",(String)memberId)));
            student.setPassword("");
            studentList.add(student);
        }
        resultMap.put("members",studentList);
        resultMap.put("awards",awardList);

        List<Teacher> teacherList = new ArrayList<>();
        List<ProjectTecher> teacherIdList = projectTecherDao.selectList(new QueryWrapper<ProjectTecher>()
                                                                            .eq("project_id",project.getId()));
        for (ProjectTecher projectTecher : teacherIdList){
            teacherList.add(teacherDao.selectById(projectTecher.getTeacherId()));
        }
        resultMap.put("teachers",teacherList);

        List<File> fileList = fileDao.selectList(new QueryWrapper<File>().eq("belong_id",project.getId()));
        resultMap.put("files",fileList);
        return ServerResponse.createBySuccess(resultMap);
    }




    private List<ProjectExcelVo> assembleProjectExcelVos(){


        return null;
    }

}
