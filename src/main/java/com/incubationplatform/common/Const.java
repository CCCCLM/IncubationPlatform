package com.incubationplatform.common;

/**
 * @author liaochaofan
 * @date 2019/3/1 11:01
 */
public class Const {

    public enum ProjectStatus{
        CollegePass(10,"学院审核通过"),
        CollegeNoPass(11,"学院审核未通过"),
        CollegeToAudit(12,"学院待审核"),
        SchoolPass(20,"学校审核通过"),
        SchoolNoPass(21,"学校审核未通过"),
        SchoolToAudit(22,"学校待审核");
        //审核状态码
        private int code;
        //审核状态
        private String status;

        ProjectStatus(int code, String status) {
            this.code = code;
            this.status = status;
        }

        public int getCode() {
            return code;
        }

        public String getStatus() {
            return status;
        }

        public static String getStatusByCode(int code){
            for (ProjectStatus projectStatus : Const.ProjectStatus.values()){
                if(projectStatus.code == code){
                    return projectStatus.status;
                }
            }
            return null;
        }
    }
    public interface ProjectClassification{
        String EXCELLENT_INNOVATE = "创新训练";
        String EXCELLENT_VENTURE = "创业训练";
        String EXCELLENT_PRACTICE = "创业实践";

    }

    public interface MessageClassification{
        String ANNOUNCEMENTS = "通知公告";
        String CHARACTER_STYLE = "创业人物风采";
        String NEW = "新闻动态";
        String STUDY_SECTION = "学习园地";
    }

    public interface FileClassfication{
        String CREDENTIAL_File ="证明材料";
        String POST_PROJECT_File = "结项文档";
    }

}
