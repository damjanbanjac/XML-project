INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');

INSERT INTO `services`.`admin_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('1', b'true', b'false', b'serbia', b'admin@admin.com', b'admin', b'123', b'false', b'381');

INSERT INTO `services`.`agent_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('1', b'true', b'false', b'serbia', b'damjanbanjac@gmail.com', b'damjan', b'123', b'false', b'333');
