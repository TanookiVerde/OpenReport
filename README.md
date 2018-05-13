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

## Sprints
### [Burn down Charts de cada Sprint, por membro](https://docs.google.com/spreadsheets/d/1cLAJabJcqsTo1P4E_HbKuMOHV_B_Jd2DMFNLmmlBLp0/edit?usp=sharing)
Aqui anexamos (link no título) um documento com todos os burn down charts elaborados até então.

### Sprint 0 
* Backlog iniciado - Trello
* Reunião decisiva da equipe para planejamento do backlog, objetivo e funções de cada membro da equipe.
* Rumo de projeto decidido, objetivo na Wiki atualizado
* Primeiros planejamentos de back-end, interface (mockups)
#### Retrospectiva:
Esta sprint serviu como um preparo geral para o trabalho principal que o grupo terá de codificação das ideias discutidas, nas quais as ferramentas preparadas até agora - o *PM-Canvas*, *Trello*, *Mapa Mental* dentre outros servirão de apoio para um projeto flexível-iterativo, organizado e agilmente desenvolvido.
### Sprint 1
#### Backlog:
* Atualização Semanal Wiki (1 de 12)
* Tela de Customização (Oca)
* Tela inicial de seleção emplates (oca)
* Visual dos Componentes
* Gerar arquivo XML a partir de uma classe
* Finalizar modelo E.R e estrutura de hierarquia  do Back End
#### Modelo Entidade-Relacionamento para Back-end
![E.R](https://i.imgur.com/rW7SyFj.png)
#### Modelo Lógico
![Lógico](https://i.imgur.com/ArXUp52.png)
#### Retrospectiva:
Nessa sprint foi acertado a divisão do desenvolvimento foi dividido em Front-end e Back-end. Foi concluído cerca de um  terço dos requisitos levantados. Destaques, conforme já citados na reação 6, incluem serialização e deserialização em XML, um esboço de interface semi-oca pronto, e o Banco de Dados modelado em E.R. A partir dessas sprints, encontram-se anexados Burndown Charts para cada membro conforme o dependível [vídeo instrucional do Cesar Brod](https://www.youtube.com/watch?v=_Dt_o7MKImQ) (recomendação do Professor Luis)

### Sprint 2
#### Backlog:
* Atualização Semanal Wiki (2 de 12)
* Adição de Componentes
* Remoção de Componentes (incompleto)
* Implementação do Diagrama e das tabelas em mySQL
* Popular Banco de Dados (incompleto)
* Imprimir Cabeçalho
* Imprimir Título
* Imprimir Texto


#### Retrospectiva:
Houve uma produção sólida com um número razoável de itens do backlog concluídos. Um dos integrantes repassou adiante suas tarefas da semana por fatores de múltiplas provas na mesma. Dois itens de destaque - a Remoção de Componentes e População do Banco de Dados acabaram não satisfatórios mesmo depois de tempo investido. Para as próximas sprints, também em um período inicial de provas do período, espera-se poder concluir esses itens juntamente de mais novos requisitos.

### Sprint 3
#### Backlog:
* Atualização Semanal Wiki (3 de 12)
* Popular Banco de Dados (incompleto)
* Remoção de Componentes (incompleto)
* Componente Imagem
* Imprimir Assinatura
* Adição em cada campo

#### Retrospectiva:
Uma queda na produção, tanto nessa quanto possivelmente na próxima semana, como anteriormente previsto na Sprint 2. Um dos membros que havia se ausentado para outras obrigações acadêmicas ocupou a maior parte da produção dessa semana. Não foi alocado tempo o suficiente para os bugs na remoção, uma vez que a documentação da wiki exigiu um tempo maior do que o previsto, e popular o Banco de Dados foi subestimado, requerindo muito mais tempo do que imaginado.

### Sprint 4
#### Backlog:
* Atualização Semanal Wiki (4 de 12)
* Popular Banco de Dados
* Implementação de Queries Enumerados (incompleto)
* Remoção de Componentes (incompleto)
* Imprimir Tabela Simples
* Imprimir Componentes de acordo com Layout
* Remoção em Cada Campo
* Edição em Cada Campo

#### Retrospectiva:
Umas das maiores tarefas do back-end, como imprimir tabelas e a implementação dos Queries enumerados foram iniciadas, mas quanto ao Banco de Dados foi suprido o atraso gerido pelas avaliações. A pedido do Professor Luis, para acesso ao versionamento e um melhor histórico de updates, foi movida a parte da documentação referente as Sprints para este repositório. A documentação novamente exigiu mais tempo do que o previsto. Após esta sprint haverá uma melhor mobilidade para cumprir mais tarefas do backlog.

## Relatórios produzidos _(em ordem de entrega)_
Os links *(nos títulos)* concedem permissão para comentários, agradecemos quaisquer observações que possam ser feitas para melhorar a qualidade de nossos relatórios!
<br>
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
