package Scenario;

import Base.BaseTest;
import Util.Steps;
import org.junit.jupiter.api.Test;

public class ScenarioTestCase extends BaseTest {
    Steps steps = new Steps();


    @Test
    public void buyTicket(){
        steps.sendKeysToElementTest("input[id='flight-from']","İstanbul");//Nereden uçmak istiyorsan ilgili bir kelime gir
        steps.clickElement("ul[id='ui-id-1']>li:nth-of-type(2)");//Listeden havalimanını seç
        steps.sendKeysToElementTest("input[id='flight-to']","İzmir");//Nereye uçmak istiyorsan ilgili bir kelime gir
        steps.clickElement("ul[id='ui-id-2']>li:nth-of-type(1)");//Listeden havalimanını seç
        steps.clickElement("div[class='search-form-item calendar departure datepicker-wrapper dtp-wrap-from']"); //Gidiş tarihi için takvimi aç
        steps.optionClick("div[class='ui-datepicker-group ui-datepicker-group-last'] a[class='ui-state-default']",9); //Bir sonraki ayın 10. gününü seç
        steps.clickElement("div[class='return-date ']");//Dönüş tarihi için takvimi aç
        steps.optionClick("div[class='ui-datepicker-group ui-datepicker-group-last'] a[class='ui-state-default']",9);//Gidilecek ayın  bir sonraki ayında 10. günü seç
        steps.clickElement("div[id='btnSearch']"); //Arama butonuna bas
        steps.clickByXpath("//a[text()='(Gizle)']"); //Fiyat pop-up'ını kapat
        steps.mouseHover("li[id='airline-TK']","li[id='airline-TK'] a[class='filter-only']"); //Havayolu filtrelerine gel ve sadece Türk hava yollarını seç
        steps.randomClick("div[class='item-domestic departure-flight rt-domestic-item flight'] input[class*='-in-button']"); //Random bir gidiş uçuşu seç
        steps.clickElement("div[class='nav-item sf-airlines'] a[class='filter-section-all']"); //Filtrelerden tüm havayollarını seç
        steps.randomClick("div[class='item-domestic rt-domestic-item flight return-flight'] input[class*='-in-button']"); //Random bir dönüş uçuşu seç
        steps.clickElement("button[class='bt-choose']"); //Devam et butonuna bas

        //Kişisel Bilgileri Doldur
        steps.clickElement("label[id='lb-male']");
        steps.sendKeysToElementTest("input[placeholder='Ad']","Hasancan");
        steps.sendKeysToElementTest("input[placeholder='Soyad']","İŞBECEREN");
        steps.selectElement("select[class='datepicker-select day-select day-of-birth']","17");
        steps.selectElement("select[class='datepicker-select month-select month-of-birth']","03");
        steps.selectElement("select[class='datepicker-select year-select year-of-birth']","1998");
        steps.selectElement("select[class='passenger-nationality']","Türkiye");
        steps.sendKeysToElementTest("input[placeholder='T.C. Kimlik No']","11111111111");
        steps.sendKeysToElementTest("input[placeholder='HES Kodu']","1111111111");
        steps.sendKeysToElementTest("input[id='txtPhone']","5555555555");
        steps.sendKeysToElementTest("input[id='txtEmail']","xmyle@outlook.com");
        steps.clickElement("button[class='btn-lg btn-payment pull-right to-booking']");


    }
}
