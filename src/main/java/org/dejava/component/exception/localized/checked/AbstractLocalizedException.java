package org.dejava.component.exception.localized.checked;

import java.util.Locale;

import org.dejava.component.exception.localized.ExceptionMessageCommand;
import org.dejava.component.exception.localized.LocalizedException;
import org.dejava.component.i18n.message.handler.MessageCommand;
import org.dejava.component.i18n.message.handler.MessageHandler;
import org.dejava.component.i18n.message.handler.impl.SimpleMessageHandler;

/**
 * General localized exception.
 */
public abstract class AbstractLocalizedException extends Exception implements LocalizedException {

	/**
	 * Generated serial.
	 */
	private static final long serialVersionUID = -6987571772328004454L;

	/**
	 * The message handler to be used in order to render localized exception messages.
	 */
	private MessageHandler messageHandler;

	/**
	 * Gets the message handler to be used in order to render localized exception messages.
	 *
	 * @return The message handler to be used in order to render localized exception messages.
	 */
	public MessageHandler getMessageHandler() {
		// If the message handler is null.
		if (messageHandler == null) {
			// Creates a new message handler.
			messageHandler = SimpleMessageHandler.getMessageHandler(Locale.getDefault());
		}
		// Returns the message handler.
		return messageHandler;
	}

	/**
	 * Sets the message handler to be used in order to render localized exception messages.
	 *
	 * @param messageHandler
	 *            New message handler to be used in order to render localized exception messages.
	 */
	@Override
	public void setMessageHandler(final MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	/**
	 * Message command for the localized exception.
	 */
	private MessageCommand messageCommand;

	/**
	 * Gets the message command for the localized exception.
	 *
	 * @return The message command for the localized exception.
	 */
	@Override
	public MessageCommand getMessageCommand() {
		// If the message command is null.
		if (messageCommand == null) {
			// Creates a new message command.
			messageCommand = new ExceptionMessageCommand();
		}
		// Returns the message command.
		return messageCommand;
	}

	/**
	 * Sets the message command for the localized exception.
	 *
	 * @param messageCommand
	 *            New message command for the localized exception.
	 */
	@Override
	public void setMessageCommand(final MessageCommand messageCommand) {
		this.messageCommand = messageCommand;
	}

	/**
	 * Gets the locale to be used in the localized message retrieval.
	 *
	 * @return The locale to be used in the localized message retrieval.
	 */
	public Locale getLocale() {
		return getMessageCommand().getLocale();
	}

	/**
	 * Sets the locale to be used in the localized message retrieval.
	 *
	 * @param locale
	 *            New locale to be used in the localized message retrieval.
	 */
	public void setLocale(final Locale locale) {
		getMessageCommand().setLocale(locale);
	}

	/**
	 * Basic constructor.
	 */
	protected AbstractLocalizedException() {
		super();
	}

	/**
	 * Basic constructor.
	 *
	 * @param type
	 *            The type for the message.
	 * @param messageKey
	 *            Message key that describes the exception.
	 * @param parameters
	 *            Parameters for the exception (and message).
	 * @param cause
	 *            Exception cause.
	 */
	public AbstractLocalizedException(final Object type, final String messageKey, final Object[] parameters,
			final Throwable cause) {
		// Calls the Exception constructor.
		super(cause);
		// Sets the basic fields.
		getMessageCommand().setType(type);
		getMessageCommand().setMessageKey(messageKey);
		getMessageCommand().setParameters(parameters);
	}

	/**
	 * @see Throwable#getLocalizedMessage()
	 */
	@Override
	public String getLocalizedMessage() {
		// Tries to return the localized message.
		return getMessageCommand().getMessage(getMessageHandler());
	}

	/**
	 * @see Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		// Gets the current locale for the message.
		final Locale locale = getLocale();
		// Tries to get the US message.
		try {
			// Resets the message locale to EN_us.
			setLocale(Locale.US);
			// Tries to return the localized message.
			return getMessageCommand().getMessage(getMessageHandler());
		}
		// At the end.
		finally {
			// Ensures that the previous locale is restored.
			setLocale(locale);
		}
	}
}