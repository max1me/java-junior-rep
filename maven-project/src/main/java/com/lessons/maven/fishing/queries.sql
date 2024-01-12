--для каждого катера вывести даты выхода в море с указанием улова
select t1.name as "Название",
       t1.type as "Тип",
	   t1.manufactured_date as "Дата постройки",
	   t2.out_date as "Дата выхода",
	   t3.fish_type as "Сорт рыбы",
	   t3.mass as "Улов"
from tb_ships t1
inner join tb_sails t2 on t1.id = t2.ship_id
left join tb_catches t3 on t3.sail_id = t2.id
order by t2.out_date asc, t1.name asc, t3.mass desc;
--для каждого катера вывести количество рейсов
select t1.name as "Название",
       t1.type as "Тип",
	   t1.manufactured_date as "Дата постройки",
	   count(t2.id) as "Количество рейсов"
from tb_ships t1
inner join tb_sails t2 on t1.id = t2.ship_id
group by t1.name, t1.type, t1.manufactured_date;
--вывести список катеров, которые получили улов выше заданного значения
select t1.name as "Название",
       t1.type as "Тип",
	   t1.manufactured_date as "Дата постройки",
	   sum(t3.mass) as "Улов"
from tb_ships t1
inner join tb_sails t2 on t1.id = t2.ship_id
left join tb_catches t3 on t3.sail_id = t2.id
group by t1.name, t1.type, t1.manufactured_date
having sum(t3.mass) > 50000;
--вывести список сортов рыбы и для каждого сорта список рейсов с указанием даты выхода и возвращения, количества улова
select t1.fish_type as "Сорт рыбы", t2.id as "ID рейса",
       t2.out_date as "Дата выхода",
	   t2.in_date as "Дата возвращения",
	   t1.mass as "Улов"
from tb_catches t1
inner join tb_sails t2 on t2.id = t1.sail_id
order by t1.fish_type asc;