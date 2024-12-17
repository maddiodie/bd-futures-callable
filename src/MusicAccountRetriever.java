

import utilities.AmazonMusicAccount;
import utilities.ImportAccountTask;
import utilities.MusicAccountService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MusicAccountRetriever {

    private MusicAccountService accountService;

    /**
     * Constructor for MusicAccountRetriever.
     */
    public MusicAccountRetriever() {
        accountService = new MusicAccountService();
    }

    /**
     * Getter for MusicAccountService object.
     * @return this MusicAccountService
     */
    public MusicAccountService getAccountService() {
        return accountService;
    }

    /**
     * Retrieves an AmazonMusicAccount with the requested account ID. Returns the result as a Future.
     * PARTICIPANTS: Complete this class declaration and implementation.
     * @param accountID Account ID for requested account.
     * @return A Future result of the AmazonMusicAccount.
     */
    public Future<AmazonMusicAccount> retrieveAccount(String accountID) {
        ExecutorService accountExecutor = Executors.newCachedThreadPool();

        ImportAccountTask importAccountTask = new ImportAccountTask(accountService, accountID);

        Future<AmazonMusicAccount> result = accountExecutor.submit(importAccountTask);;
        accountExecutor.shutdown();

        return result;
    }

    /*
    Complete the retrieveAccount(String accountID) method in MusicAccountRetriever to do two things:
    (1) Submit a newImportAccountTask class to accountExecutor.
    (2) Return the result as a Future<AmazonMusicAccount>.
     */

}
