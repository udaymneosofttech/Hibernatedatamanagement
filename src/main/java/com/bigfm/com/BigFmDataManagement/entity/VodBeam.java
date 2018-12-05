package com.bigfm.com.BigFmDataManagement.entity;


import com.bigfm.com.BigFmDataManagement.domain.VodBeamCommentDTO;
import com.bigfm.com.BigFmDataManagement.domain.VodBeamDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vodbeam")
public class VodBeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int beamid;
    String beamName;
    String beamType;
    String beamOriented;
    String description;
    String publish;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    BeamDetails beamdetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vodbeam")
    List<VodBeamComment> vodBeamComment = new ArrayList<>(0);

    public List<VodBeamComment> getVodBeamComment() {
        return vodBeamComment;
    }

    public VodBeam setVodBeamComment(List<VodBeamComment> vodBeamComment) {
        this.vodBeamComment = vodBeamComment;
        return this;
    }


    /* @OneToMany(fetch = FetchType.EAGER,targetEntity =BeamViewers.class,mappedBy = "vodbeam1")
    List<BeamViewers> beamViewers=new ArrayList<>();

    public List<BeamViewers> getBeamViewers() {
        return beamViewers;
    }

    public VodBeam setBeamViewers(List<BeamViewers> beamViewers) {
        this.beamViewers = beamViewers;
        return this;
    }*/

    public BeamDetails getBeamdetails() {
        return beamdetails;
    }

    public VodBeam setBeamdetails(BeamDetails beamdetails) {
        this.beamdetails = beamdetails;
        return this;
    }


    public int getBeamid() {
        return beamid;
    }

    public VodBeam setBeamid(int beamid) {
        this.beamid = beamid;
        return this;
    }

    public String getBeamName() {
        return beamName;
    }

    public VodBeam setBeamName(String beamName) {
        this.beamName = beamName;
        return this;
    }

    public String getBeamType() {
        return beamType;
    }

    public VodBeam setBeamType(String beamType) {
        this.beamType = beamType;
        return this;
    }

    public String getBeamOriented() {
        return beamOriented;
    }

    public VodBeam setBeamOriented(String beamOriented) {
        this.beamOriented = beamOriented;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VodBeam setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPublish() {
        return publish;
    }

    public VodBeam setPublish(String publish) {
        this.publish = publish;
        return this;
    }


    public VodBeamDTO getVodBeamDto(){
        VodBeamDTO vodBeamDTO=new VodBeamDTO();
        vodBeamDTO.setBeamId(beamid);
        vodBeamDTO.setDescription(description);
        vodBeamDTO.setPublish(publish);
        vodBeamDTO.setBeamOriented(beamOriented);
        vodBeamDTO.setBeamName(beamName);
        vodBeamDTO.setBeamType(beamType);
        if(Objects.nonNull(beamdetails))
        vodBeamDTO.setBeamdetails(beamdetails.getBeamDetailsDTO());
        if(Objects.nonNull(vodBeamComment)){

            List<VodBeamCommentDTO> vodBeamCommentDTOList=new ArrayList<>();
            for(VodBeamComment vodBeamComment1:vodBeamComment){
               // vodBeamCommentDTOList.add(vodBeamComment1.getVodBeamCommentDTO());
                break;
            }

            vodBeamDTO.setVodBeamComment(vodBeamCommentDTOList);
        }



        return vodBeamDTO;
    }
}
