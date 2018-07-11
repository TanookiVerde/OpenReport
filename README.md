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
|Interface dos componentes isoladamente|Interface Componentes|1h|X
|Adição de Componentes|Interface Componentes|3h|X
|Remoção de Componentes|Interface Componentes|1h|X
|Edição de Componentes|Interface Componentes|3h|X
|Salvar Modificações em Classe Template|Interface Componentes|2h|X
|Chamada de Exportar PDF a partir de Classe|Interface Componentes|2h|X
|Serialização e Deserialização de Classe Template em XML|Exportar PDF|2h|X
|Salvar XML em arquivo|Exportar PDF|1h|X
|Imprimir Cabeçalho|Exportar PDF|3h|X
|Imprimir Texto|Exportar PDF|1h|X
|Imprimir Título|Exportar PDF|1h|X
|Imprimir Assinatura|Exportar PDF|2h|X
|Imprimir Tabela Simples|Exportar PDF|4h|X
|Tabela: Pegar dados do BD|Exportar PDF|3h|X
|Imprimir componentes de acordo com Layout|Exportar PDF|5h|X
|Finalização Diagrama ER|Banco de Dados|1h|X
|Implementação do Diagrama e das tabelas em mySQL|Banco de Dados|2h|X
|Popular Banco de Dados|Banco de Dados|1h|X
|Enumeração dos Queries de acordo com o componente Tabela Simples|Banco de Dados|2h|X
|Implementação dos Queries enumerados|Banco de Dados|6h|X
|Integração com Java|Banco de Dados|5h|X
|Testes JUnit|Documentação|N/A| O
|Componente Histórico Escolar|Interface|3h| O
|Componente Listagem Turmas|Interface|3h| O
|Componente Listagem Alunos|Interface|3h| O
|Componente Listagem Professores|Interface|3h| O
|Polimento do Layout de Impressão|Exportar PDF|3h|O
|Document Header|Exportar PDF|4h|O
|Visual dos Componentes|Exportar PDF|4h|O
|Correção na tela de Customização|Exportar PDF|4h|O
<br>

Bônus|Tipo|Horas
----|----|-----
Escolher entre pagina vertical e horizontal|Exportar PDF|3h
Visual do Componente Tabela para histórico Escolar|Interface Componentes|1h
Visual do Componente Imagem |Interface Componentes|1h
Componente Tabela para histórico Escolar|Interface|4h
Componente Imagem |Interface|1h

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

### Sprint 5
#### Backlog:
* Atualização Semanal Wiki (5 de 12)
* Implementação de Queries Enumerados (incompleto)
* Remoção de Componentes
* Componente imagem (bugs)
* Imprimir Componentes de acordo com Layout (incompleto)


#### Retrospectiva:
Nesta sprint, além das tarefas principais concluídas e outras quase terminadas, foi proposta uma reorganização geral na estrutura do programa, principalmente no que tange a sua interface visual. Verificou-se que a biblioteca JavaFX iria requerer um número grande de funções para o caráter modular do programa, e para isso o grupo se reuniu em torno de uma estrutura composta por mais controllers, um para os slots que os componentes ocupariam, um para os componentes em si, um para templates e assim por diante. Isso requeriu uma boa parte de refatoração do código, além da leitura sobre estruturas previamente em desuso pelos elementos do grupo, como interfaces. 

Acredita-se que através dessa mudança, o grupo não precisará migrar o desenvolvimento para Java Web, algo que envolveria um tempo fora de cogitação para ser codificado.

### Sprint 6
#### Backlog:
* Atualização Semanal Wiki (6 de 12)
* Implementação de Queries Enumerados (incompleto)
* Integração com Java
* Componente imagem
* Componente tabela
* Imprimir Componentes de acordo com Layout (incompleto)


#### Retrospectiva:
Um progressivo grau de refatoração do código auxiliou na limpeza e no caráter modular do projeto. O código de estruturação da parte visual do projeto foi melhorado consideravelmente, sendo agora de fácil entendimento e menos redundante. De resto, o trabalho das queries segue sendo feito, juntamente com novas tarefas de integração de front e back-end.

### Sprint 7
#### Backlog:
* Atualização Semanal Wiki (7 de 12)
* Implementação de Queries Enumerados (incompleto)
* Enumerar Alunos por Turma
* Enumerar Turmas por Série
* Enumerar Professor por Turma
* Conexão direta com BD para acesso e edição
* Implementar componentes em outras telas
* Esboços de Design


#### Retrospectiva:
Juntamente com mais melhores no código de front, foi decidido que a categoria do backlog de Interface BD fora removida, optando por uma nova direção para o projeto - um escopo reduzido aonde o programa funcione com um banco de dados já populado, diferente do inicialmente planejado que contemplava uma tela extra de adição, remoção e edição no banco de dados. Começou-se a estudar a aplicabilidade de testes JUnit.
Quanto ao visual do projeto, começaram a ser feitos os primeiros esboços de uma melhoria geral na interface.
![menuPrincipal](https://i.imgur.com/bUhLu3E.png) 
<br>
**Menu Principal**
<br><br><br><br><br>
![criacaoTemplate](https://i.imgur.com/ZGePtfb.png) 
<br>
**Criação de Template**
## Relatórios produzidos _(em ordem de entrega)_
Os links *(nos títulos)* concedem permissão para comentários, agradecemos quaisquer observações que possam ser feitas para melhorar a qualidade de nossos relatórios!
<br>

### Sprint 8
#### Backlog:
* Atualização Semanal Wiki (8 de 12)
* Implementação de Queries Enumerados (incompleto)
* Enumerar Alunos por Turma
* Enumerar Turmas por Série
* Enumerar Professor por Turma
* Conexão direta com BD para acesso e edição
* Implementar componentes em outras telas
* Esboços de Design


#### Retrospectiva:
Juntamente com mais melhores no código de front, foi decidido que a categoria do backlog de Interface BD fora removida, optando por uma nova direção para o projeto - um escopo reduzido aonde o programa funcione com um banco de dados já populado, diferente do inicialmente planejado que contemplava uma tela extra de adição, remoção e edição no banco de dados. Começou-se a estudar a aplicabilidade de testes JUnit.
Quanto ao visual do projeto, começaram a ser feitos os primeiros esboços de uma melhoria geral na interface.
### [Relatório 1 - Métodos Ágeis, Scrum e Análise de Requisitos](http://goo.gl/Qp6Mvm) 
Um dos conceitos fundamentais da Engenharia de Software é o planejamento; um projeto feito sem organização ou estratégia pode virar facilmente um desastre e frustrar tanto o cliente quanto os próprios desenvolvedores. Nesse contexto, dentre as diversas maneiras de se lidar com este problema, destaca-se o uso de Métodos Ágeis, que consistem em técnicas e metodologias para potencializar o ritmo de desenvolvimento de um projeto.

Existem diversos Métodos Ágeis: Kanban, DSDM, entre outros, cada um com suas características e tipos recomendados de projeto. O Scrum, um dos mais famosos, é conhecido pela divisão do projeto em ciclos mensais (ou até semanais) chamados de Sprints. Este conceito significa simplesmente uma coleção de tarefas para serem feitas até o término de tal ciclo. Além disso, é designado à equipe um Scrum Master, indivíduo responsável pelo contato com clientes finais/donos de produto e pela designação das tarefas de cada sprint.

Para um Método Ágil funcionar, em especial o Scrum, é preciso uma lista de funcionalidades para que o software seja concluído. Em especial, é necessário acima de tudo entender qual o problema que a solução virtual visa resolver na elaboração desta lista. É preciso ter certeza que o produto final irá realmente beneficiar o cliente.

A elaboração da lista completa de funcionalidades só é possível a partir da Análise de Requerimento de Software, pois é nela que os profissionais competentes irão moldar o produto, entender sua proposta e, claro, suas funcionalidades chave para então encaminhá-las aos desenvolvedores.
<br>

### [Relatório 2 - Processo de Software e Canvas](http://goo.gl/cSvbDn)

Fundamentalmente, Processo de Software representa um amontoado de técnicas, modelos, e ações direcionadas para o desenvolvimento e manutenção de software e afins. Nesse contexto, equipes responsáveis pela produção se organizam em torno de diversos modelos em existência na indústria com o fim de gerir e dar sequência ao produto final que é o software funcional e em concordância com o que foi proposto para o mesmo. 

Um exemplo interessante disso em ação é a criação deste próprio relatório, que não deixa de ser uma parte instrumental do projeto final da disciplina FES-2018, sendo realizado semanalmente para que no final, exista uma documentação do projeto e dos ensinamentos repassados aos alunos.

Dentre os modelos, destaca-se o modelo em cascata (Waterfall Model), variações do mesmo, e modelos ágeis que surgiram em resposta aos mesmos. Para o primeiro, tipicamente é dedicado para cada etapa do processo um tempo extenso - requisitos, design, codificação, testes e manutenção. Esse método é originado das engenharias, sendo quase uma equivalência aproximada para fins de desenvolvimento de software.  

Entretanto, é amplamente criticado na indústria por suas características que não se traduzem bem para o viés digital - é dotado de inflexibilidade, exigindo relatórios extensos e numerosos, baixíssima capacidade de mudança durante desenvolvimento, com permissões e burocracias gerenciais obrigatórias. Para hoje sabe-se que a agilidade e flexibilidade são intrínsecas ao bom desenvolvimento. O Scrum, discutido anteriormente e as subsequentes variações do Waterfall Model se unem nessa direção. 

Como parte do Processo de Software, uma ferramenta que entrará como parte do projeto é o Project Model Canvas, que se dá por um quadro, impresso ou digital, aonde há regiões separadas (da esquerda para a direita numa progressão linear) para um amontoado considerável de necessidades e características que um processo desse tipo abrange. É de considerável ajuda às equipes, organizando desde de stakeholders, equipes, custos até restrições que inicialmente podem passar despercebidos. 
<br>

### Relatório 3 - Testes de Usabilidade e Sprint \#0

O conceito de Testes de Usabilidade foi apresentado como uma proposta interessante na parte de interação com o cliente - através de protótipos produzidos no papel, é possível dar ao cliente uma ideia do que se pode desenvolver e como ele irá interagir com o produto final. 

Acredita-se que estes testes de funcionalidade, juntamente com as tirinhas de desenvolvimento citadas anteriormente sejam de firme ajuda nos meados da Sprint \#0 (também apresentada em aula) - que é a etapa do desenvolvimento ágil iterativo responsável por colocar nos eixos iniciais as fases de codificação do software. 
É fundamental verificar na entrega da Sprint \#0 que a equipe esteja reunida, que os requisitos tenham sido levantados e o backlog inicial de entregas erguido considerando o mesmo.

A equipe GaaraVSRocklee.wmv espera entregar a Sprint \#0 na forma do Trello, plataforma aonde serão organizadas as entregas/backlog do Scrum e cada sprint será formalizada dentro do Trello do grupo. Além disso, uma visita rápida de uma responsável da Prefeitura de Caxias, Sandra, foi realizada para dar um pouco de luz ao projeto.
<br>

### Relatório 4 - Visita Prefeitura Caxias e debate Merendas x Relatório.

Foi realizada outra visita da equipe da prefeitura da Caxias, com duas responsáveis pela gestão do Sistema i-Educar, Sandra e Poliana. Houve um sentimento de definição maior do projeto em questão, posto que a turma foi apresentada o sistema i-Educar em funcionamento e problemas existentes da plataforma. Ficou claro também ao grupo que o software desejado pela prefeitura era uma distinta da inicialmente proposta de customização estética de relatórios - atualmente procura-se mais a resolução erros específicos da plataforma i-Educar com o sistema i-Report.

Somado a isso, houve uma reunião geral da turma com a equipe em outra aula instrumental na decisão dos rumos do projeto final. Cada grupo apresentando suas impressões dos estudos até então contribuiu para a instauração de uma nova opção de projeto - um sistema para gerenciar merendas para substituir as planilhas em Excel usados em escolas em Caxias.

Por motivos de alteração da estrutura existente e requisitos originais do projeto, o grupo GaaraVsRockLee.wmv decidiu em uma reunião no domingo, dia 15/04 que optaria pela rota dos relatórios.
<br>

### Relatório 5 - Entrega de Sprint 0 e planejamentos
Nessas aulas foram planejados e entregues nos dias subsequentes o backlog final do produto (instrumental no funcionamento do Scrum para popular as sprints), o Sail Boat para auxiliar nos rumos do projeto e serviram de grande auxílio para desencadear o desenvolvimento e estimar com mais corretude o tempo necessário para as etapas do projeto.

Com o auxílio do professor Luis e da Poliana da equipe de Caxias, foi possível dar início ao desenvolvimento do projeto, tendo em vista o dimensionamento das tarefas e reflexões tidas a respeito do projeto. Também foi lecionado ao grupo diretivos para confecção do Burn Down Chart, gráfico responsável pela medição das tarefas cumpridas em relação ao tempo.

O grupo espera que essas ferramentas possam ser de ajuda constante, isto é, que estejam no auxílio e em uso (principalmente o backlog) até o final do projeto.
<br>

### Relatório 6 - Entrega de Sprint 1, 2 e mais planejamentos
Apesar da interrupção de alguns feriados tomando tempo precioso das aulas, o time teve um relativo sucesso em cumprir as tarefas graças a abundância de documentação conquistada e disponibilizada por esforço individual e em conjunto com a turma   e o professor. 

Na altura da sprint 1, o desenvolvimento foi dividido em Front-end e Back-end e a codificação do que representa praticamente um  terço dos requisitos levantados já foi concluída. Destaques incluem serialização e deserialização em XML, um esboço de interface semi-oca pronto, e o Banco de Dados modelado em E.R. Além disso, foi concluído o Burndown Chart para cada membro conforme o dependível [vídeo instrucional do Cesar Brod](https://www.youtube.com/watch?v=_Dt_o7MKImQ) (recomendação do Professor Luis)

### Relatório 7 - Entrega de Sprint 3, 4, introdução a testes.
O andamento destas sprints foi infelizmente postergado devido a uma semana concentrada de avaliações acadêmicas. Entretanto, conforme detalhado nas sprints, ainda foram entregues itens do backlog de membros que possuiam tempo disponível. Quanto às aulas, o professor Eber começou a lecionar durante as segundas feiras, e o grupo teve uma introdução à Testes de Software.

Dentre as várias definições lecionadas, destacamos algumas:
* Smoke Testing, que é o teste preliminar para averiguar se o básico de um programa funciona, antes de ser testado de maneira mais aprofundada. É ideal para projetos de prazos críticos.
* Testes de Regressão, são aqueles em que um conjunto de testes é repetido, utilizado em funções ou componentes de um programa alterados recentemente e já previamente testados.
* Testes de Validação, que confirmam (validam) o funcionamento definitivo do programa conforme os requisitos pré-estabelecidos no início do ciclo de desenvolvimento.
* Testes de Sistema, aqueles responsáveis pela integração do software produzido no seu contexto definitivo de utilização - com hardwares distintos, usuários e dados.
* Integração de Software, que concerne a montagem da estrutura do programa para entender como cada módulo do mesmo está conectado e partir para a testagem dos mesmos.
* Testes de Caixa Preta - que é o teste "opaco" e se refere ao teste que analisa a saída de um programa a partir de uma entrada.
* Testes de Caixa Branca - em contrapartida, analisa o código fonte para  modelar as especificações do teste.
Além disso, foram vistas definições formais de testes, estratégias e limites para valores de teste, juntamente com exercícios em sala de aula para aplicar o conhecimento obtido.

### Relatório 8 - Entrega de Sprint 5, continuação de testes.
As aulas dessa semana por parte do professor Eber serviram para expandir o conceito de Testes de Caixa Branca, que concerne casos de testes referentes a perspectiva interna do programa, isto é, o código fonte. Para entendê-los melhor, apresentou-se o conceito de Grafos de Fluxo elementares, Grafos de Controle dentre outros que permitiam estruturar o programa em forma de nós que possam ser efetivamente percorridos pelos casos de teste propostos.

Como aplicação, foi visto outro exercício em sala de aula para desenvolver casos de testes de um programa que verificava características de lados de triangulos. Um obstáculo considerável (segurança no Fundão) e que vinha se mostrando preocupante para todos os alunos no campus do Fundão se alastrou ao longo da semana, culminando em sequestros relâmpagos e o cancelamento de várias aulas para Quinta e Sexta-Feira. Felizmente o andamento do projeto não foi afetado e não perdeu-se nenhuma aula ou progresso nas sprints.


### Relatório 9 - Entrega de Sprint 6, semana de Greve dos Caminhoneiros no Fundão
Essa semana foi marcada pelo cancelamento oficial das atividades acadêmicas da Reitoria em função da alarmante Greve dos Caminhoneiros. Em virtude dos acontecimentos, o professor Luis Felipe organizou a _HACKCOMB_, uma hackathon para que os alunos pudessem aproveitar o tempo ocioso para acelerar o desenvolvimento do projeto.

Foi oferecida a oportunidade aos alunos de atuar nos seus projetos dentro do espaço de uma empresa aonde o professor estava, e, para aqueles que não pudessem comparecer, um hangouts geral. O grupo Gaara VS RockLee participou por meio dos hangouts, embora alguns membros tenham tido problemas técnicos e de saúde. 

O evento foi inteiramente segmentado em etapas cronometradas, fazendo-se o uso da técnica Pomodoro para dosar intervalos e gerir mais produtividade. Consiste na divisão de 25 minutos para produção focada, e intervalos de 5 à 10 minutos encaixados entre cada bloco de produtividade.

Acredita-se que foi uma ótima oportunidade para produzir mesmo com o estado de calamidade do país. O grupo teve ótimos resultados, refletidos nos relatórios das sprints que envolvem uma grande limpeza no código e novas direções/adequações propícias para o projeto. 

 
 ### Relatório 10 - Entrega de Sprint 7, Casos de Uso e revisão das aulas anteriores

 Esta foi a primeira semana propriamente dita de aula após o intervalo prolongado da greve dos caminhoneiros. Foi lecionada uma revisão dos métodos principais vistos de geração de casos teste, como os de Caixa Preta e Caixa Branca descritos em relatórios anteriores. Acreditamos que foi de auxílio razoável para situar o grupo na matéria que ficou um pouco esquecida pós greve. 

 Para dar início ao resto do conteúdo, o professor Eber entrou em detalhe sobre uma série de técnicas e características de especificação de software. Destacam-se nessas o nome para métodos, seus parâmetros e saída, uma menção geral da ferramenta OCL, que é uma linguagem declarativa descrevendo regras para a *Unified Modelling Language* (UML), além da importância sumária de se comentar código produzido. 

 Juntamente a essas explicações, falou-se sobre o conteúdo de casos de uso, com o professor elencando conceitos como pré e pós condição (referente ao sistema antes e depois de rodar), fluxo de sucesso e alternativo (casos de êxito - sem "jump" e condicionais), e casos de utilização. Em cima deste conteúdo foi realizado um exercício de modelagem de casos de uso em cima do projeto de cada grupo, e no nosso caso, sobre o OpenReport.

 Na aula de quarta o grupo seguiu com a sprint review e planejou a próxima como usual, infelizmente sem destaques.

 ### Relatório 11 - Greve Rodoviária, contato entre grupos
Nesta semana, como a maioria dos elementos do grupo moram a uma distância considerável da faculdade e todas as linhas de ônibus responsáveis pelo transporte dos mesmos foram afetadas, não houve presença do grupo na aula de segunda do professor Eber. 

Na quarta, no entanto, foi incentivado o contato entre os grupos para que pudessem resolver problemas potencialmente em comum com o desenvolvimento do projeto final. Conseguimos discutir um pouco sobre o funcionamento de testes JUnit com grupos que já tinham contato com essa tecnologia, em preparo para o desenvolvimento dos testes do OpenReport. Além disso, chegou ao conheciento do grupo que o professor Eber havia comentado mais sobre o conteúdo de casos de uso e revisando alguns conceitos básicos de testes usados para os mesmos dentre outros assuntos, através de outros poucos grupos que não foram impedidos de ir a aula em razão da greve.

 ### Relatório 12 - Casos de Teste Funcionais

 Para a aula de segunda, foi revisto o conteúdo de casos de uso, sob um viés de sua importância para produção de casos de teste. Assim, foi introduzido o tópico de Casos de Testes funcionais, através de um exercício em sala de aula que se encontra disponível na wiki do grupo GaaraVSRockLee.

 A sprint review de quarta-feira foi complementado novamente pela ajuda de grupos próximos, sanando dúvidas de interface, JavaFX, e algumas referentes ao banco de dados do projeto.

 ## Relatório 13 - Arquitetura de Software e jogo do Brasil

Sendo uma das partes finais do conteúdo da disciplina, foi visto em sala de aula o conteúdo de arquitetura de software. O professor Eber decorreu sobre as vantagens de montar a visão lógica de uma arquitetura fazendo o uso de diagramas de classes|sequências|transições, introduzindo o tema com uma analogia comparando um prédio desenvolvido por uma equipe de Engenharia Civil e um software de uma empresa - ambos precisariam de uma planta para serem produzidos.

Devido ao jogo do time Brasileiro na Copa Mundial da FIFA 2018, não houve aula de laboratório.

 ## Relatório 14 - Preparações para apresentação final

 Novamente houve um jogo da Copa Mundial da FIFA 2018, porém dessa vez o evento ocorreu na aula do professor Eber.

 Na aula de quarta feira, foi decidido com a sprint review e o professor Luis um detalhamento maior da apresentação final do projeto, que viria complementada de um book contendo a trajetória inteira do grupo respectivo. Nosso grupo teria então que produzir uma apresentação de slides que, somada ao projeto, totalizem cerca de 15 minutos e contemple de maneira ideal e enxuta a jornada do grupo descrita no book. Também foram acertados detalhes da última prova, que seria na próxima segunda.

 


## Iterações do Produto Final
Número|Data|Funcionalidades
----|----|-----
1|18/05|Adicionar e remover Componentes, Acessar banco de dados
2|06/06|Edição de componentes, salvar como template XML, Edição do banco de dados através do programa e anteriores.
3|20/06|Exportar para PDF, abrir template e anteriores.
Final|04/07|Finalização - polimento - e correção de bugs.

## Ferramentas
* Java 1.8
* JavaFX
* Netbeans IDE 8.2
* [iText 5.5.1](https://drive.google.com/open?id=14n_LnNdxtv4bUePJbjCPg-2EbdQmsler)
