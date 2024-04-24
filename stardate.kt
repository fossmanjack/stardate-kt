// stardate.kt
// 2024-04-21 (77768)
// Using an epoch of 15 July 1946 00:00:00 UTC = Stardate 0000.0

import kotlin.math.round
import java.math.RoundingMode
import java.time.Instant
import java.time.format.DateTimeParseException

val EPOCH: Double = -740534400.0		// Unix epoch 1946-07-15T00:00:00.000T
val MODULUS: Double = 31_558.1184		// 100y / 10000

/**
 *
 */
fun getStardateFromInstant(timestamp: Instant): Double {
	var secs: Double = (timestamp.toEpochMilli() / 1000).toDouble()

	var stardateEpochSecond: Double = secs - EPOCH
	stardateEpochSecond /= MODULUS

	return stardateEpochSecond.toBigDecimal().setScale(4, RoundingMode.HALF_UP).toDouble()
}

/**
 *
 */
fun getInstantFromStardate(stardate: Double): Instant {
	var ret: Double = stardate * MODULUS
	ret += EPOCH

	return Instant.ofEpochMilli(ret.toLong())

	//throw Exception("Not yet implemented")
}

/**
 *
 */
fun main(args: Array<String>) {
	var timestamp: Instant

	if(args.size == 0) timestamp = Instant.now()
	else
		try {
			timestamp = Instant.parse(args.joinToString(" "))
		} catch (e: DateTimeParseException) {
			println(e.message)
			return
		}

	print(getStardateFromInstant(timestamp))
}

