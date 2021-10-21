package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass{
	public  SearchPage(){
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//button[text()='✕']")
	private WebElement cancel;
	
	@FindBy(name="q")
	private WebElement Box;
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement search;

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getBox() {
		return Box;
	}

	public WebElement getSearch() {
		return search;
	}
}