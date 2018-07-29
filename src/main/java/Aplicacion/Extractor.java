/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;



import org.openqa.selenium.*;
import java.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 *
 * @author crist
 */
public class Extractor {
    
    public ArrayList<Graduado> extraerPerfiles(){
        ArrayList<Graduado> graduados = new ArrayList<>();
        String LinkedInUri = "https://www.linkedin.com/mynetwork/invite-connect/connections/";
        
        
        DesiredCapabilities capabilities = null;
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        WebDriver webDriver = null;   
        try {
            webDriver = new ChromeDriver(options);
        } catch(Exception e) {
            System.out.println("**>uh-oh " + e.getMessage());
        }
        webDriver.manage().deleteAllCookies();
        webDriver.get(LinkedInUri);
        try{
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys("cristian.pinzon@mail.escuelaing.edu.co");
            password.sendKeys("Cr1030675544");
            boton.click();
        }catch(Exception e){
            webDriver.get("https://www.linkedin.com/uas/login?session_redirect=%2Fvoyager%2FloginRedirect%2Ehtml&fromSignIn=true&trk=uno-reg-join-sign-in");
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys("cristian.pinzon@mail.escuelaing.edu.co");
            password.sendKeys("Cr1030675544");
            boton.click();
        }
      
        webDriver.get(LinkedInUri);
       
        WebElement contacts = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.className("core-rail")));
    
        List<WebElement> lista = new ArrayList<>();
        lista = contacts.findElements(By.tagName("li"));

        for (int i=0 ; i< lista.size() ; i++) {
            WebElement boton = lista.get(i).findElement(By.tagName("a"));
            String main_window = webDriver.getWindowHandle();
            String link = boton.getAttribute("href");
            
            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
            webDriver.findElement(By.tagName("a")).sendKeys(selectLinkOpeninNewTab);
            
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            webDriver.get(link);
            //boton.sendKeys(Keys.CONTROL,Keys.RETURN);
            //for(String winHandle : webDriver.getWindowHandles()){
            //    webDriver.switchTo().window(winHandle);
            //}
            
             JavascriptExecutor jsx = (JavascriptExecutor) webDriver;
            //This will scroll the web page till end.	
            for(int k=0;k<20;k++){
                jsx.executeScript("window.scrollBy(0,200)");
            }

            //Logros
            ArrayList<Logro> logros = new ArrayList<>();
            
            WebElement divSection = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[@class='profile-detail']/div[7]/section")));
            
            List<WebElement> divs = divSection.findElements(By.xpath("./div"));
            
            for(WebElement div : divs){
                Logro tempLogro = new Logro();
                WebElement section = div.findElement(By.tagName("section"));
                String numeroTipo = section.findElement(By.tagName("h3")).getText();
                WebElement div2 = section.findElement(By.tagName("div"));
                String tipo = div2.findElement(By.tagName("h3")).getText();
                WebElement button = div2.findElement(By.tagName("button"));
                jsx.executeScript("arguments[0].click();",button );
                WebElement divLi = div2.findElement(By.tagName("div"));
                WebElement ul = divLi.findElement(By.tagName("ul"));
                List<WebElement> listLi = ul.findElements(By.tagName("li"));
                ArrayList<Sublogro> subLogros = new ArrayList<>();
                for(WebElement li :listLi){
                    String h4 = li.findElement(By.tagName("h4")).getText();
                    List<WebElement> ps = li.findElements(By.tagName("p"));
                    String fecha="NO SE REGISTRA FECHA";
                    String des = "NO SE REGISTRA DESCRIPCION";
                    try{
                        fecha = ps.get(0).getText();
                    }catch(Exception e){
                    }
                    try{
                        des = ps.get(1).getText();
                    }catch(Exception e){
                    }
                    Sublogro st = new Sublogro(h4,fecha,des);
                    subLogros.add(st); 
                }
                tempLogro.setSublogros(subLogros);
                tempLogro.setNumeroTipoLogros(numeroTipo);
                tempLogro.setTipo(tipo);
                logros.add(tempLogro);
            }
            
            
            //Actitudes
            try{
                WebElement boton2 = webDriver.findElement(
                    By.xpath("//*[@class='profile-detail']/div[5]/div/section/div/button"));
                jsx.executeScript("arguments[0].click();", boton2);
            }catch(Exception e){}
            

            Aptitud aptitud = new Aptitud();
            ArrayList<Tupla> validaciones = new ArrayList<>();
            ArrayList<Tupla> conocimientos = new ArrayList<>();
            ArrayList<Tupla> herramientas = new ArrayList<>();
            ArrayList<Tupla> interpersonales = new ArrayList<>();
            ArrayList<Tupla> otros = new ArrayList<>();
            
            try{
                List<WebElement> v = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//*[@class ='profile-detail']/div[5]/div/section/ol/li")));
                    
                //validaciones
                for(WebElement li : v){
                    WebElement ans = li.findElement(By.tagName("p"));
                    String validacionName = "No encontrado";
                    try{
                        validacionName = ans.findElement(By.tagName("a")).getText();
                    }catch(Exception e){
                        validacionName = ans.getText();
                    }
                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String validacionCantidad = "No validado";
                    try{
                        validacionCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    }catch (Exception e){}

                    validaciones.add(new Tupla(validacionName, validacionCantidad));
                }
                  
            }catch (Exception e){}
                
            
            try{
                 List<WebElement> c = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//*[@id='skill-categories-expanded']/div[1]/ol/li")));
                 
                 //conocimiento
                for(WebElement li : c){
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String conocimientoName = "No encontrado";
                    try{
                        ans = ans.findElement(By.tagName("a"));
                        conocimientoName = ans.getText();
                    }catch(Exception e){
                        conocimientoName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String conocimientoCantidad = "No validado";
                    try{
                        conocimientoCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    }catch (Exception e){}
                    conocimientos.add(new Tupla(conocimientoName, conocimientoCantidad));
                }
                
            }catch(Exception e){}
            
            
            try{
                List<WebElement> h = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//*[@id='skill-categories-expanded']/div[2]/ol/li")));
                
                //herramienta
                for(WebElement li : h){
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String herramientaName = "No encontrado";
                    try{
                        ans = ans.findElement(By.tagName("a"));
                        herramientaName = ans.getText();
                    }catch(Exception e){
                        herramientaName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String herramientaCantidad = "No validado";
                    try{
                        herramientaCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    }catch (Exception e){}
                    herramientas.add(new Tupla(herramientaName, herramientaCantidad));
                }
                
            }catch (Exception e){}
            
            
            try{
                
                List<WebElement> inter = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//*[@id='skill-categories-expanded']/div[3]/ol/li")));
                
                 //interpersonales
                for(WebElement li : inter){
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String interName = "No encontrado";
                    try{
                        ans = ans.findElement(By.tagName("a"));
                        interName = ans.getText();
                    }catch(Exception e){
                        interName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String interCantidad = "No validado";
                    try{
                        interCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    }catch (Exception e){}
                    interpersonales.add(new Tupla(interName, interCantidad));
                }
                
                
            }catch (Exception e){}
            
           try{
               List<WebElement> o = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//*[@id='skill-categories-expanded']/div[4]/ol/li")));
               
               //otros
                for(WebElement li : o){
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String otroName = "No encontrado";
                    try{
                        ans = ans.findElement(By.tagName("a"));
                        otroName = ans.getText();
                    }catch(Exception e){
                        otroName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String otroCantidad = "No validado";
                    try{
                        otroCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    }catch (Exception e){}
                    otros.add(new Tupla(otroName, otroCantidad));
                }
               
           }catch(Exception e){}

            aptitud.setValidaciones(validaciones);
            aptitud.setConocimientoSector(conocimientos);
            aptitud.setHerramientas(herramientas);
            aptitud.setInterpersonales(interpersonales);
            aptitud.setOtros(otros);
            
            System.out.println(aptitud);
            System.out.println(logros);
            
            Graduado g = new Graduado();
            g.setAptitud(aptitud);
            g.setLogros(logros);
            graduados.add(g);
            
            webDriver.close();
            webDriver.switchTo().window(main_window);

        }

            //contacts = browser.find_element_by_class_name('core-rail')
            //lista = contacts.find_elements(by="tagName", value="li")
            //time.sleep(5)

        return graduados;
    }
}
