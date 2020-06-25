--INSERT INTO `agentxml`.`agent` (`id`, `address`, `name`, `pib`) VALUES ('1', 'janka', 'damjan', '123A');

INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('1', 'CREATE-AD');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('2', 'UPADATE-AD');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('3', 'CHECK');

INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('2', 'AGENT');
INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('3', 'ADMIN');

INSERT INTO `agentxml`.`admin_app` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`, `rate`, `surname`, `town`) VALUES ('100', false, false, 'srb', 'admin@gmail.com', 'Admin', '$2a$10$mzFkdgfA8T.UiOJLXLIe7.tcEgaoUyXDpDuBlsAZQrqQoDRyMw6Ae', false, '0658545544', '5', 'Admin', 'Novi Sad');
INSERT INTO `agentxml`.`user_authority`(`user_simple_id`,`authority_id`) VALUES ('100', '3');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '1');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '2');
--INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
--INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');

INSERT INTO `agentxml`.`car_brand` (`id`,`deleted`, `name`) VALUES ('100',false,'mercedes');

INSERT INTO `agentxml`.`car_class` (`id`,`deleted`, `car_class`) VALUES ('1',false,'A');

INSERT INTO `agentxml`.`car_model` (`id`,`deleted`, `model`) VALUES ('1',false,'amg');

INSERT INTO `agentxml`.`type_of_fuel` (`id`,`deleted`, `type`) VALUES ('1',false,'dizel');

INSERT INTO `agentxml`.`type_of_gearshift` (`id`,`deleted`, `type`) VALUES ('1',false,'manuel');


--INSERT INTO `agentxml`.`users` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`, `rate`, `surname`, `town`) VALUES ('2', false, false, 'srb', 'user@gmail.com', 'Admin', '123', false, '0658545544', '5', 'Admin', 'Novi Sad');
--INSERT INTO `agentxml`.`user_authority`(`user_simple_id`,`authority_id`) VALUES ('1', '2')


