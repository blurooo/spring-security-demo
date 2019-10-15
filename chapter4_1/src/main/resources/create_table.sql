CREATE TABLE `springDemo`.`users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户是否可用',
  `roles` text CHARACTER SET utf8 COMMENT '用户角色，多个角色之间用逗号隔开',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
)

insert into `springDemo`.`users`(`username`, `password`, `roles`) values("admin", "123", "ROLE_ADMIN,ROLE_USER");
insert into `springDemo`.`users`(`username`, `password`, `roles`) values("user", "123", "ROLE_USER");