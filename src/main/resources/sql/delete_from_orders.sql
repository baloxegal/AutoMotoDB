begin;
update parts_stock set quantity = quantity + ?
where part_id = ?;
delete from orders
where part_id = ?;
commit;