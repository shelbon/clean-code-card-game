insert into CARD_PACK (CARD_COUNT, NAME, TOKEN_COST) values (3,'Pack Argent',1);
insert into CARD_PACK (CARD_COUNT, NAME, TOKEN_COST) values (5,'Pack diament',2);
insert into RARITY (NAME) values ('COMMON');
insert into RARITY (NAME) values ('RARE');
insert into RARITY (NAME) values ('LEGENDARY');
insert into CARD_PACK_RATES (RARITY_ID, RATE, CARD_PACK_ID)values (1,0.75,1),(2,0.20,1),(3,0.05,1);
insert into CARD_PACK_RATES (RARITY_ID, RATE, CARD_PACK_ID) values (1,0.50,2), (2,0.35,2),(3,0.15,2);