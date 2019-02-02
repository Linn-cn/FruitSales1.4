package com.zl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccessoryDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessoryDOExample() {
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

        public Criteria andAccessoryIdIsNull() {
            addCriterion("accessory_id is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdIsNotNull() {
            addCriterion("accessory_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdEqualTo(String value) {
            addCriterion("accessory_id =", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdNotEqualTo(String value) {
            addCriterion("accessory_id <>", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdGreaterThan(String value) {
            addCriterion("accessory_id >", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("accessory_id >=", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdLessThan(String value) {
            addCriterion("accessory_id <", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdLessThanOrEqualTo(String value) {
            addCriterion("accessory_id <=", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdLike(String value) {
            addCriterion("accessory_id like", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdNotLike(String value) {
            addCriterion("accessory_id not like", value, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdIn(List<String> values) {
            addCriterion("accessory_id in", values, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdNotIn(List<String> values) {
            addCriterion("accessory_id not in", values, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdBetween(String value1, String value2) {
            addCriterion("accessory_id between", value1, value2, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andAccessoryIdNotBetween(String value1, String value2) {
            addCriterion("accessory_id not between", value1, value2, "accessoryId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdIsNull() {
            addCriterion("gardenstuff_id is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdIsNotNull() {
            addCriterion("gardenstuff_id is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdEqualTo(String value) {
            addCriterion("gardenstuff_id =", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdNotEqualTo(String value) {
            addCriterion("gardenstuff_id <>", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdGreaterThan(String value) {
            addCriterion("gardenstuff_id >", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_id >=", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdLessThan(String value) {
            addCriterion("gardenstuff_id <", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_id <=", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdLike(String value) {
            addCriterion("gardenstuff_id like", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdNotLike(String value) {
            addCriterion("gardenstuff_id not like", value, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdIn(List<String> values) {
            addCriterion("gardenstuff_id in", values, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdNotIn(List<String> values) {
            addCriterion("gardenstuff_id not in", values, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdBetween(String value1, String value2) {
            addCriterion("gardenstuff_id between", value1, value2, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andGardenstuffIdNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_id not between", value1, value2, "gardenstuffId");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameIsNull() {
            addCriterion("accessory_name is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameIsNotNull() {
            addCriterion("accessory_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameEqualTo(String value) {
            addCriterion("accessory_name =", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameNotEqualTo(String value) {
            addCriterion("accessory_name <>", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameGreaterThan(String value) {
            addCriterion("accessory_name >", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("accessory_name >=", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameLessThan(String value) {
            addCriterion("accessory_name <", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameLessThanOrEqualTo(String value) {
            addCriterion("accessory_name <=", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameLike(String value) {
            addCriterion("accessory_name like", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameNotLike(String value) {
            addCriterion("accessory_name not like", value, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameIn(List<String> values) {
            addCriterion("accessory_name in", values, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameNotIn(List<String> values) {
            addCriterion("accessory_name not in", values, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameBetween(String value1, String value2) {
            addCriterion("accessory_name between", value1, value2, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryNameNotBetween(String value1, String value2) {
            addCriterion("accessory_name not between", value1, value2, "accessoryName");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceIsNull() {
            addCriterion("accessory_price is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceIsNotNull() {
            addCriterion("accessory_price is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceEqualTo(BigDecimal value) {
            addCriterion("accessory_price =", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceNotEqualTo(BigDecimal value) {
            addCriterion("accessory_price <>", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceGreaterThan(BigDecimal value) {
            addCriterion("accessory_price >", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accessory_price >=", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceLessThan(BigDecimal value) {
            addCriterion("accessory_price <", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accessory_price <=", value, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceIn(List<BigDecimal> values) {
            addCriterion("accessory_price in", values, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceNotIn(List<BigDecimal> values) {
            addCriterion("accessory_price not in", values, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accessory_price between", value1, value2, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accessory_price not between", value1, value2, "accessoryPrice");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeIsNull() {
            addCriterion("accessory_time is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeIsNotNull() {
            addCriterion("accessory_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeEqualTo(Date value) {
            addCriterion("accessory_time =", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeNotEqualTo(Date value) {
            addCriterion("accessory_time <>", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeGreaterThan(Date value) {
            addCriterion("accessory_time >", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accessory_time >=", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeLessThan(Date value) {
            addCriterion("accessory_time <", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeLessThanOrEqualTo(Date value) {
            addCriterion("accessory_time <=", value, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeIn(List<Date> values) {
            addCriterion("accessory_time in", values, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeNotIn(List<Date> values) {
            addCriterion("accessory_time not in", values, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeBetween(Date value1, Date value2) {
            addCriterion("accessory_time between", value1, value2, "accessoryTime");
            return (Criteria) this;
        }

        public Criteria andAccessoryTimeNotBetween(Date value1, Date value2) {
            addCriterion("accessory_time not between", value1, value2, "accessoryTime");
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