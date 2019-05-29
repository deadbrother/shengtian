SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `icon` int(11) NOT NULL COMMENT '品牌logo图关联的dataid',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态码:0正常;1暂存;2删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `sort` int(2) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMPRESSION = 'ZLIB' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for customer_comment
-- ----------------------------
DROP TABLE IF EXISTS `customer_comment`;
CREATE TABLE `customer_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '推荐信标题',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '提交日期',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态码:0正常;1暂存;2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for customer_comment_content
-- ----------------------------
DROP TABLE IF EXISTS `customer_comment_content`;
CREATE TABLE `customer_comment_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '关联客户主表id',
  `content` int(11) NOT NULL COMMENT '图片格式客户推荐信内容关联的dataid',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for long_data
-- ----------------------------
DROP TABLE IF EXISTS `long_data`;
CREATE TABLE `long_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` longblob NULL COMMENT '二级制内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for news_type
-- ----------------------------
DROP TABLE IF EXISTS `news_type`;
CREATE TABLE `news_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '新闻分类名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态码:0正常;1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for service_detail
-- ----------------------------
DROP TABLE IF EXISTS `service_detail`;
CREATE TABLE `service_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '富文本详情内容',
  `service_type_id` int(11) NOT NULL COMMENT '关联serviceId',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for service_type
-- ----------------------------
DROP TABLE IF EXISTS `service_type`;
CREATE TABLE `service_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT ' 分类名称',
  `sort` int(2) NULL DEFAULT NULL COMMENT '排序',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态码:0正常,1删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for success_case
-- ----------------------------
DROP TABLE IF EXISTS `success_case`;
CREATE TABLE `success_case`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `customer_logo` int(11) NULL DEFAULT NULL COMMENT '客户log图片关联的dataid',
  `case_pic` int(11) NULL DEFAULT NULL COMMENT '案例照片关联的dataid',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '所属行业',
  `case_desc` varchar(2048) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '案例描述',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态字段:0,已发布；1暂存；2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for success_detail
-- ----------------------------
DROP TABLE IF EXISTS `success_detail`;
CREATE TABLE `success_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '富文本内容',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `success_case_id` int(11) NOT NULL COMMENT '关联成功案例id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;