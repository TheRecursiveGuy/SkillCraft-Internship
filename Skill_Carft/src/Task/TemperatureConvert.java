//Problem 1:- Convert temperature between celsius, fahrenheit, kelvin.

package Task;

import java.util.*;
public class TemperatureConvert {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitTocelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinTocelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5.0 / 9.0;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return 1.8 * (kelvin - 273.15) + 32;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Type 1 for : celsius to fahrenheit");
            System.out.println("Type 2 for : fahrenheit to celsius");
            System.out.println("Type 3 for : celsius to kelvin");
            System.out.println("Type 4 for : kelvin to celsius");
            System.out.println("Type 5 for : fahrenheit to kelvin");
            System.out.println("Type 6 for : kelvin to fahrenheit");

            System.out.print("Enter your choice: ");
            int n = in.nextInt();

            if (n > 0 && n <= 6) {
                switch (n) {
                    case 1:
                        System.out.print("Enter temperature in celsius: ");
                        double celsius = in.nextDouble();
                        System.out.println("Temperature in fahrenheit is: " + celsiusToFahrenheit(celsius));
                        break;

                    case 2:
                        System.out.print("Enter temperature in Fahrenheit: ");
                        double fahrenheit = in.nextDouble();
                        System.out.println("Temperature in celsius is: " + fahrenheitTocelsius(fahrenheit));
                        break;

                    case 3:
                        System.out.print("Enter temperature in celsius: ");
                        double celsius1 = in.nextDouble();
                        System.out.println("Temperature in kelvin is: " + celsiusToKelvin(celsius1));
                        break;

                    case 4:
                        System.out.print("Enter temperature in Kelvin: ");
                        double kelvin = in.nextDouble();
                        System.out.println("Temperature in celsius is: " + kelvinTocelsius(kelvin));
                        break;

                    case 5:
                        System.out.print("Enter temperature in Fahrenheit: ");
                        double fah = in.nextDouble();
                        System.out.println("Temperature in kelvin is: " + fahrenheitToKelvin(fah));
                        break;

                    case 6:
                        System.out.print("Enter temperature in Kelvin: ");
                        double kel = in.nextDouble();
                        System.out.println("Temperature in fahrenheit is: " + kelvinToFahrenheit(kel));
                        break;
                }
            } else {
                System.out.println("Enter a number from 1 to 6 !!!");
                System.out.println("Re-run the program");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number from 1 and 6 .");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
