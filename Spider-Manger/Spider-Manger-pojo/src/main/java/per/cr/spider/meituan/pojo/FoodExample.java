package per.cr.spider.meituan.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FoodExample implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FoodExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andFidIsNull() {
			addCriterion("FID is null");
			return (Criteria) this;
		}

		public Criteria andFidIsNotNull() {
			addCriterion("FID is not null");
			return (Criteria) this;
		}

		public Criteria andFidEqualTo(Integer value) {
			addCriterion("FID =", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotEqualTo(Integer value) {
			addCriterion("FID <>", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThan(Integer value) {
			addCriterion("FID >", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThanOrEqualTo(Integer value) {
			addCriterion("FID >=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThan(Integer value) {
			addCriterion("FID <", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThanOrEqualTo(Integer value) {
			addCriterion("FID <=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidIn(List<Integer> values) {
			addCriterion("FID in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotIn(List<Integer> values) {
			addCriterion("FID not in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidBetween(Integer value1, Integer value2) {
			addCriterion("FID between", value1, value2, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotBetween(Integer value1, Integer value2) {
			addCriterion("FID not between", value1, value2, "fid");
			return (Criteria) this;
		}

		public Criteria andFsidIsNull() {
			addCriterion("FSID is null");
			return (Criteria) this;
		}

		public Criteria andFsidIsNotNull() {
			addCriterion("FSID is not null");
			return (Criteria) this;
		}

		public Criteria andFsidEqualTo(Integer value) {
			addCriterion("FSID =", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidNotEqualTo(Integer value) {
			addCriterion("FSID <>", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidGreaterThan(Integer value) {
			addCriterion("FSID >", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidGreaterThanOrEqualTo(Integer value) {
			addCriterion("FSID >=", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidLessThan(Integer value) {
			addCriterion("FSID <", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidLessThanOrEqualTo(Integer value) {
			addCriterion("FSID <=", value, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidIn(List<Integer> values) {
			addCriterion("FSID in", values, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidNotIn(List<Integer> values) {
			addCriterion("FSID not in", values, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidBetween(Integer value1, Integer value2) {
			addCriterion("FSID between", value1, value2, "fsid");
			return (Criteria) this;
		}

		public Criteria andFsidNotBetween(Integer value1, Integer value2) {
			addCriterion("FSID not between", value1, value2, "fsid");
			return (Criteria) this;
		}

		public Criteria andFnameIsNull() {
			addCriterion("FNAME is null");
			return (Criteria) this;
		}

		public Criteria andFnameIsNotNull() {
			addCriterion("FNAME is not null");
			return (Criteria) this;
		}

		public Criteria andFnameEqualTo(String value) {
			addCriterion("FNAME =", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameNotEqualTo(String value) {
			addCriterion("FNAME <>", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameGreaterThan(String value) {
			addCriterion("FNAME >", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameGreaterThanOrEqualTo(String value) {
			addCriterion("FNAME >=", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameLessThan(String value) {
			addCriterion("FNAME <", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameLessThanOrEqualTo(String value) {
			addCriterion("FNAME <=", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameLike(String value) {
			addCriterion("FNAME like", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameNotLike(String value) {
			addCriterion("FNAME not like", value, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameIn(List<String> values) {
			addCriterion("FNAME in", values, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameNotIn(List<String> values) {
			addCriterion("FNAME not in", values, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameBetween(String value1, String value2) {
			addCriterion("FNAME between", value1, value2, "fname");
			return (Criteria) this;
		}

		public Criteria andFnameNotBetween(String value1, String value2) {
			addCriterion("FNAME not between", value1, value2, "fname");
			return (Criteria) this;
		}

		public Criteria andFpriceIsNull() {
			addCriterion("FPRICE is null");
			return (Criteria) this;
		}

		public Criteria andFpriceIsNotNull() {
			addCriterion("FPRICE is not null");
			return (Criteria) this;
		}

		public Criteria andFpriceEqualTo(Double value) {
			addCriterion("FPRICE =", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceNotEqualTo(Double value) {
			addCriterion("FPRICE <>", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceGreaterThan(Double value) {
			addCriterion("FPRICE >", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceGreaterThanOrEqualTo(Double value) {
			addCriterion("FPRICE >=", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceLessThan(Double value) {
			addCriterion("FPRICE <", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceLessThanOrEqualTo(Double value) {
			addCriterion("FPRICE <=", value, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceIn(List<Double> values) {
			addCriterion("FPRICE in", values, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceNotIn(List<Double> values) {
			addCriterion("FPRICE not in", values, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceBetween(Double value1, Double value2) {
			addCriterion("FPRICE between", value1, value2, "fprice");
			return (Criteria) this;
		}

		public Criteria andFpriceNotBetween(Double value1, Double value2) {
			addCriterion("FPRICE not between", value1, value2, "fprice");
			return (Criteria) this;
		}

		public Criteria andFsaleIsNull() {
			addCriterion("FSALE is null");
			return (Criteria) this;
		}

		public Criteria andFsaleIsNotNull() {
			addCriterion("FSALE is not null");
			return (Criteria) this;
		}

		public Criteria andFsaleEqualTo(Integer value) {
			addCriterion("FSALE =", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleNotEqualTo(Integer value) {
			addCriterion("FSALE <>", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleGreaterThan(Integer value) {
			addCriterion("FSALE >", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleGreaterThanOrEqualTo(Integer value) {
			addCriterion("FSALE >=", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleLessThan(Integer value) {
			addCriterion("FSALE <", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleLessThanOrEqualTo(Integer value) {
			addCriterion("FSALE <=", value, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleIn(List<Integer> values) {
			addCriterion("FSALE in", values, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleNotIn(List<Integer> values) {
			addCriterion("FSALE not in", values, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleBetween(Integer value1, Integer value2) {
			addCriterion("FSALE between", value1, value2, "fsale");
			return (Criteria) this;
		}

		public Criteria andFsaleNotBetween(Integer value1, Integer value2) {
			addCriterion("FSALE not between", value1, value2, "fsale");
			return (Criteria) this;
		}

		public Criteria andFdateIsNull() {
			addCriterion("FDATE is null");
			return (Criteria) this;
		}

		public Criteria andFdateIsNotNull() {
			addCriterion("FDATE is not null");
			return (Criteria) this;
		}

		public Criteria andFdateEqualTo(Date value) {
			addCriterionForJDBCDate("FDATE =", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("FDATE <>", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateGreaterThan(Date value) {
			addCriterionForJDBCDate("FDATE >", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("FDATE >=", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateLessThan(Date value) {
			addCriterionForJDBCDate("FDATE <", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("FDATE <=", value, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateIn(List<Date> values) {
			addCriterionForJDBCDate("FDATE in", values, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("FDATE not in", values, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("FDATE between", value1, value2, "fdate");
			return (Criteria) this;
		}

		public Criteria andFdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("FDATE not between", value1, value2, "fdate");
			return (Criteria) this;
		}

		public Criteria andFlinkIsNull() {
			addCriterion("FLINK is null");
			return (Criteria) this;
		}

		public Criteria andFlinkIsNotNull() {
			addCriterion("FLINK is not null");
			return (Criteria) this;
		}

		public Criteria andFlinkEqualTo(String value) {
			addCriterion("FLINK =", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkNotEqualTo(String value) {
			addCriterion("FLINK <>", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkGreaterThan(String value) {
			addCriterion("FLINK >", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkGreaterThanOrEqualTo(String value) {
			addCriterion("FLINK >=", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkLessThan(String value) {
			addCriterion("FLINK <", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkLessThanOrEqualTo(String value) {
			addCriterion("FLINK <=", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkLike(String value) {
			addCriterion("FLINK like", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkNotLike(String value) {
			addCriterion("FLINK not like", value, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkIn(List<String> values) {
			addCriterion("FLINK in", values, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkNotIn(List<String> values) {
			addCriterion("FLINK not in", values, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkBetween(String value1, String value2) {
			addCriterion("FLINK between", value1, value2, "flink");
			return (Criteria) this;
		}

		public Criteria andFlinkNotBetween(String value1, String value2) {
			addCriterion("FLINK not between", value1, value2, "flink");
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