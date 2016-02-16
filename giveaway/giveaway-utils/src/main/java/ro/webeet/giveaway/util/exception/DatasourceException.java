/**
 *
 */
package ro.webeet.giveaway.util.exception;

/**
 * @author webeet
 *
 *         Exception thrown during the initiailization of the datasource
 */
public class DatasourceException extends Exception {

	private static final long serialVersionUID = 5527265922691090984L;

	public DatasourceException() {
		super();
	}

	public DatasourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DatasourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatasourceException(String message) {
		super(message);
	}

	public DatasourceException(Throwable cause) {
		super(cause);
	}

}
