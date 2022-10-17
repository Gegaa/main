import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val fra = Fraction(1, 3)
    val fra2 = Fraction(2, 6)
    println(fra.add(fra2))


}

class Point(private val a: Double, private val b:Double) {

    override fun toString(): String {
        return "a=$a, b=$b"
    }

    private val negA = -a
    private val negB = -b

    fun symmetric(): String {
        return "a=$negA, b=$negB"
    }

    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }

    fun length(obj: Point): Double {
        val l: Double = this.a - obj.a
        val h: Double = this.b - obj.b
        return sqrt(l.pow(2.0) + h.pow(2.0))
    }
}
class Fraction(private var numerator: Int, private var denominator: Int){
    fun cut():String{
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    fun mult(frc:Fraction):String{
        val x : Int = numerator*frc.numerator
        val y : Int = denominator*frc.denominator
        return  "$x / $y"
    }

    fun add(frc:Fraction):String{
        var x1:Int = numerator
        var y1:Int = denominator
        var x2:Int = frc.numerator
        var y2:Int = frc.denominator
        val tmp:Int = denominator
        if (denominator!=frc.denominator){
            x1*=y2
            y1*=y2
            x2*=tmp
            y2*=tmp
        }
        var sm :Int = x1+x2
        var ct = Fraction(sm, y2)
        return ct.cut()
    }
}

