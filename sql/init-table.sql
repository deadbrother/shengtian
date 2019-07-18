SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` int(11) NULL DEFAULT NULL COMMENT '文章类型',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '富文本内容',
  `headline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `cover` int(11) NULL DEFAULT NULL COMMENT '图片关联大字段数据id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` date NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据更新时间',
  `editor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编辑名字',
  `source_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源来源',
  `media_type_id` int(11) NULL DEFAULT NULL COMMENT '关联媒体类型id',
  `plat_form_id` int(11) NULL DEFAULT NULL COMMENT '关联平台id',
  `question_type_id` int(11) NULL DEFAULT NULL COMMENT '关联问题类型id',
  `review_info_type_id` int(11) NULL DEFAULT NULL COMMENT '关联审查资料类型id',
  `service_type_id` int(11) NULL DEFAULT NULL COMMENT '关联服务类型id',
  `source_type_id` int(11) NULL DEFAULT NULL COMMENT '关联资源类型id',
  `news_classification_id` int(11) NULL DEFAULT NULL COMMENT '关联新闻类型id',
  `industry_category_id` int(11) NULL DEFAULT NULL COMMENT '关联产业类型id',
  `ad_year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '自定义年份',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态:0正常1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for industry_category
-- ----------------------------
DROP TABLE IF EXISTS `industry_category`;
CREATE TABLE `industry_category`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行业类型名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for long_data
-- ----------------------------
DROP TABLE IF EXISTS `long_data`;
CREATE TABLE `long_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` longblob NULL COMMENT '二级制内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for media_type
-- ----------------------------
DROP TABLE IF EXISTS `media_type`;
CREATE TABLE `media_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` int(11) NULL DEFAULT NULL COMMENT '0:有效;1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for news_classification
-- ----------------------------
DROP TABLE IF EXISTS `news_classification`;
CREATE TABLE `news_classification`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资讯分类名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for plat_form
-- ----------------------------
DROP TABLE IF EXISTS `plat_form`;
CREATE TABLE `plat_form`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '频道/平台名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `media_type_id` int(11) NULL DEFAULT NULL COMMENT '对应媒体类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '问题分类名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for review_info_type
-- ----------------------------
DROP TABLE IF EXISTS `review_info_type`;
CREATE TABLE `review_info_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核资料类型名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `question_type_id` int(11) NULL DEFAULT NULL COMMENT '关联问题类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for service_type
-- ----------------------------
DROP TABLE IF EXISTS `service_type`;
CREATE TABLE `service_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务分类名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for source_type
-- ----------------------------
DROP TABLE IF EXISTS `source_type`;
CREATE TABLE `source_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` int(11) NULL DEFAULT NULL COMMENT '0:有效;1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

