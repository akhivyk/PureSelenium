package com.solvd.carina.demo.gui.mobilworld.android;

import com.solvd.carina.demo.gui.mobilworld.common.BlogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BlogPage.class)
public class BlogPage extends BlogPageBase {
    public BlogPage(WebDriver driver) {
        super(driver);
    }
}
