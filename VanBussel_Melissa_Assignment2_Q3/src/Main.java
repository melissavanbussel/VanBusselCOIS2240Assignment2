import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Welcome the user, explain purpose of program
        System.out.println("Welcome to the voting system!" +
                " Before we get started, we need to register you as a voter.");

        // Ask for voter information
        VotePersonalIdentification voter = new VotePersonalIdentification();
        Scanner sc = new Scanner(System.in);
        askForFirstName(sc, voter);
        askForLastName(sc, voter);
        askForSIN(sc, voter);
        askForAddress(sc, voter);
        askForCity(sc, voter);
        askForProvince(sc, voter);
        askForPostalCode(sc, voter);

        // Tell user that they've registered successfully, and display their voter information
        System.out.println(voter.successfullyRegistered());

        // Get user to vote for President and Vice President
        presidentVote(voter);
        vicePresidentVote(voter);

        // End the program
        System.out.println("Thank you for participating in the election. That's all the ballots! Have a good day.");
    }

    /** This method asks the voter for their first name, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose first name we are obtaining.
     */
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

    /** This method asks the voter for their last name, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose last name we are obtaining.
     */
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

    /** This method asks the voter for their SIN, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose SIN we are obtaining.
     */
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

    /** This method asks the voter for their street address, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose street address we are obtaining.
     */
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

    /** This method asks the voter for their city, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose city we are obtaining.
     */
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

    /** This method asks the voter for their province, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose province we are obtaining.
     */
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

    /** This method asks the voter for their postal code, validates it, then updates their voter information.
     *
     * @param sc A scanner used for receiving user input
     * @param voter An instance of class VotePersonalIdentification. This is the person whose postal code we are obtaining.
     */
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

    /** This method allows a voter to vote for President.
     *
     * @param voter An instance of class VotePersonalIdentification. This is the person voting for President.
     */
    public static void presidentVote(VotePersonalIdentification voter) {
        // Create the candidates for President
        Candidate[] presCans = new Candidate[3];
        presCans[0] = new Candidate("Bart Simpson", "If elected, I will make homework illegal.");
        presCans[1] = new Candidate("Harry Potter", "If you vote me for President, the next 4 years will be magical.");
        presCans[2] = new Candidate("Robin Hood", "If I'm President, I'll steal from the rich and give to the poor.");
        // Create the ballot for the voter to vote
        BallotCreation presBallot = new BallotCreation(voter, "President", presCans);
        // Allow the voter to vote for President
        presBallot.displayBallot();
        System.out.println(presBallot.submitBallot());
    }

    /** This method allows a voter to vote for Vice President.
     *
     * @param voter An instance of class VotePersonalIdentification. This is the person voting for Vice President.
     */
    public static void vicePresidentVote(VotePersonalIdentification voter) {
        // Create the candidates for Vice President
        Candidate[] vicePresCans = new Candidate[4];
        vicePresCans[0] = new Candidate("Buzz Lightyear", "If I'm Vice President, I'll make sure that the next few years are out of this world!");
        vicePresCans[1] = new Candidate("Squidward Tentacles", "Your life is going to suck no matter who wins, so you may as well vote for me.");
        vicePresCans[2] = new Candidate("Sheldon Cooper", "If you have any brains at all, you'll vote for me.");
        vicePresCans[3] = new Candidate("Scooby Doo", "Rote for me!!! Will share my Rooby snacks!");
        // Create the ballot for voters to vote for Vice President
        BallotCreation presBallot = new BallotCreation(voter, "Vice President", vicePresCans);
        // Allow the voter to vote for Vice President
        presBallot.displayBallot();
        System.out.println(presBallot.submitBallot());
    }
}