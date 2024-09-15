package com.incubationplatform.controller;


import com.google.gson.JsonObject;
import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Project;
import com.incubationplatform.pojo.Student;
import com.incubationplatform.pojo.Teacher;
import com.incubationplatform.service.IFileService;
import com.incubationplatform.service.IProjectService;
import com.incubationplatform.service.IStudentService;
import com.incubationplatform.vo.SubmitProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IProjectService iProjectService;
    @Autowired
    private IFileService iFileService;

    @RequestMapping("/person")
    public ServerResponse getUserInfo(){
        Student user = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ServerResponse serverResponse=iStudentService.getStudentById(user.getId());
        return serverResponse;
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    提交申报书
    @RequestMapping(value = "/declare",method = RequestMethod.POST)
    public ServerResponse submitProduct(@RequestBody SubmitProjectVo submitProjectVo){
        return iProjectService.submitProject(submitProjectVo.project,submitProjectVo.team,submitProjectVo.teacherList);
    }

    /**
     * 提交结项文档接口，需要学生id
     * @param studentId
     * @param request
     * @param upload_file
     * @return
     */
    @RequestMapping(value = "/upload_post_project_file",method = RequestMethod.POST)
    public ServerResponse uploadPostProjectFile(String studentId, HttpServletRequest request, @RequestParam(value = "upload_file",required = false) MultipartFile upload_file){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return iFileService.uploadPostProjectFile(upload_file,path,studentId);
    }

    /**
     * 提交立项证明材料接口，需要学生id
     * @param studentId
     * @param request
     * @param upload_file
     * @return
     */
    @RequestMapping(value = "/upload_credential_file",method = RequestMethod.POST)
    public ServerResponse uploadCredentialFile(String studentId, HttpServletRequest request, @RequestParam(value = "upload_file",required = false) List<MultipartFile> upload_file){
        String path = request.getSession().getServletContext().getRealPath("upload");

        return iFileService.uploadCredentialFile(upload_file,path,studentId);
    }

    @RequestMapping("/person/submit")
    public ServerResponse updateUserInfo(Student student){
        Student user = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        student.setId(user.getId());
        ServerResponse serverResponse=iStudentService.updateStudentInfo(student);
        return serverResponse;
    }

    @RequestMapping("/student/change_password")
    public ServerResponse updateUserPassword(String newPassword,String oldPassword){
        Student user = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ServerResponse serverResponse = iStudentService.updatePassword(user,newPassword,oldPassword);
        return serverResponse;
    }
}

