import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Enmascarador {

	public static int contador = 0;

	public static void main(String[] args) {

		try {
			for (int i = 0; i < 10; i++) {
				new Thread("" + i) {
					public void run() {
						try {
							HttpClient httpClient = HttpClientBuilder.create().build();
							HttpPost postRequest = new HttpPost(
									"http://157.253.191.44/abc-mascotas-receptor/rest/Mascota/guardar");

							StringEntity input;

							if (contador % 2 == 0) {
								input = new StringEntity(
										"{\"longitud\":-74.01,\"latitud\" : 4.5,\"lugar\": \"Bogota\",\"ritmoCardiaco\": \"34\",\"frecuenciaRespiratoria\": \"50\",\"idRuta\": 3}");
							} else {
								input = new StringEntity(
										"{\"longitud\":-74.01,\"latitud\" : 4.5,\"lugar\": \"Bogota\",\"ritmoCardiaco\": \"34\",\"frecuenciaRespiratoria\": \"50\",\"idRuta\": 3}");
							}

							input.setContentType("application/json");
							postRequest.addHeader("ContentType", "application/json");
							postRequest.setEntity(input);

							HttpResponse response = httpClient.execute(postRequest);
							if (response.getStatusLine().getStatusCode() != 200) {
								throw new RuntimeException(
										"Failed : HTTP error code1 : " + response.getStatusLine().getStatusCode());
							}
							System.out.println("Exitoso: " + (++contador) + " fecha: " + new Date());
						} catch (Exception e) {

							throw new RuntimeException("Failed : HTTP error code2 : " + e.getStackTrace());
						}
					}
				}.start();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
