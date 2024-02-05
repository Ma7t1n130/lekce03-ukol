import java.util.ArrayList;
import java.util.List;
public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking newBooking){
        bookingList.add(newBooking);
    }

    public Booking getBooking(int index) throws Exception {
        if((index>0) && (index<bookingList.size())){
            return bookingList.get(index);
        } else {
            throw new Exception("Booking not exist!");
        }
    }

    public List<Booking> getBookings(){
        return bookingList;
    }

    public void clearBookings(){
        bookingList.clear();
    }

    public int getNumberOfWorkingBookings(){
        int numberOfWorkingBookings = 0;
        for (Booking booking: bookingList){
            if (booking.getTypeOfVacation()==TypeOfVacation.WORK){
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }
    public double getAverageGuests(){
        int numOfGuests = 0;
        for (Booking booking: bookingList){
            numOfGuests=numOfGuests+booking.getNumberOfGuests();
        }
        if(bookingList.size()>0){
            return numOfGuests/bookingList.size();
        }
        return 0;
    }


}
