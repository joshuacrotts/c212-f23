import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class NetworkExamples {

    public static void main(String[] args) {
        URL url = null;
        try {
            // Open the URL.
            url = new URL("https://joshuacrotts.us");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            // Read all data.
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) { System.out.println(line); }

            // Close the reader stream.
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Test GET request.
        try {
            // Connect to the GitHub API.
            url = new URL("https://api.github.com/users/google");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response from the HTTP header.
            System.out.printf("Response: %d, Response message: %s\n", conn.getResponseCode(), conn.getResponseMessage());

            // Read the GET request response.
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) { System.out.println(line); }

            // Close the BR stream.
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
