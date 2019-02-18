import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        VotePersonalIdentification voter = new VotePersonalIdentification();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the voting system!" +
                " Before we get started, we need to register you as a voter.");
        askForFirstName(sc, voter);
        askForLastName(sc, voter);
        askForSIN(sc, voter);
        askForAddress(sc, voter);
        askForCity(sc, voter);
        askForProvince(sc, voter);
        askForPostalCode(sc, voter);
        System.out.println(voter.successfullyRegistered());
        System.out.println(voter.voterID());
        presidentBallot();
      //  vicePresidentBallot();
    }

    public static void askForFirstName(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your first name >> ");
            input = sc.nextLine();
            valid = voter.validateFirstName(input);
            if (valid == false)
                System.out.println("That first name is not valid.");
        } while (valid == false);
        voter.setVoterFirstName(input);
    }

    public static void askForLastName(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your last name >> ");
            input = sc.nextLine();
            valid = voter.validateLastName(input);
            if (valid == false)
                System.out.println("That last name is not valid.");
        } while (valid == false);
        voter.setVoterLastName(input);
    }

    public static void askForSIN(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your SIN (example: 123456789) >> ");
            input = sc.nextLine();
            valid = voter.validateSIN(input);
            if (valid == false)
                System.out.println("That is not a valid SIN. Please enter all 9 digits, without any spaces.");
        } while (valid == false);
        voter.setVoterSIN(input);
    }

    public static void askForAddress(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your street address >> ");
            input = sc.nextLine();
            valid = voter.validateAddress(input);
            if (valid == false) {
                System.out.println("That is not a valid address. " +
                        "Addresses must be composed only of letters and numbers. Do not use abbreviations (such as St.)." +
                        "\nFor apartments or units, attach the apartment / unit number to the street number" +
                        "For example, 123B Anywhere Street");
            }
        } while (valid == false);
        voter.setVoterAddress(input);
    }

    public static void askForCity(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your city >> ");
            input = sc.nextLine();
            valid = voter.validateCity(input);
            if (valid == false)
                System.out.println("That is not a valid city.");
        } while (valid == false);
        voter.setVoterCity(input);
    }

    public static void askForProvince(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your province >> ");
            input = sc.nextLine();
            valid = voter.validateProvince(input);
            if (valid == false)
                System.out.println("That is not a valid province. Province names must contain only letters.");
        } while (valid == false);
        voter.setVoterProvince(input);
    }

    public static void askForPostalCode(Scanner sc, VotePersonalIdentification voter) {
        Boolean valid = false;
        String input;
        do {
            System.out.print("Please enter your postal code >> ");
            input = sc.nextLine();
            valid = voter.validatePostalCode(input);
            if (valid == false)
                System.out.println("That is not a valid postal code. Please use numbers, capital letters, and spaces only.");
        } while (valid == false);
        voter.setVoterPostalCode(input);
    }

    public static void presidentBallot() {
        Candidate[] presCans = new Candidate[3];
        presCans[0] = new Candidate("Bart Simpson", "If elected, I will make homework illegal.");
        presCans[1] = new Candidate("Harry Potter", "If you vote me for President, the next 4 years will be magical.");
        presCans[2] = new Candidate("Robin Hood", "If I'm President, I'll steal from the rich and give to the poor.");
        BallotCreation presBallot = new BallotCreation("President", presCans);
        presBallot.displayBallot();
        System.out.println(presBallot.submitBallot());
    }
}