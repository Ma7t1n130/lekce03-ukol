import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String firstName;
    private String surName;
    private LocalDate birthDate;

    // region vygenerovany_kod
    public Guest(String firstName, String surName, LocalDate birthDate) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription(){
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.firstName + " " + this.surName + ", narozen(a) " + this.birthDate.format(dateFormater);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Host{" +
                "jmeno='" + firstName + '\'' +
                ", prijmeni='" + surName + '\'' +
                ", narozen(a)=" + birthDate.format(dateFormater)+
                '}';
    }

    // endregion

}
