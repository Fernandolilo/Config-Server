Config server Spring boot cloud,

chamada de endpoints nativos feita pelo application.yml

foi criado um folder em src/main/resources

detro feito profiles e chamdos os mesmo pelo profile principal

server:
  port: 8888
spring:
  application:
    name: systempro-config-server
  profiles:
    active:
    - native
