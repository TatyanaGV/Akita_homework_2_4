package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement addLogin = $("[data-test-id=login] input");
    private SelenideElement addPassword = $("[data-test-id=password] input");
    private SelenideElement buttonLogin = $("[data-test-id=action-login]");


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        addLogin.setValue(info.getLogin());
        addPassword.setValue(info.getPassword());
        buttonLogin.click();
        return new VerificationPage();
    }
}