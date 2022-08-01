package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Baseclass;

public class HomePage extends Baseclass
{
	@FindBy(xpath = "//td[contains(text(),'User: zeel modi')]")
	WebElement userNameLable;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects:
	public HomePage()
	{
	   PageFactory.initElements(driver, this);
	}
			
	public String verifyHomePageTitle() // it will return in string
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername()
	{
		return userNameLable.isDisplayed() ;
	}
	
	public ContactPage clickOnContactsLink() // after clicking on Contact link it will navigate to ContactPage so return type is ContactPage
	{
		contactsLink.click();
		return new ContactPage();  // it's a object of ContactPage class 
	}
	
	public DealsPage clickOnDealsLink() // after clicking on Deals link it will navigate to DealsPage so return type is DealsPage
	{
		dealsLink.click();
		return new DealsPage();  // it's a object of DealsPage class 
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	/*  clkonNewContactLink() will hepls you to Read data from excel sheet 
	 *  DATA DRIVEN CONCEPT : Read data from excel sheet and create a new contact
	 *  mousehover on Contact --> click on new contact  --> add new contact
	 */

	public void clkonNewContactLink()  
	{
		Actions a = new Actions(driver);
		a.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
}
