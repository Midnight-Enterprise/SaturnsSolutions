<template>
  <nav class="navbar container" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" href="/">
        <strong class="is-size-4">TakeMoney</strong>
      </a>
      <a
        role="button"
        class="navbar-burger burger"
        aria-label="menu"
        aria-expanded="false"
        data-target="navbarBasicExample"
      >
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>
    <div id="navbar" class="navbar-menu">
      <div class="navbar-start">
        <router-link to="/" class="navbar-item">Home</router-link>
        <router-link to="/about" class="navbar-item">About</router-link>
        <router-link to="/finances" class="navbar-item" v-if="$auth.isAuthenticated">Finances</router-link>
      </div>
      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <div v-if="!$auth.loading">
              <a class="button is-dark" @click="login" v-if="!$auth.isAuthenticated">
                <strong>Sign In</strong>
              </a>
              <a
                v-if="$auth.isAuthenticated"
                @click="logout"
                class="button is-dark"
                ><strong>Log out</strong></a
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>
<script>
export default {
  name: "Nav",
  data() {
    return {};
  },
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    },
    logout() {
      this.$auth.logout({
        returnTo: window.location.origin
      });
    }
  },
};
</script>
<style scoped>
nav {
  margin-top: 25px;
  margin-bottom: 30px;
}
a {
  font-weight: bold;
  color: #2c3e50;
}
a.router-link-exact-active {
  color: #d88d00;
}
</style>
