# Searcher (Em Javascript)

Esse é um dos algoritmos que você poderá utilizar para fazer a busca por palavras em um diretório pré-processado.
Caso não tenha o diretório pronto em mãos, retorne ao diretório anterior e acesse a pasta **scripts** e siga as
instruções antes de buildar a sua solução.

## Pré requisitos

- NodeJS
- Npm

## Instruções

É um projeto em NodeJS utilizando o NPM como gerenciador de pacotes. Através dele você poderá instalar as dependencias para rodar todos os comandos corretamente

Para utilizar essa solução, é preciso adicionar o diretório '**words**' gerado no pré-processamento na pasta 
**/src/resources/**. 

Obs: Caso o diretório resources não tenha a palavra words, o build gerado apresentará falhas!

### Instalação
Faça a instalação das dependências do projeto na sua máquina local.

```shell
npm install
```

### Testes
Realize os testes e verifique se o algoritmo está estável.

```shell
npm test
```

Obs: Não é preciso ter inserido o diretório words para executar essa operação, pois os testes são 
feitos com outro repositório de teste.


## Utilizando o Java Searcher
Você pode executar o arquivo JS diretamente ou através do npm.

Executando diretamente:
```shell
node searcher.js {PALAVRAS QUE VOCÊ DESEJA PROUCURAR}
```

Executando pelo npm:
```shell
npm run searcher {PALAVRAS QUE VOCÊ DESEJA PROUCURAR}
```

Exemplo:
```shell
node searcher.js marvel studio
```

Obs: Coloque as palavras em sequência separadas por espaço. Não utilize aspas em torno do termo a ser pesquisado.

O algoritmo utiliza o critério **AND** para dar o match nos arquivos. Em outras palavras, só retornará os arquivos que
contenha todas as palavras fornecidas.
 