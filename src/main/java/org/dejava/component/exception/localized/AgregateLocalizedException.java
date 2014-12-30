package org.dejava.component.exception.localized;

import java.util.Collection;

import org.dejava.component.i18n.message.handler.MessageCommand;

/**
 * Aggregate localized exception contract.
 */
public interface AgregateLocalizedException extends LocalizedException {

	/**
	 * Get messages commands from the given exception to the application.
	 *
	 * @return Messages commands from the given exception to the application.
	 */
	Collection<MessageCommand> getMessageCommands();

	/**
	 * Get messages from the given exception to the application.
	 *
	 * @return Messages from the given exception to the application.
	 */
	Collection<String> getLocalizedMessages();
}
