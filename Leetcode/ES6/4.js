var findMedianSortedArrays = function(nums1, nums2) {
    let size = nums1.length+nums2.length;
    if((size&1)) return help(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, ((size+1) >> 1));
    else {
        let first = help(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (size >> 1));
        let second = help(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (size >> 1)+1);
        return (first+second) / 2;
    }
};

function help(nums1, i1, j1, nums2, i2, j2, k) {
    let size1 = j1-i1+1,
        size2 = j2-i2+1;
    if(size1 > size2) return help(nums2, i2, j2, nums1, i1, j1, k);
    if(!size1) return nums2[i2+k-1];
    if(k === 1) return Math.min(nums1[i1], nums2[i2]);
    let part1 = Math.min(k >> 1, size1);
    let part2 = k-part1;
    if(nums1[i1+part1-1] <= nums2[i2+part2-1]) return help(nums1, i1+part1, j1, nums2, i2, j2, k-part1);
    else return help(nums1, i1, j1, nums2, i2+part2, j2, k-part2);
}
