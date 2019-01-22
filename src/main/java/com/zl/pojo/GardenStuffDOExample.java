package com.zl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GardenStuffDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GardenStuffDOExample() {
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

        public Criteria andGardenstuffPeasantidIsNull() {
            addCriterion("gardenstuff_peasantid is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidIsNotNull() {
            addCriterion("gardenstuff_peasantid is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidEqualTo(String value) {
            addCriterion("gardenstuff_peasantid =", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidNotEqualTo(String value) {
            addCriterion("gardenstuff_peasantid <>", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidGreaterThan(String value) {
            addCriterion("gardenstuff_peasantid >", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_peasantid >=", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidLessThan(String value) {
            addCriterion("gardenstuff_peasantid <", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_peasantid <=", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidLike(String value) {
            addCriterion("gardenstuff_peasantid like", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidNotLike(String value) {
            addCriterion("gardenstuff_peasantid not like", value, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidIn(List<String> values) {
            addCriterion("gardenstuff_peasantid in", values, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidNotIn(List<String> values) {
            addCriterion("gardenstuff_peasantid not in", values, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidBetween(String value1, String value2) {
            addCriterion("gardenstuff_peasantid between", value1, value2, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPeasantidNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_peasantid not between", value1, value2, "gardenstuffPeasantid");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameIsNull() {
            addCriterion("gardenstuff_name is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameIsNotNull() {
            addCriterion("gardenstuff_name is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameEqualTo(String value) {
            addCriterion("gardenstuff_name =", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameNotEqualTo(String value) {
            addCriterion("gardenstuff_name <>", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameGreaterThan(String value) {
            addCriterion("gardenstuff_name >", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_name >=", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameLessThan(String value) {
            addCriterion("gardenstuff_name <", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_name <=", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameLike(String value) {
            addCriterion("gardenstuff_name like", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameNotLike(String value) {
            addCriterion("gardenstuff_name not like", value, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameIn(List<String> values) {
            addCriterion("gardenstuff_name in", values, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameNotIn(List<String> values) {
            addCriterion("gardenstuff_name not in", values, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameBetween(String value1, String value2) {
            addCriterion("gardenstuff_name between", value1, value2, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNameNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_name not between", value1, value2, "gardenstuffName");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceIsNull() {
            addCriterion("gardenstuff_price is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceIsNotNull() {
            addCriterion("gardenstuff_price is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceEqualTo(BigDecimal value) {
            addCriterion("gardenstuff_price =", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceNotEqualTo(BigDecimal value) {
            addCriterion("gardenstuff_price <>", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceGreaterThan(BigDecimal value) {
            addCriterion("gardenstuff_price >", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gardenstuff_price >=", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceLessThan(BigDecimal value) {
            addCriterion("gardenstuff_price <", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gardenstuff_price <=", value, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceIn(List<BigDecimal> values) {
            addCriterion("gardenstuff_price in", values, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceNotIn(List<BigDecimal> values) {
            addCriterion("gardenstuff_price not in", values, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gardenstuff_price between", value1, value2, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gardenstuff_price not between", value1, value2, "gardenstuffPrice");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryIsNull() {
            addCriterion("gardenstuff_category is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryIsNotNull() {
            addCriterion("gardenstuff_category is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryEqualTo(String value) {
            addCriterion("gardenstuff_category =", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryNotEqualTo(String value) {
            addCriterion("gardenstuff_category <>", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryGreaterThan(String value) {
            addCriterion("gardenstuff_category >", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_category >=", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryLessThan(String value) {
            addCriterion("gardenstuff_category <", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_category <=", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryLike(String value) {
            addCriterion("gardenstuff_category like", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryNotLike(String value) {
            addCriterion("gardenstuff_category not like", value, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryIn(List<String> values) {
            addCriterion("gardenstuff_category in", values, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryNotIn(List<String> values) {
            addCriterion("gardenstuff_category not in", values, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryBetween(String value1, String value2) {
            addCriterion("gardenstuff_category between", value1, value2, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategoryNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_category not between", value1, value2, "gardenstuffCategory");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameIsNull() {
            addCriterion("gardenstuff_categoryname is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameIsNotNull() {
            addCriterion("gardenstuff_categoryname is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameEqualTo(String value) {
            addCriterion("gardenstuff_categoryname =", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameNotEqualTo(String value) {
            addCriterion("gardenstuff_categoryname <>", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameGreaterThan(String value) {
            addCriterion("gardenstuff_categoryname >", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_categoryname >=", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameLessThan(String value) {
            addCriterion("gardenstuff_categoryname <", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_categoryname <=", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameLike(String value) {
            addCriterion("gardenstuff_categoryname like", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameNotLike(String value) {
            addCriterion("gardenstuff_categoryname not like", value, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameIn(List<String> values) {
            addCriterion("gardenstuff_categoryname in", values, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameNotIn(List<String> values) {
            addCriterion("gardenstuff_categoryname not in", values, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameBetween(String value1, String value2) {
            addCriterion("gardenstuff_categoryname between", value1, value2, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffCategorynameNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_categoryname not between", value1, value2, "gardenstuffCategoryname");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberIsNull() {
            addCriterion("gardenstuff_number is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberIsNotNull() {
            addCriterion("gardenstuff_number is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberEqualTo(Integer value) {
            addCriterion("gardenstuff_number =", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberNotEqualTo(Integer value) {
            addCriterion("gardenstuff_number <>", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberGreaterThan(Integer value) {
            addCriterion("gardenstuff_number >", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("gardenstuff_number >=", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberLessThan(Integer value) {
            addCriterion("gardenstuff_number <", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberLessThanOrEqualTo(Integer value) {
            addCriterion("gardenstuff_number <=", value, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberIn(List<Integer> values) {
            addCriterion("gardenstuff_number in", values, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberNotIn(List<Integer> values) {
            addCriterion("gardenstuff_number not in", values, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberBetween(Integer value1, Integer value2) {
            addCriterion("gardenstuff_number between", value1, value2, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("gardenstuff_number not between", value1, value2, "gardenstuffNumber");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressIsNull() {
            addCriterion("gardenstuff_address is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressIsNotNull() {
            addCriterion("gardenstuff_address is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressEqualTo(String value) {
            addCriterion("gardenstuff_address =", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressNotEqualTo(String value) {
            addCriterion("gardenstuff_address <>", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressGreaterThan(String value) {
            addCriterion("gardenstuff_address >", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressGreaterThanOrEqualTo(String value) {
            addCriterion("gardenstuff_address >=", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressLessThan(String value) {
            addCriterion("gardenstuff_address <", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressLessThanOrEqualTo(String value) {
            addCriterion("gardenstuff_address <=", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressLike(String value) {
            addCriterion("gardenstuff_address like", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressNotLike(String value) {
            addCriterion("gardenstuff_address not like", value, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressIn(List<String> values) {
            addCriterion("gardenstuff_address in", values, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressNotIn(List<String> values) {
            addCriterion("gardenstuff_address not in", values, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressBetween(String value1, String value2) {
            addCriterion("gardenstuff_address between", value1, value2, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffAddressNotBetween(String value1, String value2) {
            addCriterion("gardenstuff_address not between", value1, value2, "gardenstuffAddress");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeIsNull() {
            addCriterion("gardenstuff_time is null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeIsNotNull() {
            addCriterion("gardenstuff_time is not null");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeEqualTo(Date value) {
            addCriterion("gardenstuff_time =", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeNotEqualTo(Date value) {
            addCriterion("gardenstuff_time <>", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeGreaterThan(Date value) {
            addCriterion("gardenstuff_time >", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gardenstuff_time >=", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeLessThan(Date value) {
            addCriterion("gardenstuff_time <", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeLessThanOrEqualTo(Date value) {
            addCriterion("gardenstuff_time <=", value, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeIn(List<Date> values) {
            addCriterion("gardenstuff_time in", values, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeNotIn(List<Date> values) {
            addCriterion("gardenstuff_time not in", values, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeBetween(Date value1, Date value2) {
            addCriterion("gardenstuff_time between", value1, value2, "gardenstuffTime");
            return (Criteria) this;
        }

        public Criteria andGardenstuffTimeNotBetween(Date value1, Date value2) {
            addCriterion("gardenstuff_time not between", value1, value2, "gardenstuffTime");
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