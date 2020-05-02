package MonteCarlo;

class RandomStrings {
  public static void main(String[] args) {
    String word;
    int n = 1000;
    word = createLower(n);
    System.out.println(word);
    
    //task 2 - create the method for findWord... scroll down
    boolean found;
    String sub = "fun";
    found = findWord(word, sub);
    System.out.println(found);
  }
  
  //method - create a random string of lowercase letters
  public static String createLower(int len){
    //declarations
    char c;
    String s = "";
    //check for n == 0 empty string
    if(len == 0){
      return "";
    }
    
    //build the string
    for (int i = 0; i < len; i++){
      //create a lower case character
      c = (char)(Math.random() * 26 + 97);
      //concatenate the new character to the string
      s += String.valueOf(c);
    }
    return s;
  }
  
  //type your function code here - method findWord(word, sub)
  public static boolean findWord (String word, String sub){
    boolean found = false;
    int subLen = sub.length();
    int wordLen = word.length();
    if(subLen > wordLen) return false;
    for(int i = 0; i <= wordLen - subLen; i++){
      if(word.substring(i, i + subLen).equals(sub)) return true;
    }
    return false;
  }
}