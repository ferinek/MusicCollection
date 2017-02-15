package com.wookie.config;

import java.io.File;

import com.wookie.dto.IdTagDTO;
import com.wookie.service.Mp3TagEditService;

public class Initializer {

    public static void main(String [] args){
        IdTagDTO oldTagDTO = Mp3TagEditService.getOldTagDTO(new File("C:\\Users\\krzysztof.slodowicz.BKMGTSRV\\Downloads\\02.Invincible.mp3"));
   
    System.out.println(oldTagDTO);
    }
    
}
