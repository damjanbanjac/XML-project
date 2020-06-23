INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('2', 'ADMIN');
INSERT INTO `services`.`authority` (`id`, `name`) VALUES ('3', 'AGENT');

INSERT INTO `services`.`admin_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('1', true, false, 'serbia', '$2a$10$mzFkdgfA8T.UiOJLXLIe7.tcEgaoUyXDpDuBlsAZQrqQoDRyMw6Ae', 'admin', '123', false, '381');

INSERT INTO `services`.`agent_auth` (`id`, `active`, `blocked`, `country`, `email`, `name`, `password`, `permission_blocked`, `phone_number`) VALUES ('1', true, false, 'serbia', 'damjanbanjac@gmail.com', 'damjan', '$2a$10$mzFkdgfA8T.UiOJLXLIe7.tcEgaoUyXDpDuBlsAZQrqQoDRyMw6Ae', false, '333');
