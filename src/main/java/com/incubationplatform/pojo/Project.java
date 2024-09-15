package com.incubationplatform.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcf
 * @since 2019-03-28
 */
public class Project extends Model<Project> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 赛事Id
     */
    private String matchId;

    /**
     * 项目名字
     */
    private String name;

    /**
     * 项目分类
     */
    private String classification;

    /**
     * 项目等级
     */
    private String grade;

    /**
     * 项目简介
     */
    private String introduce;

    /**
     * 项目背景
     */
    private String background;

    /**
     * 项目优势
     */
    private String advantage;

    /**
     * 项目市场分析
     */
    private String marketAnalysis;

    /**
     * 项目技术因素
     */
    private String technicalFactor;

    /**
     * 商业模式
     */
    private String businessModel;

    /**
     * 财务分析
     */
    private String financialAnalysis;

    /**
     * 风险预测及制约因素
     */
    private String riskAndConstraint;

    /**
     * 发展规划与创业愿景
     */
    private String planningAndVision;

    /**
     * 项目立项经费使用预算
     */
    private String fundAndBudget;

    /**
     * 项目预期成果
     */
    private String expectedResult;

    /**
     * 学院立项意见详情
     */
    private String collegeOpinionDetail;

    /**
     * 学院结项意见详情
     */
    private String collegePostOpinionDetail;

    /**
     * 学院立项意见处理人
     */
    private String collegeOpinionHandler;

    /**
     * 学院结项意见处理人
     */
    private String collegePostOpinionHandler;

    /**
     * 学院立项意见签名时间
     */
    private LocalDateTime collegeOpinionHandlerTime;

    /**
     * 学院结项意见签名时间
     */
    private LocalDateTime collegePostOpinionHandlerTime;

    /**
     * 申请人承诺详情
     */
    private String applicantPromiseDetail;

    /**
     * 申请人承诺处理者
     */
    private String applicantPromiseHandler;

    /**
     * 申请人承诺处理时间
     */
    private LocalDateTime applicantPromistHandingTime;

    /**
     * 学校立项意见详情
     */
    private String universityOpinionDetail;

    /**
     * 学校结项意见详情
     */
    private String universityPostOpinionDetail;

    /**
     * 学校立项意见处理者
     */
    private String universityOpinionHandler;

    /**
     * 学校结项意见处理者
     */
    private String universityPostOpinionHandler;

    /**
     * 学校立项意见处理时间
     */
    private LocalDateTime universityOpinionHandingTime;

    /**
     * 学校结项意见处理时间
     */
    private LocalDateTime universityPostOpinionHandingTime;

    /**
     * 审核状态
     */
    private String status;

    /**
     * 团队id
     */
    private String teamId;

    /**
     * 状态修改时间
     */
    private LocalDateTime changeTime;

    /**
     * 资助金额
     */
    private Integer supportSum;

    /**
     * 是否已并无法修改
     */
    private Integer isEnable;

    /**
     * 学科代码
     */
    private String subjectCode;

    /**
     * 结项时间
     */
    private LocalDateTime deadlineTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getMarketAnalysis() {
        return marketAnalysis;
    }

    public void setMarketAnalysis(String marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }

    public String getTechnicalFactor() {
        return technicalFactor;
    }

    public void setTechnicalFactor(String technicalFactor) {
        this.technicalFactor = technicalFactor;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getFinancialAnalysis() {
        return financialAnalysis;
    }

    public void setFinancialAnalysis(String financialAnalysis) {
        this.financialAnalysis = financialAnalysis;
    }

    public String getRiskAndConstraint() {
        return riskAndConstraint;
    }

    public void setRiskAndConstraint(String riskAndConstraint) {
        this.riskAndConstraint = riskAndConstraint;
    }

    public String getPlanningAndVision() {
        return planningAndVision;
    }

    public void setPlanningAndVision(String planningAndVision) {
        this.planningAndVision = planningAndVision;
    }

    public String getFundAndBudget() {
        return fundAndBudget;
    }

    public void setFundAndBudget(String fundAndBudget) {
        this.fundAndBudget = fundAndBudget;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getCollegeOpinionDetail() {
        return collegeOpinionDetail;
    }

    public void setCollegeOpinionDetail(String collegeOpinionDetail) {
        this.collegeOpinionDetail = collegeOpinionDetail;
    }

    public String getCollegePostOpinionDetail() {
        return collegePostOpinionDetail;
    }

    public void setCollegePostOpinionDetail(String collegePostOpinionDetail) {
        this.collegePostOpinionDetail = collegePostOpinionDetail;
    }

    public String getCollegeOpinionHandler() {
        return collegeOpinionHandler;
    }

    public void setCollegeOpinionHandler(String collegeOpinionHandler) {
        this.collegeOpinionHandler = collegeOpinionHandler;
    }

    public String getCollegePostOpinionHandler() {
        return collegePostOpinionHandler;
    }

    public void setCollegePostOpinionHandler(String collegePostOpinionHandler) {
        this.collegePostOpinionHandler = collegePostOpinionHandler;
    }

    public LocalDateTime getCollegeOpinionHandlerTime() {
        return collegeOpinionHandlerTime;
    }

    public void setCollegeOpinionHandlerTime(LocalDateTime collegeOpinionHandlerTime) {
        this.collegeOpinionHandlerTime = collegeOpinionHandlerTime;
    }

    public LocalDateTime getCollegePostOpinionHandlerTime() {
        return collegePostOpinionHandlerTime;
    }

    public void setCollegePostOpinionHandlerTime(LocalDateTime collegePostOpinionHandlerTime) {
        this.collegePostOpinionHandlerTime = collegePostOpinionHandlerTime;
    }

    public String getApplicantPromiseDetail() {
        return applicantPromiseDetail;
    }

    public void setApplicantPromiseDetail(String applicantPromiseDetail) {
        this.applicantPromiseDetail = applicantPromiseDetail;
    }

    public String getApplicantPromiseHandler() {
        return applicantPromiseHandler;
    }

    public void setApplicantPromiseHandler(String applicantPromiseHandler) {
        this.applicantPromiseHandler = applicantPromiseHandler;
    }

    public LocalDateTime getApplicantPromistHandingTime() {
        return applicantPromistHandingTime;
    }

    public void setApplicantPromistHandingTime(LocalDateTime applicantPromistHandingTime) {
        this.applicantPromistHandingTime = applicantPromistHandingTime;
    }

    public String getUniversityOpinionDetail() {
        return universityOpinionDetail;
    }

    public void setUniversityOpinionDetail(String universityOpinionDetail) {
        this.universityOpinionDetail = universityOpinionDetail;
    }

    public String getUniversityPostOpinionDetail() {
        return universityPostOpinionDetail;
    }

    public void setUniversityPostOpinionDetail(String universityPostOpinionDetail) {
        this.universityPostOpinionDetail = universityPostOpinionDetail;
    }

    public String getUniversityOpinionHandler() {
        return universityOpinionHandler;
    }

    public void setUniversityOpinionHandler(String universityOpinionHandler) {
        this.universityOpinionHandler = universityOpinionHandler;
    }

    public String getUniversityPostOpinionHandler() {
        return universityPostOpinionHandler;
    }

    public void setUniversityPostOpinionHandler(String universityPostOpinionHandler) {
        this.universityPostOpinionHandler = universityPostOpinionHandler;
    }

    public LocalDateTime getUniversityOpinionHandingTime() {
        return universityOpinionHandingTime;
    }

    public void setUniversityOpinionHandingTime(LocalDateTime universityOpinionHandingTime) {
        this.universityOpinionHandingTime = universityOpinionHandingTime;
    }

    public LocalDateTime getUniversityPostOpinionHandingTime() {
        return universityPostOpinionHandingTime;
    }

    public void setUniversityPostOpinionHandingTime(LocalDateTime universityPostOpinionHandingTime) {
        this.universityPostOpinionHandingTime = universityPostOpinionHandingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDateTime changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getSupportSum() {
        return supportSum;
    }

    public void setSupportSum(Integer supportSum) {
        this.supportSum = supportSum;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public LocalDateTime getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public static final String ID = "id";

    public static final String MATCH_ID = "match_id";

    public static final String NAME = "name";

    public static final String CLASSIFICATION = "classification";

    public static final String GRADE = "grade";

    public static final String INTRODUCE = "introduce";

    public static final String BACKGROUND = "background";

    public static final String ADVANTAGE = "advantage";

    public static final String MARKET_ANALYSIS = "market_analysis";

    public static final String TECHNICAL_FACTOR = "technical_factor";

    public static final String BUSINESS_MODEL = "business_model";

    public static final String FINANCIAL_ANALYSIS = "financial_analysis";

    public static final String RISK_AND_CONSTRAINT = "risk_and_constraint";

    public static final String PLANNING_AND_VISION = "planning_and_vision";

    public static final String FUND_AND_BUDGET = "fund_and_budget";

    public static final String EXPECTED_RESULT = "expected_result";

    public static final String COLLEGE_OPINION_DETAIL = "college_opinion_detail";

    public static final String COLLEGE_POST_OPINION_DETAIL = "college_post_opinion_detail";

    public static final String COLLEGE_OPINION_HANDLER = "college_opinion_handler";

    public static final String COLLEGE_POST_OPINION_HANDLER = "college_post_opinion_handler";

    public static final String COLLEGE_OPINION_HANDLER_TIME = "college_opinion_handler_time";

    public static final String COLLEGE_POST_OPINION_HANDLER_TIME = "college_post_opinion_handler_time";

    public static final String APPLICANT_PROMISE_DETAIL = "applicant_promise_detail";

    public static final String APPLICANT_PROMISE_HANDLER = "applicant_promise_handler";

    public static final String APPLICANT_PROMIST_HANDING_TIME = "applicant_promist_handing_time";

    public static final String UNIVERSITY_OPINION_DETAIL = "university_opinion_detail";

    public static final String UNIVERSITY_POST_OPINION_DETAIL = "university_post_opinion_detail";

    public static final String UNIVERSITY_OPINION_HANDLER = "university_opinion_handler";

    public static final String UNIVERSITY_POST_OPINION_HANDLER = "university_post_opinion_handler";

    public static final String UNIVERSITY_OPINION_HANDING_TIME = "university_opinion_handing_time";

    public static final String UNIVERSITY_POST_OPINION_HANDING_TIME = "university_post_opinion_handing_time";

    public static final String STATUS = "status";

    public static final String TEAM_ID = "team_id";

    public static final String CHANGE_TIME = "change_time";

    public static final String SUPPORT_SUM = "support_sum";

    public static final String IS_ENABLE = "is_enable";

    public static final String SUBJECT_CODE = "subject_code";

    public static final String DEADLINE_TIME = "deadline_time";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Project{" +
        "id=" + id +
        ", matchId=" + matchId +
        ", name=" + name +
        ", classification=" + classification +
        ", grade=" + grade +
        ", introduce=" + introduce +
        ", background=" + background +
        ", advantage=" + advantage +
        ", marketAnalysis=" + marketAnalysis +
        ", technicalFactor=" + technicalFactor +
        ", businessModel=" + businessModel +
        ", financialAnalysis=" + financialAnalysis +
        ", riskAndConstraint=" + riskAndConstraint +
        ", planningAndVision=" + planningAndVision +
        ", fundAndBudget=" + fundAndBudget +
        ", expectedResult=" + expectedResult +
        ", collegeOpinionDetail=" + collegeOpinionDetail +
        ", collegePostOpinionDetail=" + collegePostOpinionDetail +
        ", collegeOpinionHandler=" + collegeOpinionHandler +
        ", collegePostOpinionHandler=" + collegePostOpinionHandler +
        ", collegeOpinionHandlerTime=" + collegeOpinionHandlerTime +
        ", collegePostOpinionHandlerTime=" + collegePostOpinionHandlerTime +
        ", applicantPromiseDetail=" + applicantPromiseDetail +
        ", applicantPromiseHandler=" + applicantPromiseHandler +
        ", applicantPromistHandingTime=" + applicantPromistHandingTime +
        ", universityOpinionDetail=" + universityOpinionDetail +
        ", universityPostOpinionDetail=" + universityPostOpinionDetail +
        ", universityOpinionHandler=" + universityOpinionHandler +
        ", universityPostOpinionHandler=" + universityPostOpinionHandler +
        ", universityOpinionHandingTime=" + universityOpinionHandingTime +
        ", universityPostOpinionHandingTime=" + universityPostOpinionHandingTime +
        ", status=" + status +
        ", teamId=" + teamId +
        ", changeTime=" + changeTime +
        ", supportSum=" + supportSum +
        ", isEnable=" + isEnable +
        ", subjectCode=" + subjectCode +
        ", deadlineTime=" + deadlineTime +
        ", createTime=" + createTime +
        "}";
    }
}
