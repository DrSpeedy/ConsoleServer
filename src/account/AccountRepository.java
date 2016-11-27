package account;

import java.util.HashMap;
import java.util.UUID;

/**
 * a repository responsible for creating, storing, and accessing
 * the accounts.
 */
public
class AccountRepository
{
	/**
	 * a collection of the accounts
	 */
	private
	HashMap<UUID, Account>
		mAccounts;

	/**
	 * constructor
	 */
	public
	AccountRepository()
	{
		mAccounts
			= new HashMap<UUID, Account>();
	}

	public
	boolean createAccount( UUID accountID )
	{
		if ( hasAccount( accountID ) )
		{
			// account already exists
			return false;
		}
		else
		{
			Account
				account
				= new Account( accountID );
			mAccounts.put(
				accountID,
				account
			             );
			return hasAccount( accountID );
		}
	}

	public
	boolean hasAccount( UUID accountID )
	{
		return mAccounts.containsKey( accountID );
	}

	public
	boolean createAccount()
	{
		Account
			account
			= new Account();
		UUID
			accountID
			= account.getAccountID();
		mAccounts.put(
			accountID,
			account
		             );
		return hasAccount( accountID );

	}

	public
	Account getAccount( UUID accountID )
	{
		if ( hasAccount( accountID ) )
		{
			return mAccounts.get( accountID );
		}
		else
		{
			// account not found
			return null;
		}
	}

	public
	boolean removeAccount( UUID accountID )
	{
		if ( hasAccount( accountID ) )
		{
			mAccounts.remove( accountID );
			return hasAccount( accountID );
		}
		else
		{
			// account not found
			return false;
		}
	}
}
