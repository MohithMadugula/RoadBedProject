package com.kaankaplan.road_bed;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class RoadBedApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String mongoUri = dotenv.get("MONGODB_URI");

        if (mongoUri != null && !mongoUri.isBlank()) {
            System.setProperty("MONGODB_URI", mongoUri.replace("\uFEFF", "").trim());
        }

        SpringApplication.run(RoadBedApplication.class, args);
    }

}