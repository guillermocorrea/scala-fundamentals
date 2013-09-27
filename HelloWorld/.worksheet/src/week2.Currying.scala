package week2

object Currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(214); 
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(91); 
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(87); 
  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$0 = 

  product(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(20); val res$1 = 
  sum(x => x)(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(45); 

  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(10); val res$2 = 
  fact(5);System.out.println("""res2: Int = """ + $show(res$2))}
}
