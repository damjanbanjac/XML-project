INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('4', 'USER-SELLER');

INSERT INTO `services`.`admin_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('100', true, false, 'serbia', 'admin@gmail.com', 'damjan', '$2a$10$mzFkdgfA8T.UiOJLXLIe7.tcEgaoUyXDpDuBlsAZQrqQoDRyMw6Ae', false, '333');

INSERT INTO `services`.`agent_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('200', true, false, 'serbia', 'damjanbanjac@gmail.com', 'damjan', '$2a$10$mzFkdgfA8T.UiOJLXLIe7.tcEgaoUyXDpDuBlsAZQrqQoDRyMw6Ae', false, '333');

INSERT INTO `services`.`user_authority`(`user_id`,`authority_id`) VALUES ('100', '2');

INSERT INTO `services`.`user_authority`(`user_id`,`authority_id`) VALUES ('200', '3');

INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('1', 'CREATE-AD');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('2', 'UPADATE-AD');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('3', 'DELETE-AD');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('4', 'UN/BLOCK-USER');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('5', 'DE/ACTIVATE-USER');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('6', 'APPROVE/DENY-COMMENT');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('7', 'APPROVE/DENY-REGISTRATION');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('8', 'CRUD-CAR-COMPONENTS');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('9', 'POST-COMMENT');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('10', 'POST-GRADE');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('11', 'CRUD-IMAGE');
INSERT INTO `services`.`permission` (`id`, `name`) VALUES ('12', 'CREATE-REPORT');

INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '4');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '5');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '6');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '7');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('3', '8');

INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '1');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '2');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '3');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '8');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '9');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '10');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '11');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('2', '12');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '9');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('1', '10');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '1');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '2');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '8');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '9');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '10');
INSERT INTO `services`.`authorities_permissions` (`authority_id`, `permission_id`) VALUES ('4', '11');

