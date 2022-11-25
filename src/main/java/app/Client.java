package app;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;

class Client {


    private final String URI;
    private HttpResponse response;
    private CloseableHttpClient client;


    public Client(String uri) {
        this.URI = uri;
    }

    public boolean close() {
        try {
            if (client == null) {
                return false;
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean execute() {

        try {
            this.client = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();


            if (URI == null) {
                return false;
            }
            HttpGet request = new HttpGet(this.URI);
            this.response = client.execute(request);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public InputStream getContent() {

        if (this.response == null) {
            return null;
        }

        try {
            return this.response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

}
