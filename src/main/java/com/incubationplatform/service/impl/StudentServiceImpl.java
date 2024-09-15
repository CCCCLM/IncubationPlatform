package com.incubationplatform.service.impl;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Student;
import com.incubationplatform.dao.StudentDao;
import com.incubationplatform.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {
    @Autowired
    StudentDao studentDao;

    //根据用户id获取用户信息
    @Override
    public ServerResponse getStudentById(String id) {
        Student student = studentDao.selectById(id);
        student.setPassword(null);
        return ServerResponse.createBySuccess(student);
    }

    //根据当前登录的用户修改密码
    @Override
    public ServerResponse updatePassword(Student student, String newPassword, String oldPassword) {
        Student user = studentDao.selectById(student.getId());
        DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if (user.getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))) {
            student.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
            if (studentDao.updateById(student) > 0) {
                return ServerResponse.createBySuccess();
            } else {
                return ServerResponse.createByErrorMessage("修改失败，未知错误");
            }
        } else {
            return ServerResponse.createByErrorMessage("原密码不一致");
        }
    }

    //根据当前登录的用户修改用户信息
    @Override
    public ServerResponse updateStudentInfo(Student student) {
        if (studentDao.updateById(student)>0){
            return ServerResponse.createBySuccess();
        }else {
            return ServerResponse.createByErrorMessage("修改失败，未知错误");
        }
    }

    public ServerResponse getAllStudents(){
        return null;
    }
}
