package net.tasks;

import net.Connection;

public
class LoginTask
	implements Runnable
{
	private
	Connection mConnection;
	private boolean running;

	public LoginTask( Connection connection)
	{
		mConnection = connection;
	}

	@Override
	public
	void run()
	{
		while(running)
		{
			try
			{
				// ask for login info
				mConnection.send( "enter account name" );
				// check if response is broken
				String
					response
					= mConnection.receive();
				if ( response == null )
				{
					//
				}
				response.trim();
				if ( response.isEmpty() )
				{
					//
				}
				// check if any accounts with matching info
				// TODO add way to access modules and repositories
				// if account found, ask for password
				mConnection.send( "enter account password" );
				// check if response is broken
				response
					= mConnection.receive();
				if ( response == null )
				{
					//
				}
				response.trim();
				if ( response.isEmpty() )
				{
					//
				}
				// check if sent password matches account password
				// else, continue asking for login info
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
		}
	}

	public void stop()
	{
		running = false;
	}
}
