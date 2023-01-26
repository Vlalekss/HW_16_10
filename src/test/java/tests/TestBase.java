package tests;


import helpers.Attach;
import io.qameta.allure.Step;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import pages.RegistrationPage;

import static helpers.DriverHelper.JENKINS;
import static helpers.DriverHelper.configDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Конфигурирование драйвера")
    @BeforeAll
    static void beforeAll() {
        configDriver();
    }

    @AfterEach
    void addAttachments() {
        if (JENKINS) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }
}


