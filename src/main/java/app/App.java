package app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class App {

    private final String API_NASA = "https://api.nasa.gov/planetary/apod?api_key=tqUjAGdz17CT27wFLXUs2Khh7BxqLH9a4ayNU4FY";



    public void run() throws IOException {

            final Client clientNasaRequest = new Client(this.API_NASA);
            clientNasaRequest.execute();
            // ==================================================
            ObjectMapper mapper = new ObjectMapper();

            NasaModel model = mapper.readValue(
                    clientNasaRequest.getContent(),
                    new TypeReference<NasaModel>() {
                    }
            );

            clientNasaRequest.close();
            // =================================================

            final Client clientImageRequest = new Client(model.getUrl());
            clientImageRequest.execute();

            new Saver().toSaveImage("image1.jpg", clientImageRequest.getContent());
            clientImageRequest.close();
    }


}
