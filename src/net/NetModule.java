package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
public
class NetModule
{
	/**
	 * whether the server is accepting new connections
	 */
	private boolean acceptingConnections;
	/**
	 * the port number
	 */
	private int portNumber;
	/**
	 * a list of connections
	 */
	private List<Connection>
		mConnections;
	/**
	 * socket that receives connections
	 */
	private
	ServerSocket mServerSocket;

	public
	NetModule()
	{
		mConnections
			= new LinkedList<Connection>();
		// need a way to use connections to make sessions
	}

	public
	void openLoginServer()
	{
		while(acceptingConnections)
		{
			try
			{
				mServerSocket = new ServerSocket( portNumber );
				Socket clientSocket = mServerSocket.accept();
				Connection connection = new Connection( clientSocket );

			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
	}

	public
	int getPortNumber()
	{
		return portNumber;
	}

	public
	void setPortNumber( int portNumber )
	{
		this.portNumber
			= portNumber;
	}
}
