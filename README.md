# OpenReport

## Equipe
   * **Gabriel Aureo de Oliveira Campos** - Desenvolvimento do Banco de Dados.
   * **Henrique Vermelho de Toledo** - Scrum Master e desenvolvimento de interface.
   * **Matheus Vinicius da Silva de Figueiredo** - Desenvolvimento da exportação para PDF e geração de Template.
   * **Pedro Vítor Marques Nascimento** - Desenvolvimento de interface.

## Definição de Conclusão
O time considera pronto um software que possibilite ao usuário adicionar, editar e remover dados do banco de dados da escola. Além disso a possibilidade de, em cima deles, emitir relatórios com estrutura dividida em Title, Page Header, Body, Page Footer e Footer. Estes relatórios podem acessar os dados do banco de dados de maneira que seja possível listar alunos em uma turma específica e coisas do gênero. Outra funcionalidade é a possibilidade de salvar o template do relatório em um arquivo XML que pode ser lido posteriormente pelo sistema.

## Backlog
Nome|Tipo|Horas|Concluído
-----|----|----|-----
|Telas isoladas ocas|Interface|2h|X
|Adição de Dados em cada Campo|Interface BD|3h|
|Edição de Dados em cada Campo|Interface BD|2h|
|Remoção de Dados em cada Campo|Interface BD|1h|
|Conexão Direta com BD para acesso e edição|Interface BD|4h|
|Interface dos componentes isoladamente|Interface Componentes|1h|X
|Adição de Componentes|Interface Componentes|3h|O
|Remoção de Componentes|Interface Componentes|1h|O
|Edição de Componentes|Interface Componentes|3h|
|Salvar Modificações em Classe Template|Interface Componentes|2h|
|Chamada de Exportar PDF a partir de Classe|Interface Componentes|2h|
|Serialização e Deserialização de Classe Template em XML|Exportar PDF|2h|X
|Salvar XML em arquivo|Exportar PDF|1h|
|Imprimir Cabeçalho|Exportar PDF|3h|X
|Imprimir Texto|Exportar PDF|1h|X
|Imprimir Título|Exportar PDF|1h|X
|Imprimir Assinatura|Exportar PDF|2h|
|Imprimir Tabela Simples|Exportar PDF|4h|
|Tabela: Pegar dados do BD|Exportar PDF|3h|
|Imprimir componentes de acordo com Layout|Exportar PDF|5h|
|Finalização Diagrama ER|Banco de Dados|1h|X
|Implementação do Diagrama e das tabelas em mySQL|Banco de Dados|2h|O
|Popular Banco de Dados|Banco de Dados|1h|O
|Enumeração dos Queries de acordo com o componente Tabela Simples|Banco de Dados|2h|
|Implementação dos Queries enumerados|Banco de Dados|6h|
|Integração com Java|Banco de Dados|5h|

Bônus|Tipo|Horas
----|----|-----
Escolher entre pagina vertical e horizontal|Exportar PDF|3h
Visual do Componente Tabela para histórico Escolar|Interface Componentes|1h
Visual do Componente Imagem |Interface Componentes|1h
Componente Tabela para histórico Escolar|Exportar PDF|4h
Componente Imagem |Exportar PDF|1h

## Iterações do Produto Final
Número|Data|Funcionalidades
----|----|-----
1|18/05|Adicionar e remover Componentes, Acessar banco de dados
2|?|Edição de componentes, salvar como template XML, Edição do banco de dados através do programa e anteriores.
3|?|Exportar para PDF, abrir template e anteriores.
Final|?|Finalização - polimento - e correção de bugs.

## Ferramentas
* Java 1.8
* JavaFX
* Netbeans IDE 8.2
* [iText 5.5.1](https://drive.google.com/open?id=14n_LnNdxtv4bUePJbjCPg-2EbdQmsler)
