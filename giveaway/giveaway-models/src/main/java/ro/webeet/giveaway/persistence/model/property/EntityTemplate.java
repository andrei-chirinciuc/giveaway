package ro.webeet.giveaway.persistence.model.property;

import ro.webeet.giveaway.persistence.model.Category;
import ro.webeet.giveaway.persistence.model.DBModel;
import ro.webeet.giveaway.persistence.model.HelpCase;

public enum EntityTemplate {
	HELP_CASE(HelpCase.class), CATEGORY(Category.class);

	private Class<? extends DBModel> clazz;

	private EntityTemplate(Class<? extends DBModel> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends DBModel> getEntityClass() {
		return clazz;
	}
}
