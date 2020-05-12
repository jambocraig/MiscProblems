
package Primes;
class Jacob {
  public static void main(String[] args) { 
    int n = 10;
    //I would expect this to add the numbers 2, 3, 5, and 7
    //to output 17
    System.out.println(sumPrimes(n));
  }
  
  public static boolean isPrime(int n){
    int factorCount = 0;
    boolean result = true;
    if(n==1 || n==0){
      result = false;
      return result;
    }
    for(int i=1;i<=n;i++){
      int div = n%i;
      if(div==0){
        factorCount++;
      }

        
      }
    if(factorCount>2){
      result = false;
    }
    return result;
  }
  
  public static Integer sumPrimes(int n){
    int sumPrime = 0;
    for(int i=0;i<=n;i++){
      if(isPrime(i)){
        sumPrime=sumPrime+i;
      }
    }
    return sumPrime;
  }  
}