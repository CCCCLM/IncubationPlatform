package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcf
 * @since 2019-02-28
 */
public interface IFileService extends IService<File> {

    public ServerResponse uploadCredentialFile(List<MultipartFile> files, String path, String studentId);

    public ServerResponse<String> uploadPostProjectFile(MultipartFile file, String path,String studentId);

    public String upload(MultipartFile file, String path);
}
