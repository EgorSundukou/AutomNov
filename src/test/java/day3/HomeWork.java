package day3;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import java.awt.Dimension;


public class HomeWork {
    WebDriver driver;
    String mainPageDice = "https://www.dice.com/";
    String mainPageIndeed = "https://www.indeed.com/";
    String mainPageMonster= "https://login20.monster.com/Login/SignIn?ch=MONS&intcid=skr_navigation_www_signin";

    By searchFieldKeyword = By.id("search-field-keyword");
    By fieldLocation = By.id("search-field-location");
    By findTechJobs= By.id("findTechJobs");
    By posiCountId= By.id("posiCountId");
    By signinBtn = By.cssSelector(".signin-btn");
    By email=By.id("email");
    By advanceSearchLink = By.id("advanced-search-link");
    By advSearch= By.id("adv_search");
    By partTime = By.xpath("/html/body/div[5]/div/form/div/div[4]/span[2]/input");
    By loginBtnDice = By.cssSelector(".btn-lg");
    By editBtnDice = By.id("editProfile");
    By saveBtnDice = By.cssSelector("button.hidden-sm");
    By desiredPositionInput = By.id("desiredPositionInput");
    String keywordForSearch= "WebDriver";
    String location =  "San Francisco";
    String myEmail = "6940563@gmail.com";
    String myPasw = "6740582Dice";


    @Test
    public void UpdateProfileDice() {

        openMainPage(mainPageDice);
        clickSingInButton();
        typeEmail(myEmail);
        typePasw(myPasw);
        clickButton(loginBtnDice);
        clickButton(editBtnDice);
        waitForElement(desiredPositionInput);
        // String input =  driver.findElement(desiredPositionInput).getText();
        driver.findElement(desiredPositionInput).sendKeys(" ");
        clickButton(saveBtnDice);
        // String input2 =  driver.findElement(By.id("experienceInput")).getText();
        //console.log(input);
        driver.close();
    }

    @Test
    public void UpdateProfileIndeed() {

        openMainPage(mainPageIndeed);
        clickButton(By.cssSelector("#desktopGlobalHeader > nav > ul.icl-DesktopGlobalHeader-items.icl-DesktopGlobalHeader-items--right > li:nth-child(2) > a"));
        driver.findElement(By.id("login-email-input")).sendKeys(myEmail);
        driver.findElement(By.id("login-password-input")).sendKeys("6740582Indeed");
        clickButton(By.id("login-submit-button"));
        clickButton(By.cssSelector("#desktopGlobalHeader > div > nav > ul.icl-DesktopGlobalHeader-items.icl-DesktopGlobalHeader-items--right > span > li > div > span.icl-DesktopGlobalHeader-toggleDropdown"));
        clickButton(By.cssSelector("#desktopGlobalHeader > div > nav > ul.icl-DesktopGlobalHeader-items.icl-DesktopGlobalHeader-items--right > span > li > ul > li:nth-child(1) > a"));
        clickButton(By.cssSelector("#container > div > div.header-wrapper > div > div > div.resume-header.grid-container > div > div.grid-col-md-8.grid-fill-height > div > div.header-text-inner > div.float-right.edit-option > a > svg"));
        driver.findElement(By.cssSelector("#container > div > div.header-wrapper > div > div > div.resume-header.grid-container > div > div.grid-col-md-8.grid-fill-height > div > div.modal-box > div > div > div > div > div > div > div > div > div > div.editor-object-list > div > form > div:nth-child(3) > div > div > input"))
        .sendKeys(" ");

        clickButton(By.cssSelector(".toggleable-link-save"));

        driver.quit();
    }
    @Test
    public void UpdateProfileMonster() {

        openMainPage(mainPageMonster);
        //clickButton(By.cssSelector(".navbar-icon-link > span:nth-child(3)"));
       // clickButton(By.cssSelector("#s-menu-d > li:nth-child(1) > a:nth-child(1)"));
        driver.findElement(By.id("EmailAddress")).sendKeys(myEmail);
        driver.findElement(By.id("Password")).sendKeys("6740582Monster");
        clickButton(By.id("btn-login"));
        clickButton(By.cssSelector("#mobile-navbar-search > ul > li > a > span:nth-child(4)"));
        clickButton(By.cssSelector("#mobile-navbar-search > ul > li > ul > li:nth-child(5) > a"));
        clickButton(By.id("prfSummary"));
        driver.findElement(By.id("SummaryContent"))
                .sendKeys(" ");

        clickButton(By.cssSelector("#form0 > div:nth-child(6) > div > div:nth-child(4) > button"));

        driver.quit();
    }










    @Test
    public void Test001() {
        //openMainPage();
        typeKeyword(keywordForSearch);
        typeLocation(location);
        submitSearch();
        checkResultOfSearch(posiCountId);
       //driver.findElement(searchFieldKeyword);
    }
        //sing in test
    @Test
    public void testLogin() {

       // openMainPage();
        clickSingInButton();
        typeEmail(myEmail);
        typePasw(myPasw);
        clickButton(loginBtnDice);
        assertThatLogin();
    }

    private void assertThatLogin() {
        boolean finded=  driver.findElement(By.id("profileContactlastName")).isDisplayed();
        Assert.assertTrue(finded);
    }

    private void clickButton(By button) {
        driver.findElement(button).click(); //sign-in-button
    }

    private void typePasw(String myPasw) {
        driver.findElement(By.id("password")).sendKeys(myPasw);
    }

    private void typeEmail(String myEmail) {
        driver.findElement(email).sendKeys(myEmail);
    }

    private void clickSingInButton() {
        driver.findElement(signinBtn).click();

    }

    @Test
    public void testAdvSearch() {

       // openMainPage();
        clickSingInButton();
        typeEmail(myEmail);
        typePasw(myPasw);
        clickButton(loginBtnDice);
        clickAdvanceSearch();
        typeKeyWordAdvance(keywordForSearch,By.id("for_one"));
        typeCityAdvance(location,By.id("for_loc"));
        scrolToElement();
        scrollToSlider();
//        moveSliderToHigherValue();
        clickAdvancedSearchBtn();
        checkResultOfSearch(posiCountId);

    }
    @Test
    public void Test005(){
       // openMainPage();
        Dimension d = new Dimension(991, 800);
        driver.manage().window().setSize(d);


    }


    private void scrolToElement() {
        WebElement radius= driver.findElement(By.id("radiusMileAnchor"));
        ( (JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",radius);
    }


    private void clickAdvancedSearchBtn() {
        driver.findElement(advSearch).click();
    }

    private void scrollToSlider() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement radius= driver.findElement(By.id("radiusMileAnchor"));

       // js.executeScript("arguments[0].setAttribute('style', 'left: 60%;')",radius);
        radius.sendKeys(Keys.ARROW_RIGHT);
//js.executeScript("arguments[0].setAttribute('style', 'left: 100%;')",radius);
    }

    private void typeCityAdvance(String location,By field) {
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(location);
    }


    private void typeKeyWordAdvance(String keywordForSearch,By id) {
        driver.findElement(id).sendKeys(keywordForSearch);
    }

    private void clickAdvanceSearch() {
        waitForElement(advanceSearchLink);
        driver.findElement(advanceSearchLink).click();
    }

    //search for part-time jobs
    @Test
    public void tastPartTime() {
       // openMainPage();
        clickSingInButton();
        typeEmail(myEmail);
        typePasw(myPasw);
        clickButton(loginBtnDice);
        typeKeyWordAdvance(keywordForSearch, By.id("job"));
        typeCityAdvance(location,By.id("location"));
       // clickAdvanceSearch();
        clickCheckBox(partTime);
        checkResultOfSearch(posiCountId);
    }
    private void clickCheckBox(By xpath) {
      //driver.findElement(xpath).sendKeys(Keys.SPACE);
        driver.findElement(xpath).click();
    }
    @Test
    public void test_skills_Center() {
     //   openMainPage();
        clickCareer();
        choseSkillsCenterFromDropdList();
        typeKeyWordAdvance(keywordForSearch, By.id("s"));
        submit();
        checkResultOfSearch(By.id("piechart-canvas"));
    }

    private void submit() {
        driver.findElement(By.id("s")).sendKeys(Keys.ENTER);
    }

    private void choseSkillsCenterFromDropdList() {
        driver.findElement(By.xpath("/html/body/div[5]/header/div[1]/div/div[2]/ul[1]/li[1]/ul/li[2]/a")).click();
    }

    private void clickCareer() {
        driver.findElement(By.id("smart-toggle-Career")).click();
    }

    private void checkResultOfSearch(By elem) {
        waitForElement(elem);
//        boolean finded = false;
//        try {
//            finded=  driver.findElement(posiCountId).isDisplayed();
//        } catch (Exception e){
//            finded = false;
//        }
        boolean finded=  driver.findElement(elem).isDisplayed();
        Assert.assertTrue(finded);
    }

    private void waitForElement(By posiCountId) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebElement element =
        wait.until(ExpectedConditions.visibilityOfElementLocated(posiCountId));
    }


    private void submitSearch() {
        driver.findElement(findTechJobs).click();
    }

    private void typeLocation(String location) {
        driver.findElement(fieldLocation).clear();
        driver.findElement(fieldLocation).sendKeys(location);
    }


    private void typeKeyword(String keywordForSearch) {
        driver.findElement(searchFieldKeyword).sendKeys(keywordForSearch);


    }

    private void openMainPage(String mainPage) {
        driver.get(mainPage);
    }


    @BeforeSuite
    public void setup9(){
        String property = "webdriver.gecko.driver";
        String value = "C:\\AutomNov-master\\src\\test\\resources\\geckodriver.exe";
        System.setProperty(property,value);
        driver= new FirefoxDriver();
    }
}
