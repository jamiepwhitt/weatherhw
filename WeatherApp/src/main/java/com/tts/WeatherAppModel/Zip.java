package com.tts.WeatherAppModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Zip{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zip_id")
	private Long id;
	
    private String zipcode;
    
    @CreationTimestamp
	private Date createdAt;
    
    public Zip(String zip) {
    	zipcode = zip;
    }
    
}
