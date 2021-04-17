insert into wish_list DEFAULT VALUES;
insert into wish_list DEFAULT VALUES;

insert into Profile (name) values ('ROLE_USER');
insert into Profile (name) values ('ROLE_ADMIN');


--password is "password"
insert into User (user_Name, email, password, wish_list_id ) values ('user1', 'user1@email.com', '$2a$10$0lrsEbGppk0850neERuRW.uFiFrvcLrknEL72hVlVPdheEqN7Swvm', 1);
insert into User (user_Name, email, password, wish_list_id) values ('user2', 'user2@email.com', '$2a$10$0lrsEbGppk0850neERuRW.uFiFrvcLrknEL72hVlVPdheEqN7Swvm', 2);

insert into User_Role (user_id, role_id) values (1, 1);
insert into User_Role (user_id, role_id) values (2, 2);

insert into Item (name, price, sale, discount, rating) values ('Small Monitor', '150.00', true, .10, 1);
insert into Item (name, price, sale, rating) values ('Medium Monitor', '200.00', false, 2);
insert into Item (name, price, sale, discount, rating) values ('Large Monitor', '300.00', true, .20, 5);
insert into Item (name, price, sale, discount, rating) values ('Office chair', '300.00', '0.50', true, 4);
insert into Item (name, price, sale, rating) values ('Gaming chair', '5000.00', false, 3);
insert into Item (name, price, sale, rating) values ('Mouse', '50.00', false, 2);

insert into Category(name) values('Electronic');
insert into Category(name) values ('Furniture');
insert into Category(name) values ('Gaming');

insert into Item_Category (Item_List_Id, Category_Id) values (1, 1);
insert into Item_Category (Item_List_Id, Category_Id) values (2, 1);
insert into Item_Category (Item_List_Id, Category_Id) values (3, 1);
insert into Item_Category (Item_List_Id, Category_Id) values (4, 2);
insert into Item_Category (Item_List_Id, Category_Id) values (5, 2);
insert into Item_Category (Item_List_Id, Category_Id) values (6, 1);
insert into Item_Category (Item_List_Id, Category_Id) values (3, 3);
insert into Item_Category (Item_List_Id, Category_Id) values (5, 3);
insert into Item_Category (Item_List_Id, Category_Id) values (6, 3);

insert into Wish_List_item_list (wish_list_id, item_list_id) values (1 ,3);
insert into Wish_List_item_list (wish_list_id, item_list_id) values (1 ,6);

insert into Placed_Order(user_id, date) values(1,'2020-11-20');

insert into Placed_Order_Item (order_id, item_id) values (1, 5);