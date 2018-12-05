package com.bigfm.com.BigFmDataManagement.controller;


import com.bigfm.com.BigFmDataManagement.domain.VodBeamDTO;
import com.bigfm.com.BigFmDataManagement.entity.VodBeam;
import com.bigfm.com.BigFmDataManagement.response.DMResponse;
import com.bigfm.com.BigFmDataManagement.response.IDMResponse;
import com.bigfm.com.BigFmDataManagement.service.HazelcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HazelCastController {

   @Autowired
    private HazelcastService hservice;

    @RequestMapping(method = RequestMethod.POST,value = "/insert")
    public DMResponse insertBeamDetails(@Valid @RequestBody VodBeam vodBeamRequest){

        DMResponse response=null;
        VodBeamDTO vodbeam=null;
        try {
            vodbeam = hservice.insertBeamDetails(vodBeamRequest);
            response = new DMResponse();
            response.setData(vodbeam);
            response.setCode(200);

        }catch(Exception e){
            e.printStackTrace();
            response.setCode(500);
            response.setCode(null);
            response.setAppMessage(e.getMessage());

        }

       return  response;
    }

    @GetMapping(value = "/getdetailsbyid")
    public IDMResponse getBeamDetailsById(@RequestParam(value="id") int id){

        IDMResponse response=null;
        VodBeamDTO vodbeamdto=null;
        try {

            vodbeamdto = hservice.getBeamDetailsById(id);
            response = new DMResponse();
            response.setData(vodbeamdto);
            response.setCode(200);

        }catch(Exception e){
            response.setCode(500);
            response.setCode(null);
            response.setAppMessage(e.getMessage());

        }

        return  response;
    }
}
