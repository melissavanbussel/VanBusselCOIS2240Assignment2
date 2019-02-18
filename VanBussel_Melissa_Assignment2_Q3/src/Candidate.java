public class Candidate {
    // Fields
    private String candidateName;
    private String candidateBiography;

    // Constructors
    public Candidate() {
        this.candidateName = "John Smith";
        this.candidateBiography = "A cool guy.";
    }

    public Candidate(String candidateName, String candidateBiography) {
        this.candidateName = candidateName;
        this.candidateBiography = candidateBiography;
    }

    // Getters
    public String getCandidateName() {
        return candidateName;
    }

    public String getCandidateBiography() {
        return candidateBiography;
    }

    // Setters
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setCandidateBiography(String candidateBiography) {
        this.candidateBiography = candidateBiography;
    }
}
