import java.text.DecimalFormat;
import java.util.Calendar;
public class VotePersonalIdentification {
    // Fields
    private String voterLastName;
    private String voterFirstName;
    private String voterSIN;
    private String voterAddress;
    private String voterProvince;
    private String voterCity;
    private String voterPostalCode;

    // Constructors
    // No-arg constructor
    public VotePersonalIdentification() {
        this.voterFirstName = "John";
        this.voterLastName = "Smith";
        this.voterSIN = "12456789";
        this.voterAddress = "123 Anywhere Street";
        this.voterCity = "Peterborough";
        this.voterProvince = "Ontario";
        this.voterPostalCode = "A1B 2C3";
    }
    // Arg constructor
    public VotePersonalIdentification(String voterFirstName, String voterLastName, String voterSIN, String voterAddress, String voterCity, String voterProvince, String voterPostalCode) {
        this.voterFirstName = voterFirstName;
        this.voterLastName = voterLastName;
        this.voterSIN = voterSIN;
        this.voterAddress = voterAddress;
        this.voterCity = voterCity;
        this.voterProvince = voterProvince;
        this.voterPostalCode = voterPostalCode;
    }

    // Getters
    public String getVoterLastName() { return this.voterLastName; }
    public String getVoterFirstName() { return this.voterFirstName; }
    public String getVoterSIN() { return this.voterSIN; }
    public String getVoterAddress() { return this.voterAddress; }
    public String getVoterProvince() { return  this.voterProvince; }
    public String getVoterCity() { return  this.voterCity; }
    public String getVoterPostalCode() { return this.voterPostalCode; }

    // Setters
    public void setVoterLastName(String voterLastName) { this.voterLastName = voterLastName; }
    public void setVoterFirstName(String voterFirstName) { this.voterFirstName = voterFirstName; }
    public void setVoterSIN(String voterSIN) { this.voterSIN = voterSIN; }
    public void setVoterAddress(String voterAddress) { this.voterAddress = voterAddress; }
    public void setVoterProvince(String voterProvince) { this.voterProvince = voterProvince; }
    public void setVoterCity(String voterCity) { this.voterCity = voterCity; }
    public void setVoterPostalCode(String voterPostalCode) { this.voterPostalCode = voterPostalCode; }

    // Methods
    // Overrides the toString method for this class. Prints out the voter's information.
    @Override
    public String toString() {
        String voterString = "Voter information: ";
        voterString +=  "\nFirst name: " + this.voterFirstName +
                "\nLast name: " + this.voterLastName +
                "\nSocial Insurance Number: ******" + this.voterSIN.substring(6) +
                "\nAddress: " + this.voterAddress + ", " + this.voterCity + ", " + this.voterProvince + ", " + this.voterPostalCode +
                "\nVoter ID: " + this.voterID();
        return voterString;
    }

    /** This method ensures that the user-inputted last name contains only letters, commas, periods, spaces, apostrophes, and dashes.
     * For example, "King, Jr." would be a valid last name. So would "Smith-Jones" and "d'Eau".
     * @param voterLastName String containing user's last name (user-inputted)
     * @return returns true if last name follows valid format, false otherwise
     */
    public Boolean validateLastName(String voterLastName) {
        return voterLastName.matches("(?i:^[a-z ,.'-]+$)");
    }

    /** This method ensures that the user-inputted last name contains only letters, periods, spaces, apostrophes, and dashes.
     * For example, "Mary-Anne" would be a valid first name. So would "Mary Anne", "D.W.", and "D'arcy".
     * @param voterFirstName String containing user's first name (user-inputted)
     * @return returns true if first name follows valid format, false otherwise
     */
    public Boolean validateFirstName(String voterFirstName) {
        return voterFirstName.matches("(?i:^[a-z .'-]+$)");
    }

    /** This method ensures that the user-inputted SIN consists of exactly 9 digits.
     *
     * @param voterSIN String containing user's SIN (user-inputted)
     * @return returns true if SIN follows valid format, false otherwise
     */
    public Boolean validateSIN(String voterSIN) {
        return voterSIN.matches("^\\d{9}$");
    }

    /** This method ensures that the user-inputted street address consists only of letters, numbers, and spaces.
     * For example, "123B Anywhere Street" is valid, while "123-B Anywhere Street" and "12B Anywhere St." are not valid.
     * @param voterAddress String containing user's street address (user-inputted)
     * @return returns true if street address follows valid format, false otherwise
     */
    public Boolean validateAddress(String voterAddress) { return voterAddress.matches("[A-Za-z0-9\\s]+"); }

    /** This method ensures that the user-inputted city consists of letters, periods, commas, dashes, apostrophes, and spaces only.
     * For example, "St. John's" is valid.
     * @param voterCity String containing user's city (user-inputted)
     * @return returns true if city follows valid format, false otherwise
     */
    public Boolean validateCity(String voterCity) { return voterCity.matches("(?i:^[a-z .'-]+$)"); }

    /** This method ensures that the user-inputted province consists of letters, periods, and spaces only.
     * For example, "Prince Edward Island" and "P.E.I." are both valid.
     * @param voterProvince String containing user's city (user-inputted)
     * @return returns true if province follows valid format, false otherwise
     */
    public Boolean validateProvince(String voterProvince) { return voterProvince.matches("[.A-Za-z\\s]+"); }

    /** This method ensures that the user-inputted postal code follows the standard format for Canada. It can include a space or not.
     * For example, "A1B 2C3" and "A1B2C3" are both valid.
     * @param voterPostalCode String containing user's postal code (user-inputted)
     * @return returns true if postal code follows valid format, false otherwise
     */
    public Boolean validatePostalCode(String voterPostalCode) { return voterPostalCode.matches("(^[A-Z]\\d[A-Z]\\d[A-Z]\\d$)|(^[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d$)"); }

    /** This method informs the user that they have successfully registered to vote and displays their inputted information.
     * @return A string containing the voter's information as well as a message confirming their successful registration is returned.
     */
    public String successfullyRegistered() {
        return "Thank you! You have successfully registered to vote. " + this.toString();
    }

    /** This method calculates a voter ID for the voter, by converting the current time into a String.
     * @return A string containing the voter's ID number.
     */
    public String voterID() {
        Calendar currentTime = Calendar.getInstance();
        String year = Integer.toString(currentTime.get(Calendar.YEAR));
        String month = new DecimalFormat("00").format(currentTime.get(Calendar.MONTH));
        String day = new DecimalFormat("00").format(currentTime.get(Calendar.DAY_OF_MONTH));
        String hour = new DecimalFormat("00").format(currentTime.get(Calendar.HOUR));
        String minute = new DecimalFormat("00").format(currentTime.get(Calendar.MINUTE));
        String second = new DecimalFormat("00").format(currentTime.get(Calendar.SECOND));
        String millisecond = new DecimalFormat("00").format(currentTime.get(Calendar.MILLISECOND));
        return year + month + day + hour + minute + second + millisecond;
    }
}