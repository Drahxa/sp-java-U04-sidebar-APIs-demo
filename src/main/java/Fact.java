// THIS CLASS IS USED WITH Main_v4
public class Fact {
    private String fact;

    // Constructor
    public Fact(Fact fact2) {
        this.fact = fact2;
    }

    public Fact(Fact fact2) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public String getFact() { return fact; }
    

    public String toString() {
        return String.format("Fact: %",
                fact);
    }
}
