import java.text.DecimalFormat;
import java.util.Date;
public class VotePersonalIdentification {
    // Fields
    private String voterLastName;
    private String voterFirstName;
    private String voterSIN;
    private String voterAddress;
    private String voterProvince;
    private String voterCity;
    private String voterPostalCode;

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
    public Boolean validateLastName(String voterLastName) {
        return voterLastName.matches("(?i:^[a-z ,.'-]+$)");
    }

    public Boolean validateFirstName(String voterFirstName) {
        return voterFirstName.matches("(?i:^[a-z ,.'-]+$)");
    }

    public Boolean validateSIN(String voterSIN) {
        return voterSIN.matches("^\\d{9}$");
    }

    public Boolean validatePostalCode(String voterPostalCode) { return voterPostalCode.matches("(^[A-Z]\\d[A-Z]\\d[A-Z]\\d$)|(^[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d$)"); }

    public Boolean validateAddress(String voterAddress) { return voterAddress.matches("[A-Za-z0-9\\s]+"); }

    public Boolean validateCity(String voterCity) { return voterCity.matches("[A-Za-z\\s]+"); }

    public Boolean validateProvince(String voterCity) { return voterCity.matches("[A-Za-z\\s]+"); }

    public String successfullyRegistered() {
        return "Thank you, " + voterFirstName + " " + voterLastName + ". You have successfully registered to vote.";
    }

    public String voterID() {
        Date currentTime = new java.util.Date();
        String year = Integer.toString(currentTime.getYear() + 1900); // have to add 1900 since the getYear method returns current year - 1900
        String month = new DecimalFormat("00").format(currentTime.getMonth());
        String day = new DecimalFormat("00").format(currentTime.getDay());
        String hour = new DecimalFormat("00").format(currentTime.getHours());
        String minute = new DecimalFormat("00").format(currentTime.getMinutes());
        String second = new DecimalFormat("00").format(currentTime.getSeconds());
        String voterID = year + month + day + hour + minute + second;
        return "Your voter ID is: " + voterID;
    }
}
