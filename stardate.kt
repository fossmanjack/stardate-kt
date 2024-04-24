// stardate.kt
// 2024-04-21 (77768)
// Using an epoch of 15 July 1946 00:00:00 UCT = Stardate 0000.0

import kotlin.math.round
import java.math.RoundingMode
import java.time.Instant

fun main(args: Array<String>) {
	var timestamp: Instant
	val epoch = -740534400 						// Unix epoch 1946-07-15
	val modulus = 31_558.1184

	if(args.size == 0) timestamp = Instant.now()
	else timestamp = Instant.parse(args.joinToString(" "))

	print(getStardateFromInstant(timestamp))
}

fun getStardateFromInstant(timestamp: Instant): Double {
	var secs: Double = (timestamp.toEpochMilli() / 1000).toDouble()
	val epoch = -740534400
	val modulus = 31_558.1184

	var stardateEpochSecond: Double = secs - epoch
	stardateEpochSecond /= modulus

	return stardateEpochSecond.toBigDecimal().setScale(4, RoundingMode.HALF_UP).toDouble()
}

fun getInstantFromStardate(stardate: Double): Instant {

	return Instant.now()
}

/*
fun main() {
	var now = System.currentTimeMillis() / 1000
	val epoch = -740534400 							// Unix epoch 1946-07-15
	val modulus = 31_558.1184 						// 100y / 10_000

	var epochTime = now - epoch
	var stardateRaw = epochTime / modulus
	val stardate = stardateRaw.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

	print(stardate)



}
*/

/* NOTES

Algorithm:

- Current time in ms (double?)
- Subtract epoch timestamp in ms
- Divide my modulus (average length-of-year in seconds / 1000 star"days" per year)

I guess another way to do the rounding would be to multiply by the scale of the
modulus (10_000 in this case), do the needed arithmetic, then divide by 1000

This works though

 *
 *
*/

