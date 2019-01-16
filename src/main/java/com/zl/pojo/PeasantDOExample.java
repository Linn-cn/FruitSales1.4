package com.zl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeasantDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeasantDOExample() {
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

        public Criteria andPeasantIdIsNull() {
            addCriterion("peasant_id is null");
            return (Criteria) this;
        }

        public Criteria andPeasantIdIsNotNull() {
            addCriterion("peasant_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantIdEqualTo(String value) {
            addCriterion("peasant_id =", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdNotEqualTo(String value) {
            addCriterion("peasant_id <>", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdGreaterThan(String value) {
            addCriterion("peasant_id >", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdGreaterThanOrEqualTo(String value) {
            addCriterion("peasant_id >=", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdLessThan(String value) {
            addCriterion("peasant_id <", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdLessThanOrEqualTo(String value) {
            addCriterion("peasant_id <=", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdLike(String value) {
            addCriterion("peasant_id like", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdNotLike(String value) {
            addCriterion("peasant_id not like", value, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdIn(List<String> values) {
            addCriterion("peasant_id in", values, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdNotIn(List<String> values) {
            addCriterion("peasant_id not in", values, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdBetween(String value1, String value2) {
            addCriterion("peasant_id between", value1, value2, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantIdNotBetween(String value1, String value2) {
            addCriterion("peasant_id not between", value1, value2, "peasantId");
            return (Criteria) this;
        }

        public Criteria andPeasantNameIsNull() {
            addCriterion("peasant_name is null");
            return (Criteria) this;
        }

        public Criteria andPeasantNameIsNotNull() {
            addCriterion("peasant_name is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantNameEqualTo(String value) {
            addCriterion("peasant_name =", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameNotEqualTo(String value) {
            addCriterion("peasant_name <>", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameGreaterThan(String value) {
            addCriterion("peasant_name >", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameGreaterThanOrEqualTo(String value) {
            addCriterion("peasant_name >=", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameLessThan(String value) {
            addCriterion("peasant_name <", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameLessThanOrEqualTo(String value) {
            addCriterion("peasant_name <=", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameLike(String value) {
            addCriterion("peasant_name like", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameNotLike(String value) {
            addCriterion("peasant_name not like", value, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameIn(List<String> values) {
            addCriterion("peasant_name in", values, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameNotIn(List<String> values) {
            addCriterion("peasant_name not in", values, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameBetween(String value1, String value2) {
            addCriterion("peasant_name between", value1, value2, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantNameNotBetween(String value1, String value2) {
            addCriterion("peasant_name not between", value1, value2, "peasantName");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityIsNull() {
            addCriterion("peasant_identity is null");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityIsNotNull() {
            addCriterion("peasant_identity is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityEqualTo(String value) {
            addCriterion("peasant_identity =", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityNotEqualTo(String value) {
            addCriterion("peasant_identity <>", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityGreaterThan(String value) {
            addCriterion("peasant_identity >", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("peasant_identity >=", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityLessThan(String value) {
            addCriterion("peasant_identity <", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityLessThanOrEqualTo(String value) {
            addCriterion("peasant_identity <=", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityLike(String value) {
            addCriterion("peasant_identity like", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityNotLike(String value) {
            addCriterion("peasant_identity not like", value, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityIn(List<String> values) {
            addCriterion("peasant_identity in", values, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityNotIn(List<String> values) {
            addCriterion("peasant_identity not in", values, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityBetween(String value1, String value2) {
            addCriterion("peasant_identity between", value1, value2, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantIdentityNotBetween(String value1, String value2) {
            addCriterion("peasant_identity not between", value1, value2, "peasantIdentity");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneIsNull() {
            addCriterion("peasant_phone is null");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneIsNotNull() {
            addCriterion("peasant_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneEqualTo(String value) {
            addCriterion("peasant_phone =", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneNotEqualTo(String value) {
            addCriterion("peasant_phone <>", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneGreaterThan(String value) {
            addCriterion("peasant_phone >", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("peasant_phone >=", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneLessThan(String value) {
            addCriterion("peasant_phone <", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneLessThanOrEqualTo(String value) {
            addCriterion("peasant_phone <=", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneLike(String value) {
            addCriterion("peasant_phone like", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneNotLike(String value) {
            addCriterion("peasant_phone not like", value, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneIn(List<String> values) {
            addCriterion("peasant_phone in", values, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneNotIn(List<String> values) {
            addCriterion("peasant_phone not in", values, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneBetween(String value1, String value2) {
            addCriterion("peasant_phone between", value1, value2, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantPhoneNotBetween(String value1, String value2) {
            addCriterion("peasant_phone not between", value1, value2, "peasantPhone");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressIsNull() {
            addCriterion("peasant_address is null");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressIsNotNull() {
            addCriterion("peasant_address is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressEqualTo(String value) {
            addCriterion("peasant_address =", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressNotEqualTo(String value) {
            addCriterion("peasant_address <>", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressGreaterThan(String value) {
            addCriterion("peasant_address >", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressGreaterThanOrEqualTo(String value) {
            addCriterion("peasant_address >=", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressLessThan(String value) {
            addCriterion("peasant_address <", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressLessThanOrEqualTo(String value) {
            addCriterion("peasant_address <=", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressLike(String value) {
            addCriterion("peasant_address like", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressNotLike(String value) {
            addCriterion("peasant_address not like", value, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressIn(List<String> values) {
            addCriterion("peasant_address in", values, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressNotIn(List<String> values) {
            addCriterion("peasant_address not in", values, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressBetween(String value1, String value2) {
            addCriterion("peasant_address between", value1, value2, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantAddressNotBetween(String value1, String value2) {
            addCriterion("peasant_address not between", value1, value2, "peasantAddress");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusIsNull() {
            addCriterion("peasant_status is null");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusIsNotNull() {
            addCriterion("peasant_status is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusEqualTo(Integer value) {
            addCriterion("peasant_status =", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusNotEqualTo(Integer value) {
            addCriterion("peasant_status <>", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusGreaterThan(Integer value) {
            addCriterion("peasant_status >", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("peasant_status >=", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusLessThan(Integer value) {
            addCriterion("peasant_status <", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusLessThanOrEqualTo(Integer value) {
            addCriterion("peasant_status <=", value, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusIn(List<Integer> values) {
            addCriterion("peasant_status in", values, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusNotIn(List<Integer> values) {
            addCriterion("peasant_status not in", values, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusBetween(Integer value1, Integer value2) {
            addCriterion("peasant_status between", value1, value2, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("peasant_status not between", value1, value2, "peasantStatus");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeIsNull() {
            addCriterion("peasant_time is null");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeIsNotNull() {
            addCriterion("peasant_time is not null");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeEqualTo(Date value) {
            addCriterion("peasant_time =", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeNotEqualTo(Date value) {
            addCriterion("peasant_time <>", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeGreaterThan(Date value) {
            addCriterion("peasant_time >", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("peasant_time >=", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeLessThan(Date value) {
            addCriterion("peasant_time <", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeLessThanOrEqualTo(Date value) {
            addCriterion("peasant_time <=", value, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeIn(List<Date> values) {
            addCriterion("peasant_time in", values, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeNotIn(List<Date> values) {
            addCriterion("peasant_time not in", values, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeBetween(Date value1, Date value2) {
            addCriterion("peasant_time between", value1, value2, "peasantTime");
            return (Criteria) this;
        }

        public Criteria andPeasantTimeNotBetween(Date value1, Date value2) {
            addCriterion("peasant_time not between", value1, value2, "peasantTime");
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