package Pages;

import org.openqa.selenium.By;

public class MainPage {

    public static By title=By.xpath("//*[@id=\"content\"]/h3");
    public static By addElementButton= By.xpath("//*[@id=\"content\"]/div/button");
    public static By deleteElementButton= By.xpath("//*[@id=\"elements\"]/button");
    public static String deleteButtonPart1 ="//*[@id=\"elements\"]/button[";
    public static String deleteButtonPart2 ="]";

    public By deleteElementLocator(int count){
        return By.xpath(deleteButtonPart1+count+deleteButtonPart2);
    }
}
