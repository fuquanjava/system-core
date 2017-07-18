package poi;

import java.util.Arrays;

public class ExcelFieldDefinition {

	/**
	 * 报头序号
	 */
	private Integer order;

	/**
	 * 报头名字
	 */
	private String header;

	/**
	 * 数据有效性
	 * 
	 * @return
	 */
	private String[] explicitListValues;

	public ExcelFieldDefinition() {

	}

	public ExcelFieldDefinition(Integer order, String header) {
		this.order = order;
		this.header = header;
	}

	public ExcelFieldDefinition(Integer order, String header, String[] explicitListValues) {
		this.order = order;
		this.header = header;
		this.explicitListValues = explicitListValues;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String[] getExplicitListValues() {
		return explicitListValues;
	}

	public void setExplicitListValues(String[] explicitListValues) {
		this.explicitListValues = explicitListValues;
	}

	@Override
	public String toString() {
		return "ExcelFieldDefinition [order=" + order + ", header=" + header + ", explicitListValues=" + Arrays.toString(explicitListValues) + "]";
	}

}
