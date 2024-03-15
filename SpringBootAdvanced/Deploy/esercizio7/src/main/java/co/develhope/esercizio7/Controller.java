package co.develhope.esercizio7;

import co.develhope.esercizio7.Entities.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private Environment environment;

    @GetMapping
    public Properties endPoint() {
        String authCode = environment.getProperty("authCode");
        String devName = environment.getProperty("devName");

        return new Properties(authCode,devName);
    }

//    @Value("${authCode}")
//    String authCode;
//    @Value("${devName}")
//    String devName;
//
//    @GetMapping
//    public String endPoint(){
//        return "authCode: " + authCode + "<br>" + "devName: " + devName;
//    }


}
