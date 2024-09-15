package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
public interface IAdminService extends IService<Admin> {
    public ServerResponse addAdmin(Admin admin);
    public ServerResponse removeAdmin(Admin admin);
    public ServerResponse update(Admin admin);
    public ServerResponse getAdmin(Integer page,String status);
    public ServerResponse queryAdmin(Admin admin,Integer page);
}
