# example ratpack

sdk install groovy 2.5.4
sdk default groovy 2.5.4
grape -V -Dhttps.protocols=TLSv1.2 install io.ratpack ratpack-groovy 1.3.3


lazybones create ratpack 1.6.0 my-rat-app

sqllite3 pluto.db

create table t_pluto(channel text, description text, category text);
create table t_pluto(id smallint primary key, channel text, description text, category text);
create table t_pluto(id INTEGER PRIMARY KEY AUTOINCREMENT, channel text, description text, category text);
