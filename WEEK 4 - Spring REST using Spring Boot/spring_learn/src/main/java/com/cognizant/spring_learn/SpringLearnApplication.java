package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void displayDate() 
    {
        LOGGER.info("START - displayDate");
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("date_format.xml")) {
            SimpleDateFormat format = ctx.getBean("dateFormat", SimpleDateFormat.class);
            try 
            {
                Date date = format.parse("31/12/2018");
                LOGGER.debug("Parsed date: {}", date);
            } 
            catch (Exception e) {
                LOGGER.error("Parsing error", e);
            }
        }
        LOGGER.info("END - displayDate");
    }


    public static void displayCountry() 
    {
        LOGGER.info("START - displayCountry");


        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml")) {
            List<?> tempList = (List<?>) ctx.getBean("countryList");
            List<Country> list = new java.util.ArrayList<>();
            for (Object obj : tempList) {
                if (obj instanceof Country) {
                    list.add((Country) obj);
                }
            }
            LOGGER.debug("Countries are: {}", list);

            LOGGER.debug("Country count: {}", list.size());
        }
        try (ClassPathXmlApplicationContext ctx2 = new ClassPathXmlApplicationContext("country.xml")) {
            Country country1 = ctx2.getBean("country", Country.class);
            Country country2 = ctx2.getBean("country", Country.class);
            LOGGER.debug("Country1 == Country2? {}", country1 == country2);

            Country country = ctx2.getBean("country", Country.class);
            LOGGER.debug("Country: {}", country);
            LOGGER.debug("Country name: {}", country.getName());
            LOGGER.debug("Country code: {}", country.getCode());    
        } catch (Exception e) {
            LOGGER.error("Error retrieving country bean", e);
        }
        LOGGER.info("END - displayCountry");
    }



    public static void main(String[] args) {
        LOGGER.info("START - Spring Learn App");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END - Spring Learn App");
		displayDate();
		LOGGER.info("Application finished successfully.");	
        displayCountry();
        LOGGER.info("Application finished successfully.");
    }
}

