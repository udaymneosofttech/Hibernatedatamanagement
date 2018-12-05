package com.bigfm.com.BigFmDataManagement.service;


import com.bigfm.com.BigFmDataManagement.domain.VodBeamDTO;
import com.bigfm.com.BigFmDataManagement.entity.VodBeam;

public interface HazelcastService {

    VodBeamDTO insertBeamDetails(VodBeam vodBeamRequest);

    VodBeamDTO getBeamDetailsById(int vodBeamId);


}
