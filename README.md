# Vá de Bike - Locadora de Bicicletas
A Vá de Bike é uma aplicação web para cadastramento de locação de bicicletas, realizado como trabalho 1 na disciplina de Desenvolvimento Web 1.

<table>
  <thead>
    <tr>
      <th colspan='2'>Desenvolvido por</th>
    </tr>
  </thead>
    <tr>
      <td>Ariane Cristina Gomes</td>
      <td>743507</td>
    </tr>
    <tr>
      <td>Sabrina da Silva Miranda</td>
      <td>743595</td>
    </tr>
    <tr>
      <td>Thais Gagliardo Dordan</td>
      <td>743596</td>
    </tr>
</table>

## Criação do Banco de dados
Nome do banco de dados: Bicicletas<br>
Tabelas existentes: Usuario e Locadora

Para criar o banco de dados, as tabelas e popular com algumas inserções, execute o arquivo **/db/biciletas.sql** dentro de um console mysql.

<table>
  <thead>
    <tr>
      <th colspan='5'>Usuario</th>
    </tr>
  </thead>
    <tr>
      <td><b>Campo</td>
      <td><b>Tipo</td>
      <td><b>Null</td>
      <td><b>Chave</td>
      <td><b>Extra</td>
    </tr>
    <tr>
      <td>id</td>
      <td>bigint</td>
      <td>No</td>
      <td>Primaria</td>
      <td>Auto incremento</td>
    </tr>
    <tr>
      <td>nome</td>
      <td>varchar (30)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>login</td>
      <td>varchar (100)</td>
      <td>No</td>
      <td>Unica</td>
      <td></td>
    </tr>
    <tr>
      <td>senha</td>
      <td>varchar (64)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>papel</td>
      <td>varchar (20)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>cidade</td>
      <td>varchar (30)</td>
      <td>Yes</td>
      <td></td>
      <td></td>
    </tr>
</table>

<table>
  <thead>
    <tr>
      <th colspan='5'>Locacao</th>
    </tr>
  </thead>
    <tr>
      <td><b>Campo</td>
      <td><b>Tipo</td>
      <td><b>Null</td>
      <td><b>Chave</td>
      <td><b>Extra</td>
    </tr>
    <tr>
      <td>id</td>
      <td>bigint</td>
      <td>No</td>
      <td>Primaria</td>
      <td>Auto incremento</td>
    </tr>
    <tr>
      <td>cliente</td>
      <td>varchar (30)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>locadora</td>
      <td>varchar (20)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td>data</td>
      <td>varchar (10)</td>
      <td>No</td>
      <td></td>
      <td></td>
    </tr>
</table>

<br><br>
## CheckList Requisitos
* Página inicial
	* R3 (Lista de todas as locadoras)<br>
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (50%) e Thais (50%)
	* R4 (Lista de locadoras por cidade)<br>
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (100%) e Thais (0%)
	* Login

* Página login
	* Página cliente
		* R5 (Locação bicicleta)<br>
			(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
			Divisão na implementação da funcionalidade: Ariane (50%), Sabrina (0%) e Thais (50%)
		* R6 (Listagem de todas as locações do cliente)<br>
			(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
			Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (0%) e Thais (100%)			
		* R7 (Não permite locações de um mesmo cliente ou mesma locadora em um mesmo dia/horário)<br> 
			() Implementado ( ) Parcialmente implementado (X) Não implementado
			Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (0%) e Thais (0%)

	* Página admin
		* R1 (CRUD de cliente)<br>
			(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
			Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (50%) e Thais (50%)
		* R2 (CRUD de locadoras)<br>
			(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
			Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (50%) e Thais (50%)
	* Página locadora
		* R8 (Listagem de todas as locações)<br>
			(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
			Divisão na implementação da funcionalidade: Ariane (0%), Sabrina (0%) e Thais (100%)

* Geral (geral)
	* internacionalização (português e inglês)<br>
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Ariane (100%), Sabrina (0%) e Thais (0%)
	* tratar erros (cadastro duplicado, problema técnico, etc)<br> 
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Ariane (100%), Sabrina (0%) e Thais (0%)
	* página de erros amigável e registrando erro no console.<br>
		() Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Ariane (50%), Sabrina (0%) e Thais (50%)
