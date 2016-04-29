/**
 * @constructor
 * @param {string[]} words
 */
var WordDistance = function(words) {
    this.map = {};
    for(var i = 0; i < words.length; ++i) {
        if(words[i] in this.map) this.map[words[i]].push(i);
        else this.map[words[i]] = [i];
    }
};

/**
 * @param {string} word1
 * @param {string} word2
 * @return {integer}
 */
WordDistance.prototype.shortest = function(word1, word2) {
    var list_1 = this.map[word1];
    var list_2 = this.map[word2];
    var i = 0,
        j = 0;
    var min = Number.POSITIVE_INFINITY;
    while(i < list_1.length && j < list_2.length) {
        while(i < list_1.length && list_1[i] < list_2[j]) {
            min = Math.min(min, Math.abs(list_1[i]-list_2[j]));
            ++i;
        }
        if(i === list_1.length) break;
        while(j < list_2.length && list_2[j] < list_1[i]) {
            min = Math.min(min,Math.abs(list_1[i]-list_2[j]));
            ++j;
        }
    }
    return min;
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * var wordDistance = new WordDistance(words);
 * wordDistance.shortest("word1", "word2");
 * wordDistance.shortest("anotherWord1", "anotherWord2");
 */

 /*
    反复查找，直接用hashmap存关系表不现实
    将word对应的序列存下来，然后用头尾追逐的方式缩小
*/
