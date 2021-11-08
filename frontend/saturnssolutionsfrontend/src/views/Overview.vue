<template>
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
              `${money.prefix} ${
                !properValue.valueIncome ? 0 : properValue.valueIncome
              }`
            }}</strong>
          </td>
          <td>
            <strong>{{
              `${money.prefix} ${
                !properValue.outcomeValue ? 0 : properValue.outcomeValue
              }`
            }}</strong>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import api from "../requests/index";
export default {
  data() {
    return {
      tableValues: [],
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
    document.title = "TakeMoney - Overview";
    api.get('/api/v1/users').then((result) => {
      const { data } = result;
      data.map(user => {
        this.tableValues.push(user);
      })
    });
  }
};
</script>

<style>
</style>