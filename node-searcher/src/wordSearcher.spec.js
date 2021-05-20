const search = require('./wordSearcher');

const pathWordsTest = "resources/words_test";

describe('Word Searcher', () => {
    it('Should perfomance at most 10ms', () => {
        const words = ["hero"];
        const startTime = new Date().getTime();
        search(words, pathWordsTest);
        const performanceTime = new Date().getTime() - startTime;
        console.log(performanceTime)
        expect(performanceTime).toBeLessThanOrEqual(10);
    });
});