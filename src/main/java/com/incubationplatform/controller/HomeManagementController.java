package com.incubationplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.incubationplatform.common.Const;
import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Message;
import com.incubationplatform.pojo.MessageVideo;
import com.incubationplatform.pojo.Project;
import com.incubationplatform.pojo.Sort;
import com.incubationplatform.service.IMessageService;
import com.incubationplatform.service.IMessageVideoService;
import com.incubationplatform.service.IProjectService;
import com.incubationplatform.service.ISortService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author liaochaofan
 * @date 2019/6/1 18:19
 */
@Controller
@RequestMapping("/management/")
public class HomeManagementController {


    @Autowired
    private IMessageService iMessageService;
    @Autowired
    private IMessageVideoService iMessageVideoService;

    @Autowired
    private IProjectService iProjectService;

    @Autowired
    private ISortService iSortService;

    @PostMapping("/add_message")
    @ResponseBody
    public ServerResponse addMessagePage(@RequestBody Message message){
        if(message.getClassification().equals(Const.MessageClassification.ANNOUNCEMENTS)||
                message.getClassification().equals(Const.MessageClassification.CHARACTER_STYLE)||
                message.getClassification().equals(Const.MessageClassification.STUDY_SECTION )||
                message.getClassification().equals(Const.MessageClassification.NEW)){
                message.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                if (iMessageService.save(message)){
                    return ServerResponse.createBySuccess();
                }
            return ServerResponse.createByError();
        }
        return ServerResponse.createByError();
    }

    @GetMapping("/get_message")
    @ResponseBody
    public ServerResponse getMessagePage(@RequestParam(value = "current",defaultValue = "1") Integer current,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size,
                                         String messageClassification){
        if(messageClassification.equals(Const.MessageClassification.ANNOUNCEMENTS)||
           messageClassification.equals(Const.MessageClassification.CHARACTER_STYLE)||
           messageClassification.equals(Const.MessageClassification.STUDY_SECTION )||
           messageClassification.equals(Const.MessageClassification.NEW)){
            IPage<Message> messageIPage = iMessageService.page(new Page<Message>(current,size),
                    new QueryWrapper<Message>()
                            .eq("classification", messageClassification)
                            .orderByDesc("create_time"));
            return ServerResponse.createBySuccess(messageIPage);
        }
        if (messageClassification.equals("创业年会")){
            IPage<MessageVideo> messageIPage = iMessageVideoService.page(new Page<MessageVideo>(current,size),
                    new QueryWrapper<MessageVideo>()
                            .orderByDesc("create_time"));
            return ServerResponse.createBySuccess(messageIPage);
        }
        return ServerResponse.createByError();
    }

    @GetMapping("/del_message")
    @ResponseBody
    public ServerResponse deleteMessage(String messageId){
        if(iMessageService.removeById(messageId)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @PostMapping("/update_message")
    @ResponseBody
    public ServerResponse update(Message message){
        if (StringUtils.isBlank(message.getId())){
            return ServerResponse.createByErrorMessage("id不存在");
        }
        if (iMessageService.updateById(message)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @GetMapping("/message_detail")
    @ResponseBody
    public ServerResponse getMessageDetail(String messageId){
        Message message = iMessageService.getById(messageId);
        if (message != null){
            return ServerResponse.createBySuccess(message);
        }
        return ServerResponse.createByErrorMessage("无法找到");
    }


    @GetMapping("/del_video_message")
    @ResponseBody
    public ServerResponse deleteVideoMessage(String messageId){
        if(iMessageVideoService.removeById(messageId)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @PostMapping("/add_video_message")
    @ResponseBody
    public ServerResponse addVideoMessagePage(@RequestBody MessageVideo videoMessage){
        if (iMessageVideoService.save(videoMessage)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @PostMapping("/update_video_message")
    @ResponseBody
    public ServerResponse updateVideoMessageById(MessageVideo message){
        if (message.getId() == null){
            return ServerResponse.createByErrorMessage("id不存在");
        }
        if (iMessageVideoService.updateById(message)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @GetMapping("/video_message_detail")
    @ResponseBody
    public ServerResponse getVideoMessageDetail(Integer messageId){
        if (messageId == null){
            return ServerResponse.createByErrorMessage("id为空");
        }
        MessageVideo message = iMessageVideoService.getById(messageId);
        if (message != null){
            return ServerResponse.createBySuccess(message);
        }
        return ServerResponse.createByErrorMessage("无法找到");
    }




    @GetMapping("/get_project")
    @ResponseBody
    public ServerResponse getProjectPage(@RequestParam(value = "current",defaultValue = "1") Integer current,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size,
                                         String projectClassification){
        if(projectClassification.equals(Const.ProjectClassification.EXCELLENT_INNOVATE)||
                projectClassification.equals(Const.ProjectClassification.EXCELLENT_PRACTICE)||
                projectClassification.equals(Const.ProjectClassification.EXCELLENT_VENTURE)){
            IPage<Project> projectIPage = iProjectService.page(new Page<Project>(current,size),
                    new QueryWrapper<Project>()
                            .eq("classification", projectClassification)
                            .orderByDesc("create_time"));
            return ServerResponse.createBySuccess(projectIPage);
        }
        return ServerResponse.createByError();
    }

    @GetMapping("/del_project")
    @ResponseBody
    public ServerResponse deleteProject(String projectId){
        if(iMessageService.removeById(projectId)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @PostMapping("/update_project")
    @ResponseBody
    public ServerResponse update(Project projcet){
        if (StringUtils.isBlank(projcet.getId())){
            return ServerResponse.createByErrorMessage("id不存在");
        }
        if (iProjectService.updateById(projcet)){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @GetMapping("/project_detail")
    @ResponseBody
    public ServerResponse getProjectDetail(String projectId){
        Project project = iProjectService.getById(projectId);
        if (project != null){
            return ServerResponse.createBySuccess(project);
        }
        return ServerResponse.createByErrorMessage("无法找到");
    }


    /**
     * 置顶
     * @param classification 分类
     * @param projectId 项目id,如新闻消息的id,结项项目id
     * @return
     */
    @GetMapping("/top")
    @ResponseBody
    public ServerResponse toTop(String classification,String projectId){
        return iSortService.toTop(classification, projectId);
    }
}
