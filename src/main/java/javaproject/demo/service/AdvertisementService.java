package javaproject.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javaproject.demo.dto.AdvertisementDTO;

public interface AdvertisementService {
    
    public List<AdvertisementDTO> updateViewsAndGetActiveAdvertisements();

    public boolean addAdvTime(String ta, MultipartFile f);

    public boolean addAdvView(String ta, MultipartFile f);

}
