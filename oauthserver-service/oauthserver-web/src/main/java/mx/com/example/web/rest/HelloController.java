package mx.com.example.web.rest;

import io.swagger.annotations.Api;
import mx.com.example.commons.to.LoginRequestTO;
import mx.com.example.commons.to.TokenResponseTO;
import mx.com.example.commons.to.UserTO;
import mx.com.example.services.facade.IOauthserverFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("oauthserver")
@Api(value="oauthserver", description="Operaciones con oauthserver")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IOauthserverFacade IOauthserverFacade;

    @RequestMapping(value = "/authorize", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity authorize(@RequestBody LoginRequestTO loginRequest) {
        LOG.info("Se invoca /authorize");

        TokenResponseTO response = IOauthserverFacade.authorize(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
}