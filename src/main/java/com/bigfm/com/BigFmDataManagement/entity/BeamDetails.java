package com.bigfm.com.BigFmDataManagement.entity;


import com.bigfm.com.BigFmDataManagement.domain.BeamDetailsDTO;

import javax.persistence.*;

@Entity
@Table(name="beam_details")
public class BeamDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String title;
    String description;
/*

   @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "beam_id")

    VodBeam vodBeam;

    public VodBeam getVodBeam() {
        return vodBeam;
    }

    public BeamDetails setVodBeam(VodBeam vodBeam) {
        this.vodBeam = vodBeam;
        return this;
    }
*/

    public int getId() {
        return id;
    }

    public BeamDetails setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeamDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BeamDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BeamDetails setDescription(String description) {
        this.description = description;
        return this;
    }

    BeamDetailsDTO getBeamDetailsDTO(){

        return new BeamDetailsDTO().setId(id)
                .setDescription(description)
                .setTitle(title)
                .setName(name);
    }

}
