package javaproject.demo.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javaproject.demo.model.Advertisement;

@Repository
public interface AdvertisementRepository  extends CrudRepository<Advertisement,Integer>{
    
}
