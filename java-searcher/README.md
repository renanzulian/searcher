# Searcher (Em Java)

Esse é um dos algoritmos que você poderá utilizar para fazer a busca por palavras em um diretório pré-processado.
Caso não tenha o diretório pronto em mãos, retorne ao diretório anterior e acesse a pasta **scripts** e siga as
instruções antes de buildar a sua solução.

## Pré requisitos

- Java 11
- Apache Maven

## Instruções

Trata-se de um projeto em maven, onde você poderá utilizar as funcionalidades básicas de um automatizador de build.
Ao clonar o repositório na sua máquina, importe esse diretório na sua IDE favorita como um projeto maven.

Para empacotar uma solução, é preciso adicionar o diretório '**words**' gerado no pré-processamento na pasta 
**/src/main/resources/**. 

Obs: Caso o diretório resources não tenha a palavra words, o build gerado apresentará falhas!

### Instalação
Faça a instalação das dependências do projeto na sua máquina local.

```shell
mvn install
```

### Testes
Realize os testes e verifique se o algoritmo está estável.

```shell
mvn test
```

Obs: Não é preciso ter inserido o diretório words para executar essa operação, pois os testes são 
feitos com outro repositório de teste.

### Build
Nesse momento, é essencial que você já tenha inserido o seu diretório pré-processado como recurso do projeto.

```shell
mvn package
```

## Utilizando o Java Searcher

Após ter realizado o build do projeto, o maven irá gerar um arquivo **'searcher.jar'**. Com ele em mãos basta
executar o seguinte comando:

```shell
java -jar searcher.jar {PALAVRAS QUE VOCÊ DESEJA PROUCURAR}
```

Exemplo:
```shell
java -jar searcher.jar marvel studio
```

Obs: Coloque as palavras em sequência separadas por espaço. Não utilize aspas em torno do termo a ser pesquisado.

O algoritmo utiliza o critério **AND** para dar o match nos arquivos. Em outras palavras, só retornará os arquivos que
contenha todas as palavras fornecidas.
 
