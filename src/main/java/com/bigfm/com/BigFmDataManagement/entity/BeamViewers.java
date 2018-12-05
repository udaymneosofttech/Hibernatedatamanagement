package com.bigfm.com.BigFmDataManagement.entity;


import com.bigfm.com.BigFmDataManagement.domain.BeamViewersDTO;

import javax.persistence.*;

public class BeamViewers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private int viewerid;
    private String viewername;
    private Long viewerfollers;

    @ManyToOne
    @JoinColumn(name ="beamid")
    private VodBeam vodbeam1;

    public VodBeam getVodbeam1() {
        return vodbeam1;
    }

    public BeamViewers setVodbeam1(VodBeam vodbeam1) {
        this.vodbeam1 = vodbeam1;
        return this;
    }

    public int getId() {
        return id;
    }

    public BeamViewers setId(int id) {
        this.id = id;
        return this;
    }

    public int getViewerid() {
        return viewerid;
    }

    public BeamViewers setViewerid(int viewerid) {
        this.viewerid = viewerid;
        return this;
    }

    public String getViewername() {
        return viewername;
    }

    public BeamViewers setViewername(String viewername) {
        this.viewername = viewername;
        return this;
    }

    public Long getViewerfollers() {
        return viewerfollers;
    }

    public BeamViewers setViewerfollers(Long viewerfollers) {
        this.viewerfollers = viewerfollers;
        return this;
    }


    public BeamViewersDTO getBeamViewersDTO(){

        BeamViewersDTO beamViewersDTO=new BeamViewersDTO();
        beamViewersDTO.setId(id);
        beamViewersDTO.setViewerid(viewerid);
        beamViewersDTO.setViewerfollers(viewerfollers);
        beamViewersDTO.setViewername(viewername);
        return beamViewersDTO;
    }
}
