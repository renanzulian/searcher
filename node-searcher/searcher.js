const wordSearcher = require('./src/wordSearcher');

const desiredWords = process.argv.splice(2) || [];
const results = wordSearcher(desiredWords);
console.log(`Foram encontradas ${results.size} ocorrências pelo termo.`);
console.log(`Os arquivos que possuem "${desiredWords.join(", ")}" são:`);
console.log([...results].sort());
