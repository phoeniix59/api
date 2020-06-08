package com.project.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.search.ApiSearchRepository;
import com.project.api.search.exception.InternalServerException;
import com.project.api.search.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "api")
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApiSearchRepository apiSearchRepository;


    @ApiOperation(value = "Search for properties", tags = "Property")
    @PostMapping("/search")
    public ResponseEntity searchProperty(@RequestParam String keywords) throws InternalServerException {
        if(keywords.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Response propertyResponse = apiSearchRepository.findByKeyword(keywords);

//        List<Property> properties = propertyResponse.getResultsProperty(objectMapper);



        return new ResponseEntity<>(propertyResponse, HttpStatus.OK);
    }

//    @ApiOperation(value = "/reserve", tags = "")
//    @PostMapping
//    public ResponseEntity<String> reserve(@RequestBody Reservation reservation) {
//        apiService.registerNewReservation(reservation);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
