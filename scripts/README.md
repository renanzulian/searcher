# Pré-processador

Aqui você poderá preparar o seu diretório que contém todos os seus arquivos para poder 
posteriormente receber as pesquisas dos algoritmos.

## Requisitos tecnológicos

- Python3

## Instruções

### Testando o script
Execute o seguinte comando para testar as unidades do script:

```shell
python3 -m unittest test_setup.py
```

Obs: É preciso estar dentro do diretório de testes para executar o comando.


### Utilização
Execute o seguinte comando:

```shell
python3 setup.py {CAMINHO DO DIRETÓRIO}
```

Exemplo utilizando o diretório de filmes de exemplo:

```shell
python3 setup.py movies/data/
```

Após fazer o pré-processamento, arraste o diretório gerado "words" para o algoritmo que desejar.