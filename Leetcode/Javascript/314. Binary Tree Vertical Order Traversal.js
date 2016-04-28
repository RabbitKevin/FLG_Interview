/*
    这题用JS写有点问题. js对将key先toSting()然后以json形式存下来
    索性不用hashtale, 直接利用script的便利性写一个新的object传入queue做BFS
    BFS直接用[]实现效率不是太高，主要是每次shift之后，都会重新排列[]
*/
var verticalOrder = function(root) {
    var result = [];
    if(!root) return result;
    var range = [0,0];
    var queue = [];
    queue.push([root, 0]);
    //---------------//
    var mem = {};
    while(queue.length) {
        var tmp = queue.shift();
        var node = tmp[0];
        var col = tmp[1];
        if(node.left) queue.push([node.left, col-1]);
        if(node.right) queue.push([node.right, col+1]);
        if(col in mem) mem[col].push(node.val);
        else mem[col] = [node.val];
        if(col < range[0]) range[0] = col;
        else if(col > range[1]) range[1] = col;
    }
    for(var i = range[0]; i <= range[1]; ++i) {
        result.push(mem[i]);
    }
    return result;
};
