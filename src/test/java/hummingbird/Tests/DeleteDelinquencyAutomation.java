package hummingbird.Tests;

import org.testng.annotations.Test;

import hummingbird.BaseTestComponent.BaseTest;
import hummingbird.PageObject.DelinquencyAutomation;

public class DeleteDelinquencyAutomation extends BaseTest{

    public DelinquencyAutomation delinquencyAutomation;
    @Test
    public void deleteDelinquencyRecords() throws InterruptedException
    {
        delinquencyAutomation = new DelinquencyAutomation(driver);
        delinquencyAutomation.deleteDelinquencyAutomationRecordsWithoutAssignedProperties();
    }

}
