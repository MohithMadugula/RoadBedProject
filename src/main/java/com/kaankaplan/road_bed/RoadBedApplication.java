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

        Dotenv dotenv = Dotenv.load();

        String mongoUri = dotenv.get("MONGODB_URI");

        if (mongoUri == null || mongoUri.isBlank()) {
            throw new IllegalStateException("MONGODB_URI was not loaded from .env");
        }

        mongoUri = mongoUri.replace("\uFEFF", "").trim();

        System.setProperty("MONGODB_URI", mongoUri);

        SpringApplication.run(RoadBedApplication.class, args);
    }
}