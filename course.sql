/*
Navicat MySQL Data Transfer

Source Server         : 192.168.171.132-my
Source Server Version : 50644
Source Host           : 192.168.171.132:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-09-17 17:50:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addusercase
-- ----------------------------
DROP TABLE IF EXISTS `addusercase`;
CREATE TABLE `addusercase` (
  `id` bigint(255) DEFAULT NULL,
  `userName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `age` smallint(3) DEFAULT NULL,
  `permission` tinyint(1) DEFAULT NULL,
  `isDelete` tinyint(255) unsigned zerofill DEFAULT NULL,
  `expected` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of addusercase
-- ----------------------------
INSERT INTO `addusercase` VALUES ('5', 'zhang1', '123456', '0', '35', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', 'true');

-- ----------------------------
-- Table structure for getuserinfocase
-- ----------------------------
DROP TABLE IF EXISTS `getuserinfocase`;
CREATE TABLE `getuserinfocase` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of getuserinfocase
-- ----------------------------
INSERT INTO `getuserinfocase` VALUES ('1', '1', 'getUserInfo');
INSERT INTO `getuserinfocase` VALUES ('2', '2', 'getUserInfo');

-- ----------------------------
-- Table structure for getuserlistcase
-- ----------------------------
DROP TABLE IF EXISTS `getuserlistcase`;
CREATE TABLE `getuserlistcase` (
  `id` int(11) DEFAULT NULL,
  `userName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `expected` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of getuserlistcase
-- ----------------------------
INSERT INTO `getuserlistcase` VALUES ('1', null, null, '0', 'getUserList');
INSERT INTO `getuserlistcase` VALUES ('2', 'zhang', null, null, 'getUserList');

-- ----------------------------
-- Table structure for logincase
-- ----------------------------
DROP TABLE IF EXISTS `logincase`;
CREATE TABLE `logincase` (
  `id` int(11) DEFAULT NULL,
  `userName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `expected` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of logincase
-- ----------------------------
INSERT INTO `logincase` VALUES ('1', 'zhangsan', '123456', 'true');
INSERT INTO `logincase` VALUES ('2', 'zhangsan', '12345', 'false');

-- ----------------------------
-- Table structure for updateusercase
-- ----------------------------
DROP TABLE IF EXISTS `updateusercase`;
CREATE TABLE `updateusercase` (
  `id` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `expected` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of updateusercase
-- ----------------------------
INSERT INTO `updateusercase` VALUES ('1', '2', 'lisihah', null, null, null, null, 'getUpdateUserInfo');
INSERT INTO `updateusercase` VALUES ('2', '5', null, null, null, null, '1', 'getUpdateUserInfo');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL,
  `userName` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `age` smallint(3) DEFAULT NULL,
  `permission` tinyint(1) DEFAULT NULL,
  `isDelete` tinyint(255) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '1', '23', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');
INSERT INTO `user` VALUES ('2', 'lisi', '123456', '0', '34', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');
INSERT INTO `user` VALUES ('3', 'huanger', '123456', '1', '40', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');
INSERT INTO `user` VALUES ('4', 'zhaoliu', '123456', '0', '32', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `age` tinyint(1) DEFAULT NULL,
  `sex` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user1
-- ----------------------------
INSERT INTO `user1` VALUES ('1', 'zhangsan', '23', '男');
INSERT INTO `user1` VALUES ('2', 'lisi', '34', '女');
INSERT INTO `user1` VALUES ('3', 'huanger', '40', '女');
INSERT INTO `user1` VALUES ('4', 'zhaoliu', '32', '女');
