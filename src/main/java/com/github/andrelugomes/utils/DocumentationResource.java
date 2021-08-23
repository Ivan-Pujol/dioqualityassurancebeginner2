package com.github.andrelugomes.utils;
import com.github.andrelugomes.cities.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentationResource {
    @GetMapping
    public static ResponseEntity welcoming() {
        String corpo = "<html><body><center><h1>Welcome to the DioQABeginner#2 Final project</h1><br><h2>The following end-points are available:</h2><p>http://'host-site'/countries<br>http://'host-site'/states<br>http://'host-site'/states/'id'<br>http://'host-site'/cities<br>http://'host-site'/cities/'id'<br>http://'host-site'/distances/by-points?from='id'&to='id'<br>http://'host-site'/distances/by-cube?from='id'&to='id'</p></center></body></html>";
        ResponseEntity welcomeMessage = new ResponseEntity(corpo, HttpStatus.NOT_FOUND);
        return welcomeMessage;
    }

}
