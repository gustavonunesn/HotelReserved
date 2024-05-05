package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			String dateIn = sc.next();
			LocalDate checkIn = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			String dateOut = sc.next();
			LocalDate checkOut = LocalDate.parse(dateOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dateIn = sc.next();
			checkIn = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dateOut = sc.next();
			checkOut = LocalDate.parse(dateOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);			
		
		}
		catch(DateTimeParseException d) {
			System.out.println("Wrong date. Type again.");
		}
		catch(DomainExceptions de) {
			System.out.println("Error in reservation: " + de.getMessage());
		}
		catch(RuntimeException z) {
			System.out.println("Wrong type.");
		}
		
	}
}


