create database GestaoCondominio;
Use GestaoCondominio;


create table Conta (
	id int NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    senha varchar(100) NOT NULL,
    cpf char(11) NOT NULL,
    rg char(9) NOT NULL,
	foto_grande text, #diretório: /conta/tamanhodaimg/iddousuario.jpg
    foto_icone text,
    verificar_email boolean NOT NULL,
    verificado boolean NOT NULL,
    email_recuperacao varchar(100) NOT NULL,
    administrador boolean NOT NULL,
    apartamento int NOT NULL,
	bloco varchar(50) NOT NULL,
    primary key (id),
    CHECK (REGEXP_LIKE(email, '@'))
);

create table Comprovante (
	id int NOT NULL,
    id_conta int NOT NULL,
    documento text NOT NULL,
    primary key (id),
	foreign key (id_conta) references Conta (id) ON DELETE CASCADE
    );
    

create table Recuperação (
	id int NOT NULL,
    id_conta int NOT NULL,
    validado boolean,
	codigo_verificacao char(80),
    gerada_em datetime,
    primary key (id),
    foreign key (id_conta) references Conta (id)
);


create table Chamado (
	id int NOT NULL,
    id_conta int NOT NULL,
    assunto varchar(200) NOT NULL,
    observações varchar(350) NOT NULL, 
    prioridade enum ('baixa', 'média', 'alta') NOT NULL,
    resolvido boolean,
    primary key (id),
    foreign key (id_conta) references Conta (id)
);


create table Categoria (
	id int NOT NULL,
    titulo varchar(100),
    icone_p text,
    icone_g text,
    cor char(6),
    primary key (id)
);

create table Comentario (
	id int NOT NULL,
    id_conta int NOT NULL,
    id_categoria int NOT NULL,
    titulo varchar(100) NOT NULL,
    topico varchar(100) NOT NULL,
    assunto varchar(300) NOT NULL,
    avaliação boolean NOT NULL,
    data_publicacao datetime NOT NULL,
    primary key (id),
    foreign key (id_conta) references Conta (id),
    foreign key (id_categoria) references Categoria (id)
);


create table Gestao (
	id int NOT NULL,
    id_conta int NOT NULL,
    atuação boolean,
    periodo_inicio date NOT NULL,
    periodo_fim date,
    primary key (id),
    foreign key (id_conta) references Conta (id)
);


create table Gastos (
	id int NOT NULL,
    id_gestao int NOT NULL,
    compra varchar(100) NOT NULL,
    preço float NOT NULL,
    lugar varchar(100) NOT NULL,
    motivo varchar(100) NOT NULL, 
	periodo date NOT NULL,
    primary key (id),
    foreign key (id_gestao) references Gestao (id)
);

-- update Conta set senha = ''ýðÊ|7D~Ë]ýTn\'' where id=2;
/*'$2a$12$gb0Ue9HcECiWQr4LhNZp7Og6rUkNT1Ka9GxBmgy2TCEiGFe/Mq0Hi'*/
insert into Conta values (1, 'Joui Jouki', 'jouijojojouki@condominio.com', 'senhoritaliz'/*senhoritaliz*/, '48878704008', '385438928', '/conta/grande/1.jpg', '/conta/icone/1.jpg', true, true, 'seitadasmascaras@condominio.com', false, 44, 'Bloco B');
insert into Conta values (2, 'Cesar Cohen', 'angelofthenight@condominio.com', 'cineraria123'/*cineraria123*/, '25427928014', '296828105', '/conta/grande/2.jpg', '/conta/icone/2.jpg', true, true, 'kaiser@condominio.com', false, 41, 'Bloco A');
insert into Conta values (3, 'Thiago Fritz', 'éothigao@condominio.com', 'naovoutiraracalça'/*naovoutiraracalça*/, '40115911065', '107054383', '/conta/grande/3.jpg', '/conta/icone/3.jpg', false, true, 'antiportas@condominio.com', false, 62, 'Bloco C');
insert into Conta values (4, 'Elizabeth Webber', 'elizabethwebber@condominio.com', 'joaodaniel123'/*joaodaniel123*/, '72040790004', '396061618', '/conta/grande/4.jpg', '/conta/icone/4.jpg', false, true, 'lizveia@condominio.com', false, 62, 'Bloco C'); 
insert into Conta values (5, 'Arthur Cervero', 'arthurzinhoguitarrista@condominio.com', 'abutresforever'/*abutresforever*/, '63328362029', '408225695', '/conta/grande/5.jpg', '/conta/icone/5.jpg', false, true, 'tutuzindecria@condominio.com', false, 41, 'Bloco A');
insert into Conta values (6, 'Beatrice Portinari', 'beatriceporti@condominio.com', 'orpheuzinhoS2'/*orpheuzinhoS2*/, '67967074009', '214505935', '/conta/grande/6.jpg', '/conta/icone/6.jpg', true, true, 'lilian@condominio.com', false, 100, 'Bloco E');
insert into Conta values (7, 'Tristan Monteiro', 'tristanlindo@condominio.com', 'sorrirnuncaéd+'/*sorrirnuncaéd+*/, '87021736037', '148879809', '/conta/grande/7.jpg', '/conta/icone/7.jpg', true, true, 'tristanmonteiro@condominio.com', false, 99, 'Bloco E');
insert into Conta values (8, 'Erin Parker', 'parker.erin@condominio.com', 'kabumcaos'/*kabumcaos*/, '56595646072', '206891052', '/conta/grande/8.jpg', '/conta/icone/8.jpg', false, true, '3rinfrit4s@condominio.com', false, 45, 'Bloco B');
insert into Conta values (9, 'Dante Cristal', 'gaspar.dante@condominio.com', 'divinacomedia'/*divinacomedia*/, '94038650081', '458302545', '/conta/grande/9.jpg', '/conta/icone/9.jpg', true, true, 'loirinhofamoso@condominio.com', false, 54, 'Bloco D');
insert into Conta values (10, 'Jasmin Cristal', 'jasmincris@condominio.com', '10657923'/*10657923*/, '42498311084', '191500495', '/conta/grande/10.jpg', '/conta/icone/10.jpg', true, true, 'esposadoloirinho@condominio.com', false, 54, 'Bloco D');
insert into Conta values (11, 'Carina Leone', 'leonecarina@condominio.com', 'leonesruarr'/*leonesruarr*/, '92224906064', '113246699', '/conta/grande/11.jpg', '/conta/icone/11.jpg', false, true, 'carinaleone@condominio.com', false, 100, 'Bloco A');
insert into Conta values (12, 'Antonio Pontevedra', 'balu12344@condominio.com', 'rubiinn'/*rubiinn*/, '58422589001', '444981056', '/conta/grande/12.jpg', '/conta/icone/12.jpg', true, true, 'antoniopontevedra@condominio.com', false, 10, 'Bloco B');
insert into Conta values (13, 'Fernando Carvalho', 'fernandomusico@condominio.com', 'lucianomeuamor'/*lucianomeuamor*/, '01629462012', '108248628', '/conta/grande/13.jpg', '/conta/icone/13.jpg', false, true, 'carvalhodefernando@condominio.com', false, 66, 'Bloco C');
insert into Conta values (14, 'Luciano Carvalho', 'kian.luciano@condominio.com', 'broxabroxabroxa'/*broxabroxabroxa*/, '91631577050', '108131002', '/conta/grande/14.jpg', '/conta/icone/14.jpg', true, true, 'carvalhodeluciano@condominio.com', false, 66, 'Bloco C');
insert into Conta values (15, 'Agatha Volkemenn', 'transcender.agatha@condominio.com', 'tr4nc3nd3r'/*tr4nc3nd3r*/, '96972605083', '201625477', '/conta/grande/15.jpg', '/conta/icone/15.jpg', false, true, 'agathinha@condominio.com', false, 22, 'Bloco A');
insert into Conta values (16, 'Alexsander Kothe', 'prof.alex@condominio.com', 'powerrangersseason3ep7'/*powerrangersseason3ep7*/, '43007408016', '164342473', '/conta/grande/16.jpg', '/conta/icone/16.jpg', true, true, 'alexsander_kothe@condominio.com', false, 55, 'Bloco E');
insert into Conta values (17, 'Cristopher Cohen', 'aranha.christopher@condominio.com', 'Cohen_Cesar'/*Cohen_Cesar*/, '57523155065', '429993985', '/conta/grande/17.jpg', '/conta/icone/17.jpg', false, true, 'cohen.christopher@condominio.com', false, 42, 'Bloco A');
insert into Conta values (18, 'Daniel Hartmann', 'exbbb.daniel@condominio.com', 'entreacruzeaespada'/*entreacruzeaespada*/, '15393638051', '219590126', '/conta/grande/18.jpg', '/conta/icone/18.jpg', false, true, 'espreitador@condominio.com', false, 50, 'Bloco E');
insert into Conta values (19, 'Rubens Naluti', 'rubens@condominio.com', 'senhacomplexa'/*senhacomplexa*/, '43606842074', '292773304', '/conta/grande/19.jpg', '/conta/icone/19.jpg', true, true, 'email@condominio.com', false, 11, 'Bloco B');
insert into Conta values (20, 'Mia Verissimo', 'verissimo.mia@condominio.com', 'lupinhonenem'/*lupinhonenem*/, '22140085000', '378430129', '/conta/grande/20.jpg', '/conta/icone/20.jpg', true, true, 'lupin.mia@condominio.com', false, 22, 'Bloco A');
insert into Conta values (21, 'Artemis Rodrigues', 'gamba1234@condominio.com', 'flamejante123'/*flamejante123*/, '00058184007', '328149251', '/conta/grande/21.jpg', '/conta/icone/21.jpg', true, true, 'injustiçada@condominio.com', false, 49, 'Bloco E');
insert into Conta values (22, 'Boris Lukic', 'boris.circo@condominio.com', 'esmagado123'/*esmagado123*/, '98416447039', '126403508', '/conta/grande/22.jpg', '/conta/icone/22.jpg', true, true, 'boris@condominio.com', false, 96, 'Bloco C');
insert into Conta values (23, 'Damir Lukic', 'lukic.damir@condominio.com', 'circo321'/*circo321*/, '27094368097', '330183047', '/conta/grande/23.jpg', '/conta/icone/23.jpg', false, true, 'damir@condominio.com', false, 96, 'Bloco C');
insert into Conta values (24, 'Gal Escripta', 'gal.dragoesmetalicos@condominio.com', 'dragoesmetalicos@321123'/*dragoesmetalicos@321123*/, '62865754057', '208369223', '/conta/grande/24.jpg', '/conta/icone/24.jpg', false, true, 'injustiçane@condominio.com', false, 15, 'Bloco C');
insert into Conta values (25, 'Theodore Bagwell', 'tbag@condominio.com', 'churrasco#1423246'/*churrasco#1423246*/, '72738583075', '441451354', '/conta/grande/25.jpg', '/conta/icone/25.jpg', true, true, 'gambanoespeto@condominio.com', false, 12, 'Bloco C');
insert into Conta values (26, 'Amelie Florence', 'amelieflorence@condominio.com', 'traumatizada1332234'/*traumatizada1332234*/, '89060472071', '313535012', '/conta/grande/26.jpg', '/conta/icone/26.jpg', false, true, 'antipobre@condominio.com', false, 74, 'Bloco D');
insert into Conta values (27, 'Barbara Lima', 'lima.barbara@condominio.com', 'derretida123235345'/*derretida123235345*/, '08997480073', '109081146', '/conta/grande/27.jpg', '/conta/icone/27.jpg', false, true, 'margarida.b@condominio.com', false, 59, 'Bloco D');
insert into Conta values (28, 'Milo Castello', 'castello.m@condominio.com', 'miguel123'/*miguel123*/, '09334989009', '139728764', '/conta/grande/28.jpg', '/conta/icone/28.jpg', true, true, 'whoism@condominio.com', false, 60, 'Bloco D');
insert into Conta values (29, 'Oliver Florence', 'oliverf@condominio.com', 'traumatizado4322331'/*traumatizado4322331*/, '90369924002', '339372953', '/conta/grande/29.jpg', '/conta/icone/29.jpg', true, true, 'emo@condominio.com', false, 74, 'Bloco D');
insert into Conta values (30, 'Aniela Ukryty', 'aniela.ukryty@condominio.com', 'facadocs#1321'/*facadocs#1321*/, '67285794007', '339888404', '/conta/grande/30.jpg', '/conta/icone/30.jpg', true, true, 'aniela.ordem@condominio.com', false, 87, 'Bloco B');
insert into Conta values (31, 'Ivete Beicur', 'gauderios.ivete@condominio.com', 'arthurzinho312'/*arthurzinho312*/, '58443117010', '485858009', '/conta/grande/31.jpg', '/conta/icone/31.jpg', false, true, 'beicur_ivete@condominio.com', false, 41, 'Bloco A');
insert into Conta values (32, 'Henry Lucas', 'henry.stn@condominio.com', 'diaboobaid'/*diaboobaid*/, '60383983096', '245005468', '/conta/grande/32.jpg', '/conta/icone/32.jpg', true, true, 'diabinhodemoninho@condominio.com', false, 66, 'Bloco D');
insert into Conta values (33, 'Arnaldo Fritz', 'anfritz@condominio.com', 'anfitras0413'/*anfitras0413*/, '16716165029', '194169017', '/conta/grande/33.jpg', '/conta/icone/33.jpg', false, true, 'fritz_arnaldo@condominio.com', false, 69, 'Bloco A');
insert into Conta values (34, 'Mauro Nunes', 'granada.mauro@condominio.com', 'minaterrestre123'/*minaterrestre123*/, '92821071086', '437118253', '/conta/grande/34.jpg', '/conta/icone/34.jpg', true, true, 'grandas@condominio.com', false, 51, 'Bloco B');
insert into Conta values (35, 'Maya Shizuri', 'shizuriaya@condominio.com', 'outrafacadocs1321'/*outrafacadocs1321*/, '63293444008', '331895377', '/conta/grande/35.jpg', '/conta/icone/35.jpg', true, true, 'maya.assasina@condominio.com', false, 69, 'Bloco B');
insert into Conta values (36, 'Leandro Torres', 'leandrot@condominio.com', 'atiradordeelite235'/*atiradordeelite235*/, '85213676006', '266228677', '/conta/grande/36.jpg', '/conta/icone/36.jpg', false, true, 'leandrin@condominio.com', false, 75, 'Bloco B');
insert into Conta values (37, 'Caio Fernandes', 'caiocaindo@condominio.com', 'caiunochao213'/*caiunochao213*/, '28380053087', '249237143', '/conta/grande/37.jpg', '/conta/icone/37.jpg', false, true, 'caiodurao@condominio.com', false, 85, 'Bloco C');
insert into Conta values (38, 'Guilherme Verissimo', 'verissimo.ordem@condominio.com', 'velocimetro'/*velocimetro*/, '00967460093', '372571281', '/conta/grande/38.jpg', '/conta/icone/38.jpg', true, true, 'olhossempreabertos@condominio.com', false, 22, 'Bloco A');
insert into Conta values (39, 'Apolo Rodrigues', 'apolo.ro@condominio.com', 'hadesmelhor123'/*hadesmelhor123*/, '88897880037', '445792814', '/conta/grande/39.jpg', '/conta/icone/39.jpg', true, true, 'apolomelhordeusgregosupremacy@condominio.com', false, 49, 'Bloco E');
insert into Conta values (40, 'Sidney Silva', 'sidney.sindico@condominio.com', 'omelhoromaioralaquelequetodostemem123'/*omelhoromaioralaquelequetodostemem123*/, '07626024060', '420916428', '/conta/grande/40.jpg', '/conta/icone/40.jpg', true, true, 'deussidney@condominio.com', true, 10, 'Bloco A');


insert into Comprovante values (1, 1, '/comprovante/documento/1.jpg');
insert into Comprovante values (2, 2, '/comprovante/documento/2.jpg');
insert into Comprovante values (3, 3, '/comprovante/documento/3.jpg');
insert into Comprovante values (4, 4, '/comprovante/documento/4.jpg');
insert into Comprovante values (5, 5, '/comprovante/documento/5.jpg');
insert into Comprovante values (6, 6, '/comprovante/documento/6.jpg');
insert into Comprovante values (7, 7, '/comprovante/documento/7.jpg');
insert into Comprovante values (8, 8, '/comprovante/documento/8.jpg');
insert into Comprovante values (9, 9, '/comprovante/documento/9.jpg');
insert into Comprovante values (10, 10, '/comprovante/documento/10.jpg');
insert into Comprovante values (11, 11, '/comprovante/documento/11.jpg');
insert into Comprovante values (12, 12, '/comprovante/documento/12.jpg');
insert into Comprovante values (13, 13, '/comprovante/documento/13.jpg');
insert into Comprovante values (14, 14, '/comprovante/documento/14.jpg');
insert into Comprovante values (15, 15, '/comprovante/documento/15.jpg');
insert into Comprovante values (16, 16, '/comprovante/documento/16.jpg');
insert into Comprovante values (17, 17, '/comprovante/documento/17.jpg');
insert into Comprovante values (18, 18, '/comprovante/documento/18.jpg');
insert into Comprovante values (19, 19, '/comprovante/documento/19.jpg');
insert into Comprovante values (20, 20, '/comprovante/documento/20.jpg');
insert into Comprovante values (21, 21, '/comprovante/documento/21.jpg');
insert into Comprovante values (22, 22, '/comprovante/documento/22.jpg');
insert into Comprovante values (23, 23, '/comprovante/documento/23.jpg');
insert into Comprovante values (24, 24, '/comprovante/documento/24.jpg');
insert into Comprovante values (25, 25, '/comprovante/documento/25.jpg');
insert into Comprovante values (26, 26, '/comprovante/documento/26.jpg');
insert into Comprovante values (27, 27, '/comprovante/documento/27.jpg');
insert into Comprovante values (28, 28, '/comprovante/documento/28.jpg');
insert into Comprovante values (29, 29, '/comprovante/documento/29.jpg');
insert into Comprovante values (30, 30, '/comprovante/documento/30.jpg');
insert into Comprovante values (31, 31, '/comprovante/documento/31.jpg');
insert into Comprovante values (32, 32, '/comprovante/documento/32.jpg');
insert into Comprovante values (33, 33, '/comprovante/documento/33.jpg');
insert into Comprovante values (34, 34, '/comprovante/documento/34.jpg');
insert into Comprovante values (35, 35, '/comprovante/documento/35.jpg');
insert into Comprovante values (36, 36, '/comprovante/documento/36.jpg');
insert into Comprovante values (37, 37, '/comprovante/documento/37.jpg');
insert into Comprovante values (38, 38, '/comprovante/documento/38.jpg');
insert into Comprovante values (39, 39, '/comprovante/documento/39.jpg');
insert into Comprovante values (40, 40, '/comprovante/documento/40.jpg');


insert into Recuperação values(1, 4, true, '$2a$08$H/PiXgd5fEOH6jpV0LxoBO9s1Z6F0BG4FAbTSw2iJoimIQxKBCxDK', '2022-04-04 15:16:39');
insert into Recuperação values(2, 12, true, '$2a$08$LvKaR0ewWpINp2WBFcP.p.DA.qvkPFSHBV5MeKYszZ3XLSmUfnKlS', '2020-01-08 19:45:01');
insert into Recuperação values(3, 23, true, '$2a$08$.6iCiGxB4gjbetG7eLZOCuyCyaWP0ZTdCcSDXL22rYsKDdFBWs0fu', '2019-12-06 20:56:14');
insert into Recuperação values(4, 38, true, '$2a$08$chS4zLaSr63le.YdbEETEeWpMt/3CnivFu6WusJNGEW6ZEqdrHd/.', '2022-01-01 22:25:42');
insert into Recuperação values(5, 34, true, '$2a$08$01lq3oPp4aFe0dagtkzh5ubzrLtL82NNzndyzzwDjkdhjWRti4Jp2', '2022-06-02 01:34:51');
insert into Recuperação values(6, 17, true, '$2a$08$yMw6WSu4vG4dCIW57Nnn2.qjJsALjixZXGzjN9ZI.krrykfibFlGS', '2021-03-12 10:56:19');
insert into Recuperação values(7, 27, true, '$2a$08$k6.lpqCsQ4is5FoiqvQciuHPrA4CxbjI0aq9kq6psc5Bo5Rbru2li', '2017-11-05 03:21:12');
insert into Recuperação values(8, 8, true, '$2a$08$Dn92SznfpsUfh/Hl2fiN2.gEU6EDJqRmCKmK7PxQPYv3FAhCSjhT6', '2021-01-11 17:49:57');
insert into Recuperação values(9, 31, true, '$2a$08$Bml5.5qJqGem3RsSZtZZP.Vxq4z940govXEU0ntpBvHcag2Oj5uai', '2020-04-10 00:57:34');
insert into Recuperação values(10, 33, true, '$2a$08$leyEEdUKlHkF64wXG.mviunW9WeftaOVl6YHGV8AASmjvU.ANgHu6', '2018-08-02 06:01:50');


insert into Chamado values (1, 8, 'Lampada quebrada', 'Uma lampada quebrada na escada que impossibilita a visão', 'alta', false);
insert into Chamado values (2, 31, 'Barulho depois das 22h', 'Todo dia, no mesmo horario, ouço barulhos estranhos vindo do apartamento de baixo fora do período permitido', 'baixa', true);
insert into Chamado values (3, 12, 'Vagas apertadas', 'Não consigo estacionar meu carro', 'alta', false);
insert into Chamado values (4, 15, 'Segurança', 'A segurança do prédio está meio instavel', 'alta', true);
insert into Chamado values (5, 1, 'Janela quebrada', 'Há uma janela quebrada em um corredor do bloco B', 'media', false);
insert into Chamado values (6, 5, 'Goteiras no apartamento', 'Recentimente, começei a ouvir goteiras em casa, molhando o banheiro', 'media', false);
insert into Chamado values (7, 22, 'Portão com defeito', 'O portão de entrada não está abrindo e fechando corretamente', 'alta', true);
insert into Chamado values (8, 20, 'Área para pets', 'Queria que houvesse algum parque no nosso condominio próprio para nossos animais', 'baixa', true);
insert into Chamado values (9, 19, 'Energia', 'A energia tem falhado nas entradas dos blocos', 'média', true);
insert into Chamado values (10, 14, 'Crianças barulhentas', 'As criaças estão fazendo muito barulho durante a  noite', 'baixa', false);
insert into Chamado values (11, 18, 'Baixo sinal Wifi', 'A rede do prédio não está disponibilizando um bom wifi', 'média', false);
insert into Chamado values (12, 7, 'Piscina suja', 'A piscina não está tendo sua devida manutenção', 'média', false);
insert into Chamado values (13, 33, 'Fezes de cachorro', 'Esses dias identifiquei fezes de cachorro na área de lazer', 'alta', true);
insert into Chamado values (14, 35, 'Brinquedos sendo jogados pela varanda', 'Vi diversos brinquedos caírem de algum andar de cima', 'baixa', false);
insert into Chamado values (15, 40, 'Porteiro dormindo em serviço', 'Passei pela guarita e vi o porteiro dormindo', 'baixa', true);


insert into Categoria values (1, 'Lazer','/iconecategoria/pequeno/1.jpg', '/iconecategoria/grande/1.jpg', '42f59e');
insert into Categoria values (2, 'Ideias','/iconecategoria/pequeno/2.jpg', '/iconecategoria/grande/2.jpg', 'cc3d80');
insert into Categoria values (3, 'Avisos','/iconecategoria/pequeno/3.jpg', '/iconecategoria/grande/3.jpg', '2c4a5e');
insert into Categoria values (4, 'Reclamações','/iconecategoria/pequeno/4.jpg', '/iconecategoria/grande/4.jpg', 'a35a46');
insert into Categoria values (5, 'Festividades','/iconecategoria/pequeno/5.jpg', '/iconecategoria/grande/5.jpg', '59080d');
insert into Categoria values (6, 'Conversa','/iconecategoria/pequeno/6.jpg', '/iconecategoria/grande/6.jpg', '5f337a');
insert into Categoria values (7, 'Debates','/iconecategoria/pequeno/7.jpg', '/iconecategoria/grande/7.jpg', 'a9c7c7');
insert into Categoria values (8, 'Sugestões de melhorias','/iconecategoria/pequeno/8.jpg', '/iconecategoria/grande/8.jpg', 'f2c2e2');
insert into Categoria values (9, 'Reuniões','/iconecategoria/pequeno/9.jpg', '/iconecategoria/grande/9.jpg', 'a8a24a');
insert into Categoria values (10, 'Outros','/iconecategoria/pequeno/10.jpg', '/iconecategoria/grande/10.jpg', 'cc7523');


insert into Comentario values (1, 29, 1, 'Nova area de piscinas','Piscina', 'Senti muita falta de uma pscina nesse calor, será se tem como por uma no condominio?', false, '2022-11-26 12:00:07');
insert into Comentario values (2, 35, 1, 'Area para pets', 'Animal', 'Precisamos de um local feito para nossos pets se divertirem,', true, '2022-11-13 15:03:07');
insert into Comentario values (3, 34, 2, 'Nova cor do condominio', 'Reforma','Vocês não acham que o condominio precisava de uma renovada? Podemos mudar a cor dele, o que acham?', true, '2022-11-26 13:31:13');
insert into Comentario values (4, 28, 2, 'Festa de halloween', 'Festa', 'Estavamos pensando em comemorar o halloween aqui no predio e queriamos saber a opnião de todos quanto a isso.', true, '2022-11-13 23:21:04');
insert into Comentario values (5, 11, 3, 'Campeonato de quadribol', 'Esporte', 'Preparados para o maior evento desse condominio?? Pois bem, vem ai Campeonato de Quadribol dia 27/06, as 18:00, TODOS, repito, TODOS são convidados, amém', true, '2022-11-26 15:03:07');
insert into Comentario values (6, 21, 3, 'Entrarão na minha casa', 'Roubarão minha casa','Calvarão meu gato.', true, '2022-11-13 15:03:07');
insert into Comentario values (7, 24, 4, 'Novo sindico', 'Sindico','Queria propor uma nova eleição, esse sindico não faz nem o minimo.', true, '2022-11-26 19:27:11');
insert into Comentario values (8, 36, 4, 'Cachorros bagunceiros', 'Sujeira', 'Alguns cachorros bagunçaram a entrada do condominio, tem lava para todo lado, tentem segurar seus cachorros em dia de chuva por favor.', true, '2022-11-13 04:13:44');
insert into Comentario values (9, 19, 5, 'Festa de aniversario do condominio', 'Aniversario', 'Nesse sabado vamos comemorar o aniversario do condominio, esperamos a presença de todos.', false, '2022-11-26 15:03:07');
insert into Comentario values (10, 23, 5, 'Festa de ano novo', 'Ano novo', 'Esse ano vai ter festa de ano novo?', true, '2022-11-13 15:03:07');
insert into Comentario values (11, 19, 6, "Titulo.", "Tópico.", "Assunto.", true, '2022-11-26 15:03:07');
insert into Comentario values (12, 12, 6, "Monamour do Balu.", "Lanches", "Como todos sabemos, nada supera o Monamour do Balu.", true, '2022-11-13 22:12:03');
insert into Comentario values (13, 40, 7, "O Melhor Síndico.", "Imobiliária.", "Sidney é o melhor, oferecimento Imobiliária Fachada.", true, '2022-11-26 11:03:07');
insert into Comentario values (14, 15, 7, "Segredo.", "Bate-papo.", "Meia noite te conto.", false, '2022-11-13 23:59:59');
insert into Comentario values (15, 6, 8, "Pouca Iluminação.", "Críticas.", "O condomínio é muito escuro de noite, por favor arrumem mais lâmpadas!", true, '2022-11-26 15:03:07');
insert into Comentario values (16, 1, 8, "Sombras estranhas.", "Críticas.", "Tem umas sombras se mechendo no meu andar, acho que está precisando de dedetização", false, '2022-11-13 11:02:02');
insert into Comentario values (17, 38, 9, "Precisamos nos reunir.", "RPG.", "Reunião pra jogar RPG, quem morrer primeiro tem que pagar o ifood.", true, '2022-11-26 18:36:31');
insert into Comentario values (18, 16, 9, "Maratona de Power Rangers.", "Festas.", "Geral vem maratorar 20 temporadas de Power Rangers!", false, '2022-11-13 15:03:07');
insert into Comentario values (19, 2, 10, "Culto hoje a noite.", "Ednaldo Pereira.", "Venha cultuar nosso grande salvador Ednaldo Pereira hoje a noite!", true, '2022-11-26 21:29:45');
insert into Comentario values (20, 24, 10, "Clash.", "Video-Games.", "Preciso de um time pra jogar clash no lol hoje.", false, '2022-11-13 18:22:12');

insert into Gestao values (1, 38, false, '2019-03-14', '2022-03-15');
insert into Gestao values (2, 40, true, '2022-03-15', '2025-05-15');


insert into Gastos values (1, 1, 'Lampada', 10.00, 'Kalunga', 'Trocar a lâmpada da escada', '2022-06-04');
insert into Gastos values (2, 1, 'Janela de vidro', 255.00, 'Sodimac', 'Trocar a janela quebrada do Bloco B', '2022-06-08');
insert into Gastos values (3, 1, 'Repetidor Wi-fi', 119.90, 'Amazon', 'Melhorar o sinal wifi em algumas partes do predio', '2022-06-08');
insert into Gastos values (4, 1, 'Quebra-Cabeça', 30.00, 'Grow', 'Quebra-Cabeças para a brinquedoteca do condominio', '2022-06-10');
insert into Gastos values (5, 1, 'Jogo de tabuleiro War', 110.00, 'Amazon', 'Jogo de tabuleiro para a brinquedoteca do condominio', '2022-06-10');
insert into Gastos values (6, 1, 'Monopoly', 100.00, 'Americanas', 'Jogo de tabuleiro para a brinquedoteca do condominio', '2022-06-10');
insert into Gastos values (7, 1, 'Saquinhos plasticos', 19.90, 'Cetro', 'Saquinhos descartáveis para recolher as fezes dos pets', '2022-06-11');
insert into Gastos values (8, 1, 'Suporte de parede para saquinhos platicos', 98.42, 'Petlove', 'Suporte para deixar os saquinhos plasticos nos corredores', '2022-06-11');
insert into Gastos values (9, 1, 'Lixeira', 1799.00, 'Loja Power Bear', 'Trocar a lixeira quebrada do Bloco A', '2022-06-13');
insert into Gastos values (10, 1, 'Servico de eletricista', 500.00, 'Eletricista24h', 'Concertar o portão de entrada do estacionamento', '2022-06-14');
insert into Gastos values (11, 2, 'Servico de encanador', 850.00, 'Encanadores S.A.', 'Concertar vazamento de água no Bloco C', '2022-06-15');
insert into Gastos values (12, 2, 'Vassouras', 31.35, 'Benzolimp', 'Trocar as vassouras para a limpeza do predio', '2022-06-15');
insert into Gastos values (13, 2, '10 litros de Álcool gel', 99.80, 'Kalunga', 'Reabastecer o estoque de álcool gel do prédio', '2022-06-15');
insert into Gastos values (14, 2, 'kit para tratamento de piscina', 1593.00, 'Global Tech Brasil', 'Limpeza de piscina', '2022-07-16');
insert into Gastos values (15, 2, 'Servico para limpeza de piscina', 620.00, 'Piscinas S.A.', 'Limpar a piscina do condominio', '2022-07-18');
insert into Gastos values (16, 2, 'Kit de cameras de seguranca', 620.00, 'Tudo Forte', 'Trocar as cameras de seguranca quebradas', '2022-08-03');
insert into Gastos values (17, 2, '3 Lâmpadas', 30.00, 'Kalunga', 'Trocar as lâmpadas quebradas do Bloco A', '2022-08-08');
insert into Gastos values (18, 2, 'Bandeirinhas de festa junina', 150.00, 'Magazine Luiza', 'Decorar o condominio para a festa junina', '2022-06-20');
insert into Gastos values (19, 2, '5 Uniforme para os seguranças', 750.00, 'Fardas Expressas', 'Renovar os uniformes dos seguranças', '2022-10-08');
insert into Gastos values (20, 2, 'Decoracao natalina', 400.00, 'Shopee', 'Decorar o predio para o natal', '2022-12-08');



-- Comentários no fórum
SELECT c.topico, c.titulo, c.assunto, c.data_publicacao, co.nome, co.foto_icone, co.apartamento, co.bloco
FROM Comentario c
INNER JOIN Conta co ON c.id_conta = co.id
ORDER BY c.data_publicacao;

-- Comentários de uma única categoria no fórum
SELECT  c.topico, c.titulo, c.assunto, c.data_publicacao, co.nome, co.foto_icone, co.apartamento, co.bloco
FROM Comentario c
INNER JOIN Conta co ON c.id_conta = co.id
WHERE c.id_categoria = 9
ORDER BY c.data_publicacao;

-- Gastos do síndico durante seu período de atuação
SELECT co.nome, ge.periodo_inicio, ge.periodo_fim, ga.compra, ga.preço, ga.lugar, ga.motivo, ga.periodo as "data_da_compra"
FROM Conta co
INNER JOIN Gestao ge ON co.id = ge.id_conta
INNER JOIN Gastos ga ON ge.id = ga.id_gestao
WHERE ge.id = 2
ORDER BY ga.periodo;

-- Chamados feitos pelos usuários
SELECT c.assunto, c.observações, c.prioridade, c.resolvido, co.nome, co.foto_icone, co.apartamento, co.bloco
FROM Chamado c
INNER JOIN Conta co ON c.id_conta = co.id
ORDER BY c.prioridade DESC;

-- Perfil dos Usuarios
SELECT co.nome, co.apartamento, co.bloco, co.foto_icone, c.titulo, c.assunto as "Comentarios_recentes", c.data_publicacao, ch.observações as "Chamados_feitos", ch.resolvido
FROM Conta co
LEFT JOIN Comentario c on c.id_conta = co.id
LEFT JOIN Chamado ch on c.id_conta = ch.id
ORDER BY co.nome;

-- Perfil de um único Usuario // Todos os selects para a mesma tela
SELECT co.nome, co.apartamento, co.bloco, co.foto_icone
FROM Conta co
WHERE co.id = 2;

SELECT c.titulo, c.assunto as "Comentarios_recentes", c.data_publicacao
FROM Conta co
LEFT JOIN Comentario c on c.id_conta = co.id
WHERE co.id = 2;

SELECT ch.observações as "Chamados_feitos", ch.resolvido
FROM Conta co
LEFT JOIN Chamado ch on  co.id = ch.id
WHERE co.id = 2;

update Conta SET administrador = false where nome = "Bea";

select * from Conta;

SELECT * FROM Comentario WHERE id_categoria = 1 and data_publicacao = date() order by data_publicacao DESC;

SELECT id, id_conta, id_categoria, titulo, assunto, avaliação, date_format(data_publicacao, '%d/%m/%Y') as data_publicacao FROM Comentario;

select * from Comentario where data_publicacao BETWEEN DATE_SUB(data_publicacao, INTERVAL 1 MONTH) AND current_date;

SELECT c.titulo, c.assunto as "Comentarios_recentes", c.data_publicacao
FROM Comentario c
WHERE c.data_publicacao BETWEEN date_sub(current_date(), INTERVAL 1 MONTH) AND current_date();

SELECT c.titulo, c.assunto as "Comentarios_recentes", c.data_publicacao
FROM Comentario c
WHERE c.data_publicacao BETWEEN date_sub(current_date(), INTERVAL 7 DAY) AND current_date();

SELECT * FROM Comentario WHERE id_categoria = 1 AND data_publicacao BETWEEN date_sub(current_date(), INTERVAL 7 DAY) AND current_date();

SELECT * FROM Comentario WHERE id_categoria = 10 AND data_publicacao BETWEEN date_sub(current_date(), INTERVAL 1 MONTH) AND current_date();

		 -- Integrantes --

-- Alexsandro Leite Machado Junior - 231
-- Beatriz Galvão Verçosa - 213
-- Caetano Gonçalves de Avila Costa - 231
-- Gustavo Lemos dos Reis Silva - 231
-- Maria Eduarda Andrade da Silva - 231