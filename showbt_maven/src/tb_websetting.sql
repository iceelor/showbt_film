/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2013-07-08 17:05:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_websetting`
-- ----------------------------
DROP TABLE IF EXISTS `tb_websetting`;
CREATE TABLE `tb_websetting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sKey` varchar(50) DEFAULT NULL,
  `sValue` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5oc05grd69q2sn01qoxet0q89` (`sKey`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_websetting
-- ----------------------------
INSERT INTO `tb_websetting` VALUES ('1', 'websetting_copyright', '<p>本站资源均为网络免费资源搜索机器人自动搜索的结果，本站只提供最新电影下载，并不存放任何资源。</p>\r\n		<p>所有视频版权归原权利人，将于24小时内删除！我们强烈建议所有影视爱好者购买正版音像制品！</p>\r\n		<p>本站拒绝一切非法，淫秽电影，欢迎大家监督 有问题可联系管理员:\r\n		<a class=\"link-feedback\" target=\"_blank\" href=\"http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=Nl9VU1NaWUR2R0cYVVlb\" style=\"text-decoration:none;\"><img src=\"http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_01.png\"/></a>\r\n		</p>');
INSERT INTO `tb_websetting` VALUES ('2', 'websetting_title', '秀种资源网23213');
INSERT INTO `tb_websetting` VALUES ('3', 'websetting_movie_keywords', '电影下载,最新电影,电影天堂,电影网,高清电影下载,电影网站,showbt.com');
INSERT INTO `tb_websetting` VALUES ('4', 'websetting_movie_description', '秀种电影网－最新电影,秀种资源网－每天搜集最新免费电影下载。用户可使用迅雷软件快速下载最新的免费电影、小电影、高清电影等服务。还可以在线收看从各大视频网站搜集到的最新搞笑视频');
INSERT INTO `tb_websetting` VALUES ('5', 'websetting_video_keywords', '电影下载,最新电影,电影天堂,电影网,高清电影下载,电影网站,showbt.com');
INSERT INTO `tb_websetting` VALUES ('6', 'websetting_video_description', '秀种电影网－可以在线收看从各大视频网站搜集到的最新搞笑视频');
INSERT INTO `tb_websetting` VALUES ('7', 'websetting_template_default_path', 'skin/default/');
INSERT INTO `tb_websetting` VALUES ('8', 'websetting_url', 'http://www.showbt.com');
INSERT INTO `tb_websetting` VALUES ('9', 'websetting_html_head', null);
