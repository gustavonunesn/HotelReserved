package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	
	public Reservation() {
	}
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainExceptions{
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainExceptions("Check-out must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public Integer durationDays() {
		return (int) ChronoUnit.DAYS.between(checkIn,checkOut);
	}
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainExceptions {
		
		LocalDate now = LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainExceptions("Reservation dates for updates must be future.");
		}
		else if (!checkOut.isAfter(checkIn)){
			throw new DomainExceptions("Check-out must be after check-in date.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public String toString() {
		return "Reservation: Room " + roomNumber + ", check-in: " + checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
				", check-out: " + checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", duration: " + durationDays() + " nights";
	}
}
