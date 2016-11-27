import account.AccountRepository;
import net.NetModule;
import ui.UIModule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * a simple server used to test the client
 */
public
class ServerApplication
{
	/**
	 * repository that holds the accounts
	 */
	AccountRepository
		mAccountRepository;
	/**
	 * controller containing the application logic
	 */
	private ServerController
		mServerController;
	/**
	 * module containing all the networking variables and
	 * functions
	 */
	private
	NetModule
		mNetModule;
	/**
	 * module containing all the ui related variables and
	 * functions
	 */
	private UIModule
		mUIModule;
	/**
	 * queue of user input
	 */
	private
	List<String>
		mUserInputQueue;
	/**
	 * queue of output to be displayed
	 */
	private
	List<String>
		mOutputQueue;

	private
	HashMap<UUID, Session> mSessions;

	/**
	 * constructor
	 */
	public
	ServerApplication()
	{
		// create and initialize application variables
		mAccountRepository
			= new AccountRepository();
		mUserInputQueue
			= new LinkedList<String>();
		mOutputQueue
			= new LinkedList<String>();
		mSessions = new HashMap<UUID, Session>();
		mServerController
			= new ServerController( this );
		// create and initialize modules
		// ui
		mUIModule
			= new UIModule();
		mUIModule.setUserInputQueue( mUserInputQueue );
		mUIModule.setOutputQueue( mOutputQueue );
		// net
		mNetModule
			= new NetModule();
	}

	public static
	void main( String[] args )
	{
		ServerApplication
			serverApp
			= new ServerApplication();
		serverApp.startApplication();
	}

	/**
	 * starts the application
	 */
	public
	void startApplication()
	{
		mUIModule.start();
		Thread
			thread
			= new Thread( mServerController );
		thread.start();
	}

	/**
	 * stops the application
	 */
	public
	void stopApplication()
	{
		mUIModule.stop();
		mServerController.stop();
	}
}
