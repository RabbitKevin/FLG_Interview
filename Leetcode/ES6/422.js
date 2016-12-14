var validWordSquare = function(words) {
    if(!words.length || words.length !== words[0].length) return false;
    for(let i = 0; i < words.length; ++i) {
        let word = words[i];
        for(let j = 0; j < word.length; ++j) {
            if(!words[j] || !words[j][i] || words[j][i] !== word[j]) return false;
        }
    }
    return true;
};
