package com.incubationplatform.service.impl;

import com.incubationplatform.common.Const;
import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.File;
import com.incubationplatform.dao.FileDao;
import com.incubationplatform.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.incubationplatform.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.common.collect.Lists;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements IFileService {
    @Autowired
    private FileDao fileDao;
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 上传学生立项的证明材料
     * @param files
     * @param path
     * @param studentId
     * @return
     */
    public ServerResponse uploadCredentialFile(List<MultipartFile> files, String path, String studentId){
        List<String> successFileNames = new ArrayList<>();
        for (MultipartFile file :files){
            String fileName = file.getOriginalFilename();
            //扩展名
            String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
            String uuid = UUID.randomUUID().toString();
            String uploadFileName = uuid+"."+fileExtensionName;
            logger.info("开始上传文件，上传文件的文件名：{ }，上传的路径：{ }，新文件名：{ }",fileName,path,uploadFileName);
            java.io.File fileDir = new java.io.File(path);
            if (fileDir.exists()){
                fileDir.setWritable(true);
            }else{
                fileDir.mkdirs();
            }
            java.io.File targetFile = new java.io.File(path,uploadFileName);
            try {
                file.transferTo(targetFile);
                FTPUtil.uploadPostProjectFile(Lists.newArrayList(targetFile));
                File credentialFile = new File();
                credentialFile.setClassification(Const.FileClassfication.CREDENTIAL_File);
                credentialFile.setCreateTime(LocalDateTime.now());
                credentialFile.setName(uploadFileName);
                credentialFile.setId(uuid);
                credentialFile.setBelongId(studentId);
                credentialFile.setOriginalName(fileName);
                fileDao.insert(credentialFile);
                targetFile.delete();

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            successFileNames.add(targetFile.getName());
        }

        return ServerResponse.createBySuccess(successFileNames);
    }

    /**
     * 上传学生结项文档
     * @param file
     * @param path
     * @param studentId
     * @return
     */
    public ServerResponse<String> uploadPostProjectFile(MultipartFile file, String path, String studentId){
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uuid = UUID.randomUUID().toString();
        String uploadFileName = uuid+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{ }，上传的路径：{ }，新文件名：{ }",fileName,path,uploadFileName);
        java.io.File fileDir = new java.io.File(path);
        if (fileDir.exists()){
            fileDir.setWritable(true);
        }else{
            fileDir.mkdirs();
        }
        java.io.File targetFile = new java.io.File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            FTPUtil.uploadCredentialFile(Lists.newArrayList(targetFile));
            File credentialFile = new File();
            credentialFile.setClassification(Const.FileClassfication.POST_PROJECT_File);
            credentialFile.setCreateTime(LocalDateTime.now());
            credentialFile.setName(uploadFileName);
            credentialFile.setId(uuid);
            credentialFile.setBelongId(studentId);
            credentialFile.setOriginalName(fileName);
            fileDao.insert(credentialFile);
            targetFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return ServerResponse.createBySuccess(targetFile.getName());
    }

    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{ }，上传的路径：{ }，新文件名：{ }",fileName,path,uploadFileName);
        java.io.File fileDir = new java.io.File(path);
        if (fileDir.exists()){
            fileDir.setWritable(true);
        }else{
            fileDir.mkdirs();
        }
        java.io.File targetFile = new java.io.File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            targetFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return targetFile.getName();
    }



}
