## CheckList Requisitos
* **REST API -- CRUD clientes**
  * Cria um novo cliente [Create - CRUD]<br>
    POST http://localhost:8080/clientes<br>
    Body: raw/JSON (application/json)<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a lista de clientes [Read - CRUD]<br>
    GET http://localhost:8080/clientes<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna o cliente de id = {id} [Read - CRUD]<br>
    GET http://localhost:8080/clientes/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Atualiza o cliente de id = {id} [Update - CRUD]<br>
    PUT http://localhost:8080/clientes/{id}<br>
    Body: raw/JSON (application/json)<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Remove o cliente de id = {id} [Delete - CRUD]<br>
    DELETE http://localhost:8080/clientes/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br><br>

* **REST API -- CRUD locadoras**
  * Cria uma nova locadora [Create - CRUD]<br>
    POST http://localhost:8080/locadoras<br>
    Body: raw/JSON (application/json)<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a lista de locadoras [Read - CRUD]<br>
    GET http://localhost:8080/locadoras<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a locadora de id = {id} [Read - CRUD]<br>
    GET http://localhost:8080/locadoras/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a lista de todas as locadoras da cidade de nome = {nome}<br>
    GET http://localhost:8080/locadoras/cidades/{nome}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Atualiza a locadora de id = {id} [Update - CRUD]<br>
    PUT http://localhost:8080/locadoras/{id}<br> 
    Body: raw/JSON (application/json)<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Remove a locadora de id = {id} [Delete - CRUD]<br>
    DELETE http://localhost:8080/locadoras/{id}REST API -- Retorna a lista de locações [Read - CRUD]<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br><br>
    
* **REST API -- Locações**  
  * Retorna a lista de locações<br>
    GET http://localhost:8080/locacoes<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a locação de id = {id} [Read - CRUD]<br>
    GET http://localhost:8080/locacoes/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a lista das locações do cliente de id = {id} [Read - CRUD]<br>
    GET http://localhost:8080/locacoes/clientes/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado<br><br>
  * Retorna a lista de locações da locadora de id = {id} [Read - CRUD]<br>
    GET http://localhost:8080/locacoes/locadoras/{id}<br>
    (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
