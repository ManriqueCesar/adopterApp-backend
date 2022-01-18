insert into Document_Type values (1,"DNI");
insert into Document_Type values (2,"CE");

insert into Adopter_Severity values (1,"BUENO");
insert into Adopter_Severity values (2,"REGULAR");
insert into Adopter_Severity values (3,"PESIMO");

insert into Pet_Organization_Category values (1,20,"PEQUEÑA"),(2,30,"MEDIANA"),(3,50,"GRANDE");	
insert into Pet_Organization values ( 1,"KimsukiDemo",now(), "pendiente",now(),"987654321", 1,200,"kimsukiDemo@gmail.com", 1266, null,null,null,null, 1);
insert into Pet_Organization values ( 2,"MishishaDemo",now(), "pendiente",now(),"987654321", 1,200,"mishisha@gmail.com", 1266, null,null,null,null, 2);
insert into Pet_Organization values ( 3,"Asociacion de gatos Parque Kennedy",now(), "pendiente",now(),"987654321", 1,500,"kennedy@gmail.com", 1266, null,null,null,null, 3);

        
insert into Pet_Organization_Detail values (1,1,20);	

insert into Adopter values (1,"Cesar","Manrique","Masculino","983501261",now(),now(),"48459266",1,1,1);
insert into Adopter values (2,"Demo","DemoAp","Femenino","987654312",now(),now(),"12345678",1,1266,1);
insert into Adopter values (3,"Abraham","Mayanga","Masculino","987654123",now(),now(),"69696969",1,127,0);
insert into adopter_detail values (1,1,1,1,now(),now(),"Creador de Kimsuki","https://www.facebook.com/Kimsuki-283581860154273");
insert into adopter_detail values (2,2,1,3,now(),now(),"Demo","https://www.facebook.com/Kimsuki-283581860154273");
insert into adopter_detail values (3,3,1,3,now(),now(),"Chama","https://www.facebook.com/Kimsuki-283581860154273");


Insert into User (UserID, Username, Password, Enabled, OrganizationId)
				values	 (1,'kimsuqi','2659647',1,1),
						 (2,'misichaDemo','123456',0,2),
						 (3,'KennedyDemo','123456',1,3);	

 Insert into Role (RoleId, Description)
				values	 (1,'Pet Organization'),
						 (2,'Pet Organization'),
						 (3,'Pet Organization');	
                         

Insert into UserRole (UserRoleId, Enabled, UserId,RoleId)
				values	 (1,1,1,1),
						 (2,0,2,1),
						 (3,1,3,1);          
                        
select * from adopter_severity;
select * from adopter;
select * from Pet_Organization_Detail;