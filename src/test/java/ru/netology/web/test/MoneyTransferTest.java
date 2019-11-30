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

        val moneyTransferCard = createFormMobileBank();
        int balance1Test = moneyTransferCard.getBalance1() + 2500;
        int balance2Test = moneyTransferCard.getBalance2() - 2500;
        moneyTransferCard.transferToCard1(2500);

        assertEquals(balance1Test, moneyTransferCard.getBalance1());
        assertEquals(balance2Test, moneyTransferCard.getBalance2());

    }

    @Test
    @DisplayName("Перевод суммы с карты №1 на карту №2")
    void transferToCard2Positive() {
        val moneyTransferCard = createFormMobileBank();
        int balance1Test = moneyTransferCard.getBalance1() - 2500;
        int balance2Test = moneyTransferCard.getBalance2() + 2500;
        moneyTransferCard.transferToCard2(2500);


        assertEquals(balance1Test, moneyTransferCard.getBalance1());
        assertEquals(balance2Test, moneyTransferCard.getBalance2());

    }

    @Test
    @DisplayName("Перевод с карты №1 суммы превышающей баланс данной карты")
    void transferToCard2AmountOverCard1Negative() {
        val moneyTransferCard = createFormMobileBank();
        int balance1Test = moneyTransferCard.getBalance1();
        int balance2Test = moneyTransferCard.getBalance2();
        moneyTransferCard.transferToCard2AmountOverCard1(100000);

        assertEquals(balance1Test, moneyTransferCard.getBalance1());
        assertEquals(balance2Test, moneyTransferCard.getBalance2());
    }

    @Test
    @DisplayName("перевод с карты №2 дробной суммы на карту №1")
    void transferToCard1DoubleAmountWithCard2() {
        val moneyTransferCard = createFormMobileBank();
        double balance1Test = moneyTransferCard.getBalance1Double()  - 400.3;
        double balance2Test = moneyTransferCard.getBalance2Double() + 400.3;
        moneyTransferCard.transferToCard1DoubleAmount("400,3");

        assertEquals(balance1Test, moneyTransferCard.getBalance1());
        assertEquals(balance2Test, moneyTransferCard.getBalance2());

    }

    public MoneyTransferCard createFormMobileBank () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val formTransferCard = new MoneyTransferCard();
        return formTransferCard;
    }
}

