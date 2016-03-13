package ro.webeet.giveaway.backend.core.component;

import java.io.Serializable;

@FunctionalInterface
public interface FormAction extends Serializable { // It MUST extends
													// Serializable

	public abstract void onSubmit();

}