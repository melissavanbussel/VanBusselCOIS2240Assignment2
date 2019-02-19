public class Candidate {
    // Fields
    private String candidateName;
    private String candidateBiography;

    // Constructors
    // No-arg constructor
    public Candidate() {
        this.candidateName = "John Smith";
        this.candidateBiography = "A cool guy.";
    }
    // Arg constructor
    public Candidate(String candidateName, String candidateBiography) {
        this.candidateName = candidateName;
        this.candidateBiography = candidateBiography;
    }

    // Getters
    public String getCandidateName() { return candidateName; }
    public String getCandidateBiography() { return candidateBiography; }

    // Setters
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }
    public void setCandidateBiography(String candidateBiography) { this.candidateBiography = candidateBiography; }

    // Methods

    /** This method overrides the toString method for this class.
     * @return A string containing the name of the candidate.
     */
    @Override
    public String toString() {
        return candidateName;
    }
}
