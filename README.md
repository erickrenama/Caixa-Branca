ERROS ENCONTRADOS NO CÓDIGO

1- Uso de Strings concatenadas para consultas SQL

2- Problema: A concatenação de Strings na construção da query SQL expõe o sistema a ataques de SQL Injection.

3- Problema: Não há logs ou mensagens adequadas no bloco catch. O erro é simplesmente ignorado.

4- Problema: O driver especificado como "com.mysql.Driver.Manager" parece incorreto. O correto é "com.mysql.cj.jdbc.Driver".

5- Problema: Conexão, declaração e ResultSet não estão sendo fechados após o uso, o que pode causar vazamento de recursos.

6- Problema: Em caso de erro ao estabelecer a conexão, o método retorna null, o que pode causar NullPointerException em métodos que utilizam a conexão.

7- Problema: Variáveis como nome e result são declaradas globalmente, mas seu escopo é limitado ao método.
