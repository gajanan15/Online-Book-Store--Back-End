package com.codebrewers.onlinebookstore;

import com.codebrewers.onlinebookstore.model.Coupons;
import com.codebrewers.onlinebookstore.properties.FileProperties;
import com.codebrewers.onlinebookstore.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({FileProperties.class})
public class OnlinebookstoreApplication {

    @Autowired
    ICouponRepository couponRepository;

    @PostConstruct
    private void setCoupon() {
        List<Coupons> all = couponRepository.findAll();
        if (all.isEmpty()) {
            Coupons coupons = new Coupons("WEL100", 100.0, "10% Off upto Rs.100 on minimum purchase of Rs.699.0", "30-07-2020",699.0);
            Coupons coupons1 = new Coupons("CB50", 50.0, "5% Off upto Rs.50 on minimum purchase of Rs.299.0", "28-07-2020",299.0);
            Coupons coupons2 = new Coupons("CB500", 500.0, "50% Off upto Rs.500 on minimum purchase of Rs.999.0", "20-07-2020",999.0);

            couponRepository.save(coupons);
            couponRepository.save(coupons1);
            couponRepository.save(coupons2);
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(OnlinebookstoreApplication.class, args);
    }

}
