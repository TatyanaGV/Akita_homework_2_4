package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoneyTransferCard {

    private List<SelenideElement> buttonsRecharge = $$("[data-test-id=action-deposit]");
    private SelenideElement buttonCard1 = buttonsRecharge.get(0);
    private SelenideElement buttonCard2 = buttonsRecharge.get(1);
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement buttonRecharge = $("[data-test-id=action-transfer]");
    private SelenideElement balanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement balanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");

    public void transferToCard2() {
        buttonCard2.click();
        amount.setValue("2500");
        from.setValue("5559 0000 0000 0001");
        buttonRecharge.click();
    }

    public void transferToCard1() {
        buttonCard1.click();
        amount.setValue("2500");
        from.setValue("5559 0000 0000 0002");
        buttonRecharge.click();
    }

    public void transferToCard1DoubleAmount() {
        buttonCard2.click();
        amount.setValue("400,3");
        from.setValue("5559 0000 0000 0001");
        buttonRecharge.click();
    }

    public void transferToCard2AmountOverCard1() {
        buttonCard2.click();
        amount.setValue("11000");
        from.setValue("5559 0000 0000 0001");
        buttonRecharge.click();
    }


    public String getBalance1() {
        String[] text = balanceCard1.innerText().substring(3).split(" ");
        String balance1 = text[5];
        return balance1;
    }

    public String getBalance2() {
        String[] text = balanceCard2.innerText().substring(3).split(" ");
        String balance2 = text[5];
        return balance2;
    }
}
