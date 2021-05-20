const fs = require('fs');

const defaultWordsPath = "resources/words/"

function search(words, wordsPath=defaultWordsPath) {
    if(Array.isArray(words)) {
        const contents = [];
        words.forEach((word) => {
            contents.push(getContents(word, wordsPath))
        });
        if (contents.length > 0) {
            let results = new Set([...contents[0]]);
            return contents.reduce((prev, curr) => {
                const intersection = new Set([...prev].filter(x => curr.has(x)));
                return intersection;
            }, results);
        }
        return new Set();
    }
    return null;
}

function getContents(desiredWord, wordsPath) {
    try {
        const content = fs.readFileSync(`${wordsPath + desiredWord}.txt`, 'utf-8');
        return new Set(content.split(' '));
    } catch (error) {
        return new Set();
    }
}

module.exports = search;