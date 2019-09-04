package com.rpa.ppmtickethelperservice.business.automation;

import com.rpa.ppmtickethelperservice.entities.dto.Auth;
import com.rpa.ppmtickethelperservice.entities.dto.TicketPPM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

@RestController
public class TicketAutomation {

    @RequestMapping("/test")
    public static String createTicket(TicketPPM ticketPPM, Auth auth) throws InterruptedException {
        System.out.println("Comenzando Crear Ticket");
        // Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        sleep(3000);

        // Open browser and maximize window
        driver.manage().window().maximize();

        // Open the page
        String url = "https://ppm.softtek.com/";
        driver.get(url);
        System.out.println("Página abierta.");

        // Log in to page
        // enter username
        WebElement username = driver.findElement(By.id("field-username"));
        username.sendKeys(auth.getMail().substring(0, auth.getMail().indexOf("@")));
        // enter password

        WebElement password = driver.findElement(By.id("field-password"));
        password.sendKeys(auth.getPw());

        // push log in button
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"label-LOGON_SUBMIT_BUTTON_CAPTION\"]"));
        logInButton.click();
        System.out.println("Credenciales ingresadas correctamente.");
        sleep(3000);


        // Select type of ticket to create
        // Create Ticket
        WebElement createMenu = driver.findElement(By.xpath("//*[@id=\"yui-gen3\"]/a"));
        createMenu.click();
        // Select sub menu
        WebElement subMenuSol = driver.findElement(By.xpath("//*[@id=\"CREATE_REQUEST\"]/a"));
        subMenuSol.click();
        sleep(3000);
        // Select Option
        WebElement selectOption = driver.findElement(By.linkText("Otros tipos..."));
        selectOption.click();
        // Select Type of ticket
        WebElement selectTicket = driver.findElement(By.xpath(
                "//*[@id=\'page-min-width-div\']/div[5]/div/div/div[1]/div/form/div/table[3]/tbody/tr[16]/td[1]/div/a"));
        selectTicket.click();

        // Create Ticket Type: SERVICE
        // Insert static data: Ingresar WBS
        WebElement WBStext = driver.findElement(By.id("REQ.P.PROJECTAC_TF"));
        WBStext.sendKeys(ticketPPM.getWbs());
        sleep(3000);
        WebElement OrgUnitText = driver.findElement(By.id("REQ.P.ORG_UNITAC_TF"));
        OrgUnitText.click();
        OrgUnitText.sendKeys(ticketPPM.getOrgUnit());
        sleep(5000);
        WebElement AssignedToText = driver.findElement(By.id("REQ.ASSIGNED_TO_USER_IDAC_TF"));
        AssignedToText.sendKeys(ticketPPM.getAssignedTo());
        sleep(3000);
        //Static Data
        WebElement ReqTypeText = driver.findElement(By.id("REQ.P.REQ_TYPEAC_TF")); //id("REQ.P.REQ_TYPEAC_TF"));
        ReqTypeText.click();
        ReqTypeText.sendKeys(ticketPPM.getRequirementType());
        ReqTypeText.click();
        sleep(3000);
        WebElement ReqTypeBtn = driver.findElement(By.id("CH_3AUTOCOMP_IMG"));
        ReqTypeBtn.click();
        //sleep(3000);
        //WebDriver.switchTo().window(String windowHandler)
        //WebElement iFrame = driver.findElement(By.tagName("_yuiResizeMonitor"));
        //driver.switchTo().frame(iFrame);
        //WebElement selectOption = driver.findElement(By.linkText("Service"));
        //ValueReqType.click();
        //driver.switchTo().defaultContent();
        //sleep(3000);


        sleep(3000);
        //Dynamic Data
        //WebElement ReasonBtn = driver.findElement(By.id("CH_4AUTOCOMP_IMG"));
        //ReasonBtn.click();
        WebElement ValueReason = driver.findElement(By.id("REQ.P.REASONAC_TF"));//linkText("Analysis/Collaboration")); //xpath("//*[@id=\'2.22.18.Analysis/Collaboration\']/th")) ;  //
        ValueReason.sendKeys(ticketPPM.getReason());
        ValueReason.click();
        sleep(3000);

        //Static Data
        //WebElement ImpactBtn = driver.findElement(By.id("CH_14AUTOCOMP_IMG"));
        //ImpactBtn.click();
        //sleep(3000);
        WebElement ValueImpact = driver.findElement(By.id("REQ.P.IMPACTAC_TF"));//linkText("Low"));
        ValueImpact.sendKeys(ticketPPM.getImpact());
        ValueImpact.click();
        sleep(3000);

        //Static Data
        //WebElement UrgencyBtn = driver.findElement(By.id("CH_15AUTOCOMP_IMG"));
        //UrgencyBtn.click();
        WebElement ValueUrgency = driver.findElement(By.id("REQ.P.URGENCYAC_TF"));//linkText("Low"));
        ValueUrgency.sendKeys(ticketPPM.getUrgency());
        ValueUrgency.click();
        ValueUrgency.sendKeys(ticketPPM.getUrgency());
        sleep(3000);
        //Seleccionar Prioridad
        //WebElement ValuePriority = driver.findElement(By.id("REQ.P.PRIORITY"));//linkText("Medium"));
        //ValuePriority.click();
        Select ValuePriority = new Select (driver.findElement(By.id("REQ.P.PRIORITY")));
        ValuePriority.selectByVisibleText("Medium");

        //Dynamic Data
        WebElement DescriptionText = driver.findElement(By.id("REQ.DESCRIPTION"));
        DescriptionText.sendKeys(ticketPPM.getDescription());

        //Dynamic Data
        //WebElement CategoryAppBtn = driver.findElement(By.id("CH_4AUTOCOMP_IMG"));
        //CategoryAppBtn.click();
        WebElement ValueCategoryApp = driver.findElement(By.id("REQD.P.CAT_APPAC_TF"));//linkText("Gestión Comercial"));
        ValueCategoryApp.sendKeys(ticketPPM.getCategoryApplication());
        ValueCategoryApp.click();
        sleep(3000);

        //Dynamic Data
        WebElement ClientIdText = driver.findElement(By.id("REQD.P.CLIENT_ID"));
        ClientIdText.sendKeys(ticketPPM.getClientId());

        WebElement requestorNameText = driver.findElement(By.id("REQD.P.REQUESTOR_NAME"));
        requestorNameText.sendKeys(ticketPPM.getRequestorName());

        //Static Data
        WebElement LocationText = driver.findElement(By.id("REQD.P.LOCATIONAC_TF"));
        LocationText.sendKeys(ticketPPM.getLocation());
        sleep(3000);

        //Dynamic Data
        WebElement DetailDescriptiontext = driver.findElement(By.id("REQD.P.DETAILED_DESCRIPTION"));
        DetailDescriptiontext.sendKeys(ticketPPM.getDetailedDescription());
        sleep(3000);

        //WebElement OrgUnitBuscarBtn = driver.findElement(By.xpath("//*[@id=\"filterPanelFindButton\"]"));
        //OrgUnitBuscarBtn.click();
        //sleep(3000);


        //WebElement CreateTkBtn = driver.findElement(By.id("submit"));
        //CreateTkBtn.click();


        System.out.println("Ticket Creado.");

        return auth.getEncryptedPw();
    }
}
