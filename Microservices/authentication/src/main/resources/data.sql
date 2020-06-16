INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');

INSERT INTO `services`.`admin_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('1', true, false, 'serbia', 'admin@admin.com', 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '381');

INSERT INTO `services`.`agent_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('2', true, false, 'serbia', 'damjanbanjac@gmail.com', 'damjan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '333');

INSERT INTO `services`.`user_authority` (`user_id`, `authority_id`) VALUES ('1', '2');
INSERT INTO `services`.`user_authority` (`user_id`, `authority_id`) VALUES ('2', '3');