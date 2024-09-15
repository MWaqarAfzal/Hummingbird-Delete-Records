package hummingbird.Tests;

import org.testng.annotations.Test;

import hummingbird.BaseTestComponent.BaseTest;
import hummingbird.PageObject.AccountingSesttings;

public class DeleteAccountingTemplate extends BaseTest{
    
    public AccountingSesttings accountingSesttings;

    @Test
    public void deleteAccountingTemplate() throws InterruptedException
    {
        accountingSesttings = new AccountingSesttings(driver);
        accountingSesttings.deleteAccountingTemplatesRecordsWithoutAssignedProperties();
    }

}
