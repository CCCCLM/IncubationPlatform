/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : incubation_platform

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2019-06-30 19:53:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(32) NOT NULL,
  `name` varchar(12) DEFAULT NULL COMMENT '负责人名字',
  `password` varchar(20) DEFAULT NULL COMMENT '登录密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `belong_colleage` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role` varchar(32) DEFAULT NULL,
  `is_enable` tinyint(4) DEFAULT NULL COMMENT '该账号是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '董志康', '123', '123', '1', '2019-02-27 16:58:25', null, null);

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` int(11) NOT NULL,
  `winner_id` int(11) DEFAULT NULL COMMENT '获奖者',
  `award_name` varchar(255) DEFAULT NULL,
  `issued_unit` varchar(255) DEFAULT NULL COMMENT '颁发单位',
  `issued_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of award
-- ----------------------------

-- ----------------------------
-- Table structure for colleage
-- ----------------------------
DROP TABLE IF EXISTS `colleage`;
CREATE TABLE `colleage` (
  `id` varchar(32) NOT NULL,
  `name` varchar(40) DEFAULT NULL COMMENT '二级学院名字',
  `pid` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of colleage
-- ----------------------------
INSERT INTO `colleage` VALUES ('1', '广州商学院', '0');
INSERT INTO `colleage` VALUES ('2', '信息技术与工程学院', '1');
INSERT INTO `colleage` VALUES ('3', '金融学院', '1');
INSERT INTO `colleage` VALUES ('4', '电子商务学院', '1');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` varchar(32) NOT NULL,
  `original_name` varchar(255) DEFAULT NULL COMMENT '原文件名',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `classification` varchar(255) DEFAULT NULL COMMENT '文件功能分类',
  `url` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `belong_id` varchar(32) DEFAULT NULL COMMENT '所属者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '链接名',
  `img` varchar(255) DEFAULT NULL COMMENT '链接图标',
  `url` varchar(255) DEFAULT NULL COMMENT '链接路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES ('1', '中国知网', null, 'http://cnki.net/');
INSERT INTO `link` VALUES ('2', '广州商学院官网', null, 'http://www.gzcc.cn/');

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `start_time` datetime DEFAULT NULL COMMENT '报名开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '报名截至时间',
  `verify_time` datetime DEFAULT NULL COMMENT '二级学院审核最终时间',
  `finish_time` datetime DEFAULT NULL COMMENT '结项时间',
  `is_enable` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES ('8888', '第四届创新创业大赛', '这是第四届创新创业大赛', '2018-11-28 01:46:23', '2018-11-28 01:46:26', '2018-11-28 01:46:28', '2018-11-28 01:46:30', '1', '2018-11-28 01:46:34');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `source` varchar(255) DEFAULT NULL COMMENT '来源',
  `classification` varchar(255) DEFAULT NULL COMMENT '分类',
  `title_image` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0表示存在，1表示删除',
  `author_id` varchar(32) DEFAULT NULL COMMENT '作者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('123', '关于举办第十一届全国大学生创新创业年会的通知2', '这是通知正文内容', '创客空间', '通知公告', null, null, '1', '2018-11-26 20:46:38');
INSERT INTO `message` VALUES ('124', '第十一届全国大学生创新创业年会入选项目提交和参会须知', '这是通知<br>正文内容', '创客空间', '通知公告', '', null, '1', '2019-03-14 20:46:38');
INSERT INTO `message` VALUES ('125', '我校召开副院长（副主任）工作会议', '通报了期末考试进展情况，对教务处工作进行了总结。', '广州商学院', '新闻动态', null, null, '2', '2019-03-14 19:36:35');
INSERT INTO `message` VALUES ('127', '加盟干洗店投资多少钱', '洗衣机可以说是一个伟大的发明，它为我们节约了很多的时间和精力，给我们的生活带来了不少的便利。然而很多人发现，想羊毛衣这样的衣服不能。。。', '快马商机网', '创业学习园地', null, null, '4', '2019-03-14 19:54:16');
INSERT INTO `message` VALUES ('128', '第十一届全国大学生创新创业年会入选项目提交和参会须知', '这是通知<br>正文内容', '创客空间', '通知公告', '', null, '1', '2019-03-14 20:46:38');

-- ----------------------------
-- Table structure for message_video
-- ----------------------------
DROP TABLE IF EXISTS `message_video`;
CREATE TABLE `message_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `vedio_url` varchar(255) DEFAULT NULL COMMENT '视频链接',
  `title_image` varchar(255) DEFAULT NULL COMMENT '标题图片',
  `source` varchar(255) DEFAULT NULL COMMENT '来源',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` tinyint(4) DEFAULT NULL COMMENT '0表示存在，1表示删除',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_video
-- ----------------------------
INSERT INTO `message_video` VALUES ('126', '印象创业——创业中国年会震撼演绎', '', '', '腾讯视频', '', null, '2019-03-14 20:09:36');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(32) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `receiver_id` varchar(32) DEFAULT NULL COMMENT '被通知者id',
  `result` varchar(255) DEFAULT NULL COMMENT '结果',
  `informer_id` varchar(32) DEFAULT NULL COMMENT '通知者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `classification` tinyint(4) DEFAULT NULL,
  `deline_time` datetime DEFAULT NULL COMMENT '通知失效时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(32) NOT NULL,
  `match_id` varchar(32) DEFAULT NULL COMMENT '赛事Id',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名字',
  `classification` varchar(255) DEFAULT NULL COMMENT '项目分类',
  `grade` varchar(255) DEFAULT NULL COMMENT '项目等级',
  `introduce` text COMMENT '项目简介',
  `background` text COMMENT '项目背景',
  `advantage` text COMMENT '项目优势',
  `market_analysis` text COMMENT '项目市场分析',
  `technical_factor` text COMMENT '项目技术因素',
  `business_model` text COMMENT '商业模式',
  `financial_analysis` text COMMENT '财务分析',
  `risk_and_constraint` text COMMENT '风险预测及制约因素',
  `planning_and_vision` text COMMENT '发展规划与创业愿景',
  `fund_and_budget` text COMMENT '项目立项经费使用预算',
  `expected_result` text COMMENT '项目预期成果',
  `college_opinion_detail` varchar(32) DEFAULT NULL COMMENT '学院立项意见详情',
  `college_post_opinion_detail` varchar(32) DEFAULT NULL COMMENT '学院结项意见详情',
  `college_opinion_handler` varchar(255) DEFAULT NULL COMMENT '学院立项意见处理人',
  `college_post_opinion_handler` varchar(255) DEFAULT NULL COMMENT '学院结项意见处理人',
  `college_opinion_handler_time` datetime DEFAULT NULL COMMENT '学院立项意见签名时间',
  `college_post_opinion_handler_time` datetime DEFAULT NULL COMMENT '学院结项意见签名时间',
  `applicant_promise_detail` varchar(32) DEFAULT NULL COMMENT '申请人承诺详情',
  `applicant_promise_handler` varchar(32) DEFAULT NULL COMMENT '申请人承诺处理者',
  `applicant_promist_handing_time` datetime DEFAULT NULL COMMENT '申请人承诺处理时间',
  `university_opinion_detail` varchar(32) DEFAULT NULL COMMENT '学校立项意见详情',
  `university_post_opinion_detail` varchar(32) DEFAULT NULL COMMENT '学校结项意见详情',
  `university_opinion_handler` varchar(255) DEFAULT NULL COMMENT '学校立项意见处理者',
  `university_post_opinion_handler` varchar(255) DEFAULT NULL COMMENT '学校结项意见处理者',
  `university_opinion_handing_time` datetime DEFAULT NULL COMMENT '学校立项意见处理时间',
  `university_post_opinion_handing_time` datetime DEFAULT NULL COMMENT '学校结项意见处理时间',
  `status` varchar(255) DEFAULT NULL COMMENT '审核状态',
  `team_id` varchar(32) DEFAULT NULL COMMENT '团队id',
  `change_time` datetime DEFAULT NULL COMMENT '状态修改时间',
  `support_sum` int(255) DEFAULT NULL COMMENT '资助金额',
  `is_enable` tinyint(4) DEFAULT NULL COMMENT '是否已并无法修改',
  `subject_code` varchar(255) DEFAULT NULL COMMENT '学科代码',
  `deadline_time` datetime DEFAULT NULL COMMENT '结项时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('5555', '8888', '创序软件工作室', '创业实践', '国家级', '这是一个工作室', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '已立项', null, '2018-11-28 01:44:59', '20000', '1', null, null, '2018-11-28 01:44:54');

-- ----------------------------
-- Table structure for project_status_record
-- ----------------------------
DROP TABLE IF EXISTS `project_status_record`;
CREATE TABLE `project_status_record` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_status_record
-- ----------------------------

-- ----------------------------
-- Table structure for project_techer
-- ----------------------------
DROP TABLE IF EXISTS `project_techer`;
CREATE TABLE `project_techer` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL COMMENT '项目id',
  `teacher_id` varchar(32) DEFAULT NULL COMMENT '教师ID号',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_techer
-- ----------------------------
INSERT INTO `project_techer` VALUES ('777', '5555', '321', null);
INSERT INTO `project_techer` VALUES ('778', '5555', '322', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色iD',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('4385b1de49b7566dbc8a1f828985c60a', 'teacher', null);
INSERT INTO `role` VALUES ('554356f0764a528f9b00187c9fd53725', 'student', null);
INSERT INTO `role` VALUES ('89e48c0d0c455c128e388432e851ab34', 'vice_admin', null);
INSERT INTO `role` VALUES ('f40baec93d615bd2a68c9432bb33b8d9', 'admin', null);

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(255) NOT NULL COMMENT '分类的id',
  `classification` varchar(255) DEFAULT NULL COMMENT '分类类别',
  `order_num` int(11) DEFAULT NULL COMMENT '顺序 1-10 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(32) NOT NULL COMMENT '标识符',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `student_id` varchar(255) DEFAULT NULL COMMENT '学号',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `belong_university` varchar(255) DEFAULT NULL COMMENT '所属学校',
  `belong_college` varchar(255) DEFAULT NULL COMMENT '所属学院',
  `grade` varchar(255) DEFAULT NULL COMMENT '年级',
  `specialty` varchar(255) DEFAULT NULL COMMENT '专业',
  `qq` int(255) DEFAULT NULL COMMENT 'qq',
  `clazz` varchar(255) NOT NULL COMMENT '班级',
  `is_main` int(11) DEFAULT '0' COMMENT '是否负责人',
  `role_id` varchar(32) DEFAULT NULL COMMENT '权限角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_enable` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studentId` (`student_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('123', '黄泳棋', '123456', '201606110065', '17827417363', '1427600836@qq.com', '广州商学院', '信息技术与工程学院', '2016', '软件工程', null, '1', '1', '554356f0764a528f9b00187c9fd53725', '2018-11-28 01:34:37', null);
INSERT INTO `student` VALUES ('1234', '郭木凯', '123456', '201606110066', '17827417363', '1427600836@qq.com', '广州商学院', '信息技术与工程学院', '2016', '软件工程', null, '1', '0', '554356f0764a528f9b00187c9fd53725', '2018-11-28 01:35:14', null);
INSERT INTO `student` VALUES ('12345', '黄宏娜', '123456', '201606110067', '17827417363', '1427600836@qq.com', '广州商学院', '信息技术与工程学院', '2016', '软件工程', null, '2', '0', '554356f0764a528f9b00187c9fd53725', '2018-11-28 01:36:47', null);
INSERT INTO `student` VALUES ('123456', '廖超凡', '123456', '201606110068', '17827417363', '1427600836@qq.com', '广州商学院', '信息技术与工程学院', '2016', '软件工程', null, '1', '0', '554356f0764a528f9b00187c9fd53725', '2018-11-28 01:36:54', null);
INSERT INTO `student` VALUES ('1234567', '陈力铭', '123456', '201606110069', '17827417363', '1427600836@qq.com', '广州商学院', '信息技术与工程学院', '2016', '软件工程', null, '1', '0', '554356f0764a528f9b00187c9fd53725', '2018-11-28 01:39:02', null);

-- ----------------------------
-- Table structure for student_project
-- ----------------------------
DROP TABLE IF EXISTS `student_project`;
CREATE TABLE `student_project` (
  `id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '学生id',
  `product_id` varchar(32) DEFAULT NULL COMMENT '项目id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_project
-- ----------------------------
INSERT INTO `student_project` VALUES ('1', '123', '5555', '2019-03-14 20:00:09');
INSERT INTO `student_project` VALUES ('2', '1234', '5555', '2019-03-14 20:00:40');
INSERT INTO `student_project` VALUES ('3', '12345', '5555', '2019-03-14 20:00:52');
INSERT INTO `student_project` VALUES ('4', '123456', '5555', '2019-03-14 20:01:04');
INSERT INTO `student_project` VALUES ('5', '1234567', '5555', '2019-03-14 20:01:15');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(32) NOT NULL COMMENT '自动生成的ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `belong_college` varchar(255) DEFAULT NULL COMMENT '所属学院',
  `post` varchar(255) DEFAULT NULL COMMENT '职务',
  `degree` varchar(255) DEFAULT NULL COMMENT '学位',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('321', '何文海', '12345679801', '信息技术与工程学院', '讲师', '学士', '2018-11-28 01:40:36');
INSERT INTO `teacher` VALUES ('322', '董志康', '12345679801', '信息技术与工程学院', '讲师', '学士', '2018-11-28 01:41:12');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` varchar(32) NOT NULL,
  `team_name` varchar(255) DEFAULT NULL COMMENT '团队名字',
  `content` text COMMENT '团队简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', 'number', '这是一支充满活力的团队 ', '2018-11-28 01:48:41');
