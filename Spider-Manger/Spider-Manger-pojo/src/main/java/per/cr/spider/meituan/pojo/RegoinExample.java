package per.cr.spider.meituan.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegoinExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RegoinExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andRidIsNull() {
			addCriterion("RID is null");
			return (Criteria) this;
		}

		public Criteria andRidIsNotNull() {
			addCriterion("RID is not null");
			return (Criteria) this;
		}

		public Criteria andRidEqualTo(Integer value) {
			addCriterion("RID =", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotEqualTo(Integer value) {
			addCriterion("RID <>", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidGreaterThan(Integer value) {
			addCriterion("RID >", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidGreaterThanOrEqualTo(Integer value) {
			addCriterion("RID >=", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidLessThan(Integer value) {
			addCriterion("RID <", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidLessThanOrEqualTo(Integer value) {
			addCriterion("RID <=", value, "rid");
			return (Criteria) this;
		}

		public Criteria andRidIn(List<Integer> values) {
			addCriterion("RID in", values, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotIn(List<Integer> values) {
			addCriterion("RID not in", values, "rid");
			return (Criteria) this;
		}

		public Criteria andRidBetween(Integer value1, Integer value2) {
			addCriterion("RID between", value1, value2, "rid");
			return (Criteria) this;
		}

		public Criteria andRidNotBetween(Integer value1, Integer value2) {
			addCriterion("RID not between", value1, value2, "rid");
			return (Criteria) this;
		}

		public Criteria andSnameIsNull() {
			addCriterion("SNAME is null");
			return (Criteria) this;
		}

		public Criteria andSnameIsNotNull() {
			addCriterion("SNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSnameEqualTo(String value) {
			addCriterion("SNAME =", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameNotEqualTo(String value) {
			addCriterion("SNAME <>", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameGreaterThan(String value) {
			addCriterion("SNAME >", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameGreaterThanOrEqualTo(String value) {
			addCriterion("SNAME >=", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameLessThan(String value) {
			addCriterion("SNAME <", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameLessThanOrEqualTo(String value) {
			addCriterion("SNAME <=", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameLike(String value) {
			addCriterion("SNAME like", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameNotLike(String value) {
			addCriterion("SNAME not like", value, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameIn(List<String> values) {
			addCriterion("SNAME in", values, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameNotIn(List<String> values) {
			addCriterion("SNAME not in", values, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameBetween(String value1, String value2) {
			addCriterion("SNAME between", value1, value2, "sname");
			return (Criteria) this;
		}

		public Criteria andSnameNotBetween(String value1, String value2) {
			addCriterion("SNAME not between", value1, value2, "sname");
			return (Criteria) this;
		}

		public Criteria andRfaidIsNull() {
			addCriterion("RFAID is null");
			return (Criteria) this;
		}

		public Criteria andRfaidIsNotNull() {
			addCriterion("RFAID is not null");
			return (Criteria) this;
		}

		public Criteria andRfaidEqualTo(Integer value) {
			addCriterion("RFAID =", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidNotEqualTo(Integer value) {
			addCriterion("RFAID <>", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidGreaterThan(Integer value) {
			addCriterion("RFAID >", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidGreaterThanOrEqualTo(Integer value) {
			addCriterion("RFAID >=", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidLessThan(Integer value) {
			addCriterion("RFAID <", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidLessThanOrEqualTo(Integer value) {
			addCriterion("RFAID <=", value, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidIn(List<Integer> values) {
			addCriterion("RFAID in", values, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidNotIn(List<Integer> values) {
			addCriterion("RFAID not in", values, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidBetween(Integer value1, Integer value2) {
			addCriterion("RFAID between", value1, value2, "rfaid");
			return (Criteria) this;
		}

		public Criteria andRfaidNotBetween(Integer value1, Integer value2) {
			addCriterion("RFAID not between", value1, value2, "rfaid");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}