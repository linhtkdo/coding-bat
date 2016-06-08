public int factorial(int n) {
  // Base case: if n is 1, we can return the answer directly
  if (n == 1) return 1;
  
  // Recursion: otherwise make a recursive call with n-1 (towards the base case), i.e. call factorial(n-1).
  // Assume the recursive call works correctly, and fix up what it returns to make our result.
  return n * factorial(n-1);
}
public int bunnyEars(int bunnies) {
  // Base case: if bunnies==0, just return 0.
  if (bunnies == 0) return 0;
  
  // Recursive case: otherwise, make a recursive call with bunnies-1(towards the base case), and fix up what it returns.
  return 2 + bunnyEars(bunnies-1);
}
public int bunnyEars2(int bunnies) {
  if (bunnies==0) return 0;
  
  // The even bunnies (2, 4, ..) we'll say have 3 ears
  if (bunnies % 2 == 0) return 3 + bunnyEars2(bunnies-1);
  
  // The odd bunnies (1, 3, ..) have the normal 2 ears
  return 2 + bunnyEars2(bunnies-1);
}
public int sumDigits(int n) {
  Given a non-negative int n, return the sum of its digits recursively (no loops). 
  Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
  if (n==0) return 0;
  // towards base: slice into left (instead of n-1) and call on left
  // fix: add rightmost
  return n % 10 + sumDigits(n/10); 
}
public int count7(int n) {
  // Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
  if (n == 0) return 0;
  // 2 cases
  // fix: add 1
  if (n % 10 == 7) return 1 + count7(n/10);
  return count7(n/10);
}
public int countHi(String str) {
// Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
// countHi("xxhixx") → 1
// countHi("xhixhix") → 2  
  if (str.length() <= 1) return 0; // screen out; 'if' only len=2 cases
  
  int count = 0; // 'fix' factor
  
  if (str.substring(0, 2).equals("hi")) count = 1;  
  return count + countHi(str.substring(1)); // 'slice': sub
}
public boolean array6(int[] nums, int index) {
// Given an array of ints, compute recursively if the array contains a 6.
// We'll use the convention of considering only the part of the array that begins at the given index. 
// In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
// array6([1, 6, 4], 0) → true
  if (index == nums.length) return false; // to stop going out of bounds (instead of len=0 b/c nums stays nums)
  
  int f = nums[index]; // considering at new index instead of nums[0]
  
  if (f == 6) return true;
  return array6(nums, index+1);
}

