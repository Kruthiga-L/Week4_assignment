package week4.day1assignment;

import java.util.List;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;


public class ActionAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//search
		driver.findElement(By.name("field-keywords")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//price 
		String fprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String replace = fprice.replace(",", "");
		int parseInt = Integer.parseInt(replace);
		System.out.println("Price: "+parseInt);
		//rating
		String rating = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']//span[2]//span")).getText();
		System.out.println("No of Customer Rating: "+rating);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();	
		//Window switch
		Set<String> ph=driver.getWindowHandles();
		List<String> lph=new ArrayList<String>(ph);
		driver.switchTo().window(lph.get(1));
		//Screenshot
		File src= driver.getScreenshotAs(OutputType.FILE);
		File ds=new File("./Amazon/img.png");
		FileUtils.copyFile(src, ds);
		//cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String cart = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']//span[2]/span[2]")).getText();
		String rc = cart.replace(",", "");
		int sbTotal = Integer.parseInt(rc);
		//System.out.println(sbTotal);
		if(parseInt==sbTotal)
		{
			System.out.println("Price and SubTotal is matching");
		}
		else
		{
			System.out.println("Not matching");
		}
		driver.quit();
		
		
}
}
