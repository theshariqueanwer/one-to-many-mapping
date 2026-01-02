package com.pack.api;

import com.pack.api.common.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyMappingApplication implements CommandLineRunner {

    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // appService.saveDataForOneToMany01();
        // appService.saveDataForOneToMany02();

        // appService.saveDataForManyToOneV01();
        // appService.saveDataForManyToOneV02();

        // appService.saveDataForViceVersaV01();
        // appService.saveDataForViceVersaV02();

        appService.getAddressDataAssociatedStudent();
        appService.getStudentDataAssociatedAddress();
    }


}
