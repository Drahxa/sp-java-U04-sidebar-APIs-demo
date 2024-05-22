import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FactService {
    // We are going to make a request to the API and store all the info we want in
    // a Fruit object, and then return that Fruit object.
    // Static means we use the method on the class itself, not on an object.
    public static Fact getFact(int factID) {
        String url = "https://meowfacts.herokuapp.com/?id=" + factID;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject fruitInfo = JsonParser.parseString(response.body()).getAsJsonObject();

                // Extract all the data we want from the response, and store it in a Fruit
                JsonObject nutritions = fruitInfo.getAsJsonObject("nutritions");
              
            } else {
                System.out.println("Failed to retrieve data. HTTP status: " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error fetching fruit data: " + e.getMessage());
            return null;
        }
        return null;
    }
    
}
