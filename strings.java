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
public String getSandwich(String str) {
  
// A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance 
// of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.

  // calls to indexOf() to figure out the index numbers
  int start = str.indexOf("bread");
  int end = str.lastIndexOf("bread");
  
  // -1 (nothing) or same i (one bread)
  if (start == end) return "";
  
  // pull out the text inside
  return str.substring(start+5, end);
  
}
public String zipZap(String str) {
// Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. 
// Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".

  for (int i=0; i < str.length() - 2; i++) 
    if (str.charAt(i) == 'z' && str.charAt(i+2) == 'p')
      str = str.substring(0, i+1) + str.substring(i+2); // nice trick to delete [i+1] in str
  return str;
}
public static String starOut(String s) {
  // Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and 
  // right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
  
  StringBuilder sb = new StringBuilder(); 
  
  // Step through all the characters in the string.   
  for (int i = 0; i < s.length(); i++) {
    
    // If you land on an asterisk, don't record it.
    if (s.charAt(i) == '*') continue; 
      
    // Peek left, and if you see an asterisk, don't record it.
    if (i > 0 && s.charAt(i - 1) == '*') continue;
        
    // Peek right if you see an asterisk, don't record it.
    if (i < s.length() - 1 && s.charAt(i + 1) == '*') continue;
    
    // If none of the above things happen, record it.
    sb.append(s.charAt(i));
    }

  return sb.toString();
}
public String plusOut(String str, String word) {

// Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), 
// except for appearances of the word string which are preserved unchanged.

// plusOut("12xy34", "xy") → "++xy++"
// plusOut("12xy34", "1") → "1+++++"
// plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"

  String s = "";
  
  int found = str.indexOf(word); // find first instance
  
  for (int i=0; i < str.length(); i++) {
    
    if (i == found) { // if word is here
      s = s + word; // add word
      found = str.indexOf(word, found + word.length()); // find next instance
      i = i + word.length()-1; // move i past word
    }
    else s = s + "+"; // if word is not here (later or -1), just add +
  }
  return s;
}
public String wordEnds(String str, String word) {

// Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word 
// in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.

// wordEnds("abcXY123XYijk", "XY") → "c13i"
// wordEnds("XY123XY", "XY") → "13"
// wordEnds("XY1XY", "XY") → "11"

  String s = "";
  int i=0;
  while (i < str.length()) {
    int found = str.indexOf(word, i); // find word
    if (found == -1) break; 
    
    int before = found-1; // flag pos
    int after = found + word.length();
    
    if (before >= 0) s = s + str.charAt(before); // do something with [pos]
    if (after <= str.length()-1) s = s + str.charAt(after);
    
    i = after; // advance i to start the next iteration
  }
  return s;
}
public int countYZ(String str) {
// Given a string, count the number of words ending in 'y' or 'z' -- 
// so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). 
// We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. 
// (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
// countYZ("fez day") → 2

  str = str.toLowerCase() + " "; // to handle last char == y
  int count = 0;
  for (int i=0; i < str.length()-1; i++) {
    if (!Character.isLetter(str.charAt(i+1)) && (str.charAt(i) == 'y' || str.charAt(i) == 'z')) 
      count++;
  }
  return count;
}
public String withoutString(String base, String remove) {
// Given two strings, base and remove, 
// return a version of the base string where all instances of the remove string have been removed (not case sensitive). 

// withoutString("Hello there", "llo") → "He there"
// withoutString("xxx", "xx") → "x"	

  String s = "";
  int found = base.toLowerCase().indexOf(remove.toLowerCase()); // not case sensitive
  
  while (found != -1) {
    s += base.substring(0, found);
    base = base.substring(found + remove.length());
    found = base.toLowerCase().indexOf(remove.toLowerCase());
  }
  
  s += base;
  return s;
}
public boolean equalIsNot(String str) {
// Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances 
// of "not" anywhere in the string (case sensitive).
  return helper(str, "is") == helper(str, "not");
}
public int helper(String str, String word) { 
  int count = 0;
  
  for (int i=0; i <= str.length() - word.length(); i++) // handles different edge cases for us!
    if (str.substring(i, i + word.length()).equals(word)) 
      count++;
      
  return count;
}
public int sumDigits(String str) {
// Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. 
  int sum=0;
  
  for (int i=0; i < str.length(); i++) 
    if (Character.isDigit(str.charAt(i))) // tests if a char is one of the chars '0', '1', .. '9'
      sum += Integer.parseInt(str.substring(i, i+1)); // converts a string to an int
      
  return sum;
}
public String notReplace(String str) {
// Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". 
// The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. 
// (Note: Character.isLetter(char) tests if a char is a letter.)

// notReplace("is test") → "is not test"
// notReplace("is-is") → "is not-is not"
// notReplace("This is right") → "This is not right"

  // make new string
  String s = "";
  
  // step through all chars in str
  for (int i=0; i < str.length(); i++) { // do not use indexOf() + while loop to find all instances 
    
    // if "is" here, add "is not" to s, advance i past "is"
    if (i < str.length()-1 && str.substring(i, i+2).equals("is")) {
      
      boolean letterBefore = i > 0 && Character.isLetter(str.charAt(i-1));
      
      boolean letterAfter = i < str.length()-2 && Character.isLetter(str.charAt(i+2));
                  
      if (!letterBefore && !letterAfter) { // only add if there's no letter before or after
        s += "is not"; 
        i++;
        continue;
      }
    }
    
    // else just add current char to s
    s += str.charAt(i);
  }
  return s;
}

