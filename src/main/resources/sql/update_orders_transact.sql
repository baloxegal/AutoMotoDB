begin;
update orders set quantity = quantity + ?
where part_id = ?;
update parts_stock set quantity = quantity - ?
where part_id = ?;
commit;