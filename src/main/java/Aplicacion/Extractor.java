/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Presentacion.MostrarInformacion;
import org.openqa.selenium.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author crist
 */
public class Extractor implements Runnable {

    String LinkedInUri = "https://www.linkedin.com/mynetwork/invite-connect/connections/";
    WebDriver webDriver = null;
    String Contactos;
    String email, password;
    private int numeroBusqueda;
    ConcurrentLinkedQueue<Graduado> graduados = new ConcurrentLinkedQueue<>();
    private final String ACTITUDES = "Cantidad de Aptitudes";
    private final String LOGROS = "Cantidad de Logros";
    private final String EXPERIENCIA = "Cantidad de Experiencia";
    private final String NOMBRES = "Nombres";

    public Extractor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String extraerNumeroContactos() {
        DesiredCapabilities capabilities = null;
        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        } catch (Exception ex) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");

        }

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        try {
            webDriver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("**>uh-oh " + e.getMessage());
        }
        webDriver.manage().deleteAllCookies();
        webDriver.get(LinkedInUri);
        try {
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys(this.email);
            password.sendKeys(this.password);
            boton.click();
        } catch (Exception e) {
            webDriver.get("https://www.linkedin.com/uas/login?session_redirect=%2Fvoyager%2FloginRedirect%2Ehtml&fromSignIn=true&trk=uno-reg-join-sign-in");
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys(this.email);
            password.sendKeys(this.password);
            boton.click();
        }

        webDriver.get(LinkedInUri);

        WebElement contacts = (new WebDriverWait(webDriver, 5)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("core-rail")));

        List<WebElement> lista = new ArrayList<>();
        lista = contacts.findElements(By.tagName("li"));
        Contactos = Integer.toString(lista.size());
        webDriver.quit();

        return Contactos;
    }

    public ArrayList<Graduado> extraerPerfiles() {

        return null;
    }

    public Graduado[] OrdenarGraduadosPor(String metodoFiltrar) {
        Graduado[] sort = graduados.toArray(new Graduado[graduados.size()]);
        if (metodoFiltrar.equals(NOMBRES)) {
            Arrays.sort(sort, (Graduado g1, Graduado g2) -> g1.getPerfil().getNombre().compareTo(g2.getPerfil().getNombre()));
        } else if (metodoFiltrar.equals(NOMBRES)) {

        }
        return sort;
    }

    @Override
    public void run() {

        DesiredCapabilities capabilities = null;
        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        } catch (Exception ex) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");

        }

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        try {
            webDriver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("**>uh-oh " + e.getMessage());
        }
        webDriver.manage().deleteAllCookies();
        webDriver.get(LinkedInUri);
        try {
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys(this.email);
            password.sendKeys(this.password);
            boton.click();
        } catch (Exception e) {
            webDriver.get("https://www.linkedin.com/uas/login?session_redirect=%2Fvoyager%2FloginRedirect%2Ehtml&fromSignIn=true&trk=uno-reg-join-sign-in");
            WebElement email = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_key-login']")));
            WebElement password = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='session_password-login']")));
            WebElement boton = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn-primary']")));
            email.sendKeys(this.email);
            password.sendKeys(this.password);
            //email.sendKeys("ricardo.pinto@mail.escuelaing.edu.co");
            //password.sendKeys("Insertiniciofin8");
            //email.sendKeys("cristian.pinzon@mail.escuelaing.edu.co");
            //password.sendKeys("Cr1030675544");
            boton.click();
        }

        webDriver.get(LinkedInUri);

        WebElement contacts = (new WebDriverWait(webDriver, 5)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("core-rail")));

        List<WebElement> lista = new ArrayList<>();
        lista = contacts.findElements(By.tagName("li"));
        Contactos = Integer.toString(lista.size());
        for (int i = 0; i < 5; i++) {
            WebElement boton = lista.get(i).findElement(By.tagName("a"));
            String main_window = webDriver.getWindowHandle();
            String link = boton.getAttribute("href");

            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
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
            for (int k = 0; k < 20; k++) {
                jsx.executeScript("window.scrollBy(0,200)");
            }

            //Perfil
            WebElement divNombre = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("div.mt4.display-flex.ember-view")));
            String nombre = "", cargo = "", pais = "", descripcion = "", url = "";
            try {
                nombre = divNombre.findElement(By.tagName("h1")).getText();
            } catch (Exception e) {
            }
            try {
                cargo = divNombre.findElement(By.tagName("h2")).getText();
            } catch (Exception e) {
            }
            try {
                pais = divNombre.findElement(By.tagName("h3")).getText();
            } catch (Exception e) {
            }
            try {
                WebElement prin = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfElementLocated(By.className("core-rail")));
                WebElement divDescripcion = prin.findElements(By.tagName("div")).get(1);
                WebElement botonMostrarMasDescripcion = divDescripcion.findElements(By.tagName("div")).get(13).findElement(By.tagName("button"));
                jsx.executeScript("arguments[0].click();", botonMostrarMasDescripcion);
                descripcion = divDescripcion.findElements(By.tagName("div")).get(13).findElement(By.tagName("p")).getText();
            } catch (Exception e) {
            }
            WebElement divUrl = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("div.pv-top-card-section__photo-wrapper.pv-top-card-v2-section__photo-wrapper")));
            WebElement div2Url = divUrl.findElement(By.tagName("div"));
            WebElement div3Url = div2Url.findElement(By.tagName("div"));
            try {
                url = div3Url.getAttribute("style").replace("background-image: url(", "").replace("\"", "").replace("\"", "").replace(");", "");
            } catch (Exception e) {
            }
            Perfil p = new Perfil();
            p.setCargoActual(cargo);
            p.setDescripcion(descripcion);
            p.setNombre(nombre);
            p.setPais(pais);
            p.setPhoto(url);

            System.out.println("||||||");
            System.out.println(nombre);
            System.out.println(cargo);
            System.out.println(pais);
            System.out.println(descripcion);
            System.out.println(url);

            //Experiencias
            ArrayList<Experiencia> experiencias = new ArrayList<>();

            WebElement divSectionExp = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[@class='profile-detail']/div[4]")));

            //WebElement botonExpMas = divSectionExp.findElement(By.tagName("span")).findElement(By.tagName("section")).findElement(By.tagName("div")).findElement(By.tagName("section")).findElement(By.tagName("button"));
            WebElement listaExp = divSectionExp.findElement(By.tagName("ul"));

            List<WebElement> elementosLista = listaExp.findElements(By.tagName("li"));

            for (WebElement elemento : elementosLista) {
                List<WebElement> divTrabajos = elemento.findElement(By.tagName("a")).findElements(By.tagName("div"));
                WebElement divTrabajo = divTrabajos.get(1);
                String nombre2 = "", lugar = "", fecha = "", ubicacion = "", descripcion1 = "";
                try {
                    nombre2 = divTrabajo.findElement(By.tagName("h3")).getText();
                } catch (Exception e) {
                }
                try {
                    lugar = divTrabajo.findElements(By.tagName("h4")).get(0).getText().replace("Nombre de la empresa\n", "");
                } catch (Exception e) {
                }
                try {
                    fecha = divTrabajo.findElements(By.tagName("h4")).get(1).getText().replace("Fechas de empleo\n", "");
                } catch (Exception e) {
                }
                try {
                    ubicacion = divTrabajo.findElements(By.tagName("h4")).get(3).getText().replace("Ubicación\n", "");
                } catch (Exception e) {
                }
                try {
                    descripcion1 = elemento.findElement(By.cssSelector("div.pv-entity__extra-details.ember-view")).getText().replace("Nombre de la empresa\n", "");
                } catch (Exception e) {
                }
                System.out.println("11111111111111");
                //    System.out.println(descripcion1);
                //    System.out.println(fecha);
                System.out.println(lugar);
                //    System.out.println(nombre2);
                //    System.out.println(ubicacion);
                Experiencia exp = new Experiencia();
                exp.setDescripcion(descripcion1);
                exp.setFecha(fecha);
                exp.setLugar(lugar);
                exp.setNombre(nombre2);
                exp.setUbicacion(ubicacion);

                experiencias.add(exp);

            }

            //Educaciones
            ArrayList<Educacion> educaciones = new ArrayList<>();
            try {
                WebElement divSectionEdu = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//*[@class='profile-detail']/div[4]")));

                //WebElement botonExpMas = divSectionExp.findElement(By.tagName("span")).findElement(By.tagName("section")).findElement(By.tagName("div")).findElement(By.tagName("section")).findElement(By.tagName("button"));
                WebElement listaEst = divSectionEdu.findElements(By.tagName("ul")).get(1);

                List<WebElement> elementosLista2 = listaEst.findElements(By.tagName("li"));

                for (WebElement elemento : elementosLista2) {
                    List<WebElement> divTrabajos = elemento.findElement(By.tagName("a")).findElements(By.tagName("div"));
                    WebElement divTrabajo = divTrabajos.get(1);
                    String nombreLugar = "", nombreCurso = "", periodo = "", actividades = "", detallesExtra = "";
                    try {
                        nombreLugar = divTrabajo.findElement(By.tagName("h3")).getText();
                    } catch (Exception e) {
                    }
                    try {
                        nombreCurso = divTrabajo.findElements(By.tagName("div")).get(0).findElements(By.tagName("p")).get(0).findElements(By.tagName("span")).get(1).getText();
                    } catch (Exception e) {
                    }
                    try {
                        periodo = divTrabajo.findElement(By.cssSelector("p.pv-entity__dates")).findElements(By.tagName("span")).get(1).getText();
                    } catch (Exception e) {
                    }
                    try {
                        actividades = divTrabajo.findElements(By.tagName("p")).get(4).findElements(By.tagName("span")).get(1).getText();
                    } catch (Exception e) {
                    }
                    try {
                        detallesExtra = elemento.findElement(By.cssSelector("div.pv-entity__extra-details.ember-view")).getText();
                    } catch (Exception e) {
                    }
                    //    System.out.println("22222222222");
                    //    System.out.println(nombreLugar);
                    //    System.out.println(nombreCurso);
                    //    System.out.println(periodo);
                    //    System.out.println(actividades);
                    //    System.out.println(detallesExtra);
                    Educacion edu = new Educacion();
                    edu.setActividades(actividades);
                    edu.setDetallesExtra(detallesExtra);
                    edu.setNombreCurso(nombreCurso);
                    edu.setNombreLugar(nombreLugar);
                    edu.setPeriodo(periodo);

                    educaciones.add(edu);

                }
            } catch (Exception e) {
            }

            //Logros
            ArrayList<Logro> logros = new ArrayList<>();

            WebElement divSection = (new WebDriverWait(webDriver, 5)).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[@class='profile-detail']/div[7]/section")));

            List<WebElement> divs = divSection.findElements(By.xpath("./div"));

            for (WebElement div : divs) {
                Logro tempLogro = new Logro();
                WebElement section = div.findElement(By.tagName("section"));
                String numeroTipo = section.findElement(By.tagName("h3")).getText();
                WebElement div2 = section.findElement(By.tagName("div"));
                String tipo = div2.findElement(By.tagName("h3")).getText();
                WebElement button = div2.findElement(By.tagName("button"));
                jsx.executeScript("arguments[0].click();", button);
                WebElement divLi = div2.findElement(By.tagName("div"));
                WebElement ul = divLi.findElement(By.tagName("ul"));
                List<WebElement> listLi = ul.findElements(By.tagName("li"));
                ArrayList<Sublogro> subLogros = new ArrayList<>();
                for (WebElement li : listLi) {
                    String h4 = li.findElement(By.tagName("h4")).getText();
                    List<WebElement> ps = li.findElements(By.tagName("p"));
                    String fecha = "NO SE REGISTRA FECHA";
                    String des = "NO SE REGISTRA DESCRIPCION";
                    try {
                        fecha = ps.get(0).getText();
                    } catch (Exception e) {
                    }
                    try {
                        des = ps.get(1).getText();
                    } catch (Exception e) {
                    }
                    Sublogro st = new Sublogro(h4, fecha, des);
                    System.out.println(st.getNombreSublogro());
                    System.out.println(st.getDescripcion());
                    System.out.println(st.getFecha());

                    subLogros.add(st);
                }
                tempLogro.setSublogros(subLogros);
                tempLogro.setNumeroTipoLogros(numeroTipo);
                tempLogro.setTipo(tipo);
                logros.add(tempLogro);
            }

            //Actitudes
            try {
                WebElement boton2 = webDriver.findElement(
                        By.xpath("//*[@class='profile-detail']/div[5]/div/section/div/button"));
                jsx.executeScript("arguments[0].click();", boton2);
            } catch (Exception e) {
            }

            Aptitud aptitud = new Aptitud();
            ArrayList<Tupla> validaciones = new ArrayList<>();
            ArrayList<Tupla> conocimientos = new ArrayList<>();
            ArrayList<Tupla> herramientas = new ArrayList<>();
            ArrayList<Tupla> interpersonales = new ArrayList<>();
            ArrayList<Tupla> otros = new ArrayList<>();

            try {
                List<WebElement> v = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@class ='profile-detail']/div[5]/div/section/ol/li")));

                //validaciones
                for (WebElement li : v) {
                    WebElement ans = li.findElement(By.tagName("p"));
                    String validacionName = "No encontrado";
                    try {
                        validacionName = ans.findElement(By.tagName("a")).getText();
                    } catch (Exception e) {
                        validacionName = ans.getText();
                    }
                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String validacionCantidad = "No validado";
                    try {
                        validacionCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    } catch (Exception e) {
                    }

                    validaciones.add(new Tupla(validacionName, validacionCantidad));
                }

            } catch (Exception e) {
            }

            try {
                List<WebElement> c = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@id='skill-categories-expanded']/div[1]/ol/li")));

                //conocimiento
                for (WebElement li : c) {
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String conocimientoName = "No encontrado";
                    try {
                        ans = ans.findElement(By.tagName("a"));
                        conocimientoName = ans.getText();
                    } catch (Exception e) {
                        conocimientoName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String conocimientoCantidad = "No validado";
                    try {
                        conocimientoCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    } catch (Exception e) {
                    }
                    conocimientos.add(new Tupla(conocimientoName, conocimientoCantidad));
                }

            } catch (Exception e) {
            }

            try {
                List<WebElement> h = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@id='skill-categories-expanded']/div[2]/ol/li")));

                //herramienta
                for (WebElement li : h) {
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String herramientaName = "No encontrado";
                    try {
                        ans = ans.findElement(By.tagName("a"));
                        herramientaName = ans.getText();
                    } catch (Exception e) {
                        herramientaName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String herramientaCantidad = "No validado";
                    try {
                        herramientaCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    } catch (Exception e) {
                    }
                    herramientas.add(new Tupla(herramientaName, herramientaCantidad));
                }

            } catch (Exception e) {
            }

            try {

                List<WebElement> inter = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@id='skill-categories-expanded']/div[3]/ol/li")));

                //interpersonales
                for (WebElement li : inter) {
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String interName = "No encontrado";
                    try {
                        ans = ans.findElement(By.tagName("a"));
                        interName = ans.getText();
                    } catch (Exception e) {
                        interName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String interCantidad = "No validado";
                    try {
                        interCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    } catch (Exception e) {
                    }
                    interpersonales.add(new Tupla(interName, interCantidad));
                }

            } catch (Exception e) {
            }

            try {
                List<WebElement> o = (new WebDriverWait(webDriver, 5)).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@id='skill-categories-expanded']/div[4]/ol/li")));

                //otros
                for (WebElement li : o) {
                    WebElement ans = li.findElement(By.tagName("div"));
                    ans = ans.findElement(By.tagName("p"));
                    String otroName = "No encontrado";
                    try {
                        ans = ans.findElement(By.tagName("a"));
                        otroName = ans.getText();
                    } catch (Exception e) {
                        otroName = ans.getText();
                    }

                    WebElement ans2 = li.findElement(By.tagName("div"));
                    String otroCantidad = "No validado";
                    try {
                        otroCantidad = ans2.findElements(By.tagName("a")).get(1).getText();
                    } catch (Exception e) {
                    }
                    otros.add(new Tupla(otroName, otroCantidad));
                }

            } catch (Exception e) {
            }

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
            g.setPerfil(p);
            g.setExperiencia(experiencias);
            g.setEducacion(educaciones);
            graduados.add(g);

            webDriver.close();
            webDriver.switchTo().window(main_window);

            MostrarInformacion.getApp().pintarDatos(graduados);
            if (!MostrarInformacion.getApp().getEstadoBusqueda()) {

                synchronized (MostrarInformacion.getApp().o) {
                    try {
                        synchronized (MostrarInformacion.getApp().ob2) {
                            MostrarInformacion.getApp().ob2.notify();
                        }
                        MostrarInformacion.getApp().o.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Extractor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            //progreso = Integer.toString(i+1);
        }

        webDriver.quit();
        MostrarInformacion.getApp().setGraduados(graduados);
    }

}
