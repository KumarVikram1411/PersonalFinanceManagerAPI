package com.javaj2eefsd.workshop.api;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Registeruser;
import com.javaj2eefsd.workshop.service.RegisterService;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
public class ActivateUserApiController implements ActivateUserApi {

    private static final Logger log = LoggerFactory.getLogger(ActivateUserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ActivateUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    @Autowired
    RegisterService registerserviceObj;
    


    public ResponseEntity<Registeruser> activateUserLoginAccount(@ApiParam(value = "Activating user." ,required=true )  @RequestParam("userId") String userId, @RequestParam("otp") Integer otp) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	registerserviceObj.activateUser(userId , otp);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
            }
        }

        return new ResponseEntity<Registeruser>(HttpStatus.OK);
        
       /* String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                registerserviceObj.registerUser(body);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Registeruser>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }*/
    }

}
