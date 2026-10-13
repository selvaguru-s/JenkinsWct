package JenkinsTask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WctJenkins {
	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			driver.get("https://whalecoursetechnologies.com/");

			Actions actions = new Actions(driver);

			// ============================================================
			// HOVER OVER COURSES - WAIT 2 SECONDS
			// ============================================================

			WebElement courses = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(@class,'nav-link-1') and normalize-space()='Courses']")));

			hoverAndWait(actions, courses, "Courses");

			// ============================================================
			// HOVER OVER JOB GUARANTEE - WAIT 2 SECONDS
			// ============================================================

			WebElement jobGuarantee = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(@class,'nav-link-1') and normalize-space()='Job Guarantee']")));

			hoverAndWait(actions, jobGuarantee, "Job Guarantee");

			// ============================================================
			// HOVER OVER SOCIAL PROFILES - WAIT 2 SECONDS
			// ============================================================

			WebElement socialProfiles = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(@class,'nav-link-1') and normalize-space()='Social Profiles']")));

			hoverAndWait(actions, socialProfiles, "Social Profiles");

			// ============================================================
			// HOVER OVER PLACEMENT RECORDS - WAIT 2 SECONDS
			// ============================================================

			WebElement placementRecords = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Placement Records\"]")));

			hoverAndWait(actions, placementRecords, "Placement Records");

			// ============================================================
			// HOVER OVER RESOURCES - WAIT 2 SECONDS
			// ============================================================

			WebElement resources = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(@class,'nav-link-1') and normalize-space()='Resources']")));

			hoverAndWait(actions, resources, "Resources");

			// ============================================================
			// CLICK RESOURCES
			// ============================================================

			wait.until(ExpectedConditions.elementToBeClickable(resources)).click();

			System.out.println("Clicked Resources");

			Thread.sleep(1000);

			// ============================================================
			// CLICK TESTING TOOLS
			// ============================================================

			WebElement testingTools = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[contains(@class,'dropdown-menu')]//a[normalize-space()='Testing Tools']")));

			testingTools.click();

			System.out.println("Clicked Testing Tools");

			Thread.sleep(1000);

			// ============================================================
			// VERIFY REGISTER PAGE
			// ============================================================

			WebElement registerHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h1[normalize-space()='Register'] | //h2[normalize-space()='Register']")));

			System.out.println("Register page is displayed");

			Thread.sleep(1000);

			// ============================================================
			// FIRST NAME
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")))
					.sendKeys("Nobi");

			Thread.sleep(500);

			// ============================================================
			// LAST NAME
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")))
					.sendKeys("Asta");

			Thread.sleep(1000);

			// ============================================================
			// ADDRESS
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).sendKeys("Chennai");

			Thread.sleep(1000);

			// ============================================================
			// EMAIL
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")))
					.sendKeys("nobiasta@gmail.com");

			Thread.sleep(500);

			// ============================================================
			// PHONE
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='tel']")))
					.sendKeys("9176693516");

			Thread.sleep(500);

			// ============================================================
			// SELECT MALE RADIO BUTTON
			// ============================================================

			WebElement maleRadio = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @value='Male']")));

			if (!maleRadio.isSelected()) {

				try {
					maleRadio.click();

				} catch (ElementClickInterceptedException e) {

					js.executeScript("arguments[0].click();", maleRadio);
				}
			}

			Thread.sleep(500);

			// ============================================================
			// SELECT CHECKBOX 1
			// ============================================================

			WebElement checkbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox1")));

			selectCheckbox(driver, wait, checkbox1);

			Thread.sleep(500);

			// ============================================================
			// SELECT CHECKBOX 2
			// ============================================================

			WebElement checkbox2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox2")));

			selectCheckbox(driver, wait, checkbox2);

			Thread.sleep(500);

			// ============================================================
			// CLICK REGISTER HEADING TO CLOSE LANGUAGE DROPDOWN
			// ============================================================

			wait.until(ExpectedConditions.elementToBeClickable(registerHeading)).click();

			Thread.sleep(1000);

			// ============================================================
			// SELECT SKILL = JAVA
			// ============================================================

			WebElement skillsDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Skills")));

			new Select(skillsDropdown).selectByVisibleText("Java");

			Thread.sleep(500);

			// ============================================================
			// LEAVE MANDATORY COUNTRY DROPDOWN EMPTY
			// ============================================================

			WebElement countryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("countries")));

			System.out.println("Country dropdown intentionally left empty");

			Thread.sleep(500);

			// ============================================================
			// SELECT SECOND COUNTRY = INDIA
			// ============================================================

			WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));

			new Select(country).selectByVisibleText("India");

			Thread.sleep(500);

			// ============================================================
			// SELECT YEAR = 1998
			// ============================================================

			WebElement year = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Year']")));

			new Select(year).selectByVisibleText("1998");

			Thread.sleep(500);

			// ============================================================
			// SELECT MONTH = MAY
			// ============================================================

			WebElement month = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Month']")));

			new Select(month).selectByVisibleText("May");

			Thread.sleep(500);

			// ============================================================
			// SELECT DAY = 15
			// ============================================================

			WebElement day = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Day']")));

			new Select(day).selectByVisibleText("15");

			Thread.sleep(500);

			// ============================================================
			// PASSWORD
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstpassword"))).sendKeys("Nobi123");

			Thread.sleep(500);

			// ============================================================
			// CONFIRM PASSWORD
			// ============================================================

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secondpassword"))).sendKeys("Nobi123");

			Thread.sleep(1000);

			// ============================================================
			// SUBMIT
			// ============================================================

			WebElement submit = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']")));

			submit.click();

			System.out.println("Submit button clicked");

			Thread.sleep(1000);

			// ============================================================
			// VALIDATE MANDATORY COUNTRY FIELD
			// ============================================================

			boolean isCountryValid = (Boolean) js.executeScript("return arguments[0].checkValidity();",
					countryDropdown);

			String countryErrorMessage = (String) js.executeScript("return arguments[0].validationMessage;",
					countryDropdown);

			System.out.println("Country validation message: " + countryErrorMessage);

			// ============================================================
			// ASSERTIONS
			// ============================================================

			if (!isCountryValid) {

				System.out.println("PASS: Country field is mandatory");

			} else {

				System.out.println("FAIL: Country field is not mandatory");
			}

			if (countryErrorMessage != null && countryErrorMessage.toLowerCase().contains("select")) {

				System.out.println("PASS: Expected validation message displayed");

			} else {

				System.out.println("FAIL: Validation message is not as expected");
			}

		} finally {

			// Always close browser
			driver.quit();

			long endTime = System.currentTimeMillis();

			double totalTime = (endTime - startTime) / 1000.0;

			System.out.println("----------------------------------");
			System.out.println("Total Execution Time: " + totalTime + " seconds");
			System.out.println("----------------------------------");
		}
	}

	// ================================================================
	// REUSABLE HOVER METHOD
	// ================================================================

	public static void hoverAndWait(Actions actions, WebElement element, String menuName) throws InterruptedException {

		actions.moveToElement(element).perform();

		System.out.println("Hovered over " + menuName);

		Thread.sleep(2000);
	}

	// ================================================================
	// REUSABLE CHECKBOX HANDLING METHOD
	// ================================================================

	public static void selectCheckbox(WebDriver driver, WebDriverWait wait, WebElement checkbox) {

		if (checkbox.isSelected()) {

			System.out.println(checkbox.getAttribute("id") + " already selected");

			return;
		}

		try {

			// First attempt: normal Selenium click
			wait.until(ExpectedConditions.elementToBeClickable(checkbox));

			checkbox.click();

		} catch (ElementClickInterceptedException e) {

			System.out.println(
					"Normal click intercepted for " + checkbox.getAttribute("id") + ". Trying JavaScript fallback.");

			// Scroll checkbox into visible area
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);

			try {

				// Retry normal click
				wait.until(ExpectedConditions.elementToBeClickable(checkbox));

				checkbox.click();

			} catch (ElementClickInterceptedException secondException) {

				// Final fallback: JavaScript click
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
			}
		}

		// Verify checkbox is selected
		if (checkbox.isSelected()) {

			System.out.println("PASS: " + checkbox.getAttribute("id") + " selected");

		} else {

			throw new AssertionError("FAIL: Could not select " + checkbox.getAttribute("id"));
		}
	}

}
