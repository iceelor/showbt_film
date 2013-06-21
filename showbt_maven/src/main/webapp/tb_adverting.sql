/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2013-06-21 15:36:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_adverting`
-- ----------------------------
DROP TABLE IF EXISTS `tb_adverting`;
CREATE TABLE `tb_adverting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adCode` varchar(2000) DEFAULT NULL,
  `addTime` datetime DEFAULT NULL,
  `height` int(11) NOT NULL,
  `source` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `width` int(11) NOT NULL,
  `adKey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_adverting
-- ----------------------------
INSERT INTO `tb_adverting` VALUES ('1', '123123', '2013-06-21 12:23:55', '123', '123', '首页顶部广告', '23', 'index_top_img');
INSERT INTO `tb_adverting` VALUES ('2', 'sasd', '2013-06-21 14:36:41', '60', 'abc', '首页中部电影列表下广告', '600', 'index_movie_bottom_img');
INSERT INTO `tb_adverting` VALUES ('3', '<div><script type=\"text/javascript\"></div><div> u_a_client=\"16082\";</div><div> u_a_width=\"760\";</div><div> u_a_height=\"90\";</div><div> u_a_zones=\"42050\";</div><div> u_a_type=\"0\"</div><div></script></div><div><script src=\"http://code.ynlssc.com/i.js\"></script></div>', '2013-06-21 14:39:48', '60', '222', '首页中部视频列表下广告', '600', 'index_video_bottom_img');
INSERT INTO `tb_adverting` VALUES ('4', '<script type=\"text/javascript\">\r\n u_a_client=\"16082\";\r\n u_a_width=\"760\";\r\n u_a_height=\"90\";\r\n u_a_zones=\"42050\";\r\n u_a_type=\"0\"\r\n</script>\r\n<script src=\"http://code.ynlssc.com/i.js\"></script>', '2013-06-21 14:53:41', '60', '333', '首页右侧电影列表下广告', '600', 'index_movie_right_img');
INSERT INTO `tb_adverting` VALUES ('5', '<script type=\"text/javascript\">\r\n u_a_client=\"16082\";\r\n u_a_width=\"760\";\r\n u_a_height=\"90\";\r\n u_a_zones=\"42050\";\r\n u_a_type=\"0\"\r\n</script>\r\n<script src=\"http://code.ynlssc.com/i.js\"></script>', '2013-06-21 14:54:13', '60', 'wer', '首页右侧视频列表下广告', '600', 'index_video_right_img');
INSERT INTO `tb_adverting` VALUES ('6', '<script type=\"text/javascript\">\r\n u_a_client=\"16082\";\r\n u_a_width=\"120\";\r\n u_a_height=\"240\";\r\n u_a_zones=\"41731\";\r\n u_a_type=\"1\"\r\n</script>\r\n<script src=\"http://code.ynlssc.com/i.js\"></script>', '2013-06-21 15:03:52', '60', '55', '首页中部电影剧列表下广告', '600', 'index_tv_bottom_img');
