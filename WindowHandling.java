package week4.day1assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);
		//Merge
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		Thread.sleep(1000);
		
		//From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();
		Set<String> from = driver.getWindowHandles();
		System.out.println(from);
		List<String> fromContact=new ArrayList<String>(from);
		driver.switchTo().window(fromContact.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a")).click();
		driver.switchTo().window(fromContact.get(0));

		
		//To Contact
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();
		Set<String> to = driver.getWindowHandles();
		System.out.println(to);
		List<String> toContact=new ArrayList<String>(to);
		driver.switchTo().window(toContact.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[2]/a")).click();
		driver.switchTo().window(toContact.get(0));
		//merge click
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//switch to alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		String title = driver.getTitle();
		
		if(title.contains("Merge Contacts"))
		{
			System.out.println("Title of the page is matched");
		}
		else
		{
			System.out.println("Title is not matched");
		}
		driver.close();

	}

}
