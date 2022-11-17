package org.panyukovnn.ntreststub.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Component
@Validated
@ConfigurationProperties("stub")
public class StubProperty {

    /**
     * Задержка ответа.
     */
    private int delayMs;

    /**
     * Путь к файлу с готовым ответом.
     */
    @NotEmpty(message = "Не задан путь к заготовленному файлу ответа")
    private String responseFilePath;
}
