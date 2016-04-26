var findMedianSortedArrays = function(nums1, nums2) {
    var size_1 = nums1.length;
    var size_2 = nums2.length;
    var sum = size_1+size_2;
    if(sum & 1) return help(nums1, 0, size_1-1, nums2, 0, size_2-1, (sum >> 1)+1);
    var first = help(nums1, 0, size_1-1, nums2, 0, size_2-1, (sum >> 1));
    var second = help(nums1, 0, size_1-1, nums2, 0, size_2-1, (sum >> 1)+1);
    console.log(first);
    console.log(second);
    return (first+second)/2;
};
function help(nums_1, start_1, end_1, nums_2, start_2, end_2, k) {
    var part_A = end_1-start_1+1;
    var part_B = end_2-start_2+1;
    //--------------------------//
    if(part_B < part_A) return help(nums_2, start_2, end_2, nums_1, start_1, end_1, k) ;
    if(!part_A) return nums_2[start_2+k-1];
    if(k === 1) return Math.min(nums_2[start_2], nums_1[start_1]);
    //-----------------------------------------------------------//
    part_A = Math.min(part_A, (k >> 1));
    part_B = k-part_A;
    //----------------------------------------------------------//
    if(nums_1[start_1+part_A-1] > nums_2[start_2+part_B-1]) return help(nums_1, start_1, end_1, nums_2, start_2+part_B, end_2,k-part_B);
    else if(nums_1[start_1+part_A-1] < nums_2[start_2+part_B-1]) return help(nums_1, start_1+part_A, end_1, nums_2, start_2, end_2,k-part_A);
    else return nums_1[start_1+part_A-1];
}
