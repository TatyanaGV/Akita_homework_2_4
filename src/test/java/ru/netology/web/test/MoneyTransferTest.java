package ru.netology.web.test;

import lombok.val;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.MoneyTransferCard;

import static com.codeborne.selenide.Selenide.open;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTransferTest {
    @Test
    @DisplayName("Перевод суммы с карты №2 на карту №1")
    void transferToCard1Positive() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val moneyTransferCard = new MoneyTransferCard();
        moneyTransferCard.transferToCard1();

        assertEquals(moneyTransferCard.getBalance1(), "12500");
        assertEquals(moneyTransferCard.getBalance2(), "7500");

    }

    @Test
    @DisplayName("Перевод суммы с карты №1 на карту №2")
    void transferToCard2Positive() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val moneyTransferCard = new MoneyTransferCard();
        moneyTransferCard.transferToCard2();

        assertEquals(moneyTransferCard.getBalance1(), "7500");
        assertEquals(moneyTransferCard.getBalance2(), "12500");

    }

    @Test
    @DisplayName("Перевод с карты №1 суммы превышающей баланс данной карты")
    void transferToCard2AmountOverCard1Negative() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val moneyTransferCard = new MoneyTransferCard();
        moneyTransferCard.transferToCard2AmountOverCard1();

        assertEquals(moneyTransferCard.getBalance1(), "10000");
        assertEquals(moneyTransferCard.getBalance2(), "10000");
    }


    @Test
    @DisplayName("перевод с карты №2 дробной суммы на карту №1")
    void transferToCard1DoubleAmountWithCard2() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val moneyTransferCard = new MoneyTransferCard();
        moneyTransferCard.transferToCard1DoubleAmount();

        assertEquals(moneyTransferCard.getBalance1(), "10400,3");
        assertEquals(moneyTransferCard.getBalance2(), "9599,7");

    }

}

