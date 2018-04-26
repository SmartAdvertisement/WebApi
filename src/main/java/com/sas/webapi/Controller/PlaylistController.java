package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.Playlist;
import com.sas.webapi.Services.PlaylistService;
import com.sas.webapi.utils.AppZip;
import com.sas.webapi.utils.MediaTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequestMapping("/playlist")
@Controller
public class PlaylistController {
    private static final String DIRECTORY = System.getProperty("user.home");
    private static final String DEFAULT_FILE_NAME = "Folder.zip";

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private PlaylistService playlistService;

    // http://localhost:8080/download3?fileName=abc.zip
    // Using HttpServletResponse
    @GetMapping("/downloadFile")
    public void downloadFile3(HttpServletResponse resonse,
                              @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {

        try{
            AppZip appZip = new AppZip();
            appZip.createZip();

            MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
            System.out.println("fileName: " + fileName);
            System.out.println("mediaType: " + mediaType);

            File file = new File(DIRECTORY + "/" + fileName);

            // Content-Type
            // application/pdf
            resonse.setContentType(mediaType.getType());

            // Content-Disposition
            resonse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());

            // Content-Length
            resonse.setContentLength((int) file.length());

            BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            outStream.flush();
            inStream.close();
        }catch (Exception e){
            System.out.print(e);
        }

    }


    @ResponseBody
    @PostMapping("checkVersion")
    public int checkVersion(@RequestBody String json){
        try{
            Playlist playlist = new ObjectMapper().readValue(json,Playlist.class);
           if(playlist.getVersion()==playlistService.getVersion()){
               return 0;
           }else{
               return playlistService.getVersion();
           }

        }catch (Exception e){
            System.out.print(e);
            return -1;
        }
    }

}
