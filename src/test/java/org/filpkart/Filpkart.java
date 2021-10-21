package org.filpkart;




import java.util.Date;
import java.util.List;

import org.base.BaseClass;
import org.base.IphonePage;
import org.base.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filpkart extends BaseClass{

	@BeforeClass
	private void beforeClass() {
     launchBrowser("Chrome");
     timeDynamic();
     System.out.println("Before class");
	}
	@AfterClass
	private void afterClass() {
		quitBrowser();
	  System.out.println("After class");
       System.out.println();
	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before method");
		System.out.println("Test starts from date of----------"+new Date());
	
	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method");

		System.out.println("Test end of----------"+new Date());
		
	}
	
	
	@Test
	private void test1() throws InterruptedException {
		
			launchUrl("https://www.flipkart.com/");
			timeDynamic();
			SearchPage s=new SearchPage();
			s.getCancel().click();
			fillTextBox(s.getBox(), "iphone");
			s.getSearch().click();
			
			IphonePage ip =new IphonePage();
		
			System.out.println(ip.getIphoneNames().size());
			
			for (int i = 0; i < ip.getIphoneNames().size(); i++) {
				String iphonename = getText(ip.getIphoneNames().get(i));
		        System.out.println(iphonename);
		   }
			

			System.out.println(ip.getIphonePrice().size());
			
			for (int i = 0; i < ip.getIphonePrice().size(); i++) {
				String iphoneprice = getText(ip.getIphonePrice().get(i));
		        System.out.println(iphoneprice);
			
			}
			System.out.println("Test1");
			}
            }          
	
		
	
//	List<String> l=new ArrayList<>();
//	l.add(all1);
//	
//	
//  Set<String> s1=new TreeSet<>();
//  s1.addAll(l);
//  System.out.println();
//  System.out.println(all1);

	
//	List<String> l=new ArrayList<>();
//	l.add(all11);
//	
//	
//  TreeSet<String> s1=new TreeSet<>();
//  s1.addAll(l);
//  
//  System.out.println(s1);
//  System.out.println();
	
	
