package account;

import java.util.UUID;
public
class Account
{
	/**
	 * unique ID used to identify the account
	 */
	private
	UUID
		mAccountID;

	/**
	 * name associated with account
	 */
	private String
		mAccountName;
	/**
	 * password associated with account
	 *
	 * TODO replace this and the login task!
	 */
	private String mPassword;

	/**
	 * constructor to create an account without specifying the ID
	 */
	public
	Account()
	{
		this(
			UUID.randomUUID()
		    );
	}

	public
	Account( UUID accountID )
	{
		mAccountID
			= accountID;
	}

	public
	UUID getAccountID()
	{
		return mAccountID;
	}


	public
	String getAccountName()
	{
		return mAccountName;
	}

	public
	void setAccountName( String accountName )
	{
		mAccountName
			= accountName;
	}

	public
	boolean updatePassword( String oldPassword, String newPassword )
	{
		if(mPassword.equals( oldPassword))
		{
			newPassword
				= mPassword;
			return true;
		}
		else
		{
			return false;
		}
	}
}
