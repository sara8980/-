package javaproject.demo.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javaproject.demo.model.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area,Integer>{
    
}
