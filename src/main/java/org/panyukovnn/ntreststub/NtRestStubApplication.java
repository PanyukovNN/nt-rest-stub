package org.panyukovnn.ntreststub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NtRestStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(NtRestStubApplication.class);
    }
}
