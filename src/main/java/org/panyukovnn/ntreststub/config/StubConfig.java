package org.panyukovnn.ntreststub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Configuration
public class StubConfig {

    private static final String RESPONSE_FILE = "/response.json";

    /**
     * Ответ, возвращаемый заглушкой.
     *
     * @return ответ
     * @throws IOException исключение
     * @throws URISyntaxException исключение
     */
    @Bean
    public byte[] defaultResponse() throws IOException, URISyntaxException {
        URI responseFileUri = Objects.requireNonNull(getClass().getResource(RESPONSE_FILE)).toURI();

        return Files.readAllBytes(Paths.get(responseFileUri));
    }
}
