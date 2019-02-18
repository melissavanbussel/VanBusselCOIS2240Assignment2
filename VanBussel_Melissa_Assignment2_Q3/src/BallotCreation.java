import java.util.Scanner;
public class BallotCreation {
    // Fields
    private String ballotName;
    private Candidate[] candidates;

    // Constructors
    public BallotCreation() {
        this.ballotName = "Ballot 1";
        Candidate candidate1 = new Candidate();
        this.candidates = new Candidate[1];

    }

    public BallotCreation(String ballotName, Candidate[] candidates) {
        this.ballotName = ballotName;
        this.candidates = candidates;
    }

    // Getters
    public String getBallotName() {
        return ballotName;
    }

    public Candidate[] getCandidates() {
        return candidates;
    }

    // Setters
    public void setBallotName(String ballotName) {
        this.ballotName = ballotName;
    }

    public void setCandidates(Candidate[] candidates) {
        this.candidates = candidates;
    }

    // Methods
    public void displayBallot() {
        System.out.println("This ballot will allow you to vote for: " + this.ballotName);
        for (int i = 0; i < this.candidates.length; i ++) {
            System.out.println("Candidate " + (i + 1) + " name: " + this.candidates[i].getCandidateName());
            System.out.println("Candidate " + (i + 1) + " biography: " + this.candidates[i].getCandidateBiography());
        }
    }

    public String submitBallot() {
        Boolean validVote = false;
        int choice = -1;
        do {
            System.out.println("Who would you like to vote for, for " + this.ballotName + "? Type the number of the desired candidate.");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice > 0 && choice <= this.candidates.length)
                validVote = true;
            if (validVote == false)
                System.out.println("Your vote was invalid. Please try again.");
        } while (validVote == false);
        return "You voted for candidate number " + choice + ", " + this.candidates[choice + 1] + "." +
                "Thank you for voting! Your vote for " + this.ballotName + " has been recorded!";
    }
}
