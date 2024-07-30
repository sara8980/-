package javaproject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javaproject.demo.dto.AdvertisementDTO;
import javaproject.demo.service.AdvertisementService;

@RestController
@RequestMapping("/advs")
public class AdvertisementController {
    @Autowired
    private AdvertisementService Advservice;

    @PostMapping("/getAndUpdateWebSite")
    public List<AdvertisementDTO> updateViewsAndGetActiveAdvertisements() {

        return Advservice.updateViewsAndGetActiveAdvertisements();

    }

    @PostMapping("/addTimeAdv")
    public boolean addAdvTime(@RequestPart("adv") String ta,@RequestPart("file") MultipartFile f) {
        return Advservice.addAdvTime(ta, f);
    }

    @PostMapping("/addViewsAdv")
    public boolean addAdvView(@RequestPart("adv") String ta,@RequestPart("file") MultipartFile f) {
    return Advservice.addAdvView(ta, f);
    }



}
