                package Appium;

                import com.google.common.collect.ImmutableMap;
                import io.appium.java_client.AppiumBy;
                import org.openqa.selenium.By;
                import org.openqa.selenium.JavascriptExecutor;
                import org.openqa.selenium.WebElement;
                import org.openqa.selenium.remote.RemoteWebElement;
                import org.testng.Assert;
                import org.testng.annotations.Test;

                import java.net.MalformedURLException;
                import java.net.URISyntaxException;

                public class GestureDragDrop extends BaseScript {
                    @Test
                    public void DragDrop() throws MalformedURLException, URISyntaxException, InterruptedException {
                        driver.findElement(AppiumBy.accessibilityId("Views")).click();
                        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
                        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

                        ((JavascriptExecutor) driver).executeScript ("mobile: dragGesture", ImmutableMap.of(
                                "elementId", ((RemoteWebElement) source).getId(),
                                "endX", 650,
                                "endY", 650
                        ));

                        Thread.sleep(3000);
                        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
                        Assert.assertEquals(result, "Dropped!");
                    }

                }

//Common Android Key Press // Not working