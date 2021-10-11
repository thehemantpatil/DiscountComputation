package discountingComputation;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PrincipalCalculator {

	public static void main(String[] args) {
		try {
		// FileReader object to read config file which contains amount, interest rate,
		// duration.
		FileReader reader = new FileReader("config");
		Properties properties = new Properties();

		properties.load(reader);

		// fetching values from the config file and assigning to the variable
		double maturityAmount = Double.parseDouble(properties.getProperty("maturityAmount"));
		double interestRate = Double.parseDouble(properties.getProperty("interestRate"));
		int desiredAge = Integer.parseInt(properties.getProperty("desiredAge"));
		int duration = desiredAge - Integer.parseInt(properties.getProperty("myAge"));

		Onboarding onboarding = new Onboarding();
		onboarding.onboardingScreen(maturityAmount, interestRate, desiredAge);
		
		double principalAmount = principalAmountCalculator(maturityAmount, interestRate / 100, duration);
		
		printOutput(maturityAmount, interestRate, principalAmount, duration);
		
	} catch(Exception e) {
		System.out.println(e.toString());
	}
		
	}

	public static double principalAmountCalculator(double maturityAmount, double interestRate, int duration) {
		double principleAmount = maturityAmount/Math.pow((1+interestRate), duration);
		return principleAmount;
	}
	
	public static void printOutput(double maturityAmount, double interestRate, double principal, int duration) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println();

		System.out.println("Result:- ");
		System.out.println();
		System.out.println(String.format("Amount Needed in %d years           : ", duration) + "             "
				+ String.format("%.2f", maturityAmount));
		System.out.println("Rate of interest                    : " + "              "
				+ String.format("%.2f", interestRate) + "%");
		System.out.println("Today’s Date                        : " + "              " + ft.format(dNow));
		System.out.println("Amount to be invested today         : " + "              "
				+ String.format("%.2f", principal));

	}
		
}
