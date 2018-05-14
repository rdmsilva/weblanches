insert into ingrediente (id, nome, valor) values (1, 'Alface', 0.40);
insert into ingrediente (id, nome, valor) values (2, 'Bacon', 2.00);
insert into ingrediente (id, nome, valor) values (3, 'Hambúrguer de carne', 3.00);
insert into ingrediente (id, nome, valor) values (4, 'Ovo', 0.80);
insert into ingrediente (id, nome, valor) values (5, 'Queijo', 1.50);

insert into lanche (id, nome, valor) values (1, 'X-Bacon', 6.50);
insert into lanche (id, nome, valor) values (2, 'X-Burguer', 4.50);
insert into lanche (id, nome, valor) values (3, 'X-Egg', 5.3);
insert into lanche (id, nome, valor) values (4, 'X-Egg Bacon', 7.3);

insert into lanche_ingrediente (lanche_id, ingrediente_id) values (1, 2);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (1, 3);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (1, 5);

insert into lanche_ingrediente (lanche_id, ingrediente_id) values (2, 3);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (2, 5);

insert into lanche_ingrediente (lanche_id, ingrediente_id) values (3, 3);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (3, 4);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (3, 5);

insert into lanche_ingrediente (lanche_id, ingrediente_id) values (4, 2);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (4, 3);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (4, 4);
insert into lanche_ingrediente (lanche_id, ingrediente_id) values (4, 5);