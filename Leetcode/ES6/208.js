/**
 * @constructor
 * Initialize your data structure here.
 */
var TrieNode = function() {
    this.isEnd = false;
    this.next = new Array(26);
};

var Trie = function() {
    this.root = new TrieNode();
};

/**
 * @param {string} word
 * @return {void}
 * Inserts a word into the trie.
 */
Trie.prototype.insert = function(word) {
    let cur = this.root;
    for(let i = 0; i < word.length; ++i) {
        let index = word.charCodeAt(i)-97;
        if(!cur.next[index]) cur.next[index] = new TrieNode();
        cur = cur.next[index];
    }
    cur.isEnd = true;
};

/**
 * @param {string} word
 * @return {boolean}
 * Returns if the word is in the trie.
 */
Trie.prototype.search = function(word) {
    let cur = this.root;
    for(let i = 0; i < word.length; ++i) {
        let index = word.charCodeAt(i)-97;
        if(!cur.next[index]) return false;
        cur = cur.next[index];
    }
    return cur.isEnd;
};

/**
 * @param {string} prefix
 * @return {boolean}
 * Returns if there is any word in the trie
 * that starts with the given prefix.
 */
Trie.prototype.startsWith = function(prefix) {
    let cur = this.root;
    for(let i = 0; i < prefix.length; ++i) {
        let index = prefix.charCodeAt(i)-97;
        if(!cur.next[index]) return false;
        cur = cur.next[index];
    }
    return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var trie = new Trie();
 * trie.insert("somestring");
 * trie.search("key");
 */
