<template>
  <div class="container">
    <div class="control">
      <span class="finance-income">Is that your income?</span>
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
    <div class="columns">
      <div class="column" v-if="isIncomeValue">
        <span class="finance-income"> Income value </span>
        <input
          type="text"
          placeholder="Income value"
          class="input-income"
          v-model="valueIncome"
        />
      </div>
    </div>
    <div class="columns">
      <div class="column" v-if="!isIncomeValue">
        <span class="finance-income"> Outcome value </span>
        <input
          type="text"
          placeholder="Income value"
          class="input-income"
          v-model="valueIncome"
        />
      </div>
    </div>
    <button @click="addPersonalValues">Send it</button>
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
          <tr v-for="(properValue, index) in tableValues" :key="index">
            <th>{{properValue.user}}</th>
            <td>
              <strong>{{properValue.incomeProperty ? 'Yes' : 'Nope'}}</strong>
            </td>
            <td>
              <strong>{{properValue.valueIncome ? properValue.valueIncome : 'US$'}}</strong>
            </td>
            <td>
              <strong>{{properValue.outcomeValue}}</strong>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isIncomeValue: false,
      valueIncome: "0",
      outcomeValue: "0",
      tableValues: []
    };
  },
  created() {
    document.title = "TakeMoney - Finance";
  },
  methods: {
    addPersonalValues() {
      if (this.isIncomeValue) {
        const personalValues = {
          valueIncome: `US$${this.valueIncome}`,
          outcomeValue: this.outcomeValue,
          user: this.$auth.user.name,
          incomeProperty: this.isIncomeValue
        };
        return this.tableValues.push(personalValues);
      } else {
        const personalValues = {
          valueIncome: `US$${this.valueIncome}`,
          outcomeValue: this.outcomeValue,
          user: this.$auth.user.name,
          incomeProperty: this.isIncomeValue
        };
        return this.tableValues.push(personalValues);
      }
    },
  },
};
</script>

<style scoped>
.finance-income {
  display: block;
  margin: 10px 5px;
}

.column .input-income {
  margin-left: 5px;
  padding: 10px;
}
</style>
