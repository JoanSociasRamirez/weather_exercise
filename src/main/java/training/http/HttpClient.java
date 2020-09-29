package training.http;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;

public class HttpClient {

	private final NetHttpTransport transport;
	private static HttpClient instance;

	private HttpClient(final NetHttpTransport transport) {
		this.transport = transport;
	}

	public static HttpClient getInstance(final NetHttpTransport transport) {
		if (HttpClient.instance == null) {
			HttpClient.instance = new HttpClient(transport);
		}
		return HttpClient.instance;
	}

	public String getRequest(final String url) throws IOException {
		HttpRequest request = this.transport.createRequestFactory().buildGetRequest(new GenericUrl(url));
		HttpResponse response = request.execute();
		if (response.getStatusCode() != 200) {
			throw new IOException("Unexpected response status: " + response.getStatusCode());
		}
		return response.parseAsString();
	}
}