package week4.day1assignment;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SnapDeal {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//men shoe moveToElement
		Actions act=new Actions(driver);
		WebElement mn = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		act.moveToElement(mn).perform();
		
		//sport men shoe moveToElement
		WebElement sh = driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]"));
		act.moveToElement(sh).perform();
		sh.click();
		
		//count of sport shoe
		String count = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
		System.out.println("Count of Sport show : "+count);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//sort from low to high
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//verify it is sorted
		/*List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> intPrice=new ArrayList<Integer>();
		for (WebElement i : price) {
			String text=i.getText();
			String rp=text.replace("Rs. ","");
			int iPrice = Integer.parseInt(rp);
			intPrice.add(iPrice);
			//System.out.println(intPrice);
		}
		for(int j=0;j<intPrice.size()-1;j++)
		{
			if(intPrice.get(j)<=intPrice.get(j+1))
			{
				System.out.println("it is sorted");
			}
			else
			{
				System.out.println("not sorted");
			}
		}*/
		
		//verify it is sorted
		String sort = driver.findElement(By.className("sort-selected")).getText();
		if(sort.contains("Price Low"))
		{
			System.out.println("The displayed is sorted");
		}
		else
		{
			System.out.println("The displayed item not sorted");
		}
		//filter by price
		WebElement range = driver.findElement(By.xpath("(//div[@class='price-text-box'])[1]/input"));
		range.clear();
		range.sendKeys("500");
		WebElement range2 = driver.findElement(By.xpath("(//div[@class='price-text-box'])[2]/input"));
		range2.clear();
		range2.sendKeys("700");
		
		//filter by color
		driver.findElement(By.xpath("//label[@for='Color_s-Black']/span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Quick View
		Actions act1=new Actions(driver);
		WebElement fProd = driver.findElement(By.xpath("//div[@class='clearfix rating av-rating']"));
		act1.moveToElement(fProd).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//First shoe price/rating
		String fprice= driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();	
		System.out.println("Price of the first Shoe: "+fprice);
		String disc= driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();	
		System.out.println("Discount of the first Shoe: "+disc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//screenshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./Snap/img.png");
		FileUtils.copyFile(src,des);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.close();
		
		
		
		
		
	}
	}


