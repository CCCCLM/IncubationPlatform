package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
public interface IProjectService extends IService<Project> {

    ServerResponse reviewProject(Integer projectId, Integer adminId, String opinion, Integer status);

    public ServerResponse submitProject(Project project, List<String> team, List<String> teacherList);

    public ServerResponse getProjectByStatus(Integer page,Integer status);

    public ServerResponse getProjectDetail(String projectId);
}
