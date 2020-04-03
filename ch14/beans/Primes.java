package com.awl.jspbook.ch14;

import org.apache.jasper.runtime.*;

public abstract class Primes extends HttpJspBase {
  int primes[];

  public void jspInit() {
    /* Pre-populate the first 100 primes */
    primes(100);
  }

  /**
   * We don't need to do anything when the JSP
   * is destroyed, but we still need to provide
   * this method to satisfy the interface.
   */
  public void jspDestroy() {
    return;
  }

  public int primes(int n) {
    if(primes != null && n < primes.length) {
      return primes[n-1];
    }
    
    int oldPrimes[] = primes;
    primes          = new int[n];
    
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
}
