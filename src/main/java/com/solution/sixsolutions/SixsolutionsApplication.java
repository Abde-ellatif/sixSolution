package com.solution.sixsolutions;

import com.solution.sixsolutions.entity.Entreprise;
import com.solution.sixsolutions.repository.EntrepriseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SixsolutionsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SixsolutionsApplication.class, args);
    }


    @Autowired
    EntrepriseRepo entrepriseRepo;
    @Override
    public void run(String... args) throws Exception {
        entrepriseRepo.save(new Entreprise(1L,"","","","","","","",""));
    }
}
