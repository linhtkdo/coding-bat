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
  if (str.length() <= 1) return 0; // screen out; 
  
  int count = 0; // 'fix' factor
  
  if (str.substring(0, 2).equals("hi")) count = 1; // 'if' only len=2 cases
  return count + countHi(str.substring(1)); // 'slice': sub
}
public boolean array6(int[] nums, int index) {
// Given an array of ints, compute recursively if the array contains a 6.
// We'll use the convention of considering only the part of the array that begins at the given index. 
// In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
// array6([1, 6, 4], 0) → true
  if (index == nums.length) return false; // to not go out of bounds (instead of len=0 b/c nums stays same)
  
  int f = nums[index]; // considering at new index instead of nums[0]
  
  if (f == 6) return true;
  return array6(nums, index+1);
}
public int countHi2(String str) {
// Given a string, compute recursively the number of times lowercase "hi" appears in the string, 
// however do not count "hi" that have an 'x' immedately before them.
// countHi2("ahixhi") → 1
// countHi2("ahibhi") → 2
// countHi2("xhixhi") → 0

  if (str.length() <= 1) return 0;
  
  if (str.substring(0, 2).equals("hi")) // hi: add 1 and skip to [2]
    return 1 + countHi2(str.substring(2));
  
  if (str.charAt(0) == 'x' && str.charAt(1) != 'x') // x: skip next letter; but don't do that if next letter is x
    return countHi2(str.substring(2));
  
  return countHi2(str.substring(1)); // everything else
}
public String parenBit(String str) {
  // "xyz(abc)123" yields "(abc)".
  
  // Is the first char a '('? If not, recur, removing one char from the left of the string.
  if (str.charAt(0) != '(') {
    return parenBit(str.substring(1));
  }
  
  // Eventually this gets us to '(' at the start of the string.
  // If the first char is '(', then recur similarly, removing one char from the end of the string, until it is ')'.
  if (str.charAt(str.length()-1) != ')') {
    return parenBit(str.substring(0, str.length()-1));
  }
  
  // Now the first and last chars are ( .. ) and you're done.
  return str;
}
public boolean nestParen(String str) {
// Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". 

// nestParen("(())") → true
// nestParen("((()))") → true
// nestParen("(((x))") → false
  
  // 2 eventual base scenarios; () here b/c to not go outta bound below
  if (str.equals("") || str.equals("()")) return true;
  
  // check the first and last chars, and then recur on what's inside them
  if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
    return nestParen(str.substring(1, str.length() - 1));
  
  // third eventual base case 
  return false;
}
public boolean strCopies(String str, String sub, int n) {
  
// Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, 
// possibly with overlapping. N will be non-negative.

// strCopies("catcowcat", "cat", 2) → true
// strCopies("catcowcat", "cow", 2) → false
// strCopies("catcowcat", "cow", 1) → true

  if (n == 0) return true; // stop, met requirement
  int len = sub.length();
  if (str.length() < len) return false; // haven't met requirement and ran out of len 
  
  if (str.substring(0, len).equals(sub)) {
    
    // Found it, so subtract 1 from n in the recursion
    return strCopies(str.substring(1), sub, n-1);
    
  } else {
    return strCopies(str.substring(1), sub, n);
  }
}
public int strDist(String str, String sub) {
  
// Given a string and a non-empty substring sub, 
// compute recursively the largest substring which starts and ends with sub and return its length.

// strDist("catcowcat", "cat") → 9
// strDist("catcowcat", "cow") → 3
// strDist("cccatcowcatxx", "cat") → 9

  if (str.length() < sub.length()) return 0; // to not go out of bounds below
  
  if (!str.substring(0, sub.length()).equals(sub)) 
    return strDist(str.substring(1), sub); // slice it down until gets to sub
  
  if (!str.substring(str.length() - sub.length()).equals(sub)) 
    return strDist(str.substring(0, str.length() - 1), sub);
    
  return str.length(); // now we have sub...sub to return its len
}
public boolean groupSum(int start, int[] nums, int target) {
// Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? 
// This is a classic backtracking recursion problem. 

  // Base case: if there are no numbers left, then there is a solution only if target is 0.
  if (start == nums.length) return target == 0 ;
  
  // Key idea: nums[start] is chosen or it is not. Return true if either of the two recursive calls returns true.
  return (groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target));
}
public boolean groupNoAdj(int start, int[] nums, int target) {

// Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target 
// with this additional constraint: 
// If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. 

  if (start >= nums.length) return (target == 0);
  
  return groupNoAdj(start + 1, nums, target) // next index is called, then it can be chosen or not at next call
  || groupNoAdj(start + 2, nums, target - nums[start]); // num[start] is chosen, so skip next index
}
public boolean groupSumClump(int start, int[] nums, int target) {

// Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, 
// with this additional constraint: 

// if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. 
// For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.

// (one loop can be used to find the extent of the identical values).

  if (start >= nums.length) return target == 0;
  
  int count = 0;
  int num = nums[start];
    
  for (int i=start; i<nums.length; i++) {
    if (nums[i] != num) break; // we need only *adj* identical nums, so ala a diffent num, break loop 
    else count++;
  } 
  
  return groupSumClump(start + count, nums, target)
      || groupSumClump(start + count, nums, target - num*count);
}
public boolean splitArray(int[] nums) {
// Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. 
// Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, 
// and make the initial call to your recursive helper from splitArray(). (No loops needed.)

// splitArray([2, 2]) → true
// splitArray([2, 3]) → false
// splitArray([5, 2, 3]) → true

  return helper(0, nums, 0, 0);
}
public boolean helper(int start, int[] nums, int sum1, int sum2) {
  if (start >= nums.length) return sum1 == sum2;
  
  int num = nums[start];
  
  // all permutations of every num is in sum1 or sum2 (w/ all there lower combinations) are considered
  return helper(start + 1, nums, sum1 + num, sum2) 
      || helper (start + 1, nums, sum1, sum2 + num); 
}

