var isValid = function(s) {
    let stack = [];
    let help =(a, b)=>{
        if(a === '(') return b === ')';
        else if(a === '[') return b === ']';
        else return b === '}';
    }
    for(let str of s.split('')) {
        if(str === '(' || str === '{' || str === '[') stack.push(str);
        else {
            if(!stack.length) return false;
            else if(!help(stack[stack.length-1], str)) return false;
            else stack.pop();
        }
    }
    return stack.length === 0;
};
