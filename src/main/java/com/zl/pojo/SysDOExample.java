package com.zl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDOExample() {
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

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(Integer value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(Integer value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(Integer value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(Integer value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<Integer> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<Integer> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysVersionIsNull() {
            addCriterion("sys_version is null");
            return (Criteria) this;
        }

        public Criteria andSysVersionIsNotNull() {
            addCriterion("sys_version is not null");
            return (Criteria) this;
        }

        public Criteria andSysVersionEqualTo(String value) {
            addCriterion("sys_version =", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionNotEqualTo(String value) {
            addCriterion("sys_version <>", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionGreaterThan(String value) {
            addCriterion("sys_version >", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sys_version >=", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionLessThan(String value) {
            addCriterion("sys_version <", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionLessThanOrEqualTo(String value) {
            addCriterion("sys_version <=", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionLike(String value) {
            addCriterion("sys_version like", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionNotLike(String value) {
            addCriterion("sys_version not like", value, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionIn(List<String> values) {
            addCriterion("sys_version in", values, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionNotIn(List<String> values) {
            addCriterion("sys_version not in", values, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionBetween(String value1, String value2) {
            addCriterion("sys_version between", value1, value2, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysVersionNotBetween(String value1, String value2) {
            addCriterion("sys_version not between", value1, value2, "sysVersion");
            return (Criteria) this;
        }

        public Criteria andSysUrlIsNull() {
            addCriterion("sys_url is null");
            return (Criteria) this;
        }

        public Criteria andSysUrlIsNotNull() {
            addCriterion("sys_url is not null");
            return (Criteria) this;
        }

        public Criteria andSysUrlEqualTo(String value) {
            addCriterion("sys_url =", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlNotEqualTo(String value) {
            addCriterion("sys_url <>", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlGreaterThan(String value) {
            addCriterion("sys_url >", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sys_url >=", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlLessThan(String value) {
            addCriterion("sys_url <", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlLessThanOrEqualTo(String value) {
            addCriterion("sys_url <=", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlLike(String value) {
            addCriterion("sys_url like", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlNotLike(String value) {
            addCriterion("sys_url not like", value, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlIn(List<String> values) {
            addCriterion("sys_url in", values, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlNotIn(List<String> values) {
            addCriterion("sys_url not in", values, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlBetween(String value1, String value2) {
            addCriterion("sys_url between", value1, value2, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysUrlNotBetween(String value1, String value2) {
            addCriterion("sys_url not between", value1, value2, "sysUrl");
            return (Criteria) this;
        }

        public Criteria andSysOperationIsNull() {
            addCriterion("sys_operation is null");
            return (Criteria) this;
        }

        public Criteria andSysOperationIsNotNull() {
            addCriterion("sys_operation is not null");
            return (Criteria) this;
        }

        public Criteria andSysOperationEqualTo(String value) {
            addCriterion("sys_operation =", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationNotEqualTo(String value) {
            addCriterion("sys_operation <>", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationGreaterThan(String value) {
            addCriterion("sys_operation >", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationGreaterThanOrEqualTo(String value) {
            addCriterion("sys_operation >=", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationLessThan(String value) {
            addCriterion("sys_operation <", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationLessThanOrEqualTo(String value) {
            addCriterion("sys_operation <=", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationLike(String value) {
            addCriterion("sys_operation like", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationNotLike(String value) {
            addCriterion("sys_operation not like", value, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationIn(List<String> values) {
            addCriterion("sys_operation in", values, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationNotIn(List<String> values) {
            addCriterion("sys_operation not in", values, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationBetween(String value1, String value2) {
            addCriterion("sys_operation between", value1, value2, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysOperationNotBetween(String value1, String value2) {
            addCriterion("sys_operation not between", value1, value2, "sysOperation");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeIsNull() {
            addCriterion("sys_runtime is null");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeIsNotNull() {
            addCriterion("sys_runtime is not null");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeEqualTo(String value) {
            addCriterion("sys_runtime =", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeNotEqualTo(String value) {
            addCriterion("sys_runtime <>", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeGreaterThan(String value) {
            addCriterion("sys_runtime >", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_runtime >=", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeLessThan(String value) {
            addCriterion("sys_runtime <", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeLessThanOrEqualTo(String value) {
            addCriterion("sys_runtime <=", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeLike(String value) {
            addCriterion("sys_runtime like", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeNotLike(String value) {
            addCriterion("sys_runtime not like", value, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeIn(List<String> values) {
            addCriterion("sys_runtime in", values, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeNotIn(List<String> values) {
            addCriterion("sys_runtime not in", values, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeBetween(String value1, String value2) {
            addCriterion("sys_runtime between", value1, value2, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysRuntimeNotBetween(String value1, String value2) {
            addCriterion("sys_runtime not between", value1, value2, "sysRuntime");
            return (Criteria) this;
        }

        public Criteria andSysJdkIsNull() {
            addCriterion("sys_jdk is null");
            return (Criteria) this;
        }

        public Criteria andSysJdkIsNotNull() {
            addCriterion("sys_jdk is not null");
            return (Criteria) this;
        }

        public Criteria andSysJdkEqualTo(String value) {
            addCriterion("sys_jdk =", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkNotEqualTo(String value) {
            addCriterion("sys_jdk <>", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkGreaterThan(String value) {
            addCriterion("sys_jdk >", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkGreaterThanOrEqualTo(String value) {
            addCriterion("sys_jdk >=", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkLessThan(String value) {
            addCriterion("sys_jdk <", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkLessThanOrEqualTo(String value) {
            addCriterion("sys_jdk <=", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkLike(String value) {
            addCriterion("sys_jdk like", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkNotLike(String value) {
            addCriterion("sys_jdk not like", value, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkIn(List<String> values) {
            addCriterion("sys_jdk in", values, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkNotIn(List<String> values) {
            addCriterion("sys_jdk not in", values, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkBetween(String value1, String value2) {
            addCriterion("sys_jdk between", value1, value2, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysJdkNotBetween(String value1, String value2) {
            addCriterion("sys_jdk not between", value1, value2, "sysJdk");
            return (Criteria) this;
        }

        public Criteria andSysMysqlIsNull() {
            addCriterion("sys_mysql is null");
            return (Criteria) this;
        }

        public Criteria andSysMysqlIsNotNull() {
            addCriterion("sys_mysql is not null");
            return (Criteria) this;
        }

        public Criteria andSysMysqlEqualTo(String value) {
            addCriterion("sys_mysql =", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlNotEqualTo(String value) {
            addCriterion("sys_mysql <>", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlGreaterThan(String value) {
            addCriterion("sys_mysql >", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlGreaterThanOrEqualTo(String value) {
            addCriterion("sys_mysql >=", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlLessThan(String value) {
            addCriterion("sys_mysql <", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlLessThanOrEqualTo(String value) {
            addCriterion("sys_mysql <=", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlLike(String value) {
            addCriterion("sys_mysql like", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlNotLike(String value) {
            addCriterion("sys_mysql not like", value, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlIn(List<String> values) {
            addCriterion("sys_mysql in", values, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlNotIn(List<String> values) {
            addCriterion("sys_mysql not in", values, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlBetween(String value1, String value2) {
            addCriterion("sys_mysql between", value1, value2, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysMysqlNotBetween(String value1, String value2) {
            addCriterion("sys_mysql not between", value1, value2, "sysMysql");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeIsNull() {
            addCriterion("sys_itemsize is null");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeIsNotNull() {
            addCriterion("sys_itemsize is not null");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeEqualTo(String value) {
            addCriterion("sys_itemsize =", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeNotEqualTo(String value) {
            addCriterion("sys_itemsize <>", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeGreaterThan(String value) {
            addCriterion("sys_itemsize >", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_itemsize >=", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeLessThan(String value) {
            addCriterion("sys_itemsize <", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeLessThanOrEqualTo(String value) {
            addCriterion("sys_itemsize <=", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeLike(String value) {
            addCriterion("sys_itemsize like", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeNotLike(String value) {
            addCriterion("sys_itemsize not like", value, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeIn(List<String> values) {
            addCriterion("sys_itemsize in", values, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeNotIn(List<String> values) {
            addCriterion("sys_itemsize not in", values, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeBetween(String value1, String value2) {
            addCriterion("sys_itemsize between", value1, value2, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysItemsizeNotBetween(String value1, String value2) {
            addCriterion("sys_itemsize not between", value1, value2, "sysItemsize");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeIsNull() {
            addCriterion("sys_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeIsNotNull() {
            addCriterion("sys_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeEqualTo(Date value) {
            addCriterion("sys_updatetime =", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeNotEqualTo(Date value) {
            addCriterion("sys_updatetime <>", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeGreaterThan(Date value) {
            addCriterion("sys_updatetime >", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_updatetime >=", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeLessThan(Date value) {
            addCriterion("sys_updatetime <", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_updatetime <=", value, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeIn(List<Date> values) {
            addCriterion("sys_updatetime in", values, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeNotIn(List<Date> values) {
            addCriterion("sys_updatetime not in", values, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("sys_updatetime between", value1, value2, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_updatetime not between", value1, value2, "sysUpdatetime");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightIsNull() {
            addCriterion("sys_copyright is null");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightIsNotNull() {
            addCriterion("sys_copyright is not null");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightEqualTo(String value) {
            addCriterion("sys_copyright =", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightNotEqualTo(String value) {
            addCriterion("sys_copyright <>", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightGreaterThan(String value) {
            addCriterion("sys_copyright >", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightGreaterThanOrEqualTo(String value) {
            addCriterion("sys_copyright >=", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightLessThan(String value) {
            addCriterion("sys_copyright <", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightLessThanOrEqualTo(String value) {
            addCriterion("sys_copyright <=", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightLike(String value) {
            addCriterion("sys_copyright like", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightNotLike(String value) {
            addCriterion("sys_copyright not like", value, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightIn(List<String> values) {
            addCriterion("sys_copyright in", values, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightNotIn(List<String> values) {
            addCriterion("sys_copyright not in", values, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightBetween(String value1, String value2) {
            addCriterion("sys_copyright between", value1, value2, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysCopyrightNotBetween(String value1, String value2) {
            addCriterion("sys_copyright not between", value1, value2, "sysCopyright");
            return (Criteria) this;
        }

        public Criteria andSysAuthorIsNull() {
            addCriterion("sys_author is null");
            return (Criteria) this;
        }

        public Criteria andSysAuthorIsNotNull() {
            addCriterion("sys_author is not null");
            return (Criteria) this;
        }

        public Criteria andSysAuthorEqualTo(String value) {
            addCriterion("sys_author =", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorNotEqualTo(String value) {
            addCriterion("sys_author <>", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorGreaterThan(String value) {
            addCriterion("sys_author >", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("sys_author >=", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorLessThan(String value) {
            addCriterion("sys_author <", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorLessThanOrEqualTo(String value) {
            addCriterion("sys_author <=", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorLike(String value) {
            addCriterion("sys_author like", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorNotLike(String value) {
            addCriterion("sys_author not like", value, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorIn(List<String> values) {
            addCriterion("sys_author in", values, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorNotIn(List<String> values) {
            addCriterion("sys_author not in", values, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorBetween(String value1, String value2) {
            addCriterion("sys_author between", value1, value2, "sysAuthor");
            return (Criteria) this;
        }

        public Criteria andSysAuthorNotBetween(String value1, String value2) {
            addCriterion("sys_author not between", value1, value2, "sysAuthor");
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