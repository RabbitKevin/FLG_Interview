var levelOrder = function(root) {
    let res = [];
    if(!root) return res;
    let queue = [];
    queue.push(root);
    while(queue.length) {
        let size = queue.length;
        let level = [];
        for(let i = 0; i < size; ++i) {
            let tmp = queue.shift();
            level.push(tmp.val);
            if(tmp.left) queue.push(tmp.left);
            if(tmp.right) queue.push(tmp.right);
        }
        res.push(level);
    }
    return res;
};
