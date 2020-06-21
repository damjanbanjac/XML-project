INSERT INTO `agentxml`.`agent` (`id`, `address`, `name`, `pib`) VALUES ('1', 'janka', 'damjan', '123A');


INSERT INTO `agentxml`.`car_brand` (`id`,`deleted`, `name`) VALUES ('100',false,'mercedes');

INSERT INTO `agentxml`.`car_class` (`id`,`deleted`, `car_class`) VALUES ('1',false,'A');

INSERT INTO `agentxml`.`car_model` (`id`,`deleted`, `model`) VALUES ('1',false,'amg');

INSERT INTO `agentxml`.`type_of_fuel` (`id`,`deleted`, `type`) VALUES ('1',false,'dizel');

INSERT INTO `agentxml`.`type_of_gearshift` (`id`,`deleted`, `type`) VALUES ('1',false,'manuel');

INSERT INTO `agentxml`.`ad_car` (`id`, `available_from`, `available_to`, `cdw`, `city`, `grade`, `kids_seats`, `km_restriction`, `km_traveled`, `agent_ad_id`, `car_brand_id_id`, `car_class_id_id`, `car_model_id_id`, `fuel_type_car_id_id`, `gear_shift_car_id_id`) VALUES ('100', '2020-6-19 12:10:59', '2020-6-24 12:10:59', true, 'novi sad', '0', '2', '3000', '1000', '1', '100', '1', '1', '1', '1');

INSERT INTO `agentxml`.`users` (`id`, `active`, `blocked`, `email`) VALUES ('1', true, false, 'lala');

INSERT INTO `agentxml`.`order_ad` (`id`, `deleted`, `state`, `using_time_up`, `ad_car`, `user_id`) VALUES ('1', false, 'PAID', true, '100', '1');


INSERT INTO `agentxml`.`order_ad` (`id`, `deleted`, `state`, `using_time_up`, `ad_car`, `user_id`) VALUES ('2', false, 'PAID', true, '100', '1');

INSERT INTO `agentxml`.`order_ad` (`id`, `deleted`, `state`, `using_time_up`, `ad_car`, `user_id`) VALUES ('3', false, 'PAID', true, '100', '1');

