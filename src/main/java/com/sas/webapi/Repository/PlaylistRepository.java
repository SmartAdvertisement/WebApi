package com.sas.webapi.Repository;

import com.sas.webapi.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
/*
    @Query("SELECT 1 FROM playlist p WHERE p.version = :version")
    boolean checkVersion(@Param("version") int version);

    @Query("SELECT version FROM Playlist WHERE id=1")
    int getVersion();


    @Query("UPDATE playlist SET version = version + 1 WHERE id = 1")
    void increaseVersion();
    */
}
