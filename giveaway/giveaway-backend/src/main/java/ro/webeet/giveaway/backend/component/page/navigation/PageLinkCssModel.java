package ro.webeet.giveaway.backend.component.page.navigation;

import java.io.Serializable;

import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;

class PageLinkCssModel implements IModel<String>, Serializable {

	private static final long serialVersionUID = 6598879394298896497L;

	private final long pageNumber;

	protected final IPageable pageable;

	private final String css;

	public PageLinkCssModel(IPageable pageable, long pageNumber, String css) {
		this.pageNumber = pageNumber;
		this.pageable = pageable;
		this.css = css;
	}

	@Override
	public String getObject() {
		return isSelected() ? css : "waves-effect";
	}

	@Override
	public void setObject(String object) {
	}

	@Override
	public void detach() {
	}

	public boolean isSelected() {
		return getPageNumber() == pageable.getCurrentPage();
	}

	private long getPageNumber() {
		long idx = pageNumber;
		if (idx < 0) {
			idx = pageable.getPageCount() + idx;
		}

		if (idx > pageable.getPageCount() - 1) {
			idx = pageable.getPageCount() - 1;
		}

		if (idx < 0) {
			idx = 0;
		}

		return idx;
	}

}
