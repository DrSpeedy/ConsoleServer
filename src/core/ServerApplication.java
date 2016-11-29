package core;

import account.AccountRepository;
import execution.ExecutionModule;
import log.LogModule;
import net.NetModule;
import ui.UIModule;

import java.util.HashMap;
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

	private
	HashMap<UUID, Session> mSessions;

	/**
	 * constructor
	 */
	public
	ServerApplication()
	{
		ModuleLocator
			moduleLocator
			= ModuleLocator.getInstance();
		// create and initialize the modules
		// execution
		ExecutionModule
			executionModule
			= new ExecutionModule();
		// log
		LogModule
			logModule
			= new LogModule();
		// ui
		UIModule
			uiModule
			= new UIModule();
		// net
		NetModule
			netModule
			= new NetModule();
		// add the modules to the module locator
		moduleLocator.addModule( executionModule );
		moduleLocator.addModule( logModule );
		moduleLocator.addModule( uiModule );
		moduleLocator.addModule( netModule );
		// create and initialize application variables
		mAccountRepository
			= new AccountRepository();
		mSessions = new HashMap<UUID, Session>();
		// the application controller
		mServerController
			= new ServerController( this );
		mServerController.setUserInputQueue( uiModule.getUserInputQueue() );
		mServerController.setOutputQueue( uiModule.getOutputQueue() );
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
		ModuleLocator
			moduleLocator
			= ModuleLocator.getInstance();
		// start the modules
		moduleLocator.startAllModules();
		ExecutionModule
			executionModule
			= (ExecutionModule)
			moduleLocator
				.getModule( "execution" );
		// run the application controller
		executionModule.execute( mServerController );
	}

	/**
	 * stops the application
	 */
	public
	void stopApplication()
	{
		ModuleLocator
			moduleLocator
			= ModuleLocator.getInstance();
		// stop the modules
		moduleLocator.stopAllModules();
	}
}
