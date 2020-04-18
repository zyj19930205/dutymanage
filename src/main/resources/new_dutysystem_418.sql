/*
 Navicat Premium Data Transfer

 Source Server         : 信息平台
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 120.53.29.69:3306
 Source Schema         : new_dutysystem

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 18/04/2020 17:55:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jxlt_duty_rule
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_duty_rule`;
CREATE TABLE `jxlt_duty_rule`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `typeLevel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '规则级别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_duty_rule
-- ----------------------------
INSERT INTO `jxlt_duty_rule` VALUES (1, '不值班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (2, '假日白班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (3, '周四晚班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (4, '周末白班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (5, '普通晚班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (6, '周六白班', '2', '2');
INSERT INTO `jxlt_duty_rule` VALUES (7, '周日白班', '2', '2');
INSERT INTO `jxlt_duty_rule` VALUES (8, '周六晚班', '2', '2');
INSERT INTO `jxlt_duty_rule` VALUES (9, '周日晚班', '2', '2');
INSERT INTO `jxlt_duty_rule` VALUES (10, '特殊值班', '1', '1');
INSERT INTO `jxlt_duty_rule` VALUES (11, '假日晚班', '1', '2');

-- ----------------------------
-- Table structure for jxlt_emp_dutyrule
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_emp_dutyrule`;
CREATE TABLE `jxlt_emp_dutyrule`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `dutyTypeId` int(0) NULL DEFAULT NULL COMMENT '值班类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 478 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_emp_dutyrule
-- ----------------------------
INSERT INTO `jxlt_emp_dutyrule` VALUES (232, 2, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (233, 2, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (234, 2, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (235, 2, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (236, 2, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (237, 2, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (238, 2, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (239, 2, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (240, 2, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (241, 3, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (242, 3, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (243, 3, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (244, 3, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (245, 3, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (246, 3, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (247, 3, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (248, 3, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (249, 3, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (250, 4, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (251, 4, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (252, 4, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (253, 5, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (254, 5, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (255, 5, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (256, 6, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (257, 6, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (258, 6, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (259, 7, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (260, 7, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (261, 7, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (262, 7, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (263, 7, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (264, 7, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (265, 7, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (266, 7, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (267, 7, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (271, 9, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (272, 9, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (273, 9, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (274, 9, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (275, 9, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (276, 9, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (277, 9, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (278, 9, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (279, 9, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (280, 10, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (281, 10, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (282, 10, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (283, 11, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (284, 11, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (285, 11, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (286, 12, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (287, 12, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (288, 12, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (289, 13, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (290, 13, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (291, 13, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (292, 13, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (293, 13, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (294, 13, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (295, 13, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (296, 13, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (297, 13, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (301, 15, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (302, 15, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (303, 15, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (304, 16, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (305, 16, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (306, 16, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (307, 17, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (308, 17, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (309, 17, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (310, 17, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (311, 17, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (312, 17, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (313, 17, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (314, 17, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (315, 17, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (316, 18, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (317, 18, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (318, 18, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (319, 18, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (320, 18, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (321, 18, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (322, 18, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (323, 18, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (324, 18, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (325, 19, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (326, 19, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (327, 19, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (328, 20, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (329, 20, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (330, 20, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (331, 21, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (332, 21, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (333, 21, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (334, 22, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (335, 22, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (336, 22, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (337, 22, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (338, 22, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (339, 22, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (340, 22, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (341, 22, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (342, 23, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (343, 23, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (344, 23, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (345, 23, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (346, 23, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (347, 23, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (348, 23, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (349, 23, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (350, 23, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (351, 24, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (352, 24, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (353, 24, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (354, 25, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (355, 25, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (356, 25, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (357, 25, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (358, 25, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (359, 25, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (360, 25, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (361, 25, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (362, 25, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (363, 26, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (364, 26, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (365, 26, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (375, 30, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (376, 30, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (377, 30, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (378, 31, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (379, 31, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (380, 31, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (381, 31, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (382, 31, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (383, 31, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (384, 31, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (385, 31, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (386, 32, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (387, 32, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (388, 32, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (389, 33, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (390, 33, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (391, 33, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (392, 33, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (393, 33, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (394, 33, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (395, 33, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (396, 33, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (397, 33, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (398, 34, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (399, 34, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (400, 34, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (401, 34, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (402, 34, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (403, 34, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (404, 34, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (405, 34, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (409, 36, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (410, 36, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (411, 36, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (412, 36, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (413, 36, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (414, 36, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (415, 36, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (416, 36, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (417, 36, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (418, 37, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (419, 37, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (420, 37, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (421, 38, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (422, 38, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (423, 38, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (424, 38, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (425, 38, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (426, 38, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (427, 38, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (428, 38, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (429, 38, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (430, 39, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (431, 39, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (432, 39, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (433, 39, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (434, 39, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (435, 39, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (436, 39, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (437, 39, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (438, 39, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (439, 40, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (440, 40, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (441, 40, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (442, 40, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (443, 41, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (444, 41, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (445, 41, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (446, 41, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (447, 41, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (448, 41, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (449, 41, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (450, 41, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (451, 42, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (452, 42, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (453, 42, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (454, 42, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (455, 43, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (456, 43, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (457, 43, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (458, 44, 10);
INSERT INTO `jxlt_emp_dutyrule` VALUES (459, 45, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (460, 45, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (461, 45, 3);
INSERT INTO `jxlt_emp_dutyrule` VALUES (462, 45, 4);
INSERT INTO `jxlt_emp_dutyrule` VALUES (463, 45, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (464, 45, 6);
INSERT INTO `jxlt_emp_dutyrule` VALUES (465, 45, 7);
INSERT INTO `jxlt_emp_dutyrule` VALUES (466, 45, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (467, 45, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (468, 47, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (469, 47, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (470, 47, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (471, 48, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (472, 48, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (473, 48, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (477, 8, 1);
INSERT INTO `jxlt_emp_dutyrule` VALUES (483, 27, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (484, 27, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (485, 27, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (486, 27, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (487, 27, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (488, 28, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (489, 28, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (490, 28, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (491, 28, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (492, 28, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (493, 1, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (494, 1, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (495, 1, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (496, 1, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (497, 1, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (498, 14, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (499, 14, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (500, 14, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (501, 14, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (502, 14, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (503, 29, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (504, 29, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (505, 29, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (506, 29, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (507, 29, 9);
INSERT INTO `jxlt_emp_dutyrule` VALUES (508, 35, 2);
INSERT INTO `jxlt_emp_dutyrule` VALUES (509, 35, 11);
INSERT INTO `jxlt_emp_dutyrule` VALUES (510, 35, 5);
INSERT INTO `jxlt_emp_dutyrule` VALUES (511, 35, 8);
INSERT INTO `jxlt_emp_dutyrule` VALUES (512, 35, 9);

-- ----------------------------
-- Table structure for jxlt_employee
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_employee`;
CREATE TABLE `jxlt_employee`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `special_rule` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否存在特殊规则，是:1,否:0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_employee
-- ----------------------------
INSERT INTO `jxlt_employee` VALUES (1, '陈浩', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (2, '陈杰', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (5, '邓志强', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (6, '冯小华', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (7, '何涛', '男', NULL, '', '0');
INSERT INTO `jxlt_employee` VALUES (8, '黄巍', '男', NULL, '营业账务组', '0');
INSERT INTO `jxlt_employee` VALUES (9, '黄小明', '男', NULL, '营业账务组', '0');
INSERT INTO `jxlt_employee` VALUES (10, '江波', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (11, '匡石磊', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (12, '刘璟峰', '男', NULL, '数据组', '0');
INSERT INTO `jxlt_employee` VALUES (13, '刘迅', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (14, '彭丹', '男', NULL, '营业账务组', '0');
INSERT INTO `jxlt_employee` VALUES (15, '汤健', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (16, '涂晨华', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (17, '涂远文', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (18, '万辉', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (19, '万星', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (20, '王冠', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (21, '王苏文', '男', NULL, '', '0');
INSERT INTO `jxlt_employee` VALUES (22, '吴樵', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (23, '杨星', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (24, '杨治兴', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (25, '尹晟浩', '男', NULL, '', '0');
INSERT INTO `jxlt_employee` VALUES (26, '余尚顺', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (27, '钟林', '男', NULL, '营业账务组', '0');
INSERT INTO `jxlt_employee` VALUES (28, '周恬', '男', NULL, '数据组', '0');
INSERT INTO `jxlt_employee` VALUES (29, '邹宇杰', '男', NULL, '营业账务组', '0');
INSERT INTO `jxlt_employee` VALUES (30, '陈彬', '男', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (31, '戴玉娟', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (32, '邓曼莉', '女', NULL, '不值周末班', '0');
INSERT INTO `jxlt_employee` VALUES (33, '黄素文', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (34, '李芳', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (35, '李悦', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (36, '卢超素', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (37, '齐卉芳', '女', NULL, '家庭原因不值周末班', '0');
INSERT INTO `jxlt_employee` VALUES (38, '邱晨', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (39, '饶盼利', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (40, '王莉莉', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (41, '魏奇明', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (42, '吴宝凤', '女', NULL, '身体原因不值晚班', '0');
INSERT INTO `jxlt_employee` VALUES (43, '吴莉佳', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (44, '吴琼', '女', NULL, '只值每月第一天或最后一天的班', '1');
INSERT INTO `jxlt_employee` VALUES (45, '颜顺凤', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (47, '张慧芬', '女', NULL, NULL, '0');
INSERT INTO `jxlt_employee` VALUES (48, '魏文海', '男', NULL, '数据组主管', '0');

-- ----------------------------
-- Table structure for jxlt_formal_duty_result
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_formal_duty_result`;
CREATE TABLE `jxlt_formal_duty_result`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `dutyDate` date NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dutyTypeId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 199 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_formal_duty_result
-- ----------------------------
INSERT INTO `jxlt_formal_duty_result` VALUES (1, 32, '2019-02-04', '邓曼莉', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (2, 18, '2019-02-04', '万辉', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (3, 19, '2019-02-05', '万星', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (4, 25, '2019-02-05', '尹晟浩', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (5, 4, '2019-02-06', '邓方红', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (6, 38, '2019-02-06', '邱晨', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (7, 36, '2019-02-07', '卢超素', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (8, 11, '2019-02-07', '匡石磊', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (9, 24, '2019-02-08', '杨治兴', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (10, 6, '2019-02-08', '冯小华', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (11, 33, '2019-02-09', '黄素文', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (12, 7, '2019-02-09', '何涛', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (13, 39, '2019-02-10', '饶盼利', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (14, 26, '2019-02-10', '余尚顺', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (15, 44, '2019-10-01', '吴琼', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (16, 23, '2019-10-01', '杨星', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (17, 31, '2019-10-02', '戴玉娟', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (18, 34, '2019-10-02', '李芳', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (19, 37, '2019-10-03', '齐卉芳', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (20, 45, '2019-10-03', '颜顺凤', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (21, 43, '2019-10-04', '吴莉佳', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (22, 48, '2019-10-04', '魏文海', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (23, 13, '2019-10-05', '刘迅', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (24, 12, '2019-10-05', '刘璟峰', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (25, 36, '2019-10-06', '卢超素', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (26, 2, '2019-10-06', '陈杰', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (27, 40, '2019-10-07', '王莉莉', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (28, 8, '2019-10-07', '黄巍', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (29, 38, '2020-02-01', '邱晨', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (30, 25, '2020-02-06', '尹晟浩', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (31, 7, '2020-02-13', '何涛', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (32, 18, '2020-02-20', '万辉', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (33, 9, '2020-02-27', '黄小明', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (34, 23, '2020-02-02', '杨星', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (35, 31, '2020-02-08', '戴玉娟', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (36, 34, '2020-02-09', '李芳', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (37, 45, '2020-02-15', '颜顺凤', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (38, 13, '2020-02-16', '刘迅', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (39, 2, '2020-02-22', '陈杰', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (40, 40, '2020-02-23', '王莉莉', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (41, 15, '2020-02-29', '汤健', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (42, 21, '2020-02-02', '王苏文', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (43, 39, '2020-02-03', '饶盼利', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (44, 19, '2020-02-04', '万星', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (45, 4, '2020-02-05', '邓方红', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (46, 37, '2020-02-07', '齐卉芳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (47, 24, '2020-02-08', '杨治兴', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (48, 6, '2020-02-09', '冯小华', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (49, 26, '2020-02-10', '余尚顺', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (50, 11, '2020-02-11', '匡石磊', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (51, 43, '2020-02-12', '吴莉佳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (52, 48, '2020-02-14', '魏文海', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (53, 12, '2020-02-15', '刘璟峰', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (54, 36, '2020-02-16', '卢超素', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (55, 47, '2020-02-17', '张慧芬', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (56, 1, '2020-02-18', '陈浩', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (57, 33, '2020-02-19', '黄素文', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (58, 32, '2020-02-21', '邓曼莉', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (59, 3, '2020-02-22', '陈敏', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (60, 10, '2020-02-23', '江波', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (61, 22, '2020-02-24', '吴樵', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (62, 5, '2020-02-25', '邓志强', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (63, 17, '2020-02-26', '涂远文', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (64, 14, '2020-02-28', '彭丹', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (65, 44, '2020-02-29', '吴琼', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (92, 10, '2020-01-24', '江波', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (93, 22, '2020-01-25', '吴樵', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (94, 5, '2020-01-26', '邓志强', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (95, 17, '2020-01-27', '涂远文', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (96, 14, '2020-01-28', '彭丹', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (97, 15, '2020-01-29', '汤健', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (98, 42, '2020-01-30', '吴宝凤', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (99, 20, '2020-01-01', '王冠', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (100, 32, '2020-01-24', '邓曼莉', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (101, 28, '2020-01-25', '周恬', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (102, 29, '2020-01-26', '邹宇杰', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (103, 30, '2020-01-27', '陈彬', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (104, 35, '2020-01-28', '李悦', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (105, 16, '2020-01-29', '涂晨华', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (106, 41, '2020-01-30', '魏奇明', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (107, 27, '2020-01-02', '钟林', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (108, 33, '2020-01-09', '黄素文', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (109, 39, '2020-01-16', '饶盼利', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (110, 2, '2020-01-23', '陈杰', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (111, 23, '2020-01-04', '杨星<白班>', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (112, 31, '2020-01-11', '戴玉娟<白班>', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (113, 34, '2020-01-18', '李芳<白班>', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (114, 45, '2020-01-05', '颜顺凤<白班>', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (115, 13, '2020-01-12', '刘迅<白班>', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (116, 40, '2020-01-03', '王莉莉', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (117, 9, '2020-01-04', '黄小明<晚班>', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (118, 11, '2020-01-05', '匡石磊<晚班>', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (119, 4, '2020-01-06', '邓方红', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (120, 19, '2020-01-07', '万星', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (121, 24, '2020-01-08', '杨治兴', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (122, 37, '2020-01-10', '齐卉芳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (123, 26, '2020-01-11', '余尚顺<晚班>', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (124, 6, '2020-01-12', '冯小华<晚班>', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (125, 43, '2020-01-13', '吴莉佳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (126, 48, '2020-01-14', '魏文海', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (127, 12, '2020-01-15', '刘璟峰', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (128, 8, '2020-01-17', '黄巍', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (129, 38, '2020-01-18', '邱晨<晚班>', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (130, 36, '2020-01-19', '卢超素', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (131, 47, '2020-01-20', '张慧芬', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (132, 1, '2020-01-21', '陈浩', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (133, 33, '2020-01-22', '黄素文', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (134, 44, '2020-01-31', '吴琼', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (135, 3, '2020-01-01', '陈敏<白班>', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (136, 44, '2020-04-01', '吴琼', 10);
INSERT INTO `jxlt_formal_duty_result` VALUES (137, 21, '2020-04-04', '王苏文', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (138, 25, '2020-04-05', '尹晟浩', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (139, 7, '2020-04-06', '何涛', 2);
INSERT INTO `jxlt_formal_duty_result` VALUES (140, 18, '2020-04-04', '万辉', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (141, 9, '2020-04-05', '黄小明', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (142, 23, '2020-04-06', '杨星', 11);
INSERT INTO `jxlt_formal_duty_result` VALUES (143, 45, '2020-04-02', '颜顺凤', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (144, 13, '2020-04-09', '刘迅', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (145, 2, '2020-04-16', '陈杰', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (146, 38, '2020-04-23', '邱晨', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (147, 36, '2020-04-30', '卢超素', 3);
INSERT INTO `jxlt_formal_duty_result` VALUES (148, 31, '2020-04-11', '戴玉娟', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (149, 34, '2020-04-12', '李芳', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (150, 40, '2020-04-18', '王莉莉', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (151, 33, '2020-04-19', '黄素文', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (152, 39, '2020-04-25', '饶盼利', 4);
INSERT INTO `jxlt_formal_duty_result` VALUES (153, 32, '2020-04-03', '邓曼莉', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (154, 19, '2020-04-07', '万星', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (155, 11, '2020-04-08', '匡石磊', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (156, 24, '2020-04-10', '杨治兴', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (157, 6, '2020-04-11', '冯小华', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (158, 26, '2020-04-12', '余尚顺', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (159, 37, '2020-04-13', '齐卉芳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (160, 43, '2020-04-14', '吴莉佳', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (161, 48, '2020-04-15', '魏文海', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (162, 12, '2020-04-17', '刘璟峰', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (163, 47, '2020-04-18', '张慧芬', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (164, 1, '2020-04-19', '陈浩', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (165, 10, '2020-04-20', '江波', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (166, 22, '2020-04-21', '吴樵', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (167, 5, '2020-04-22', '邓志强', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (168, 17, '2020-04-24', '涂远文', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (169, 14, '2020-04-25', '彭丹', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (170, 15, '2020-04-26', '汤健', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (171, 16, '2020-04-27', '涂晨华', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (172, 20, '2020-04-28', '王冠', 5);
INSERT INTO `jxlt_formal_duty_result` VALUES (173, 27, '2020-04-29', '钟林', 5);

-- ----------------------------
-- Table structure for jxlt_formal_emp_queue
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_formal_emp_queue`;
CREATE TABLE `jxlt_formal_emp_queue`  (
  `rowId` int(0) NOT NULL AUTO_INCREMENT COMMENT '相当于队列的索引',
  `empId` int(0) NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`rowId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9599 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_formal_emp_queue
-- ----------------------------
INSERT INTO `jxlt_formal_emp_queue` VALUES (6, 44, '吴琼');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9549, 28, '周恬');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9550, 29, '邹宇杰');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9551, 30, '陈彬');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9559, 35, '李悦');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9560, 45, '颜顺凤');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9561, 13, '刘迅');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9562, 2, '陈杰');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9563, 42, '吴宝凤');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9564, 40, '王莉莉');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9565, 41, '魏奇明');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9566, 38, '邱晨');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9567, 32, '邓曼莉');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9568, 19, '万星');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9569, 11, '匡石磊');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9570, 24, '杨治兴');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9571, 6, '冯小华');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9572, 26, '余尚顺');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9573, 37, '齐卉芳');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9574, 43, '吴莉佳');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9575, 48, '魏文海');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9576, 12, '刘璟峰');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9577, 47, '张慧芬');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9578, 1, '陈浩');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9579, 10, '江波');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9580, 5, '邓志强');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9581, 14, '彭丹');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9582, 15, '汤健');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9583, 16, '涂晨华');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9584, 20, '王冠');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9585, 27, '钟林');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9586, 33, '黄素文');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9587, 39, '饶盼利');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9588, 17, '涂远文');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9589, 36, '卢超素');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9590, 31, '戴玉娟');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9591, 34, '李芳');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9592, 22, '吴樵');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9593, 21, '王苏文');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9594, 18, '万辉');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9595, 25, '尹晟浩');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9596, 9, '黄小明');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9597, 7, '何涛');
INSERT INTO `jxlt_formal_emp_queue` VALUES (9598, 23, '杨星');

-- ----------------------------
-- Table structure for jxlt_holiday_rule
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_holiday_rule`;
CREATE TABLE `jxlt_holiday_rule`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `holidayType` int(0) NULL DEFAULT NULL,
  `holidayRemark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_holiday_rule
-- ----------------------------
INSERT INTO `jxlt_holiday_rule` VALUES (1, 1, '春节');
INSERT INTO `jxlt_holiday_rule` VALUES (2, 2, '中秋');
INSERT INTO `jxlt_holiday_rule` VALUES (3, 3, '端午');
INSERT INTO `jxlt_holiday_rule` VALUES (4, 4, '清明');
INSERT INTO `jxlt_holiday_rule` VALUES (5, 5, '国庆');
INSERT INTO `jxlt_holiday_rule` VALUES (6, 6, '劳动节');
INSERT INTO `jxlt_holiday_rule` VALUES (7, 7, '调休');
INSERT INTO `jxlt_holiday_rule` VALUES (8, 8, '元旦');

-- ----------------------------
-- Table structure for jxlt_holidays
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_holidays`;
CREATE TABLE `jxlt_holidays`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `holidayName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `holidayDate` date NULL DEFAULT NULL,
  `HolidayType` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_holidays
-- ----------------------------
INSERT INTO `jxlt_holidays` VALUES (1, '元旦', '2020-01-01', '8');
INSERT INTO `jxlt_holidays` VALUES (2, '除夕', '2020-01-24', '1');
INSERT INTO `jxlt_holidays` VALUES (3, '春节', '2020-01-25', '1');
INSERT INTO `jxlt_holidays` VALUES (4, '春节', '2020-01-26', '1');
INSERT INTO `jxlt_holidays` VALUES (5, '春节', '2020-01-27', '1');
INSERT INTO `jxlt_holidays` VALUES (6, '春节', '2020-01-28', '1');
INSERT INTO `jxlt_holidays` VALUES (7, '春节', '2020-01-29', '1');
INSERT INTO `jxlt_holidays` VALUES (8, '春节', '2020-01-30', '1');
INSERT INTO `jxlt_holidays` VALUES (9, '清明', '2020-04-04', '4');
INSERT INTO `jxlt_holidays` VALUES (10, '清明', '2020-04-05', '4');
INSERT INTO `jxlt_holidays` VALUES (11, '清明', '2020-04-06', '4');
INSERT INTO `jxlt_holidays` VALUES (12, '劳动节', '2020-05-01', '6');
INSERT INTO `jxlt_holidays` VALUES (13, '劳动节', '2020-05-02', '6');
INSERT INTO `jxlt_holidays` VALUES (14, '劳动节', '2020-05-03', '6');
INSERT INTO `jxlt_holidays` VALUES (15, '劳动节', '2020-05-04', '6');
INSERT INTO `jxlt_holidays` VALUES (16, '劳动节', '2020-05-05', '6');
INSERT INTO `jxlt_holidays` VALUES (17, '端午节', '2020-06-25', '3');
INSERT INTO `jxlt_holidays` VALUES (18, '端午节', '2020-06-26', '3');
INSERT INTO `jxlt_holidays` VALUES (19, '端午节', '2020-06-27', '3');
INSERT INTO `jxlt_holidays` VALUES (20, '国庆节', '2020-10-01', '5');
INSERT INTO `jxlt_holidays` VALUES (21, '国庆节', '2020-10-02', '5');
INSERT INTO `jxlt_holidays` VALUES (22, '国庆节', '2020-10-03', '5');
INSERT INTO `jxlt_holidays` VALUES (23, '国庆节', '2020-10-04', '5');
INSERT INTO `jxlt_holidays` VALUES (24, '国庆节', '2020-10-05', '5');
INSERT INTO `jxlt_holidays` VALUES (25, '国庆节', '2020-10-06', '5');
INSERT INTO `jxlt_holidays` VALUES (26, '国庆节', '2020-10-07', '5');
INSERT INTO `jxlt_holidays` VALUES (27, '调休', '2020-01-19', '7');
INSERT INTO `jxlt_holidays` VALUES (28, '调休', '2020-02-01', '7');
INSERT INTO `jxlt_holidays` VALUES (29, '调休', '2020-04-26', '7');
INSERT INTO `jxlt_holidays` VALUES (30, '调休', '2020-05-09', '7');
INSERT INTO `jxlt_holidays` VALUES (31, '调休', '2020-06-28', '7');
INSERT INTO `jxlt_holidays` VALUES (32, '调休', '2020-09-27', '7');
INSERT INTO `jxlt_holidays` VALUES (33, '调休', '2020-10-10', '7');

-- ----------------------------
-- Table structure for jxlt_special_duty
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_special_duty`;
CREATE TABLE `jxlt_special_duty`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `special_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `special_duty_day` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `special_duty_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_special_duty
-- ----------------------------
INSERT INTO `jxlt_special_duty` VALUES (1, 44, '只值月初或月末的班', '1,29,30,31', '0');

-- ----------------------------
-- Table structure for jxlt_temp_duty_result
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_temp_duty_result`;
CREATE TABLE `jxlt_temp_duty_result`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `dutyDate` date NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dutyTypeId` int(0) NULL DEFAULT NULL COMMENT '标记这一天属于什么类型的值班',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3439 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_temp_duty_result
-- ----------------------------
INSERT INTO `jxlt_temp_duty_result` VALUES (4144, 44, '2020-05-31', '吴琼', 10);
INSERT INTO `jxlt_temp_duty_result` VALUES (4145, 45, '2020-05-01', '颜顺凤', 2);
INSERT INTO `jxlt_temp_duty_result` VALUES (4146, 13, '2020-05-02', '刘迅', 2);
INSERT INTO `jxlt_temp_duty_result` VALUES (4147, 2, '2020-05-03', '陈杰', 2);
INSERT INTO `jxlt_temp_duty_result` VALUES (4148, 40, '2020-05-04', '王莉莉', 2);
INSERT INTO `jxlt_temp_duty_result` VALUES (4149, 38, '2020-05-05', '邱晨', 2);
INSERT INTO `jxlt_temp_duty_result` VALUES (4150, 19, '2020-05-01', '万星', 11);
INSERT INTO `jxlt_temp_duty_result` VALUES (4151, 11, '2020-05-02', '匡石磊', 11);
INSERT INTO `jxlt_temp_duty_result` VALUES (4152, 24, '2020-05-03', '杨治兴', 11);
INSERT INTO `jxlt_temp_duty_result` VALUES (4153, 6, '2020-05-04', '冯小华', 11);
INSERT INTO `jxlt_temp_duty_result` VALUES (4154, 26, '2020-05-05', '余尚顺', 11);
INSERT INTO `jxlt_temp_duty_result` VALUES (4155, 33, '2020-05-07', '黄素文', 3);
INSERT INTO `jxlt_temp_duty_result` VALUES (4156, 39, '2020-05-14', '饶盼利', 3);
INSERT INTO `jxlt_temp_duty_result` VALUES (4157, 17, '2020-05-21', '涂远文', 3);
INSERT INTO `jxlt_temp_duty_result` VALUES (4158, 36, '2020-05-28', '卢超素', 3);
INSERT INTO `jxlt_temp_duty_result` VALUES (4159, 42, '2020-05-10', '吴宝凤', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4160, 41, '2020-05-16', '魏奇明', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4161, 31, '2020-05-17', '戴玉娟', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4162, 34, '2020-05-23', '李芳', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4163, 22, '2020-05-24', '吴樵', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4164, 18, '2020-05-30', '万辉', 4);
INSERT INTO `jxlt_temp_duty_result` VALUES (4165, 28, '2020-05-06', '周恬', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4166, 29, '2020-05-08', '邹宇杰', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4167, 30, '2020-05-09', '陈彬', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4168, 35, '2020-05-10', '李悦', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4169, 32, '2020-05-11', '邓曼莉', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4170, 37, '2020-05-12', '齐卉芳', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4171, 43, '2020-05-13', '吴莉佳', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4172, 48, '2020-05-15', '魏文海', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4173, 12, '2020-05-16', '刘璟峰', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4174, 47, '2020-05-17', '张慧芬', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4175, 1, '2020-05-18', '陈浩', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4176, 10, '2020-05-19', '江波', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4177, 5, '2020-05-20', '邓志强', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4178, 14, '2020-05-22', '彭丹', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4179, 15, '2020-05-23', '汤健', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4180, 16, '2020-05-24', '涂晨华', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4181, 20, '2020-05-25', '王冠', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4182, 27, '2020-05-26', '钟林', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4183, 21, '2020-05-27', '王苏文', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4184, 25, '2020-05-29', '尹晟浩', 5);
INSERT INTO `jxlt_temp_duty_result` VALUES (4185, 9, '2020-05-30', '黄小明', 5);

-- ----------------------------
-- Table structure for jxlt_temp_duty_result_copy1
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_temp_duty_result_copy1`;
CREATE TABLE `jxlt_temp_duty_result_copy1`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `dutyDate` datetime(0) NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dutyTypeId` int(0) NULL DEFAULT NULL COMMENT '标记这一天属于什么类型的值班',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 222 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_temp_duty_result_copy1
-- ----------------------------
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (177, 10, '2020-01-24 00:00:00', '江波<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (178, 22, '2020-01-25 00:00:00', '吴樵<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (179, 5, '2020-01-26 00:00:00', '邓志强<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (180, 17, '2020-01-27 00:00:00', '涂远文<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (181, 14, '2020-01-28 00:00:00', '彭丹<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (182, 15, '2020-01-29 00:00:00', '汤健<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (183, 42, '2020-01-30 00:00:00', '吴宝凤<白班>', 2);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (184, 20, '2020-01-01 00:00:00', '王冠<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (185, 32, '2020-01-24 00:00:00', '邓曼莉<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (186, 28, '2020-01-25 00:00:00', '周恬<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (187, 29, '2020-01-26 00:00:00', '邹宇杰<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (188, 30, '2020-01-27 00:00:00', '陈彬<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (189, 35, '2020-01-28 00:00:00', '李悦<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (190, 16, '2020-01-29 00:00:00', '涂晨华<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (191, 41, '2020-01-30 00:00:00', '魏奇明<晚班>', 11);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (192, 27, '2020-01-02 00:00:00', '钟林', 3);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (193, 33, '2020-01-09 00:00:00', '黄素文', 3);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (194, 39, '2020-01-16 00:00:00', '饶盼利', 3);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (195, 2, '2020-01-23 00:00:00', '陈杰', 3);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (196, 23, '2020-01-04 00:00:00', '杨星<白班>', 4);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (197, 31, '2020-01-11 00:00:00', '戴玉娟<白班>', 4);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (198, 34, '2020-01-18 00:00:00', '李芳<白班>', 4);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (199, 45, '2020-01-05 00:00:00', '颜顺凤<白班>', 4);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (200, 13, '2020-01-12 00:00:00', '刘迅<白班>', 4);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (201, 40, '2020-01-03 00:00:00', '王莉莉', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (202, 9, '2020-01-04 00:00:00', '黄小明<晚班>', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (203, 11, '2020-01-05 00:00:00', '匡石磊<晚班>', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (204, 4, '2020-01-06 00:00:00', '邓方红', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (205, 19, '2020-01-07 00:00:00', '万星', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (206, 24, '2020-01-08 00:00:00', '杨治兴', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (207, 37, '2020-01-10 00:00:00', '齐卉芳', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (208, 26, '2020-01-11 00:00:00', '余尚顺<晚班>', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (209, 6, '2020-01-12 00:00:00', '冯小华<晚班>', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (210, 43, '2020-01-13 00:00:00', '吴莉佳', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (211, 48, '2020-01-14 00:00:00', '魏文海', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (212, 12, '2020-01-15 00:00:00', '刘璟峰', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (213, 8, '2020-01-17 00:00:00', '黄巍', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (214, 38, '2020-01-18 00:00:00', '邱晨<晚班>', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (215, 36, '2020-01-19 00:00:00', '卢超素', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (216, 47, '2020-01-20 00:00:00', '张慧芬', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (217, 1, '2020-01-21 00:00:00', '陈浩', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (218, 33, '2020-01-22 00:00:00', '黄素文', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (219, 44, '2020-01-31 00:00:00', '吴琼', 5);
INSERT INTO `jxlt_temp_duty_result_copy1` VALUES (221, 3, '2020-01-01 00:00:00', '陈敏<白班>', 2);

-- ----------------------------
-- Table structure for jxlt_temp_emp_queue
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_temp_emp_queue`;
CREATE TABLE `jxlt_temp_emp_queue`  (
  `rowId` int(0) NOT NULL AUTO_INCREMENT COMMENT '相当于队列的索引',
  `empId` int(0) NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`rowId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11029 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_temp_emp_queue
-- ----------------------------
INSERT INTO `jxlt_temp_emp_queue` VALUES (6, 44, '吴琼');
INSERT INTO `jxlt_temp_emp_queue` VALUES (9597, 7, '何涛');
INSERT INTO `jxlt_temp_emp_queue` VALUES (9598, 23, '杨星');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13123, 33, '黄素文');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13124, 39, '饶盼利');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13125, 17, '涂远文');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13126, 36, '卢超素');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13127, 42, '吴宝凤');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13128, 41, '魏奇明');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13129, 31, '戴玉娟');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13130, 34, '李芳');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13131, 22, '吴樵');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13132, 18, '万辉');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13133, 28, '周恬');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13134, 29, '邹宇杰');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13135, 30, '陈彬');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13136, 35, '李悦');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13137, 32, '邓曼莉');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13138, 37, '齐卉芳');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13139, 43, '吴莉佳');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13140, 48, '魏文海');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13141, 12, '刘璟峰');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13142, 47, '张慧芬');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13143, 1, '陈浩');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13144, 10, '江波');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13145, 5, '邓志强');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13146, 14, '彭丹');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13147, 15, '汤健');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13148, 16, '涂晨华');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13149, 20, '王冠');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13150, 27, '钟林');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13151, 21, '王苏文');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13152, 25, '尹晟浩');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13153, 9, '黄小明');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13154, 45, '颜顺凤');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13155, 13, '刘迅');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13156, 2, '陈杰');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13157, 40, '王莉莉');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13158, 38, '邱晨');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13159, 19, '万星');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13160, 11, '匡石磊');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13161, 24, '杨治兴');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13162, 6, '冯小华');
INSERT INTO `jxlt_temp_emp_queue` VALUES (13163, 26, '余尚顺');

-- ----------------------------
-- Table structure for jxlt_temp_emp_queue_copy1_copy1
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_temp_emp_queue_copy1_copy1`;
CREATE TABLE `jxlt_temp_emp_queue_copy1_copy1`  (
  `rowId` int(0) NOT NULL AUTO_INCREMENT COMMENT '相当于队列的索引',
  `empId` int(0) NULL DEFAULT NULL,
  `empName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`rowId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_temp_emp_queue_copy1_copy1
-- ----------------------------
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (1, 21, '王苏文');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (2, 25, '尹晟浩');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (3, 7, '何涛');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (4, 18, '万辉');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (5, 9, '黄小明');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (6, 44, '吴琼');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (7, 23, '杨星');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (8, 31, '戴玉娟');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (9, 34, '李芳');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (10, 45, '颜顺凤');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (11, 13, '刘迅');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (12, 2, '陈杰');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (13, 40, '王莉莉');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (14, 32, '邓曼莉');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (15, 19, '万星');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (16, 4, '邓方红');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (17, 11, '匡石磊');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (18, 24, '杨治兴');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (19, 6, '冯小华');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (20, 26, '余尚顺');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (21, 37, '齐卉芳');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (22, 43, '吴莉佳');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (23, 48, '魏文海');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (24, 12, '刘璟峰');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (25, 8, '黄巍');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (26, 38, '邱晨');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (27, 36, '卢超素');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (28, 47, '张慧芬');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (29, 1, '陈浩');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (30, 33, '黄素文');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (31, 39, '饶盼利');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (32, 3, '陈敏');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (33, 10, '江波');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (34, 22, '吴樵');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (35, 5, '邓志强');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (36, 17, '涂远文');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (37, 14, '彭丹');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (38, 15, '汤健');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (39, 16, '涂晨华');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (40, 20, '王冠');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (41, 27, '钟林');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (42, 28, '周恬');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (43, 29, '邹宇杰');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (44, 30, '陈彬');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (45, 35, '李悦');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (46, 41, '魏奇明');
INSERT INTO `jxlt_temp_emp_queue_copy1_copy1` VALUES (47, 42, '吴宝凤');

-- ----------------------------
-- Table structure for jxlt_user
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_user`;
CREATE TABLE `jxlt_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `empId` int(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_user
-- ----------------------------
INSERT INTO `jxlt_user` VALUES (1, 29, 'admin', 'zouyj19', '2');
INSERT INTO `jxlt_user` VALUES (2, 32, 'dml', 'dml', '2');
INSERT INTO `jxlt_user` VALUES (3, 1, 'ch', 'ch1998', '1');

-- ----------------------------
-- Table structure for jxlt_user_type
-- ----------------------------
DROP TABLE IF EXISTS `jxlt_user_type`;
CREATE TABLE `jxlt_user_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `usertype_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of jxlt_user_type
-- ----------------------------
INSERT INTO `jxlt_user_type` VALUES (1, '普通用户');
INSERT INTO `jxlt_user_type` VALUES (2, '管理员');

SET FOREIGN_KEY_CHECKS = 1;
