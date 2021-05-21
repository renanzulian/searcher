const search = require('./wordSearcher');

const pathWordsTest = 'src/resources/words_test/';

describe('Word Searcher', () => {
    it('Should perfomance at most 10ms', () => {
        const words = ['hero'];
        const startTime = new Date().getTime();
        search(words, pathWordsTest);
        const performanceTime = new Date().getTime() - startTime;
        expect(performanceTime).toBeLessThanOrEqual(10);
    });

    it('Should take an empty set when no words are not provided', () => {
        const words = [];
        const results = search(words, pathWordsTest);
        expect(results.size).toBe(0);
    });

    it('Should get an empty set when an unavailable is provided', () => {
        const words = ['renanzulian'];
        const results = search(words, pathWordsTest);
        expect(results.size).toBe(0);
    });

    it('Should get contents when a valid word is provided', () => {
        const words = ['bellator'];
        const results = search(words, pathWordsTest);
        expect(results.size).toBe(9);
        expect(results.has('example/bellator-10.txt')).toBeTruthy();
    });

    it('Should get contents when many words is provided', () => {
        const words = ['peter', 'man'];
        const results = search(words, pathWordsTest);
        expect(results.size).toBe(1);
    });

    it('Should get type erro when the words is not a list', () => {
        const words = '10';
        expect(() => search(words, pathWordsTest)).toThrowError(TypeError);
    });
});