package ro.webeet.giveaway.backend.core.component;

import java.io.Serializable;

@FunctionalInterface
public interface StringSupplier extends Serializable {

	public String get();

}