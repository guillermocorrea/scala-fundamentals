package week2

object Currying {
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res0: Int = 144
  sum(x => x)(1, 4)                               //> res1: Int = 10

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  fact(5)                                         //> res2: Int = 120
}