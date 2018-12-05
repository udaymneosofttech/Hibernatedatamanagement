package com.bigfm.com.BigFmDataManagement.service.impl;


import com.bigfm.com.BigFmDataManagement.domain.VodBeamDTO;
import com.bigfm.com.BigFmDataManagement.entity.*;
import com.bigfm.com.BigFmDataManagement.repository.IBeamRepository;
import com.bigfm.com.BigFmDataManagement.repository.IVodCommentRepository;
import com.bigfm.com.BigFmDataManagement.service.HazelcastService;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class HazelCastServiceImpl implements HazelcastService {



    // @Autowired
    HazelcastInstance inst;

    @Autowired
    IBeamRepository beamrepository;

    @Autowired
    IVodCommentRepository vodCommentRepository;

    // return (new HazelcastClientFactory(config)).getHazelcastInstance();
    HazelcastInstance hzInstance= Hazelcast.newHazelcastInstance();
    //Hazelcast.newHazelcastInstance(config);


    //static Map<Integer,VodBeamDTO> cachemap=new HashMap<>();

    @Override
    public VodBeamDTO insertBeamDetails(VodBeam vodBeamRequest) {

        try {

            //SET the Beam Details
            BeamDetails beamdetails=new BeamDetails();

            beamdetails.setName("udaybeam");
            beamdetails.setDescription("hello beam desc");
            beamdetails.setTitle("beam titlke");
            vodBeamRequest.setBeamdetails(beamdetails);

            //let register the user

            User user1=new User();
            user1.setAddress("kanipakam");
            user1.setUsername("uday");

            User user2=new User();
            user2.setAddress("rajampet");
            user2.setUsername("pritesh");

            VodBeam vodbeam1 = beamrepository.save(vodBeamRequest);
            //let user can comment the beam

            VodBeamComment vodBeamComment=new VodBeamComment();
            vodBeamComment.setUserid(user1);
            vodBeamComment.setDesc("good beam");
           vodBeamComment.setVodbeam(vodbeam1);

            VodBeamComment vodBeamComment1=vodCommentRepository.save(vodBeamComment);

            //create vodBeam

            vodBeamRequest.setBeamdetails(beamdetails);

            ArrayList<VodBeamComment> vodBeamCommentArrayList=new ArrayList<>();
            vodBeamCommentArrayList.add(vodBeamComment1);
            vodBeamRequest.setVodBeamComment(vodBeamCommentArrayList);





            VodBeam vodbeam = beamrepository.save(vodBeamRequest);

            VodBeamDTO beamDTO = vodbeam.getVodBeamDto();

            System.out.println("hi exceuted");


            return beamDTO;

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException("internal exception");
        }
    }

    @SuppressWarnings("Duplicate")
    @Override
    public VodBeamDTO getBeamDetailsById(int vodBeamId) {
        try {

            VodBeamDTO vodBeamDTO=null;


            Optional<VodBeam> vodbeam = beamrepository.findById(vodBeamId);
            if (!vodbeam.isPresent()) {
                throw new RuntimeException("data not present");
            }

            vodBeamDTO=vodbeam.get().getVodBeamDto();



            return vodBeamDTO;



        }catch (Exception e){

            throw new RuntimeException("database level exception");
        }




    }
}
