// stardate.kt
// 2024-04-21 (77768)
// Using an epoch of 15 July 1946 00:00:00 UCT = Stardate 0000.0

import kotlin.math.round
import java.math.RoundingMode

fun main() {
	var now = System.currentTimeMillis() / 1000
	val epoch = -740534400 							// Unix epoch 1946-07-15
	//val modulus = 24159661.344 						// this isn't right
	val modulus = 31_558.1184 						// 100y / 10_000

	var epochTime = now - epoch
	var stardateRaw = epochTime / modulus
	val stardate = stardateRaw.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

	print(stardate)



}

/* NOTES

Algorithm:

- Current time in ms (double?)
- Subtract epoch timestamp in ms
- Divide my modulus (average length-of-year in seconds / 1000 star"days" per year)
- 

 *
 *
*/

