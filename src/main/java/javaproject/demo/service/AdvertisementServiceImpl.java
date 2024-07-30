package javaproject.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javaproject.demo.dal.AdvertisementRepository;
import javaproject.demo.dal.AreaRepository;
import javaproject.demo.dto.AdvertisementDTO;
import javaproject.demo.dto.TimeAdvertisementDTO;
import javaproject.demo.dto.ViewsAdvertisementDTO;
import javaproject.demo.model.Advertisement;
import javaproject.demo.model.Area;
import javaproject.demo.model.TimeAdvertisement;
import javaproject.demo.model.ViewsAdvertisement;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advRep;
    @Autowired
    private AreaRepository areaRep;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ObjectMapper objMapper;

    @Override
    public List<AdvertisementDTO> updateViewsAndGetActiveAdvertisements() {
        List<Advertisement> list = ((List<Advertisement>) advRep.findAll()).stream().filter(x -> x.isActive()).toList();
        List<AdvertisementDTO> listDTO = new ArrayList<>();
        list.forEach(x -> {

            if (x instanceof ViewsAdvertisement) {
                ViewsAdvertisement v = (ViewsAdvertisement) x;
                synchronized (x) {
                    v.setAmountViews(v.getAmountViews() + 1);

                    if (v.getAmountViews() >= v.getWantedViews()) {
                        v.setActive(false);
                        v.getArea_().setFree(true);
                        areaRep.save(v.getArea_());
                    }
                    advRep.save(v);
                }

            }
            AdvertisementDTO dto = mapper.map(x, AdvertisementDTO.class);

            try {
                InputStream in = new FileInputStream("C:\\myFolder\\pic" + x.getCode() + ".png");
                dto.setFile(StreamUtils.copyToByteArray(in));
                listDTO.add(dto);
            } catch (IOException e) {

                e.printStackTrace();
            }

        });

        return listDTO;

    }

    
    @Override
    public boolean addAdvTime(String ta, MultipartFile f) {

        try {
            TimeAdvertisementDTO da = objMapper.readValue(ta, TimeAdvertisementDTO.class);
            Area a = areaRep.findById(da.getAreaCode()).get();
            synchronized (a) {
                if (a.isFree()) {
                    // להכניס את a לdb

                    a.setFree(false);
                    da.setActive(true);
                    da.setOrderDate(new Date());
                    areaRep.save(a);
                    Advertisement dal = mapper.map(da, TimeAdvertisement.class);
                    dal=advRep.save(dal);
                    Timer timer = new Timer();
                    da.setCode(dal.getCode());
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() { 
                            a.setFree(true );
                            da.setActive(false);
                            areaRep.save(a);
                            advRep.save(mapper.map(da, TimeAdvertisement.class));
                        }
                    }, da.getMinutes()*1000*60);

                    f.transferTo(new File("C:\\myFolder\\pic" + dal.getCode() + ".png"));
                    return true;

                }
            }
        } catch (IOException e) {
            // טיפול בשגיאה בהמרה
            throw new RuntimeException("Failed to parse JSON", e);
        }

        return false;

    }


    @Override
    public boolean addAdvView(String ta, MultipartFile f) {

        try {
            ViewsAdvertisementDTO da = objMapper.readValue(ta, ViewsAdvertisementDTO.class);
            Area a = areaRep.findById(da.getAreaCode()).get();
            synchronized (a) {
                if (a.isFree()) {
                    // להכניס את a לdb
                    a.setFree(false);
                    da.setActive(true);
                    da.setOrderDate(new Date());
                    areaRep.save(a);
                    Advertisement dal = mapper.map(da, ViewsAdvertisement.class);
                    dal=advRep.save(dal);
                    f.transferTo(new File("C:\\myFolder\\pic" + dal.getCode() + ".png"));
                    return true;
                }
            }
        } catch (IOException e) {
            // טיפול בשגיאה בהמרה
            throw new RuntimeException("Failed to parse JSON", e);
        }

        return false;

    }
}