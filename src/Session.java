import net.Connection;

import java.util.UUID;
public
class Session
{
	/**
	 * the ID of the account used in this session
	 */
	private
	UUID
		mAccountID;
	/**
	 * the connection used in this session
	 */
	private
	Connection
		mConnection;

	public
	Session(
		UUID accountID,
		Connection connection
	       )
	{
		mAccountID
			= accountID;
		mConnection
			= connection;
	}

	/**
	 * retrieves the account ID
	 *
	 * @return the ID of the account in this session
	 */
	public
	UUID getAccountID()
	{
		return mAccountID;
	}

	public
	void endSession()
	{
		mConnection.close();
	}
}
