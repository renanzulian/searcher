# Searcher

Algoritmo de indexação e recuperação de informações em arquivos.

## Objetivo

Imagine que você tem um diretório com um número muito grande de arquivos .TXT e quer saber qual em quais deles contém um determinado conjunto de palavras com uma perfomance aceitavel. Se o google pudesse acesssar seu diretório seria bacana, não? Com esse algoritmo é possivel recuperar as informações em milissegundos!

## Solução

Loop em arquivos? Tabela hash do conteudo? Subir um banco? Nada disso, pois tudo isso pode ser mais simples e objetivo!

### Faça um pré processamento no diretório que contem os arquivos

Aqui já esta metade do **segredo do performance**. Utilize nosso script de configuração para isso e você tera um diretório com um todas as palavras existentes no repositório fornecido. Sim, você gerou um tabela de dispersão onde as chaves são palavras e os valores são os nomes dos arquivos.

Você pode encontrar o script de pré-processamento na pastas **scripts**.

### Faça a busca das palavras

Com o repositório pre processado em mãos, coloque-os no mesmo diretório de um buscado (searcher) das soluções contruídas. 

Você pode encontrar um algoritmo de pesquisa em uma das pastas do diretório. **Estão separados por linguagem de programação**

### Soluções disponíveis

- Java (OK)
- NodeJS (OK)
- Python (Backlog) - Sem previsão para início.
