package per.cr.spider.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StreetExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StreetExample() {
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

		public Criteria andStidIsNull() {
			addCriterion("STID is null");
			return (Criteria) this;
		}

		public Criteria andStidIsNotNull() {
			addCriterion("STID is not null");
			return (Criteria) this;
		}

		public Criteria andStidEqualTo(Integer value) {
			addCriterion("STID =", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidNotEqualTo(Integer value) {
			addCriterion("STID <>", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidGreaterThan(Integer value) {
			addCriterion("STID >", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidGreaterThanOrEqualTo(Integer value) {
			addCriterion("STID >=", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidLessThan(Integer value) {
			addCriterion("STID <", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidLessThanOrEqualTo(Integer value) {
			addCriterion("STID <=", value, "stid");
			return (Criteria) this;
		}

		public Criteria andStidIn(List<Integer> values) {
			addCriterion("STID in", values, "stid");
			return (Criteria) this;
		}

		public Criteria andStidNotIn(List<Integer> values) {
			addCriterion("STID not in", values, "stid");
			return (Criteria) this;
		}

		public Criteria andStidBetween(Integer value1, Integer value2) {
			addCriterion("STID between", value1, value2, "stid");
			return (Criteria) this;
		}

		public Criteria andStidNotBetween(Integer value1, Integer value2) {
			addCriterion("STID not between", value1, value2, "stid");
			return (Criteria) this;
		}

		public Criteria andStnameIsNull() {
			addCriterion("STNAME is null");
			return (Criteria) this;
		}

		public Criteria andStnameIsNotNull() {
			addCriterion("STNAME is not null");
			return (Criteria) this;
		}

		public Criteria andStnameEqualTo(String value) {
			addCriterion("STNAME =", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameNotEqualTo(String value) {
			addCriterion("STNAME <>", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameGreaterThan(String value) {
			addCriterion("STNAME >", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameGreaterThanOrEqualTo(String value) {
			addCriterion("STNAME >=", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameLessThan(String value) {
			addCriterion("STNAME <", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameLessThanOrEqualTo(String value) {
			addCriterion("STNAME <=", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameLike(String value) {
			addCriterion("STNAME like", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameNotLike(String value) {
			addCriterion("STNAME not like", value, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameIn(List<String> values) {
			addCriterion("STNAME in", values, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameNotIn(List<String> values) {
			addCriterion("STNAME not in", values, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameBetween(String value1, String value2) {
			addCriterion("STNAME between", value1, value2, "stname");
			return (Criteria) this;
		}

		public Criteria andStnameNotBetween(String value1, String value2) {
			addCriterion("STNAME not between", value1, value2, "stname");
			return (Criteria) this;
		}

		public Criteria andStfaidIsNull() {
			addCriterion("STFAID is null");
			return (Criteria) this;
		}

		public Criteria andStfaidIsNotNull() {
			addCriterion("STFAID is not null");
			return (Criteria) this;
		}

		public Criteria andStfaidEqualTo(Integer value) {
			addCriterion("STFAID =", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidNotEqualTo(Integer value) {
			addCriterion("STFAID <>", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidGreaterThan(Integer value) {
			addCriterion("STFAID >", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidGreaterThanOrEqualTo(Integer value) {
			addCriterion("STFAID >=", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidLessThan(Integer value) {
			addCriterion("STFAID <", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidLessThanOrEqualTo(Integer value) {
			addCriterion("STFAID <=", value, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidIn(List<Integer> values) {
			addCriterion("STFAID in", values, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidNotIn(List<Integer> values) {
			addCriterion("STFAID not in", values, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidBetween(Integer value1, Integer value2) {
			addCriterion("STFAID between", value1, value2, "stfaid");
			return (Criteria) this;
		}

		public Criteria andStfaidNotBetween(Integer value1, Integer value2) {
			addCriterion("STFAID not between", value1, value2, "stfaid");
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