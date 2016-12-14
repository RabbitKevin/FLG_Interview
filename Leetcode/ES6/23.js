var mergeKLists = function(lists) {
  let help = (one, two) => {
      let dummy = new ListNode(Number.NEGATIVE_INFINITY);
      let ptr = dummy;
      while(one && two) {
          if(one.val <= two.val) {
              ptr.next = one;
              one = one.next;
              ptr = ptr.next;
              //ptr.next = null;
          }
          else {
              ptr.next = two;
              two = two.next;
              ptr = ptr.next;
              //ptr.next = null;
          }
      }
      //--------------------------//
      if(one) ptr.next = one;
      else if (two) ptr.next = two;
      else ptr.next = null;
      ptr = dummy.next;
      dummy.next = null;
      return ptr;
  }
  let next = [];
  for(let one of lists) {
      if(one !== null) next.push(one);
  }
  lists = next;
  if(!lists.length) return null;
  while(lists.length !== 1) {
      let tmp = [];
      for(let i = 0; i < lists.length;) {
          if(i+1 < lists.length) {
              tmp.push(help(lists[i], lists[i+1]));
              i+=2;
          }
          else tmp.push(lists[i++]);
      }
      lists = tmp;
  }
  return lists[0];
};
