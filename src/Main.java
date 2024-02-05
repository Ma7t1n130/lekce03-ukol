import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum TypeOfVacation {WORK,HOLIDAY};

public class Main {
    private static Room getRoomByNumber(int roomNumber, List<Room> roomList) throws Exception{
        for (Room room: roomList){
            if (room.getRoomNumber()==roomNumber){
                return room;
            }
        }
        throw new Exception("Neexistujici pokoj!");
    }
    public static void main(String[] args) throws Exception{

        //vytvoření hostů
        List<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest("Adéla","Malíková", LocalDate.of(1993,3,13)));
        guestList.add(new Guest("Jan","Dvořáček", LocalDate.of(1995,5,5)));
        guestList.forEach(System.out::println);
        for (Guest guest: guestList){
            System.out.println(guest.getDescription());
        }

        //vytvoření pokojů
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(1,1,true,true, BigDecimal.valueOf(1000)));
        roomList.add(new Room(2,1,true,true, BigDecimal.valueOf(1000)));
        roomList.add(new Room(3,3,false,true, BigDecimal.valueOf(2400)));
        roomList.forEach(System.out::println);

        //rezervace
        List<Booking> bookingList = new ArrayList<>();
        //vytvoření rezervace pro jednoho hosta na pokoj číslo 1
        Booking booking = new Booking(
                getRoomByNumber(1,roomList),
                LocalDate.of(2021,7,19),
                LocalDate.of(2021,7,26),
                TypeOfVacation.WORK,
                guestList.getFirst() //první a jediný host je Adéla Malíková, pro jednoduchost, "první" z listu
        );
        bookingList.add(booking);
        //vytvoření rezervace pro dva hosty na pokoj číslo 3
        booking = new Booking(
                getRoomByNumber(3,roomList),
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),
                TypeOfVacation.HOLIDAY,
                guestList.getFirst() //první host je Adéla Malíková
        );
        booking.addGuest(guestList.getLast()); //přidat Jana Dvořáčka do rezervace, pro jednoduchost toho "posledniho" z listu
        bookingList.add(booking);
        //rezervace bez datumu, tedy checkIn=dnes, checkOut = dnes + 6 dní
        booking = new Booking(
                getRoomByNumber(2,roomList),
                TypeOfVacation.HOLIDAY,
                guestList.getFirst() //první host je Adéla Malíková
        );
        bookingList.add(booking);

        //vypsat rezervace
        bookingList.forEach(System.out::println);


    }
}