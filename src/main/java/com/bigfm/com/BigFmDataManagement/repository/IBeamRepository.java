package com.bigfm.com.BigFmDataManagement.repository;


import com.bigfm.com.BigFmDataManagement.entity.VodBeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeamRepository extends JpaRepository<VodBeam,Integer> {
    
}
