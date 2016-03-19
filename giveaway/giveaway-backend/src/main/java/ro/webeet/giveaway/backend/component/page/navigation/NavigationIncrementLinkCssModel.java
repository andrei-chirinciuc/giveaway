package ro.webeet.giveaway.backend.component.page.navigation;

import java.io.Serializable;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;

class NavigationIncrementLinkCssModel implements IModel<String>, Serializable {

	private static final long serialVersionUID = 8337862805552969251L;

	protected final IPageable pageable;

	private final long pageNumber;

	public NavigationIncrementLinkCssModel(IPageable pageable, long pageNumber) {
		this.pageable = pageable;
		this.pageNumber = pageNumber;
	}

	@Override
	public String getObject() {
		return isEnabled() ? "waves-effect" : "disabled";
	}

	@Override
	public void setObject(String object) {
	}

	@Override
	public void detach() {
	}

	public boolean isEnabled() {
		boolean enabled;
		if (pageNumber < 0) {
			enabled = !isFirst();
		} else {
			enabled = !isLast();
		}
		return enabled;
	}

	public boolean isFirst() {
		return pageable.getCurrentPage() <= 0;
	}

	public boolean isLast() {
		return pageable.getCurrentPage() >= pageable.getPageCount() - 1;
	}
}