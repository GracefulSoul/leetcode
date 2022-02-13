package gracefulsoul.object.nested;

import java.util.ArrayList;
import java.util.List;

public class SimpleNestedInteger implements NestedInteger {

	private Integer integer;
	private List<NestedInteger> list;

	public SimpleNestedInteger() {
		this.list = new ArrayList<>();
	}

	public SimpleNestedInteger(int value) {
		this();
		this.setInteger(value);
	}

	public boolean isInteger() {
		return this.integer != null;
	}

	public Integer getInteger() {
		return this.integer;
	}

	public void setInteger(int value) {
		this.integer = value;
	}

	public void add(NestedInteger ni) {
		this.list.add(ni);
	}

	public List<NestedInteger> getList() {
		return this.list;
	}

}
