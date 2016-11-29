package core;

import java.util.ArrayList;
import java.util.List;
public
class ServerController
	implements Runnable
{
	/**
	 * crappy pseudo state variable
	 */
	private boolean
		running;
	/**
	 * the application being controlled
	 */
	private ServerApplication
		mServerApplication;

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

	public
	ServerController( ServerApplication serverApplication )
	{
		mServerApplication
			= serverApplication;
	}

	@Override
	public
	void run()
	{
		running
			= true;
		while ( running )
		{
			if ( mUserInputQueue.isEmpty() )
			{
				if ( !running )
				{
					return;
				}
				try
				{
					Thread.sleep( 666 );
				}
				catch ( InterruptedException e )
				{
					e.printStackTrace();
				}
			}
			else
			{
				handleInput(
					mUserInputQueue.remove( 0 )
				           );
			}
		}
	}

	/**
	 * @param input
	 * 	the line of input to be processed
	 */
	public
	void handleInput( String input )
	{
		if ( input == null )
		{
			return;
		}
		input.trim();
		if ( input.isEmpty() )
		{
			return;
		}
		String[]
			inputTokens
			= parseInput( input );
		switch ( inputTokens[ 0 ] )
		{
			case "stop":
				stop();
				break;
			case "create":
				if ( inputTokens.length == 1 )
				{
					// more arguments required
				}
				else
				{
					switch ( inputTokens[ 1 ] )
					{
						case "account":
							if ( inputTokens.length == 2 )
							{
								String
									msg
									= "usage: create account <name>";
								mOutputQueue.add( msg );
							}
							break;
						default:
							String
								msg
								= "unrecognized argument: "
								  + inputTokens[ 1 ];
							mOutputQueue.add( msg );
					}
				}
				break;
			case "":

				break;
			default:
				String
					msg
					= "unrecognized command: " + inputTokens[ 0 ];
				mOutputQueue.add( msg );
		}
	}

	private
	String[] parseInput( String input )
	{
		ArrayList<String>
			tokens
			= new ArrayList<String>();
		StringBuilder
			sb
			= new StringBuilder();
		for (
			int
			i
			= 0;
			i < input.length();
			i++
			)
		{
			if ( input.charAt( i ) == ' ' )
			{
				tokens.add( sb.toString() );
				sb.setLength( 0 );
			}
			else
			{
				sb.append( input.charAt( i ) );
			}
		}
		tokens.add( sb.toString() );
		return tokens.toArray( new String[ tokens.size() ] );
	}

	public
	void stop()
	{
		running
			= false;
		mServerApplication.stopApplication();
	}

	public
	void setUserInputQueue(
		List<String> userInputQueue
	                      )
	{
		mUserInputQueue
			= userInputQueue;
	}

	public
	void setOutputQueue( List<String> outputQueue )
	{
		mOutputQueue
			= outputQueue;
	}
}
