//Problem 2:-build a program that generates a random number and asks the user to guess it.

package Task;
import java.util.*;
public class RandomNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("System is generating a random number.........");
		
		int randomNo=(int)((Math.random()*10)+1);

		System.out.print("Enter a number between 1 and 10 -->");
		int n=in.nextInt();
		
		if(n==randomNo) {
			System.out.println("yipeee!! You have guessed the correct number");
		}
		else {
			System.out.println("Better luck next time!!");
			System.out.println("The system chose the number :"+randomNo);
		}
	}
}