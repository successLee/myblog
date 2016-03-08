CREATE database IF NOT EXISTS `myblog` DEFAULT CHARACTER SET UTF8;
use `myblog`;

/* users 表 */
DROP TABLE IF EXISTS `users`;

CREATE TABLE users (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
	`username` varchar(50) DEFAULT NULL COMMENT '用户名',
	`sex` varchar(10) DEFAULT NULL COMMENT '性别',
	`password` varchar(64) DEFAULT NULL COMMENT '密码',
	`password_salt` varchar(64) DEFAULT NULL COMMENT 'password盐',
	`email` varchar(50) DEFAULT NULL COMMENT '邮箱',
	`registertime` datetime DEFAULT NULL COMMENT '注册时间',
	`lastlogintime` datetime DEFAULT NULL COMMENT '上次登录时间',
	`iconpath` varchar(64) DEFAULT NULL COMMENT '用户头像',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB charset=utf8 COMMENT='用户表';

insert into users(id, username, sex, password, password_salt, email, registertime, lastlogintime) values(1, 'admin', 'male', '123456', 'salt', '1318106568@qq.com', '2016-2-29 19:24:06', null);

/* article 表 */
DROP TABLE IF EXISTS `article`;

CREATE TABLE article (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
	`title` varchar(255) DEFAULT NULL COMMENT '文章标题',
	`content` longtext DEFAULT NULL COMMENT '文章内容',
	`posttime` datetime DEFAULT NULL COMMENT '发表时间',
	`author_id` bigint(20) unsigned NOT NULL COMMENT '作者id',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB charset=utf8 COMMENT='文章表';

alter table `article` add constraint FK_AUTHORID foreign key(author_id) references `users`(id);

insert into article(id, title, content, posttime, author_id) values(1, 'test', 'testcontent', '2016-2-29 19:52:02', 1);

/* reply 表 */
DROP TABLE IF EXISTS `reply`;

CREATE TABLE reply(
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '回复id',
	`content` longtext DEFAULT NULL COMMENT '回复内容',
	`replytime` datetime DEFAULT NULL COMMENT '回复时间',
	`article_id` bigint(20) unsigned NOT NULL COMMENT '所属文章id',
	`author_id` bigint(20) unsigned NOT NULL COMMENT '作者id',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB charset=utf8 COMMENT='回复表';

alter table reply add constraint FK_ARTICLE_ID foreign key (article_id) references `article` (id) on delete cascade;
alter table reply add constraint FK_AUTHOR_ID foreign key (author_id) references `users` (id);
insert into reply(id, content, replytime, article_id, author_id) values(1, '测试回复', '2016-2-29 19:57:18', 1, 1);