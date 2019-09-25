package edu.cnm.deepdive;

import java.math.BigInteger;
import java.util.Iterator;

public class Fibonacci implements Iterable<BigInteger> {

  private final int length;

  public Fibonacci(int length) {
    this.length = length;
  }

  @Override
  public Iterator<BigInteger> iterator() {
    return new FibIterator(length);
  }

  private static class FibIterator implements Iterator<BigInteger> {

    private final int length;
    private int generated;
    private BigInteger prev = BigInteger.valueOf(-1);
    private BigInteger curr = BigInteger.ONE;

    public FibIterator(int length) {
      this.length = length;
    }

    @Override
    public boolean hasNext() {
      return generated < length;
    }

    @Override
    public BigInteger next() {
      generated++;
      BigInteger next = prev.add(curr);
      prev = curr;
      curr = next;
      return curr;
    }

  }

}
