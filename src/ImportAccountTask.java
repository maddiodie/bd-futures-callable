import utilities.AmazonMusicAccount;
import utilities.MusicAccountService;

import java.util.concurrent.Callable;

public class ImportAccountTask implements Callable<AmazonMusicAccount> {
    // PARTICIPANTS: Complete this class's declaration and implement the call() method.

    /*
    The class declaration must be completed along with properly implementing the call() method.
    It should return a type of AmazonMusicAccount. The MusicAccountService class has a static method
    getAccount(String accountID) which will return an AmazonMusicAccount for the associated account.
    You can use this as the return value in call().
     */

    private MusicAccountService accountService;
    private String accountID;

    /**
     * Constructor for ImportAccountTask.
     * @param acctService MusicAccountService reference.
     * @param acctID Account ID to access.
     */
    public ImportAccountTask(MusicAccountService acctService, String acctID) {
        accountService = acctService;
        accountID = acctID;
    }

    public String getAccountID() {
        return accountID;
    }

    public MusicAccountService getAccountService() {
        return accountService;
    }

    /**
     * Code to be executed in ExecutorService.
     *
     * PARTICIPANTS: complete this method's declaration and implementation. It should retrieve the
     * AmazonMusicAccount from the MusicAccountService.
     *
     * @return AmazonMusicAccount object.
     */
    public AmazonMusicAccount call() {
        return MusicAccountService.getAccount(this.accountID);
    }

    /*
    The class declaration must be completed along with properly implementing the call() method.
    It should return a type of AmazonMusicAccount. The MusicAccountService class has a static method
    getAccount(String accountID) which will return an AmazonMusicAccount for the associated account.
    You can use this as the return value in call().
     */

}
