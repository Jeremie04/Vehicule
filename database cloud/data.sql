insert into marque(idmarque,nomMarque) values
(default,'Hyundai');

insert into categorie values
(default,'sport');

insert into modele values 
(default,'MAR1','CAT1', 'modele');
insert into TypeCarburant values
(default,'essence');

insert into sousModele values
(default, 'MOD1',400,100,'TYCAR1',false,250,200,default, true, 'SportHund');

insert into annonce values
(default,'UTI1','SMOD1','grenat',2000000,1900000,'2024-02-25',3),
(default,'UTI1','SMOD1','vert',3000000,2900000,'2024-02-25',5),
(default,'UTI3','SMOD1','bleu',5000000,4900000,'2024-02-25',5),
(default,'UTI4','SMOD1','rouge',10200000,1000000,'2024-02-25',5),
(default,'UTI5','SMOD1','noir',2000000,1900000,'2024-02-25',5),
(default,'UTI2','SMOD1','noir',1500000,1400000,'2024-02-25',5);


-- insert into vente values 
-- (default,'2024-01-26','UTI1','ANN2','UTI2',2000000),
-- (default,'2023-12-26','UTI1','ANN2','UTI2',100000),
-- (default,'2023-08-05','UTI1','ANN8','UTI2',345000),
-- (default,'2023-09-12','UTI1','ANN8','UTI2',300000),
-- (default,'2023-10-12','UTI2','ANN8','UTI1',10000),
-- (default,'2024-01-03','UTI2','ANN8','UTI1',345000);

insert into interet values(default,1,'2023-05-11');