package org.panyukovnn.ntreststub.config;

import lombok.extern.slf4j.Slf4j;
import org.panyukovnn.ntreststub.property.StubProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Configuration
public class StubConfig {

    /**
     * Ответ, возвращаемый заглушкой.
     *
     * @return ответ
     */
    @Bean
    public byte[] defaultResponse(StubProperty stubProperty) {
        try {
            byte[] response = Files.readAllBytes(Paths.get(stubProperty.getResponseFilePath()));

            log.info("В память загружен заготовленный ответ из файла: " + stubProperty.getResponseFilePath());

            return response;
        } catch (IOException e) {
            throw new IllegalArgumentException("Не удалось прочитать заготовленный ответ из файла: " + stubProperty.getResponseFilePath(), e);
        }
    }
}
