1 - https://github.com/andre1405sousa/apiorclmetrics.git

3 - cd ./apiorclmetrics/

4 - executar o script database_scripts.sql no banco com usuário sys
    vai criar 5 views, um usuário, e dar permissão de select nas view.

5 - vim  ./src/main/resources/application.properties [vim ou qq editor]

    na linha: spring.datasource.url=jdbc:oracle:thin:@localhost:1521/xepdb1

    informar os dados de conexão com o banco.

6 - mvn clean install

7 - java -jar ./target/apiorclmetrics-0.0.1-SNAPSHOT.jar
