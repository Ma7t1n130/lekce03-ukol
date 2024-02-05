import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    List<Guest> guestList = new ArrayList<>();
    private LocalDate checkIn;
    private LocalDate checkOut;
    private TypeOfVacation typeOfVacation;

    public Booking(Room room, LocalDate checkIn, LocalDate checkOut, TypeOfVacation typeOfVacation, Guest firstGuest) throws Exception {
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.typeOfVacation = typeOfVacation;
        this.addGuest(firstGuest);
    }

    public Booking(Room room, TypeOfVacation typeOfVacation, Guest firstGuest) throws Exception {
        this.room = room;
        this.checkIn = LocalDate.now();
        this.checkOut = checkIn.plusDays(6);
        this.typeOfVacation = typeOfVacation;
        this.addGuest(firstGuest);
    }

    public void addGuest(Guest guest) throws Exception{
        if (this.isEmptyBed()) {
            guestList.add(guest);
        } else {
            throw new Exception("Už není volná postel!");
        }
    }

    public boolean isEmptyBed(){
        return (this.guestList.size()<this.room.getNumOfBed());
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Booking{" +
                "room=" + room +
                ", guestList=" + guestList +
                ", checkIn=" + checkIn.format(dateFormater) +
                ", checkOut=" + checkOut.format(dateFormater) +
                ", typeOfVacation=" + typeOfVacation +
                '}';
    }
}
