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
			// ask for login info
			// check if any accounts with matching info
			// if account found, create session
			// else, continue asking for login info
		}
	}

	public void stop()
	{
		running = false;
	}
}
