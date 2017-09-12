package assignment4.karen.raymond;

public class Sieve {

	// Method to find all primeNumbers less than or equal to the user's input.

	public void sieveOfEratosthenes(int n) {
		boolean[] primeNumbers = new boolean[n + 1];
		for (int i = 2; i < primeNumbers.length; i++) {
			primeNumbers[i] = true;
		}
		int num = 2;
		while (true) {
			for (int i = 2;; i++) {
				int multiple = num * i;
				if (multiple > n) {
					break;
				} else {
					primeNumbers[multiple] = false;
				}
			}
			boolean nextNumFound = false;
			for (int i = num + 1; i < n + 1; i++) {
				if (primeNumbers[i]) {
					num = i;
					nextNumFound = true;
					break;
				}
			}
			if (!nextNumFound) {
				break;
			}
		}
		for (int i = 0; i < primeNumbers.length; i++) {
			if (primeNumbers[i]) {
				System.out.println(i);
			}
		}
	}

	// Driver for the sieveOfEratosthenes method.

	public static void main(String args[]) {

		/*
		 * Ant build files allow values to be passed using args[]. Parses a signed
		 * decimal integer from args[] which is then passed to the sieveOfEratosthenes
		 * method.
		 */

		int primeMax = Integer.parseInt(args[0]);

		// Prints all prime numbers less than or equal to the input.

		System.out.println("The following list of numbers are prime and "
				+ "smaller than or equal to " + primeMax +".");
		Sieve sieve = new Sieve();
		sieve.sieveOfEratosthenes(primeMax);
	}
}
