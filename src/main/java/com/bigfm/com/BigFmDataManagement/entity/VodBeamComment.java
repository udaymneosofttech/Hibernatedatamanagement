package com.bigfm.com.BigFmDataManagement.entity;


import com.bigfm.com.BigFmDataManagement.domain.VodBeamCommentDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class VodBeamComment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    User userid;

    @Column(name = "description")
    String desc;

    @ManyToOne
    @JoinColumn(name = "vodbeam_id")
    VodBeam vodbeam;

    public VodBeam getVodbeam() {
        return vodbeam;
    }

    public VodBeamComment setVodbeam(VodBeam vodbeam) {
        this.vodbeam = vodbeam;
        return this;
    }

    public int getId() {
        return id;
    }

    public VodBeamComment setId(int id) {
        this.id = id;
        return this;
    }

    public User getUserid() {
        return userid;
    }

    public VodBeamComment setUserid(User userid) {
        this.userid = userid;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public VodBeamComment setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public VodBeamCommentDTO getVodBeamCommentDTO(){

        VodBeamCommentDTO vodBeamCommentDTO=new VodBeamCommentDTO();
        vodBeamCommentDTO.setId(id);
        vodBeamCommentDTO.setDesc(desc);
        if(Objects.nonNull(vodbeam))
       // vodBeamCommentDTO.setVodbeam(vodbeam.getVodBeamDto());
        if(Objects.nonNull(userid))
        vodBeamCommentDTO.setUserid(userid.getUserDto());
        return vodBeamCommentDTO;

    }
}
