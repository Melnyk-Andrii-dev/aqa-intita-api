package steps;

import cache.TestCache;
import cache.TestCacheKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import rest.ArchivedTaskRestClient;

public class ApiArchiveTaskStepdefs {
    ArchivedTaskRestClient archiveRestClient = new ArchivedTaskRestClient();

    @And("I send to ARCHIVE created {} task request")
    public void iSendToARCHIVECreatedTaskRequest(String id) {
        archiveRestClient.sendArchiveRequest(id);
        TestCache.putDataInCache(TestCacheKey.TASK_ID, id);
    }

    @Then("The created {} task was archived")
    public void theCreatedTaskWasArchived(String expectedArchivedTaskName) {
        String actualArchivedTaskName = archiveRestClient.getArchivedTaskNameRequest(Integer.parseInt(TestCache.getStringFromCache(TestCacheKey.TASK_ID)));
        Assertions.assertThat(actualArchivedTaskName).as("Archived task name is different").isEqualTo(expectedArchivedTaskName);

        }

    @And("The task {} was unzipped")
    public void theTaskWasUnzip(int id) {
        archiveRestClient.sendUnzipTaskRequest(id);
    }
}

