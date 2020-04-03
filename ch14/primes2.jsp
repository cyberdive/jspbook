<%!
  int primes[];
%>

<%!
  public void jspInit() {
    /* Pre-populate the first 100 primes */
    primes(100);
  }
%>

<%!
  public int primes(int n) {
    if(primes != null && n < primes.length) {
      return primes[n-1];
    }
    
    int oldPrimes[] = primes;
    primes          = new int[n+1];
    
    int candidate;
    int numSoFar;
    
    if(oldPrimes != null) {
      System.arraycopy(oldPrimes,0,primes,0,oldPrimes.length-1);
      candidate = oldPrimes[oldPrimes.length-1];
      numSoFar  = oldPrimes.length;
    } else {
      primes[0] = 2;
      candidate = 3;
      numSoFar  = 1;
    }

    boolean maybePrime;
    
    while (numSoFar < n) {
      maybePrime = true;
      for(int i=0;i<numSoFar && maybePrime;i++) {
        maybePrime = (candidate % primes[i]) != 0;
      }
      
      if(maybePrime) {
        primes[numSoFar++] = candidate;
      }
      candidate++;
    }
    
    return primes[n-1];
  }
%>

<HTML>
<HEAD><TITLE>Primes</TITLE></HEAD>

<BODY>

<P>Here are the first 5 prime numbers:</P>

<UL>
<LI><%= primes(1) %>
<LI><%= primes(2) %>
<LI><%= primes(3) %>
<LI><%= primes(4) %>
<LI><%= primes(5) %>
</UL>

</BODY>
</HTML>

