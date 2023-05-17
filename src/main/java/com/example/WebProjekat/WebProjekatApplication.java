package com.example.WebProjekat;

import com.example.WebProjekat.model.Korisnik;
import com.example.WebProjekat.repository.KorisnikRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.WebProjekat.*")
public class WebProjekatApplication implements CommandLineRunner {
@Autowired
KorisnikRepository repozitorijum;
	public static void main(String[] args) {
		SpringApplication.run(WebProjekatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repozitorijum.save(new Korisnik("Mika", "Mikic"));
		for(Korisnik k: repozitorijum.findAll())
		{
			System.out.println(k);
		}

	}
}
