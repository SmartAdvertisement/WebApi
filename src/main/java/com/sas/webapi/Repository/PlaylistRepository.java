package com.sas.webapi.Repository;

import com.sas.webapi.Model.AgProgramlama;
import com.sas.webapi.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaylistRepository extends JpaRepository<AgProgramlama,Integer> {

    @Query("SELECT 1 FROM Playlist p WHERE p.version = :version")
    boolean checkVersion(@Param("version") int version);

    @Query("SELECT version FROM Playlist WHERE id=1")
    int getVersion();


    @Query("UPDATE Playlist SET version = version + 1")
    void increaseVersion();
}
