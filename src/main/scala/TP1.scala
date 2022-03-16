object TP1Ex1:


  /* Définissez les opérateurs booléens suivants en utilisant des expressions conditionnelles
   * et les valeurs 'true' et 'false' */
  def not(b: Boolean): Boolean = if(b) false else true

  def and(l: Boolean, r: Boolean): Boolean = if(l) if(r) true else false else false

  def or(l: Boolean, r: Boolean): Boolean = if(l) true else if(r) true else false

  def xor(l: Boolean, r: Boolean): Boolean = if(l) if (r) false else true else if(r) true else false

  /* Définissez la valeur absolue d'un nombre */
  def abs(x: Double): Double = if(x < 0) -x else x

  /* Définissez la factorielle d'un nombre positif à l'aide d'une fonction récursive */
  def factorial(n: BigInt): BigInt =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else
      if n == 0 then
        1
      else
        n * factorial(n-1)

  /* Définissez l'exponentiation à l'aide d'une fonction récursive */
  def power(b: BigInt, n: Int): BigInt =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else
      if n == 0 then
        1
      else
        b * power(b,n-1)

  /* Définissez une fonction récursive qui calcule la somme des entiers de n à m (inclus). */
  def sumSegment(n: Int, m: Int): Int =
    if n > m then
      0
    else
      if n == m then
        m
      else
        n + sumSegment(n+1,m)

  /* Définissez une fonction non-récursive qui effectue le même calcul.
   *
   * Indication: utilisez la formule pour calculer la somme des n premiers entiers: n * (n + 1) / 2 */
  def fastSumSegment(n: Int, m: Int): Int =
    m * (m + 1) / 2 - (n-1) * (n )/2

  /* Définissez une fonction récursive qui calcule la représentation en binaire d'un entier n */
  def binaryString(n: Int): String =
    if n == 0 then "0"
    else if n == 1 then "1"
    else if n == -1 then "-1"
    else binaryString(n/2) + n%2



  /* Définissez une fonction qui calcule le PGCD de deux nombres, en vous basant sur l'algorithme d'Euclide */
  def gcd(a: Int, b: Int): Int =
    if a < 0 then gcd(-a,b)
    else if b < 0 then gcd(a,-b)
    else if b == 0 then a
    else if a == 0 then 0
    else gcd(b,a%b)

  @main def mainTP1Ex1 =
    println("Hello, world!")
    println(s"not(${true}) is ${not(true)}")
    println(s"and(${true}, ${false}) is ${and(true, false)}")
    println(s"or(${true}, ${false}) is ${or(true, false)}")
    println(s"xor(${true}, ${false}) is ${xor(true, false)}")
    val x = -1.895
    println(s"the absolute value of ${x} is ${abs(x)}")
    val n = 6
    println(s"the factorial of ${n} is ${factorial(n)}")
    val b1 = 9
    val n1 = 5
    println(s"${b1} raised to the power of ${n1} is ${power(b1, n1)}")
    val n3 = 3
    val m3 = 9
    println(s"the sum of integers from ${n3} to ${m3} is ${sumSegment(n3, m3)}")
    val n4 = 18
    val m4 = 29
    println(s"the sum of integers from ${n4} to ${m4} is ${sumSegment(n4, m4)}")
    println(s"the binary representation of ${n4} is ${binaryString(n4)}")
    val a = 64
    val b = 24
    println(s"the greatest commond divisor of ${a} and ${b} is ${gcd(a, b)}")