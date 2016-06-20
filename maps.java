public Map wordCount(String[] strings) {
given an array of strings, return a Map<String, Integer> with a key for each different string, 
with the value the number of times that string appears in the array.
  Map map = new HashMap ();
  for (String s:strings) {
    
    if (!map.containsKey(s)) {  // first time we've seen this string
      map.put(s, 1);
    }
    else {
      int count = map.get(s);
      map.put(s, count + 1);
    }
  }
  return map;
}
public String[] allSwap(String[] strings) {

We'll say that 2 strings "match" if they are non-empty and their first chars are the same. 
Loop over and then return the given array of non-empty strings as follows: 
if a string matches an earlier string in the array, swap the 2 strings in the array. 
When a position in the arrays has been swapped, it no longer matches anything. 

allSwap(["ab", "ac"]) → ["ac", "ab"]
allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]

  // Make a Map<String, Integer> with the first char as the key and the index in the array as the value.
  Map<String, Integer> map = new HashMap();
  
  for (int i=0; i<strings.length; i++) {
    String key = strings[i].substring(0, 1);
    if (!map.containsKey(key)) map.put(key, i);
    
    else {
      int first = map.get(key);
      String temp = strings[i];
      strings[i] = strings[first];
      strings[first] = temp;
      
      // After doing a swap, remove that key so it won't match anything in the future.
      map.remove(key);
    }
  }
  
  return strings;
}
