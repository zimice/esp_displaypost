package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

public class HttpPost {

	private String url = "http://localhost:8888/post";
	private HttpURLConnection con;

	private void createConnection() {

		URL UrlObj = null;
		try {
			UrlObj = new URL(url);
			con = (HttpURLConnection) UrlObj.openConnection();
			con.setRequestMethod("POST");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);
	}

	private String body = "Test HTTP POST " + System.currentTimeMillis();
	private int responseCode = 404;

	private void setOutputStream() {
		DataOutputStream outputStream;
		try {
			outputStream = new DataOutputStream(con.getOutputStream());
			outputStream.writeBytes(body);
			outputStream.flush();
			outputStream.close();
			System.out.println("Send 'HTTP POST' request to : " + url);
			int responseCode;
			responseCode = con.getResponseCode();

			System.out.println("Response Code : " + responseCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void handleResponse() {

		if (responseCode == HttpURLConnection.HTTP_OK) {
			try {
				BufferedReader inputReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = inputReader.readLine()) != null) {
					response.append(inputLine);
				}
				inputReader.close();
				System.out.println(response.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public HttpPost() {

	}

	public int sendPost(String msg) {
		setBody(msg);
		createConnection();
		setOutputStream();
		handleResponse();
		return responseCode;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	private void setBody(String body) {
		this.body = body;
	}

}
