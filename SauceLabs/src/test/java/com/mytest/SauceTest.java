package com.mytest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTest extends BaseTest{
	
	
	public void dologin() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	
	@Test(priority = 1)
	public void checkInventoryItem() {
		dologin();
		Assert.assertTrue(driver.findElements(By.cssSelector(".inventory_item")).size() == 6);
	}
	

	@Test(priority = 2)
	public void checkAddToCartButton() {
		dologin();
		Assert.assertTrue(driver.findElements(By.xpath("//button[text()='Add to cart']")).size() == 6);
	}
	
}
