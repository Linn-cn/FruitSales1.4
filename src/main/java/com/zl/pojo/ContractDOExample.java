package com.zl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractDOExample() {
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

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCheckIsNull() {
            addCriterion("check is null");
            return (Criteria) this;
        }

        public Criteria andCheckIsNotNull() {
            addCriterion("check is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEqualTo(Integer value) {
            addCriterion("check =", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotEqualTo(Integer value) {
            addCriterion("check <>", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckGreaterThan(Integer value) {
            addCriterion("check >", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("check >=", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckLessThan(Integer value) {
            addCriterion("check <", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckLessThanOrEqualTo(Integer value) {
            addCriterion("check <=", value, "check");
            return (Criteria) this;
        }

        public Criteria andCheckIn(List<Integer> values) {
            addCriterion("check in", values, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotIn(List<Integer> values) {
            addCriterion("check not in", values, "check");
            return (Criteria) this;
        }

        public Criteria andCheckBetween(Integer value1, Integer value2) {
            addCriterion("check between", value1, value2, "check");
            return (Criteria) this;
        }

        public Criteria andCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("check not between", value1, value2, "check");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNull() {
            addCriterion("contract_price is null");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNotNull() {
            addCriterion("contract_price is not null");
            return (Criteria) this;
        }

        public Criteria andContractPriceEqualTo(BigDecimal value) {
            addCriterion("contract_price =", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotEqualTo(BigDecimal value) {
            addCriterion("contract_price <>", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThan(BigDecimal value) {
            addCriterion("contract_price >", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_price >=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThan(BigDecimal value) {
            addCriterion("contract_price <", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_price <=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceIn(List<BigDecimal> values) {
            addCriterion("contract_price in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotIn(List<BigDecimal> values) {
            addCriterion("contract_price not in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_price between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_price not between", value1, value2, "contractPrice");
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