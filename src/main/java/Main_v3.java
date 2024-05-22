// Gson is Google's JSON package, therefore it must be in the pom file
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Main_v1: the API response is returned as a string.
// Main_v2: the GSON package is used to Pretty print the API response.
// Main_v3: the GSON package is used to parse through the API response.
// Main_v4: a Fruit class is utilized to store a fruit. The FruitService class handles the API call and response.
public class Main_v3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter an ID:");
        int factID = scan.nextInt();

        // method that uses the API, it returns a JSON object
        JsonObject catFact = getCatFact(factID);

        if (catFact != null){
            // parse through the API response using the JSON package
            String fact = catFact.get("data").getAsString();

            // We want to look at the nutritions specifically

            System.out.printf("\n\n\nFact #" + factID + " " + fact + "\n\n\n");

        }
        scan.close();
    }

    public static JsonObject getCatFact(int factID) {
        // Constructing the URL for the API request
        String url = "https://meowfacts.herokuapp.com/?id=" + factID;


        // Create an HTTP client object
        HttpClient client = HttpClient.newHttpClient();

        // Build an HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // Send the request to the API, and get a response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check that response.statusCode() returns a 200
            if (response.statusCode() == 200) {
                // here we create a JsonObject, which we'll parse through in the main()
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

                return jsonResponse;
            } else {
                System.out.println("Failed to retrieve data. HTTP status: " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}