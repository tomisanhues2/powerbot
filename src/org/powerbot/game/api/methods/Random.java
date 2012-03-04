package org.powerbot.game.api.methods;

public class Random {
	public static final java.util.Random random = new java.util.Random();

	public static boolean nextBoolean() {
		return random.nextBoolean();
	}

	public static int nextInt(final int min, final int max) {
		if (max < min) {
			return max + random.nextInt(min - max);
		}
		return min + (max == min ? 0 : random.nextInt(max - min));
	}

	public static double nextDouble(final double min, final double max) {
		return min + random.nextDouble() * (max - min);
	}

	public static double nextDouble() {
		return random.nextDouble();
	}

	public static int nextGaussian(final int min, final int max, final int sd) {
		return nextGaussian(min, max, min + (max - min) / 2, sd);
	}

	public static int nextGaussian(final int min, final int max, final int mean, final int sd) {
		if (min == max) {
			return min;
		}
		int rand;
		do {
			rand = (int) (random.nextGaussian() * sd + mean);
		} while (rand < min || rand >= max);
		return rand;
	}
}