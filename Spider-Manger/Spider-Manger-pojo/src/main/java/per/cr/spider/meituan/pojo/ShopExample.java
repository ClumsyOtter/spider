package per.cr.spider.meituan.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ShopExample() {
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

		public Criteria andSidIsNull() {
			addCriterion("SID is null");
			return (Criteria) this;
		}

		public Criteria andSidIsNotNull() {
			addCriterion("SID is not null");
			return (Criteria) this;
		}

		public Criteria andSidEqualTo(Integer value) {
			addCriterion("SID =", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotEqualTo(Integer value) {
			addCriterion("SID <>", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThan(Integer value) {
			addCriterion("SID >", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThanOrEqualTo(Integer value) {
			addCriterion("SID >=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThan(Integer value) {
			addCriterion("SID <", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThanOrEqualTo(Integer value) {
			addCriterion("SID <=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidIn(List<Integer> values) {
			addCriterion("SID in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotIn(List<Integer> values) {
			addCriterion("SID not in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidBetween(Integer value1, Integer value2) {
			addCriterion("SID between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotBetween(Integer value1, Integer value2) {
			addCriterion("SID not between", value1, value2, "sid");
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

		public Criteria andSphoneIsNull() {
			addCriterion("SPHONE is null");
			return (Criteria) this;
		}

		public Criteria andSphoneIsNotNull() {
			addCriterion("SPHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSphoneEqualTo(Integer value) {
			addCriterion("SPHONE =", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneNotEqualTo(Integer value) {
			addCriterion("SPHONE <>", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneGreaterThan(Integer value) {
			addCriterion("SPHONE >", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneGreaterThanOrEqualTo(Integer value) {
			addCriterion("SPHONE >=", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneLessThan(Integer value) {
			addCriterion("SPHONE <", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneLessThanOrEqualTo(Integer value) {
			addCriterion("SPHONE <=", value, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneIn(List<Integer> values) {
			addCriterion("SPHONE in", values, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneNotIn(List<Integer> values) {
			addCriterion("SPHONE not in", values, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneBetween(Integer value1, Integer value2) {
			addCriterion("SPHONE between", value1, value2, "sphone");
			return (Criteria) this;
		}

		public Criteria andSphoneNotBetween(Integer value1, Integer value2) {
			addCriterion("SPHONE not between", value1, value2, "sphone");
			return (Criteria) this;
		}

		public Criteria andSgradeIsNull() {
			addCriterion("SGRADE is null");
			return (Criteria) this;
		}

		public Criteria andSgradeIsNotNull() {
			addCriterion("SGRADE is not null");
			return (Criteria) this;
		}

		public Criteria andSgradeEqualTo(Double value) {
			addCriterion("SGRADE =", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeNotEqualTo(Double value) {
			addCriterion("SGRADE <>", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeGreaterThan(Double value) {
			addCriterion("SGRADE >", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeGreaterThanOrEqualTo(Double value) {
			addCriterion("SGRADE >=", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeLessThan(Double value) {
			addCriterion("SGRADE <", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeLessThanOrEqualTo(Double value) {
			addCriterion("SGRADE <=", value, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeIn(List<Double> values) {
			addCriterion("SGRADE in", values, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeNotIn(List<Double> values) {
			addCriterion("SGRADE not in", values, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeBetween(Double value1, Double value2) {
			addCriterion("SGRADE between", value1, value2, "sgrade");
			return (Criteria) this;
		}

		public Criteria andSgradeNotBetween(Double value1, Double value2) {
			addCriterion("SGRADE not between", value1, value2, "sgrade");
			return (Criteria) this;
		}

		public Criteria andStypeIsNull() {
			addCriterion("STYPE is null");
			return (Criteria) this;
		}

		public Criteria andStypeIsNotNull() {
			addCriterion("STYPE is not null");
			return (Criteria) this;
		}

		public Criteria andStypeEqualTo(Integer value) {
			addCriterion("STYPE =", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeNotEqualTo(Integer value) {
			addCriterion("STYPE <>", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeGreaterThan(Integer value) {
			addCriterion("STYPE >", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("STYPE >=", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeLessThan(Integer value) {
			addCriterion("STYPE <", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeLessThanOrEqualTo(Integer value) {
			addCriterion("STYPE <=", value, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeIn(List<Integer> values) {
			addCriterion("STYPE in", values, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeNotIn(List<Integer> values) {
			addCriterion("STYPE not in", values, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeBetween(Integer value1, Integer value2) {
			addCriterion("STYPE between", value1, value2, "stype");
			return (Criteria) this;
		}

		public Criteria andStypeNotBetween(Integer value1, Integer value2) {
			addCriterion("STYPE not between", value1, value2, "stype");
			return (Criteria) this;
		}

		public Criteria andSregionIsNull() {
			addCriterion("SREGION is null");
			return (Criteria) this;
		}

		public Criteria andSregionIsNotNull() {
			addCriterion("SREGION is not null");
			return (Criteria) this;
		}

		public Criteria andSregionEqualTo(Integer value) {
			addCriterion("SREGION =", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionNotEqualTo(Integer value) {
			addCriterion("SREGION <>", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionGreaterThan(Integer value) {
			addCriterion("SREGION >", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionGreaterThanOrEqualTo(Integer value) {
			addCriterion("SREGION >=", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionLessThan(Integer value) {
			addCriterion("SREGION <", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionLessThanOrEqualTo(Integer value) {
			addCriterion("SREGION <=", value, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionIn(List<Integer> values) {
			addCriterion("SREGION in", values, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionNotIn(List<Integer> values) {
			addCriterion("SREGION not in", values, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionBetween(Integer value1, Integer value2) {
			addCriterion("SREGION between", value1, value2, "sregion");
			return (Criteria) this;
		}

		public Criteria andSregionNotBetween(Integer value1, Integer value2) {
			addCriterion("SREGION not between", value1, value2, "sregion");
			return (Criteria) this;
		}

		public Criteria andSrodeIsNull() {
			addCriterion("SRODE is null");
			return (Criteria) this;
		}

		public Criteria andSrodeIsNotNull() {
			addCriterion("SRODE is not null");
			return (Criteria) this;
		}

		public Criteria andSrodeEqualTo(Integer value) {
			addCriterion("SRODE =", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeNotEqualTo(Integer value) {
			addCriterion("SRODE <>", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeGreaterThan(Integer value) {
			addCriterion("SRODE >", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SRODE >=", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeLessThan(Integer value) {
			addCriterion("SRODE <", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeLessThanOrEqualTo(Integer value) {
			addCriterion("SRODE <=", value, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeIn(List<Integer> values) {
			addCriterion("SRODE in", values, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeNotIn(List<Integer> values) {
			addCriterion("SRODE not in", values, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeBetween(Integer value1, Integer value2) {
			addCriterion("SRODE between", value1, value2, "srode");
			return (Criteria) this;
		}

		public Criteria andSrodeNotBetween(Integer value1, Integer value2) {
			addCriterion("SRODE not between", value1, value2, "srode");
			return (Criteria) this;
		}

		public Criteria andSaddressIsNull() {
			addCriterion("SADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andSaddressIsNotNull() {
			addCriterion("SADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andSaddressEqualTo(String value) {
			addCriterion("SADDRESS =", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressNotEqualTo(String value) {
			addCriterion("SADDRESS <>", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressGreaterThan(String value) {
			addCriterion("SADDRESS >", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressGreaterThanOrEqualTo(String value) {
			addCriterion("SADDRESS >=", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressLessThan(String value) {
			addCriterion("SADDRESS <", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressLessThanOrEqualTo(String value) {
			addCriterion("SADDRESS <=", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressLike(String value) {
			addCriterion("SADDRESS like", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressNotLike(String value) {
			addCriterion("SADDRESS not like", value, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressIn(List<String> values) {
			addCriterion("SADDRESS in", values, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressNotIn(List<String> values) {
			addCriterion("SADDRESS not in", values, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressBetween(String value1, String value2) {
			addCriterion("SADDRESS between", value1, value2, "saddress");
			return (Criteria) this;
		}

		public Criteria andSaddressNotBetween(String value1, String value2) {
			addCriterion("SADDRESS not between", value1, value2, "saddress");
			return (Criteria) this;
		}

		public Criteria andSlinkIsNull() {
			addCriterion("SLINK is null");
			return (Criteria) this;
		}

		public Criteria andSlinkIsNotNull() {
			addCriterion("SLINK is not null");
			return (Criteria) this;
		}

		public Criteria andSlinkEqualTo(String value) {
			addCriterion("SLINK =", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkNotEqualTo(String value) {
			addCriterion("SLINK <>", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkGreaterThan(String value) {
			addCriterion("SLINK >", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkGreaterThanOrEqualTo(String value) {
			addCriterion("SLINK >=", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkLessThan(String value) {
			addCriterion("SLINK <", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkLessThanOrEqualTo(String value) {
			addCriterion("SLINK <=", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkLike(String value) {
			addCriterion("SLINK like", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkNotLike(String value) {
			addCriterion("SLINK not like", value, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkIn(List<String> values) {
			addCriterion("SLINK in", values, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkNotIn(List<String> values) {
			addCriterion("SLINK not in", values, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkBetween(String value1, String value2) {
			addCriterion("SLINK between", value1, value2, "slink");
			return (Criteria) this;
		}

		public Criteria andSlinkNotBetween(String value1, String value2) {
			addCriterion("SLINK not between", value1, value2, "slink");
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