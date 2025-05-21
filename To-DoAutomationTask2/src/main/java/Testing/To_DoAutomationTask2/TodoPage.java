package Testing.To_DoAutomationTask2;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

import java.util.List;

public class TodoPage {
    WebDriver driver;

    @FindBy(className = "new-todo")
    WebElement taskInput;

    @FindBy(css = "#root > main > ul > li")
    List<WebElement> tasks;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addTask(String taskName) {
        taskInput.sendKeys(taskName);
        taskInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getTasks() {
        return tasks;
    }

    public void completeTask(int index) {
        WebElement checkbox = tasks.get(index).findElement(By.cssSelector("#root > main > ul > li > div > input"));
        checkbox.click();
    }

    public void deleteTask(int index) {
        WebElement task = tasks.get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(task).perform();
        task.findElement(By.cssSelector("#root > main > ul > li > div > button")).click();
    }

    public boolean isTaskCompleted(int index) {
        String className = tasks.get(index).getAttribute("class");
        return className.contains("completed");
    }
    
//    @Step("Add a New Task: {taskName}")
//    public void addTask4(String taskName) {
//        driver.findElement(By.className("new-todo")).sendKeys(taskName + "Do Some Excerises");
//    }
}


