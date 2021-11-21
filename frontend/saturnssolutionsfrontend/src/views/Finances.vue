<template>
  <div class="container">
    <div class="control">
      <h2>
        <span class="finance-income"> Is that your income? </span>
      </h2>
      <label class="radio">
        <input type="radio" name="answer" @change="isIncomeValue = true" />
        Yes
      </label>
      <label class="radio">
        <input
          type="radio"
          name="answer"
          @change="isIncomeValue = false"
          checked
        />
        No
      </label>
    </div>
    <div class="columns" v-if="isIncomeValue">
      <div class="column">
        <h2>
          <span class="finance-income"> Income value </span>
        </h2>
        <Money
          v-bind="money"
          v-model="valueIncome"
          class="input-income"
        ></Money>
      </div>
    </div>
    <div class="columns" v-if="!isIncomeValue">
      <div class="column">
        <h2>
          <span class="finance-income"> Outcome value </span>
        </h2>
        <Money
          v-bind="money"
          v-model="outcomeValue"
          class="input-income"
        ></Money>
      </div>
    </div>
    <button @click="addPersonalValues">Send it</button>
    <div class="border-bottom"></div>
  </div>
</template>
<script>
import { Money } from "v-money";
import api from '../requests/index';
import Finance from '../factories/FinancesFactory/Finance';
export default {
  components: {
    Money,
  },
  data() {
    return {
      isIncomeValue: false,
      refreshComponent: false,
      valueIncome: "0",
      outcomeValue: "0",
      tableValues: [],
      users: [],
      data: {},
      factoryFinance: {},
      money: {
        prefix: "US$",
        decimal: ".",
        thousands: ",",
        precision: 2,
        masked: false,
      },
    };
  },
  mounted() {
    document.title = "TakeMoney - Finance";
  },
  methods: {
    addPersonalValues() {
      this.factoryFinance = Finance(this.valueIncome, this.outcomeValue, this.isIncomeValue, this.$auth.user.name);
      api.post('/api/v1/users', this.data = {
        valueIncome: this.factoryFinance.valueIncome,
        outcomeValue: this.factoryFinance.outcomeValue,
        incomeProperty: this.factoryFinance.isIncomeValue,
        user: this.factoryFinance.user
      })
      this.$forceUpdate();
      this.cleaningFields();
    },
    cleaningFields() {
      this.valueIncome = "";
      this.outcomeValue = "";
    },
  },
};
</script>

<style scoped>
h2 span {
  display: inline-block;
  font: 15px bold 30px Georgia, serif;
  margin-bottom: 0.4rem;
}

.column .input-income {
  margin-left: 5px;
  padding: 10px;
}
.border-bottom {
  padding-top: 10px;
  padding-bottom: 20px;
  border-bottom: 1px solid rgba(77, 76, 76, 0.719);
}
</style>
