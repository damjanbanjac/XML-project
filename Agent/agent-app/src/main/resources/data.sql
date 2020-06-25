--INSERT INTO `agentxml`.`agent` (`id`, `address`, `name`, `pib`) VALUES ('1', 'janka', 'damjan', '123A');

INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('1', 'CREATE-AD');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('2', 'UPADATE-AD');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('3', 'DELETE-AD');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('4', 'UN/BLOCK-USER');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('5', 'DE/ACTIVATE-USER');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('6', 'APPROVE/DENY-COMMENT');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('7', 'APPROVE/DENY-REGISTRATION');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('8', 'CRUD-CAR-COMPONENTS');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('9', 'POST-COMMENT');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('10', 'POST-GRADE');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('11', 'CRUD-IMAGE');
INSERT INTO `agentxml`.`permission` (`id`, `name`) VALUES ('12', 'CREATE-REPORT');

INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('2', 'AGENT');
INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('3', 'USER');
INSERT INTO `agentxml`.`authority` (`id`, `name`) VALUES ('4', 'USER-SELLER');


INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '4');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '5');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '6');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '7');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '8');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '1');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '2');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '3');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '8');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '9');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '10');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '11');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '12');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '9');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '10');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '1');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '2');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '8');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '9');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '10');
INSERT INTO `agentxml`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '11');

--INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
--INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');

INSERT INTO `agentxml`.`car_brand` (`id`,`deleted`, `name`) VALUES ('100',false,'mercedes');

INSERT INTO `agentxml`.`car_class` (`id`,`deleted`, `car_class`) VALUES ('1',false,'A');

INSERT INTO `agentxml`.`car_model` (`id`,`deleted`, `model`) VALUES ('1',false,'amg');

INSERT INTO `agentxml`.`type_of_fuel` (`id`,`deleted`, `type`) VALUES ('1',false,'dizel');

INSERT INTO `agentxml`.`type_of_gearshift` (`id`,`deleted`, `type`) VALUES ('1',false,'manuel');

--INSERT INTO `agentxml`.`agent` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`, `rate`, `surname`, `town`, `pib`) VALUES ('1', false, false, 'srb', 'agent@gmail.com', 'Admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '0658545544', '5', 'Admin', 'Novi Sad', '12');
--INSERT INTO `agentxml`.`users` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`, `rate`, `surname`, `town`) VALUES ('2', false, false, 'srb', 'user@gmail.com', 'Admin', '123', false, '0658545544', '5', 'Admin', 'Novi Sad');
--INSERT INTO `agentxml`.`user_authority`(`user_simple_id`,`authority_id`) VALUES ('1', '2')


