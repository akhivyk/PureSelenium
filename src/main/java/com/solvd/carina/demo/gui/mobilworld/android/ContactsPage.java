package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.ContactsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactsPageBase.class)
public class ContactsPage extends ContactsPageBase {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }
}
