package org.dejava.component.exception.test.util;

import org.dejava.component.exception.localized.checked.AbstractLocalizedException;

/**
 * Localized exception.
 */
public class LocalizedException extends AbstractLocalizedException {

	/**
	 * Generated serial.
	 */
	private static final long serialVersionUID = -5031681554691854022L;

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
	public LocalizedException(final Object type, final String messageKey, final Object[] parameters,
			final Throwable cause) {
		super(type, messageKey, parameters, cause);
	}

}
