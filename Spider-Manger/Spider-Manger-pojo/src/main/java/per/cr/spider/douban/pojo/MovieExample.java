package per.cr.spider.douban.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieExample implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMnameIsNull() {
            addCriterion("MNAME is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("MNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("MNAME =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("MNAME <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("MNAME >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("MNAME >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("MNAME <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("MNAME <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("MNAME like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("MNAME not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("MNAME in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("MNAME not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("MNAME between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("MNAME not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMinfoIsNull() {
            addCriterion("MINFO is null");
            return (Criteria) this;
        }

        public Criteria andMinfoIsNotNull() {
            addCriterion("MINFO is not null");
            return (Criteria) this;
        }

        public Criteria andMinfoEqualTo(String value) {
            addCriterion("MINFO =", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoNotEqualTo(String value) {
            addCriterion("MINFO <>", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoGreaterThan(String value) {
            addCriterion("MINFO >", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoGreaterThanOrEqualTo(String value) {
            addCriterion("MINFO >=", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoLessThan(String value) {
            addCriterion("MINFO <", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoLessThanOrEqualTo(String value) {
            addCriterion("MINFO <=", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoLike(String value) {
            addCriterion("MINFO like", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoNotLike(String value) {
            addCriterion("MINFO not like", value, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoIn(List<String> values) {
            addCriterion("MINFO in", values, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoNotIn(List<String> values) {
            addCriterion("MINFO not in", values, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoBetween(String value1, String value2) {
            addCriterion("MINFO between", value1, value2, "minfo");
            return (Criteria) this;
        }

        public Criteria andMinfoNotBetween(String value1, String value2) {
            addCriterion("MINFO not between", value1, value2, "minfo");
            return (Criteria) this;
        }

        public Criteria andMrateIsNull() {
            addCriterion("MRATE is null");
            return (Criteria) this;
        }

        public Criteria andMrateIsNotNull() {
            addCriterion("MRATE is not null");
            return (Criteria) this;
        }

        public Criteria andMrateEqualTo(Double value) {
            addCriterion("MRATE =", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateNotEqualTo(Double value) {
            addCriterion("MRATE <>", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateGreaterThan(Double value) {
            addCriterion("MRATE >", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateGreaterThanOrEqualTo(Double value) {
            addCriterion("MRATE >=", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateLessThan(Double value) {
            addCriterion("MRATE <", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateLessThanOrEqualTo(Double value) {
            addCriterion("MRATE <=", value, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateIn(List<Double> values) {
            addCriterion("MRATE in", values, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateNotIn(List<Double> values) {
            addCriterion("MRATE not in", values, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateBetween(Double value1, Double value2) {
            addCriterion("MRATE between", value1, value2, "mrate");
            return (Criteria) this;
        }

        public Criteria andMrateNotBetween(Double value1, Double value2) {
            addCriterion("MRATE not between", value1, value2, "mrate");
            return (Criteria) this;
        }

        public Criteria andMplsIsNull() {
            addCriterion("MPLS is null");
            return (Criteria) this;
        }

        public Criteria andMplsIsNotNull() {
            addCriterion("MPLS is not null");
            return (Criteria) this;
        }

        public Criteria andMplsEqualTo(Integer value) {
            addCriterion("MPLS =", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsNotEqualTo(Integer value) {
            addCriterion("MPLS <>", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsGreaterThan(Integer value) {
            addCriterion("MPLS >", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsGreaterThanOrEqualTo(Integer value) {
            addCriterion("MPLS >=", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsLessThan(Integer value) {
            addCriterion("MPLS <", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsLessThanOrEqualTo(Integer value) {
            addCriterion("MPLS <=", value, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsIn(List<Integer> values) {
            addCriterion("MPLS in", values, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsNotIn(List<Integer> values) {
            addCriterion("MPLS not in", values, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsBetween(Integer value1, Integer value2) {
            addCriterion("MPLS between", value1, value2, "mpls");
            return (Criteria) this;
        }

        public Criteria andMplsNotBetween(Integer value1, Integer value2) {
            addCriterion("MPLS not between", value1, value2, "mpls");
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

        public Criteria andMdateIsNull() {
            addCriterion("MDATE is null");
            return (Criteria) this;
        }

        public Criteria andMdateIsNotNull() {
            addCriterion("MDATE is not null");
            return (Criteria) this;
        }

        public Criteria andMdateEqualTo(Integer value) {
            addCriterion("MDATE =", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotEqualTo(Integer value) {
            addCriterion("MDATE <>", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThan(Integer value) {
            addCriterion("MDATE >", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("MDATE >=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThan(Integer value) {
            addCriterion("MDATE <", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateLessThanOrEqualTo(Integer value) {
            addCriterion("MDATE <=", value, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateIn(List<Integer> values) {
            addCriterion("MDATE in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotIn(List<Integer> values) {
            addCriterion("MDATE not in", values, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateBetween(Integer value1, Integer value2) {
            addCriterion("MDATE between", value1, value2, "mdate");
            return (Criteria) this;
        }

        public Criteria andMdateNotBetween(Integer value1, Integer value2) {
            addCriterion("MDATE not between", value1, value2, "mdate");
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