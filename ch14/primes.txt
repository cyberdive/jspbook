<%!

  public int primes(int n) {
    if(n < 2)  return 2;
    if(n == 2) return 3;
    
    int primes[] = new int[n];
    primes[0]    = 2;
    primes[1]    = 3;
    
    int candidate = 5;
    int numSoFar  = 2;
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

