package com.zl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealerDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DealerDOExample() {
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

        public Criteria andDealerIdIsNull() {
            addCriterion("dealer_id is null");
            return (Criteria) this;
        }

        public Criteria andDealerIdIsNotNull() {
            addCriterion("dealer_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealerIdEqualTo(String value) {
            addCriterion("dealer_id =", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotEqualTo(String value) {
            addCriterion("dealer_id <>", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThan(String value) {
            addCriterion("dealer_id >", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_id >=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThan(String value) {
            addCriterion("dealer_id <", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThanOrEqualTo(String value) {
            addCriterion("dealer_id <=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLike(String value) {
            addCriterion("dealer_id like", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotLike(String value) {
            addCriterion("dealer_id not like", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdIn(List<String> values) {
            addCriterion("dealer_id in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotIn(List<String> values) {
            addCriterion("dealer_id not in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdBetween(String value1, String value2) {
            addCriterion("dealer_id between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotBetween(String value1, String value2) {
            addCriterion("dealer_id not between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNull() {
            addCriterion("dealer_name is null");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNotNull() {
            addCriterion("dealer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDealerNameEqualTo(String value) {
            addCriterion("dealer_name =", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotEqualTo(String value) {
            addCriterion("dealer_name <>", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThan(String value) {
            addCriterion("dealer_name >", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_name >=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThan(String value) {
            addCriterion("dealer_name <", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThanOrEqualTo(String value) {
            addCriterion("dealer_name <=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLike(String value) {
            addCriterion("dealer_name like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotLike(String value) {
            addCriterion("dealer_name not like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameIn(List<String> values) {
            addCriterion("dealer_name in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotIn(List<String> values) {
            addCriterion("dealer_name not in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameBetween(String value1, String value2) {
            addCriterion("dealer_name between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotBetween(String value1, String value2) {
            addCriterion("dealer_name not between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneIsNull() {
            addCriterion("dealer_phone is null");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneIsNotNull() {
            addCriterion("dealer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneEqualTo(String value) {
            addCriterion("dealer_phone =", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneNotEqualTo(String value) {
            addCriterion("dealer_phone <>", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneGreaterThan(String value) {
            addCriterion("dealer_phone >", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_phone >=", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneLessThan(String value) {
            addCriterion("dealer_phone <", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneLessThanOrEqualTo(String value) {
            addCriterion("dealer_phone <=", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneLike(String value) {
            addCriterion("dealer_phone like", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneNotLike(String value) {
            addCriterion("dealer_phone not like", value, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneIn(List<String> values) {
            addCriterion("dealer_phone in", values, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneNotIn(List<String> values) {
            addCriterion("dealer_phone not in", values, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneBetween(String value1, String value2) {
            addCriterion("dealer_phone between", value1, value2, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerPhoneNotBetween(String value1, String value2) {
            addCriterion("dealer_phone not between", value1, value2, "dealerPhone");
            return (Criteria) this;
        }

        public Criteria andDealerAddressIsNull() {
            addCriterion("dealer_address is null");
            return (Criteria) this;
        }

        public Criteria andDealerAddressIsNotNull() {
            addCriterion("dealer_address is not null");
            return (Criteria) this;
        }

        public Criteria andDealerAddressEqualTo(String value) {
            addCriterion("dealer_address =", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressNotEqualTo(String value) {
            addCriterion("dealer_address <>", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressGreaterThan(String value) {
            addCriterion("dealer_address >", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_address >=", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressLessThan(String value) {
            addCriterion("dealer_address <", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressLessThanOrEqualTo(String value) {
            addCriterion("dealer_address <=", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressLike(String value) {
            addCriterion("dealer_address like", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressNotLike(String value) {
            addCriterion("dealer_address not like", value, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressIn(List<String> values) {
            addCriterion("dealer_address in", values, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressNotIn(List<String> values) {
            addCriterion("dealer_address not in", values, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressBetween(String value1, String value2) {
            addCriterion("dealer_address between", value1, value2, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerAddressNotBetween(String value1, String value2) {
            addCriterion("dealer_address not between", value1, value2, "dealerAddress");
            return (Criteria) this;
        }

        public Criteria andDealerStatusIsNull() {
            addCriterion("dealer_status is null");
            return (Criteria) this;
        }

        public Criteria andDealerStatusIsNotNull() {
            addCriterion("dealer_status is not null");
            return (Criteria) this;
        }

        public Criteria andDealerStatusEqualTo(Integer value) {
            addCriterion("dealer_status =", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusNotEqualTo(Integer value) {
            addCriterion("dealer_status <>", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusGreaterThan(Integer value) {
            addCriterion("dealer_status >", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dealer_status >=", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusLessThan(Integer value) {
            addCriterion("dealer_status <", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("dealer_status <=", value, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusIn(List<Integer> values) {
            addCriterion("dealer_status in", values, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusNotIn(List<Integer> values) {
            addCriterion("dealer_status not in", values, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusBetween(Integer value1, Integer value2) {
            addCriterion("dealer_status between", value1, value2, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dealer_status not between", value1, value2, "dealerStatus");
            return (Criteria) this;
        }

        public Criteria andDealerTimeIsNull() {
            addCriterion("dealer_time is null");
            return (Criteria) this;
        }

        public Criteria andDealerTimeIsNotNull() {
            addCriterion("dealer_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealerTimeEqualTo(Date value) {
            addCriterion("dealer_time =", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeNotEqualTo(Date value) {
            addCriterion("dealer_time <>", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeGreaterThan(Date value) {
            addCriterion("dealer_time >", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dealer_time >=", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeLessThan(Date value) {
            addCriterion("dealer_time <", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeLessThanOrEqualTo(Date value) {
            addCriterion("dealer_time <=", value, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeIn(List<Date> values) {
            addCriterion("dealer_time in", values, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeNotIn(List<Date> values) {
            addCriterion("dealer_time not in", values, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeBetween(Date value1, Date value2) {
            addCriterion("dealer_time between", value1, value2, "dealerTime");
            return (Criteria) this;
        }

        public Criteria andDealerTimeNotBetween(Date value1, Date value2) {
            addCriterion("dealer_time not between", value1, value2, "dealerTime");
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