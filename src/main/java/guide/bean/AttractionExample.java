package guide.bean;

import java.util.ArrayList;
import java.util.List;

public class AttractionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttractionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andImglocationIsNull() {
            addCriterion("imgLocation is null");
            return (Criteria) this;
        }

        public Criteria andImglocationIsNotNull() {
            addCriterion("imgLocation is not null");
            return (Criteria) this;
        }

        public Criteria andImglocationEqualTo(String value) {
            addCriterion("imgLocation =", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotEqualTo(String value) {
            addCriterion("imgLocation <>", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationGreaterThan(String value) {
            addCriterion("imgLocation >", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationGreaterThanOrEqualTo(String value) {
            addCriterion("imgLocation >=", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLessThan(String value) {
            addCriterion("imgLocation <", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLessThanOrEqualTo(String value) {
            addCriterion("imgLocation <=", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLike(String value) {
            addCriterion("imgLocation like", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotLike(String value) {
            addCriterion("imgLocation not like", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationIn(List<String> values) {
            addCriterion("imgLocation in", values, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotIn(List<String> values) {
            addCriterion("imgLocation not in", values, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationBetween(String value1, String value2) {
            addCriterion("imgLocation between", value1, value2, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotBetween(String value1, String value2) {
            addCriterion("imgLocation not between", value1, value2, "imglocation");
            return (Criteria) this;
        }

        public Criteria andPunchnumIsNull() {
            addCriterion("punchNum is null");
            return (Criteria) this;
        }

        public Criteria andPunchnumIsNotNull() {
            addCriterion("punchNum is not null");
            return (Criteria) this;
        }

        public Criteria andPunchnumEqualTo(Integer value) {
            addCriterion("punchNum =", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumNotEqualTo(Integer value) {
            addCriterion("punchNum <>", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumGreaterThan(Integer value) {
            addCriterion("punchNum >", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("punchNum >=", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumLessThan(Integer value) {
            addCriterion("punchNum <", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumLessThanOrEqualTo(Integer value) {
            addCriterion("punchNum <=", value, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumIn(List<Integer> values) {
            addCriterion("punchNum in", values, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumNotIn(List<Integer> values) {
            addCriterion("punchNum not in", values, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumBetween(Integer value1, Integer value2) {
            addCriterion("punchNum between", value1, value2, "punchnum");
            return (Criteria) this;
        }

        public Criteria andPunchnumNotBetween(Integer value1, Integer value2) {
            addCriterion("punchNum not between", value1, value2, "punchnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIsNull() {
            addCriterion("currentNum is null");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIsNotNull() {
            addCriterion("currentNum is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentnumEqualTo(Integer value) {
            addCriterion("currentNum =", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotEqualTo(Integer value) {
            addCriterion("currentNum <>", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumGreaterThan(Integer value) {
            addCriterion("currentNum >", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentNum >=", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumLessThan(Integer value) {
            addCriterion("currentNum <", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumLessThanOrEqualTo(Integer value) {
            addCriterion("currentNum <=", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIn(List<Integer> values) {
            addCriterion("currentNum in", values, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotIn(List<Integer> values) {
            addCriterion("currentNum not in", values, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumBetween(Integer value1, Integer value2) {
            addCriterion("currentNum between", value1, value2, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotBetween(Integer value1, Integer value2) {
            addCriterion("currentNum not between", value1, value2, "currentnum");
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