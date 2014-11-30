package org.dejava.component.exception.localized;

import java.util.Collection;

/**
 * Aggregate localized exception contract.
 */
public interface AgregateLocalizedException extends LocalizedException {

	/**
	 * Get messages from the given exception to the application.
	 *
	 * @return Messages from the given exception to the application.
	 */
	Collection<String> getLocalizedMessages();
}
