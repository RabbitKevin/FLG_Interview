/*
  pre-order遍历，对于任意root节点来说，必然是小子树先被遍历，然后再是大子树.
  维护min作为当前遍历条件下的最小值
*/
var verifyPreorder = function(preorder) {
    var stack = [];
    min = Number.NEGATIVE_INFINITY;
    for(var i = 0; i < preorder.length; ++i) {
        if(preorder[i] < min) return false;
        while(stack.length && (preorder[i] > stack[stack.length-1])) min = stack.pop();
        stack.push(preorder[i]);
    }
    return true;
};
/*
  不用单独的stack, 用pre-order作为stack, 用一个index去track
*/
var verifyPreorder = function(preorder) {
    min = Number.NEGATIVE_INFINITY;
    var j = -1;
    for(var i = 0; i < preorder.length; ++i) {
        if(preorder[i] < min) return false;
        while(j >= 0 && preorder[i] > preorder[j]) {
            min = preorder[j--];
        }
        preorder[++j] = preorder[i];
    }
    return true;
};
//Follow up， how to verify post-order traversal
/*
  Pre-order:root, left, right;
  post-order: left, right, root;
  Just reverse it...
*/
var verifyPostorder = function(postorder) {
  var j = postorder.length;
  max = Number.POSITIVE_INFINITY;
  for(var i = postorder.length-1; i >= 0; --i) {
    if(postorder[i] > max) return false;
    while(j < postorder.length && postorder[i] < postorder[j]) {
      max = postorder[j++];
    }
    postorder[--j] = postorder[i];
  }
  return true;
}
