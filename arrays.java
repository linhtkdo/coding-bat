// sameEnds
// Return true if the group of N numbers at the start and end of the array are the same.
// sameEnds([5, 6, 45, 99, 13, 5, 6], 1) → false
// sameEnds([5, 6, 45, 99, 13, 5, 6], 2) → true
// sameEnds([5, 6, 45, 99, 13, 5, 6], 3) → false
public boolean sameEnds(int[] nums, int len) {
  for (int i=0; i<len; i++) {
    if (nums[i] != nums[nums.length-len + i]) return false; //different start pts (0 vs nums.length-len)
  }
  return true;
}
// shiftLeft
// Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}
public int[] shiftLeft(int[] nums) {
  if (nums.length > 0) { // do nothing to len=0 case; bypass a[0] err
    int first = nums[0]; // temp memory for first
    for (int i=0; i < nums.length-1; i++) {
      nums[i] = nums[i+1]; // now can shift arr 1-by-1
    }
    nums[nums.length-1] = first;
  }
  return nums;
}
// tenRun
// For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, 
// until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
public int[] tenRun(int[] nums) {
  boolean rep = false; // signal off
  int n = 0;
  for (int i=0; i < nums.length; i++) {
    if (nums[i] % 10 == 0) {
      n = nums[i];  
      rep = true; // turn on signal
    }
    if (rep) nums[i] = n; // signal on: do sth 
  }
  return nums;
}
// zeroFront
// {1, 0, 0, 1} becomes {0 ,0, 1, 1}
public int[] zeroFront(int[] nums) {
  int count = 0;
  for (int i=0; i < nums.length; i++) {
    if (nums[i] == 0) {
      nums[i] = nums[count]; // count = 0; non-zero @[0], etc
      nums[count] = 0; // swap zero and non-zero
      count++;
    }
  }
  return nums;
}
public int[] evenOdd(int[] nums) {
  all the even numbers come before all the odd numbers
  evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
  int countEven = 0;
  for (int i=0; i < nums.length; i++) {
    if (nums[i] % 2 == 0) {
      int even = nums[i]; // temp to hold even, vs default 0 for zeroFront
      nums[i] = nums[countEven];
      nums[countEven] = even;
      countEven++;
    }
  }
  return nums;
}
public int[] zeroMax(int[] nums) {
  
  Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of the zero 
  in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
  zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
  zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
  zeroMax([0, 1, 0]) → [1, 1, 0]
  
  int max = 0;
  for (int i = nums.length-1; i >= 0; i--) { //iterate backwards b/c zero only gets max to its right
    if (nums[i] % 2 == 1) max = Math.max(max, nums[i]); 
    if (nums[i] == 0) nums[i] = max;
  }
  return nums;
}


