package com.cydeo.step_definitions;


import com.cydeo.pages.TodoElements;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TodoStepDefs {
    TodoElements todoElements;
    Faker faker;
    @Given("user is on the Todo home page")
    public void user_is_on_the_todo_home_page() {
        Driver.getDriver().get("http://todomvc.com/");
        todoElements = new TodoElements();
    }
    @When("user click Javascript tab")
    public void user_click_javascript_tab() {
        todoElements.javaScript.click();


    }
    @When("user select Polymer link")
    public void user_select_polymer_link() {
        todoElements.polymer.click();
    }
    @When("user add first todo item and second item")
    public void user_add_first_todo_item_and_second_item() {
        faker = new Faker();
        todoElements.toDoItem.sendKeys(faker.animal().name()+ Keys.ENTER+faker.animal().name() + Keys.ENTER);
    }
    @Then("user should re-edit second item")
    public void user_should_re_edit_second_item() {
        Actions actions = new Actions(Driver.getDriver());

        String first = todoElements.SecondItem.getText();

        actions.doubleClick(todoElements.SecondItem).perform();



        todoElements.inPut.sendKeys(Keys.chord(Keys.CONTROL+"a")+Keys.BACK_SPACE);
        todoElements.inPut.sendKeys(faker.animal().name()+Keys.ENTER);

        String second = todoElements.SecondItem.getText();

        System.out.println(first+ "  " + second);

        Assert.assertTrue(!first.equals(second));

        Driver.getDriver().close();

    }
}













/*
public class toDoTask {

    @Given("user load the website")
    public void user_load_the_website() {
        Driver.getDriver().get("https://todomvc.com/");
    }
    @When("click within the JavaScript tab")
    public void click_within_the_java_script_tab() {
        Driver.getDriver().findElement(By.xpath("//div[text()='JavaScript']")).click();
    }
    @When("select Polymer link")
    public void select_polymer_link() {
        Driver.getDriver().findElement(By.xpath("//ul/li[8]/a[text()='Polymer']")).click();
    }
    @When("add two Todo items")
    public void add_two_todo_items() {
        Faker faker = new Faker();

        WebElement toDO = Driver.getDriver().findElement(By.id("new-todo"));

        toDO.sendKeys(faker.animal().name()+ Keys.ENTER+faker.animal().name()+Keys.ENTER);

        WebElement secondItem = Driver.getDriver().findElement(By.xpath("//li[2]//div//label[@class='style-scope td-item']"));


    }
    @When("edit the content of the second Todo item")
    public void edit_the_content_of_the_second_todo_item() {
        Actions actions = new Actions(Driver.getDriver());
        WebElement secondItem = Driver.getDriver().findElement(By.xpath("//li[2]//div//label[@class='style-scope td-item']"));



        actions.doubleClick(secondItem).perform();

        WebElement edit = Driver.getDriver().findElement(By.xpath("//input[@id='edit']"));
        edit.sendKeys(Keys.chord(Keys.COMMAND, "a")+ Keys.BACK_SPACE);
        //chord   bu method sayesinde 2 action aynı anda kullanılabiliyor


        edit.sendKeys("earth"+ Keys.ENTER);
    }
    @Then("user should see the edited second item on Todo list")
    public void user_should_see_the_edited_second_item_on_todo_list() {
        String actual = "earth";
        String expected = "earth";
        Assert.assertEquals(actual,expected);
    }

}
/*
Driver.getDriver().get("https://todomvc.com/");
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//div[text()='JavaScript']")).click();
        Driver.getDriver().findElement(By.xpath("//ul/li[8]/a[text()='Polymer']")).click();

        Faker faker = new Faker();

        WebElement toDO = Driver.getDriver().findElement(By.id("new-todo"));

        toDO.sendKeys(faker.animal().name()+ Keys.ENTER+faker.animal().name()+Keys.ENTER);

        WebElement secondItem = Driver.getDriver().findElement(By.xpath("//li[2]//div//label[@class='style-scope td-item']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(secondItem).perform();

        BrowserUtils.sleep(2);

        actions.doubleClick().perform();

        actions.sendKeys(faker.animal().name()).perform();
        actions.sendKeys(Keys.ENTER).perform();

        /*
        Actions actions = new Actions(driver);

        WebElement todo2= driver.findElement(By.xpath("(//label[@class='style-scope td-item'])[2]"));
        actions.doubleClick(todo2).perform();

        WebElement edit = driver.findElement(By.xpath("//input[@id='edit']"));
        edit.sendKeys(Keys.chord(Keys.CONTROL, "a")+ Keys.BACK_SPACE);
        //chord   bu method sayesinde 2 action aynı anda kullanılabiliyor

        todo.sendKeys("earth"+ Keys.ENTER);
         */
