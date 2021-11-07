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
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th><abbr title="User">User</abbr></th>
            <th><abbr title="User">Is that your income?</abbr></th>
            <th><abbr title="Income quantity">Income quantity</abbr></th>
            <th><abbr title="Outcome quantity">Outcome quantity</abbr></th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <th><abbr title="User">User</abbr></th>
            <th><abbr title="User">Is that your income?</abbr></th>
            <th><abbr title="Income quantity">Income quantity</abbr></th>
            <th><abbr title="Outcome quantity">Outcome quantity</abbr></th>
          </tr>
        </tfoot>
        <tbody>
          <tr v-for="properValue in tableValues" :key="properValue.id">
            <th>{{ properValue.user }}</th>
            <td>
              <strong>{{ properValue.incomeProperty ? "Yes" : "Nope" }}</strong>
            </td>
            <td>
              <strong>{{
                `${money.prefix} ${!properValue.valueIncome ? 0 : properValue.valueIncome }`
              }}</strong>
            </td>
            <td>
              <strong>{{
                `${money.prefix} ${!properValue.outcomeValue ? 0 : properValue.outcomeValue }`
              }}</strong>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import { Money } from "v-money";
import api from '../requests/index';
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
    api.get('/api/v1/users').then((result) => {
      const { data } = result;
      data.map(user => {
        this.tableValues.push(user);
      })
    });
  },
  methods: {
    addPersonalValues() {
      api.post('/api/v1/users', this.data = {
        valueIncome: this.valueIncome,
        outcomeValue: this.outcomeValue,
        incomeProperty: this.isIncomeValue,
        user: this.$auth.user.name
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
