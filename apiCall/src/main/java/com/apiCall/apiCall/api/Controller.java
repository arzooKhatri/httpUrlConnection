package com.apiCall.apiCall.api;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class Controller {

    private Logger logger = null;

    public Controller() {
        logger = Logger.getLogger(Controller.class);
    }

    @RequestMapping(Constants.EMPLOYEE_TEST_URL)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = Constants.EMPLOYEE, method = RequestMethod.POST)
    public void createProducts(@RequestBody Employee employee) throws IOException {

        String uri = Constants.ANOTHER_API_CALL; //TODO : api path which you want to call
        Gson gson = new Gson(); //json to model and model to json convert
        try {
            String reg = gson.toJson(employee); // model to json convert
            System.out.println("employee : " + reg);
            URL url = new URL(uri);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("POST"); // method which you req as same as another api you want to call
            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
            httpUrlConnection.setRequestProperty("Accept", "application/json");
            httpUrlConnection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(httpUrlConnection.getOutputStream());
            wr.writeBytes(reg);
            wr.flush();
            wr.close();
            if (httpUrlConnection.getResponseCode() == 200) {
                httpUrlConnection.disconnect();
                logger.info("Successfully..");
            } else {
                logger.info("Refreshed..");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}