begin;
insert into orders values(?,?,?);
update parts_stock set quantity = quantity - ?
where part_id = ?;
commit;