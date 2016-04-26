var lengthOfLongestSubstring = function(s) {
    var chars = new Array(256);
    for(var i = 0; i < 256; ++i) chars.push(false);
    //--------------------------------------------//
    var j = 0;
    var max = 0;
    for(i = 0; i < s.length; ++i) {
        var index = s.charCodeAt(i);
        if(!chars[index]) chars[index] = true;
        else {
            max = Math.max(i-j, max);
            var tmp = s.charCodeAt(j);
            while(tmp != index) {
                chars[tmp] = false;
                j++;
                tmp = s.charCodeAt(j);
            }
            j++;
        }
    }
    return Math.max(i-j, max);
};
