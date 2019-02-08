package com.zl.pojo;

import java.util.ArrayList;
import java.util.List;

public class MiddleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MiddleDOExample() {
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

        public Criteria andMiddleIdIsNull() {
            addCriterion("middle_id is null");
            return (Criteria) this;
        }

        public Criteria andMiddleIdIsNotNull() {
            addCriterion("middle_id is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleIdEqualTo(String value) {
            addCriterion("middle_id =", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdNotEqualTo(String value) {
            addCriterion("middle_id <>", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdGreaterThan(String value) {
            addCriterion("middle_id >", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdGreaterThanOrEqualTo(String value) {
            addCriterion("middle_id >=", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdLessThan(String value) {
            addCriterion("middle_id <", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdLessThanOrEqualTo(String value) {
            addCriterion("middle_id <=", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdLike(String value) {
            addCriterion("middle_id like", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdNotLike(String value) {
            addCriterion("middle_id not like", value, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdIn(List<String> values) {
            addCriterion("middle_id in", values, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdNotIn(List<String> values) {
            addCriterion("middle_id not in", values, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdBetween(String value1, String value2) {
            addCriterion("middle_id between", value1, value2, "middleId");
            return (Criteria) this;
        }

        public Criteria andMiddleIdNotBetween(String value1, String value2) {
            addCriterion("middle_id not between", value1, value2, "middleId");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("contract_id like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("contract_id not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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