public boolean dividesSelf(int n) {

// We'll say that a positive int divides itself if every digit in the number divides into the number evenly. 
// So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly. 
// We'll say that 0 does not divide into anything evenly, so no number with a 0 digit divides itself. 
// Note: use % to get the rightmost digit, and / to discard the rightmost digit.

  for (int num = n; num>0; num = num/10) { // 'decrement' num -- discard rightmost digit -- until we get to < 0
    int digit = num % 10; // pull out rightmost digit
    if (digit == 0 || n % digit != 0) return false; // check digit
  }
  return true;
}

