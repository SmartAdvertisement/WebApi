package com.sas.webapi.Services;

import com.sas.webapi.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;
/*
    public boolean checkVersion(int versionId){

        return this.playlistRepository.checkVersion(versionId);
    }

    public int getVersion(){

        return this.playlistRepository.getVersion();
    }


    public void increaseVersion(){
        this.playlistRepository.increaseVersion();
    }
    */
}
