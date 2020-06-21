INSERT INTO `services`.`agent_order` (`id`) VALUES ('1');

INSERT INTO `services`.`agent_order` (`id`) VALUES ('2');

INSERT INTO `services`.`user_order` (`id`) VALUES ('1');

INSERT INTO `services`.`user_order` (`id`) VALUES ('2');

INSERT INTO `services`.`user_order` (`id`) VALUES ('3');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('1','1','2');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('2','1','1');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('3','1','1');

INSERT INTO `services`.`ad_car_order` (`id`,`agent_izdao_ad_id`,`user_izdavao_ad_id`) VALUES ('4','2','3');

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('4','10/10/2019','15/05/2020','1','1','2','1');

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('5','11/10/2019','05/05/2020','2','1','1','1');

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('3','10/10/2019','15/05/2020','1','1','2','2');

INSERT INTO `services`.`orders` (`id`,`available_from`,`available_to`,`ad_car_id`,`agent_izdao_id`,`user_izdavao_id`,`userr_id`) VALUES ('6','10/10/2019','15/05/2020','4','2','3','2');

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('3','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'RESERVED');

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('4','2020-6-19 12:10:59','2020-6-20 08:10:59',false,'PENDING');

INSERT INTO `services`.`requests` (`id`,`payment_date`,`accept_date`,`bundle`,`status`) VALUES ('5','2020-6-21 08:10:59','2020-6-21 08:10:59',false,'PENDING');

INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('3','3');

INSERT INTO `services`.`requests_order_list` (`request_id`,`order_list_id`) VALUES ('5','6');