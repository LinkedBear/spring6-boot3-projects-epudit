DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
    `pid` int(11) DEFAULT NULL COMMENT '上级部门id',
    `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除字段',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;