/*
    If < than root, must be in the left tree or root;
    if(>= root), must in the right tree;
*/
var inorderSuccessor = function(root, p) {
    if(!root) return null;
    if(p.val < root.val) {
        var tmp = inorderSuccessor(root.left, p);
        return tmp?tmp:root;
    }
    return inorderSuccessor(root.right, p);
};
