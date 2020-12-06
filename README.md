# example ratpack

sdk install groovy 2.5.4
sdk default groovy 2.5.4
grape -V -Dhttps.protocols=TLSv1.2 install io.ratpack ratpack-groovy 1.3.3


lazybones create ratpack 1.6.0 my-rat-app
