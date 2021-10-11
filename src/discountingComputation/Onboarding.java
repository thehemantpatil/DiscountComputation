package discountingComputation;

public class Onboarding {
	/*
	 * This class contains onboardingScreen method. Which is calling from main
	 * method of interestCalculator, This method is for printing the onboarding
	 * messages. It will print initial messages to user like What's a purpose of App
	 * and Welcome greeting.
	 * 
	 */

	public void onboardingScreen(double maturityAmount, double interestRate, int desiredAge) {

		System.out.println("Welcome to Discount Computation..");
		System.out.println();

		String amountInterstMessage = String.format(
				"It will calculate the Principle amount if you want %.2f amount at the age of %d with an " +
		        "Annual Rate of %.2f per year.", maturityAmount,
				desiredAge, interestRate);

		System.out.println(amountInterstMessage);
		System.out.println();

	}
}
