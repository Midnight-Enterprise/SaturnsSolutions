<template>
  <div class="event-single">
    <section class="hero is-primary">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">Login</h1>
        </div>
      </div>
    </section>
    <section class="event-content">
      <div class="container">
        <div class="field">
          <p class="control has-icons-left has-icons-right">
            <input class="input" type="email" placeholder="Email" v-model="username"/>
            <span class="icon is-small is-left">
              <i class="far fa-user"></i>
            </span>
            <span class="icon is-small is-right" v-if="username.length > 1">
              <i class="fas fa-user-check"></i>
            </span>
          </p>
        </div>
        <div class="field">
          <p class="control has-icons-left">
            <input class="input" type="password" placeholder="Password" v-model="password"/>
            <span class="icon is-small is-left">
              <i class="fas fa-user-lock"></i>
            </span>
          </p>
        </div>
        <div class="field">
          <p class="control">
            <button class="button is-success">Login</button>
          </p>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },
  created() {
    document.title = "TakeMoney - Login";
  },
  methods: {},
};
</script>

<style scoped>
.event-single {
  margin-top: 30px;
}
.hero {
  margin-bottom: 70px;
}
.event-images {
  margin-top: 50px;
}
.description {
  margin-bottom: 30px;
}
</style>
