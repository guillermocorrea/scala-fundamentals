package week2
import math.abs

object FixedPoints {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  fixedPoint(x => 1 + x / 1)(0)                   //> res0: Double = 102.0
  def averageDamp(f: Double => Double)(x: Double) = {
    (x + f(x)) / 2
  }                                               //> averageDamp: (f: Double => Double)(x: Double)Double
  def squareRoot(x: Double) = fixedPoint(averageDamp(y => x / y))(1)
                                                  //> squareRoot: (x: Double)Double
  squareRoot(8)                                   //> res1: Double = 2.8284271250498643
  
}