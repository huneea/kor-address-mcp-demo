package com.example.address.service;

import com.example.address.client.JusoApiResponse;
import com.example.address.client.JusoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@ActiveProfiles("test")
@SpringBootTest
@Import(JusoServiceTest.TestConfig.class)
class JusoServiceTest {

    @Autowired
    private JusoService jusoService;


    @Test
    void getAddresses() {
        JusoApiResponse response = jusoService.find(1, 10, "NHN");
        assertThat(response).isNotNull();
        assertThat(response.getResults()).isNotNull();
        assertThat(response.getResults().getJusos()).isNotEmpty();
    }


    @TestConfiguration
    public static class TestConfig {

        @Bean
        public String apiKey() {
            // TODO - 테스트용 API-KEY 반환
            return "";
        }
    }
}
