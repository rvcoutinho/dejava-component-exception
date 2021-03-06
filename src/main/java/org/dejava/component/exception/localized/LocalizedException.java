package org.dejava.component.exception.localized;

import org.dejava.component.i18n.message.handler.MessageCommand;
import org.dejava.component.i18n.message.handler.MessageHandler;

/**
 * Localized exception contract.
 */
public interface LocalizedException {

	/**
	 * Sets the message handler to be used in order to render localized exception messages.
	 *
	 * @param messageHandler
	 *            New message handler to be used in order to render localized exception messages.
	 */
	void setMessageHandler(final MessageHandler messageHandler);

	/**
	 * Sets the message command for the localized exception.
	 *
	 * @param messageCommand
	 *            New message command for the localized exception.
	 */
	void setMessageCommand(final MessageCommand messageCommand);

	/**
	 * Gets the message command for the localized exception.
	 * 
	 * @return The message command for the localized exception.
	 */
	MessageCommand getMessageCommand();

	/**
	 * Gets the localized message for the exception.
	 *
	 * @return The localized message for the exception.
	 */
	String getLocalizedMessage();
}
