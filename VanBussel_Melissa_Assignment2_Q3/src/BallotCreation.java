import java.util.Scanner;
public class BallotCreation extends VotePersonalIdentification {
    // Fields
    private String ballotName;
    private Candidate[] candidates;

    // Constructors
    // No-arg constructor
    public BallotCreation() {
        this.ballotName = "Ballot 1";
        Candidate candidate1 = new Candidate();
        this.candidates = new Candidate[1];
    }
    // Arg constructors
    public BallotCreation(String voterFirstName, String voterLastName, String voterSIN, String voterAddress, String voterCity, String voterProvince, String voterPostalCode, String ballotName, Candidate[] candidates) {
        super(voterFirstName, voterLastName, voterSIN, voterAddress, voterCity, voterProvince, voterPostalCode);
        this.ballotName = ballotName;
        this.candidates = candidates;
    }
    public BallotCreation(VotePersonalIdentification voter, String ballotName, Candidate[] candidates) {
        super.setVoterFirstName(voter.getVoterFirstName());
        super.setVoterLastName(voter.getVoterLastName());
        super.setVoterSIN(voter.getVoterSIN());
        super.setVoterAddress(voter.getVoterAddress());
        super.setVoterCity(voter.getVoterCity());
        super.setVoterProvince(voter.getVoterProvince());
        super.setVoterPostalCode(voter.getVoterPostalCode());
        this.ballotName = ballotName;
        this.candidates = candidates;
    }

    // Getters
    public String getBallotName() { return ballotName; }
    public Candidate[] getCandidates() { return candidates; }

    // Setters
    public void setBallotName(String ballotName) { this.ballotName = ballotName; }
    public void setCandidates(Candidate[] candidates) { this.candidates = candidates; }

    // Methods

    /** This method overrides the toString method for this class.
     * @return A string containing the name of the ballot as well as all of the candidates and their biographies.
     */
    @Override
    public String toString() {
        String ballotString = "Ballot name: " + this.ballotName;
        for (int i = 0; i < this.candidates.length; i ++) {
            ballotString += "\nCandidate " + (i + 1) + " name: " + this.candidates[i].getCandidateName();
            ballotString += "\nCandidate " + (i + 1) + " biography: " + this.candidates[i].getCandidateBiography();
        }
        ballotString += "\nThis ballot belongs to " + super.getVoterFirstName() + " " + super.getVoterLastName() +
                ", with voter ID " + super.voterID();
        return ballotString;
    }

    // This method displays the ballot information to the voter by calling the toString method for this class.
    public void displayBallot() { System.out.println(this.toString()); }

    /** This method allows the user to submit their ballot / vote.
     * @return A string informing the voter who they voted for and confirming successful voting.
     */
    public String submitBallot() {
        Boolean validVote = false;
        int choice = -1; // Initialize to an invalid value so that user has to give a valid choice
        // Ask user for their vote; do so until they provide a valid choice
        do {
            System.out.print("Who would you like to vote for, for " + this.ballotName + "? Type the number of your desired candidate. >> ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            // Validate that the user's choice is one of the options provided
            if (choice > 0 && choice <= this.candidates.length)
                validVote = true;
            if (validVote == false)
                System.out.println("Your vote was invalid. Please try again.");
        } while (validVote == false);
        // Inform voter that they successfully voted on the ballot
        return "You voted for candidate number " + choice + ", " + this.candidates[choice - 1] + ". " +
                "Thank you for voting! Your vote for " + this.ballotName + " has been recorded!";
    }
}
