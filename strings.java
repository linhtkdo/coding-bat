public String doubleChar(String str) {
  // doubleChar("The") → "TThhee"
  
  String s = "";
  for (int i=0; i<str.length(); i++) {
    
    // get each char, and add them to the result string with "=" and "+".
    char ch = str.charAt(i);
    s = s + ch + ch; 
  }
  return s;
}
public int countHi(String str) {

// Return the number of times that the string "hi" appears anywhere in the given string.
// countHi("abc hi ho") → 1

  int count = 0;
  
  for (int i=0; i < str.length()-1; i++) { // Loop to length-1 so we can access index i and i+1 in the loop.
    if (str.substring(i, i+2).equals("hi")) count++; // pull out a substring and test it with .equals("hi"), and if so increment a count
  }
  return count;  
}
public boolean endOther(String a, String b) {
  
// endOther("Hiabc", "abc") → true
// endOther("AbC", "HiaBc") → true
// endOther("abc", "abXabc") → true

    a = a.toLowerCase(); // first, return the lowercase version of a string
    b = b.toLowerCase();
    boolean test1 = a.length() >= b.length() // to avoid out of bound
            && a.substring(a.length() - b.length()).equals(b); // now, compare
    boolean test2 = b.length() >= a.length() 
            && b.substring(b.length() - a.length()).equals(a);
    return test1 || test2;
}
public boolean xyzThere(String str) {
  
// Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). 
// xyzThere("abcxyz") → true
// xyzThere("abc.xyz") → false
// xyzThere("xyz.abc") → true
  
  // always check length before using sub
  if (str.length() >= 3 && str.substring(0, 3).equals("xyz")) return true;
  
  // Loop to length-3 so we can access index i+3 in the loop.
  for (int i=0; i < str.length()-3; i++) {
    if (str.substring(i+1, i+4).equals("xyz") && str.charAt(i) != '.')
      return true;
  }
  return false;
}
public boolean xyBalance(String str) {
  
// We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. 
// xyBalance("aaxbby") → true
// xyBalance("aaxbb") → false
// xyBalance("yaaxbb") → false

  int y = -1; // no y
  
  for (int i=str.length()-1; i>=0; i--) {
    if (str.charAt(i) == 'y') y = i; // Rightmost y if exists
    if (str.charAt(i) == 'x' && i > y) return false; // x is after y -- out
  }
  
  return true; 
}
public String mixString(String a, String b) {
  
//Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, 
// the second char of b, and so on. Any leftover chars go at the end of the result.
// mixString("abc", "xyz") → "axbycz"
// mixString("Hi", "There") → "HTihere"
// mixString("xxxx", "There") → "xTxhxexre"

  int lenA = a.length();
  int lenB = b.length();
  
  String s = "";
  
  // add char alternately -- loop
  for (int i=0; i < Math.min(lenA, lenB); i++) { // fxn rather than ternary xD
    s = s + a.charAt(i) + b.charAt(i);
  }
  
  // add leftovers -- sub
  return (lenA < lenB) ? (s + b.substring(lenA)) : (s + a.substring(lenB)); // (if this) ? (then this) : (otherwise this)
}
public boolean xyzMiddle(String str) {
// Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left 
// and right of the "xyz" must differ by at most one. This problem is harder than it looks.
// xyzMiddle("AAxyzBB") → true
// xyzMiddle("AxyzBB") → true
// xyzMiddle("AxyzBBB") → false

  int len = str.length();
  
  // xyz must present + to avoid out of bound
  if (len < 3) return false;
  
  // odd: check midsub (1 case)
  if (len % 2 == 1) 
    return str.substring(len/2 - 1, len/2 + 2).equals("xyz");
  
  // even: check midsub (2 cases)
  return str.substring(len/2 - 2, len/2 + 1).equals("xyz")
      || str.substring(len/2 - 1, len/2 + 2).equals("xyz");
}
