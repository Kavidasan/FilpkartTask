package org.base;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphonePage  extends BaseClass{
	public  IphonePage(){
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> iphoneNames;
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> iphonePrice;
	
	
	public List<WebElement> getIphoneNames() {
		return iphoneNames;
	}
	public List<WebElement> getIphonePrice() {
		return iphonePrice;
	}
	
}
