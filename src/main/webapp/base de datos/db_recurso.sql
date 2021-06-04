create database db_recurso;
use db_recurso;


create table tb_user(
cod_user int (11) not null auto_increment,
log_user varchar (15) default null,
pass_user varchar (15) default null,
nom_user varchar (50) default null,
ape_user varchar (50) default null,
fdn_user date default null,
correo_user varchar(45) default null,
dir_user varchar (100) default null,
estado_user char(1),
primary key (cod_user)
);

create table tb_menu(
cod_menu int (11) not null auto_increment,
desc_menu varchar(30) default null,
url_menu varchar(400) default null,
primary key (cod_menu)
);


create table tb_acceso(
cod_menu int (11) not null,
cod_user int(11) not null,
primary key (cod_menu, cod_user),
key cod_user (cod_user),
CONSTRAINT tb_acceso_FK1 foreign key (cod_menu) references tb_menu (cod_menu),
CONSTRAINT tb_acceso_FK2 foreign key (cod_user) references tb_user (cod_user)
);

insert into tb_user values(1, 'elena', 'elena', 'Elena', 'Efimova', STR_TO_DATE('22-04-1987', '%d-%m-%Y'), 
'i201720773@cibertec.edu.pe', '221B Baker street', '1'),
(2, 'test', 'test', 'Test', 'User', STR_TO_DATE('25-12-0000', '%d-%m-%Y'), 
'testuser@cibertec.edu.pe', 'Mordor', '3');

insert into tb_menu values (1,'Usuario','ServletUsuario?accion=LISTAR'),
(2,'Solicitud','solicitud.jsp'),(3,'Apelación','apelacion.jsp'),(4,'Expediente','expediente.jsp');

 


INSERT INTO `tb_acceso` VALUES (1,1),(2,1),(3,1),(4,1),(1,2),(2,2),(3,2),(4,2);


SELECT * FROM TB_ACCESO;
SELECT * FROM TB_USER;
SELECT * FROM TB_MENU;

create table tb_solicitud
(
cod_soli int primary key not null auto_increment,
cod_user int,
cod_area int,
cod_informe int,
fec_info date,
perfil_soli varchar(100),
descri_soli varchar(100),
CONSTRAINT tb_solicitud_FK1 foreign key (cod_user) references tb_user (cod_user)
);

insert into tb_solicitud
	values (null,1,1,1002,CURDATE(),'Solicitud Vacaciones','De acuerdo a la ley me corresponde Vacaciones : )');

Select * from tb_solicitud;