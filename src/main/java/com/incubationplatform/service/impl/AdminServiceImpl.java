package com.incubationplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Admin;
import com.incubationplatform.dao.AdminDao;
import com.incubationplatform.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements IAdminService {
    @Autowired
    private AdminDao adminDao;

    public ServerResponse addAdmin(Admin admin){
        admin.setCreateTime(LocalDateTime.now());
        admin.setIsEnable(1);
        admin.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        int count=adminDao.insert(admin);
        if (count>0){
            return ServerResponse.createBySuccess();
        }else {
            return ServerResponse.createByErrorMessage("修改失败，未知错误");
        }
    }

    public ServerResponse removeAdmin(Admin admin){
        admin.setIsEnable(0);
        int count=adminDao.updateById(admin);
        if (count>0){
            return ServerResponse.createBySuccess();
        }else {
            return ServerResponse.createByErrorMessage("修改失败，未知错误");
        }
    }

    public ServerResponse update(Admin admin){
        int count=adminDao.updateById(admin);
        if (count>0){
            return ServerResponse.createBySuccess();
        }else {
            return ServerResponse.createByErrorMessage("修改失败，未知错误");
        }
    }

    public ServerResponse getAdmin(Integer page,String status){
        QueryWrapper queryWrapper=new QueryWrapper<>().eq("is_enable",1);
        queryWrapper.eq("is_enable",1);
        if (page!=null){
            IPage admins = adminDao.selectPage(new Page<>(page,10),queryWrapper);
            return ServerResponse.createBySuccess(admins);
        }else {
            IPage admins = adminDao.selectPage(new Page<>(1,10),queryWrapper);
            return ServerResponse.createBySuccess(admins);
        }
    }

    public ServerResponse queryAdmin(Admin admin,Integer page){
        QueryWrapper queryWrapper=new QueryWrapper<>().eq("is_enable",1);
        queryWrapper.eq("is_enable",1);
        queryWrapper.like("name",admin.getName());
        if (page!=null){
            IPage admins = adminDao.selectPage(new Page<>(page,10),queryWrapper);
            return ServerResponse.createBySuccess(admins);
        }else {
            IPage admins = adminDao.selectPage(new Page<>(1,10),queryWrapper);
            return ServerResponse.createBySuccess(admins);
        }
    }
}
