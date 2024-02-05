import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int numOfBed;
    private boolean isBalcony;
    private boolean isSeaLook;
    private BigDecimal pricePerNight;



    public Room(int roomNumber, int numOfBed, boolean isBalcony, boolean isSeaLook, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numOfBed = numOfBed;
        this.isBalcony = isBalcony;
        this.isSeaLook = isSeaLook;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumOfBed() {
        return numOfBed;
    }

    public boolean isBalcony() {
        return isBalcony;
    }

    public boolean isSeaLook() {
        return isSeaLook;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", numOfBed=" + numOfBed +
                ", isBalcony=" + isBalcony +
                ", isSeaLook=" + isSeaLook +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}
