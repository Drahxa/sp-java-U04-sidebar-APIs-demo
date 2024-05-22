import java.util.Scanner;

// Main_v1: the API response is returned as a string.
// Main_v2: the GSON package is used to Pretty print the API response.
// Main_v3: the GSON package is used to parse through the API response.
// Main_v4: a Fruit class is utilized to store a fruit. The FruitService class handles the API call and response.
public class Main_v4 {
    public static void main(String[] args, Object fruit) {
        Scanner scan = new Scanner(System.in);

        // Ask user for a fruit
        System.out.println("Please enter an ID:");
        int factID = scan.nextInt();
        scan.close();

        // Use the FruitService class to make the API request
        // Store the response in a Fruit
        Fact fact = new Fact(FactService.getFact(factID));
        if (fact != null) {
            System.out.println("All about " + fact.getFact() + "s:\n" + fruit);
        }
    }
}