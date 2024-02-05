import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum TypeOfVacation {WORK,HOLIDAY};

public class Main {
    static List<Room> roomList = new ArrayList<>();
    static BookingManager bookingManager = new BookingManager();
    private static Room getRoomByNumber(int roomNumber, List<Room> roomList) throws Exception{
        for (Room room: roomList){
            if (room.getRoomNumber()==roomNumber){
                return room;
            }
        }
        throw new Exception("Neexistujici pokoj!");
    }

    private static void fillRooms(){
        roomList.add(new Room(1,1,true,true, BigDecimal.valueOf(1000)));
        roomList.add(new Room(2,1,true,true, BigDecimal.valueOf(1000)));
        roomList.add(new Room(3,3,false,true, BigDecimal.valueOf(2400)));
    }

    private static void fillBookings() throws Exception{
        //Karel Dvořák, narozen 15. 5. 1990, si rezervuje pokoj číslo 3 od 1. 6. 2023 do 7. 6. 2023. Bude to pracovní pobyt.
        bookingManager.addBooking(new Booking(getRoomByNumber(3,roomList),
                LocalDate.of(2023,6,1),
                LocalDate.of(2023,6,7),
                TypeOfVacation.WORK,
                new Guest("Karel","Dvořák",LocalDate.of(1990,5,15))));
        //Jiný pan Karel Dvořák, narozen 3. 1. 1979, si rezervuje pokoj číslo 2 od 18. 7. 2023 do 21. 7. 2023. Bude to rekreační pobyt.
        bookingManager.addBooking(new Booking(getRoomByNumber(2,roomList),
                LocalDate.of(2023,7,18),
                LocalDate.of(2023,7,21),
                TypeOfVacation.HOLIDAY,
                new Guest("Karel","Dvořák",LocalDate.of(1979,1,3))));
        /*
        Fyzioterapeutka Karolína Tmavá si pro své klienty rezervuje pokoj číslo 2 na dvoudenní pobyty v měsíci srpnu. Vytvoř 10 dvoudenních rezervací pro rekreační pobyty:
            První rezervace bude od 1. do 2. 8.,
            druhá od 3. do 4. 8.
            třetí od 5. do 6. 8.
            a tak dále. Poslední rezervace bude od 19. do 20. 6. Karolína bude uvedena jako jediný host.
        */
        Guest karolinaTmava = new Guest("Karolína","Tmavá",LocalDate.of(1970,1,1));
        Room room2=getRoomByNumber(2,roomList);
        for(int i=1;i<20;i=i+2){
            bookingManager.addBooking(new Booking(room2,
                    LocalDate.of(2023,8,i),
                    LocalDate.of(2023,8,i+1),
                    TypeOfVacation.HOLIDAY,
                    karolinaTmava));
        }
        //Fyzioterapeutka Karolína Tmavá z předchozího úkolu si dále rezervuje pokoj číslo 3 na celý srpen (od 1.8. do 31.8.).
        bookingManager.addBooking(new Booking(getRoomByNumber(3,roomList),
                LocalDate.of(2023,8,1),
                LocalDate.of(2023,8,31),
                TypeOfVacation.WORK, //Fyzioterapeutka to má asi jako práci
                karolinaTmava));
    }

    private static void showAllBookings(){
        for(Booking booking: bookingManager.getBookings()){
            System.out.println(booking.customPrint());
        }
    }

    private static void showBookings(int numberOfShowBooking, TypeOfVacation typeOfVacation){
        int counter = 0;
        for(Booking booking: bookingManager.getBookings()){
            if (booking.getTypeOfVacation()==typeOfVacation){
                System.out.println(booking.customPrint());
                counter++;
                if (counter>=numberOfShowBooking){
                    return;
                }
            }
        }
    }

    private static void printGuestsStatistics(){
        int oneGuestBooking = 0;
        int twoGuestBooking = 0;
        int moreGuestBooking = 0;
        for(Booking booking: bookingManager.getBookings()){
            if(booking.getNumberOfGuests()==1){
                oneGuestBooking++;
            } else if (booking.getNumberOfGuests()==2) {
                twoGuestBooking++;
            } else {
                moreGuestBooking++;
            }
        }
        System.out.println("Počet rezervací s jedním hostem = "+oneGuestBooking);
        System.out.println("Počet rezervací se dvěma hosty = "+twoGuestBooking);
        System.out.println("Počet rezervací s víc než dvěma hosty = "+moreGuestBooking);
    }
    public static void main(String[] args) throws Exception{
        //vytvoření pokojů
        fillRooms();
        System.out.println("Výpis pokojů");
        roomList.forEach(System.out::println);
        //vytvoření rezervací
        fillBookings();
        //V hlavní třídě projektu připrav metodu pro výpis seznam všech rezervací
        System.out.println("Celkový počet rezervací je "+bookingManager.getBookings().size());
        System.out.println("Výpis všech rezervací");
        showAllBookings();
        //Připrav metodu pro výpis prvních 8 rezervací, které jsou určeny pro rekreaci
        System.out.println("Výpis prvních osmi rekreačních rezervací");
        showBookings(8,TypeOfVacation.HOLIDAY);
        System.out.println("Statistika podle počtu hostů");
        printGuestsStatistics();
    }
}