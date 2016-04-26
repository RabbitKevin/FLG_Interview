for(int i = 0; i < A.length;){
    if(A[i] == target){
        return i;
    }else{
        i = i + Math.abs(target - A[i]);
    }
}
return -1;
