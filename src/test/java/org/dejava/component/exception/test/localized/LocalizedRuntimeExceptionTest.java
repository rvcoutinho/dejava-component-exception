package org.dejava.component.exception.test.localized;

import java.util.Locale;

import org.dejava.component.exception.test.constant.ErrorKeys;
import org.dejava.component.exception.test.util.LocalizedRuntimeException;
import org.dejava.component.exception.test.util.MessageTypes;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the localized runtime exception.
 */
public class LocalizedRuntimeExceptionTest {

	/**
	 * Affix to be used in pt_BR messages.
	 */
	private static final String BR_AFFIX = ".br";

	/**
	 * Affix to be used in en_US messages.
	 */
	private static final String US_AFFIX = ".us";

	/**
	 * Tests the get message method.
	 */
	@Test
	public void testGetMessage() {
		// Creates a new localized exception.
		final LocalizedRuntimeException localizedException = new LocalizedRuntimeException(
				MessageTypes.Error.class, ErrorKeys.GENERIC, null, null);
		// Sets the locale to pt_BR.
		localizedException.setLocale(new Locale("pt_BR"));
		// Asserts that the message is the expected one.
		Assert.assertEquals(ErrorKeys.GENERIC + US_AFFIX, localizedException.getMessage());
	}

	/**
	 * Tests the get localized message method.
	 */
	@Test
	public void testGetLocalizedMessage() {
		// Creates a new localized exception.
		final LocalizedRuntimeException localizedException = new LocalizedRuntimeException(
				MessageTypes.Error.class, ErrorKeys.GENERIC, null, null);
		// Sets the locale to pt_BR.
		localizedException.setLocale(new Locale("pt_BR"));
		// Asserts that the message is the expected one.
		Assert.assertEquals(ErrorKeys.GENERIC + BR_AFFIX, localizedException.getLocalizedMessage());
	}

}
