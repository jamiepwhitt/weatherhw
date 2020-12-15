package com.tts.WeatherAppRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.WeatherAppModel.Zip;


@Repository
public interface ZipRepository extends CrudRepository<Zip, Long> {

 long count();
 
  List<Zip> findAll();
  
}

