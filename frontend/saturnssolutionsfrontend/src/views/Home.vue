<template>
  <div class="home">
    <section class="hero is-dark">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">Welcome to the TakeMoney</h1>
          <h2 class="subtitle">
            Your service to do not get in indebted
          </h2>
          <div class="button-block">
            <button class="button is-xl is-dark" @click="login" v-if="!$auth.isAuthenticated">
              Sign Up right now
            </button>
            <h3 v-if="$auth.isAuthenticated" class="is-size-3 has-background-dark welcome">
              Welcome, {{ $auth.user.name }}!
            </h3>
            <h3 v-if="$auth.isAuthenticated" class="is-size-3 has-background-dark welcome">
              Your total is {{ `US$:${data[0]}` }}!
            </h3>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from "../requests/index";
export default {
  name: 'Home',
  components: {},
  data(){
    return{
      data: {},
    }
  },
  created() {
    document.title = 'TakeMoney - Home';
    api.get('/api/v1/users/total').then( result => {
      const {data} = result;
      this.data = data.map((value) => {
        return value[6]
      });
    })
  },
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    },
  }
}
</script>

<style scoped>
  .hero {
    text-align: center;
    background-image: url('https://images.pexels.com/photos/2068975/pexels-photo-2068975.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    height: 400px;
  }
  .hero-body .title {
    text-shadow: 4px 4px 4px rgba(0, 0, 0, 0.6);
    padding: 40px 0 20px 0;
    font-size: 60px;
  }
  .subtitle {
    text-shadow: 4px 4px 4px rgba(0, 0, 0, 0.7);
    font-size: 30px;
  }
  .button-block {
    text-align: center;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    position: absolute;
    bottom: -150px;
  }
  .button {
    margin-right: 50px;
    padding-left: 50px;
    padding-right: 50px;
  }
  .welcome {
    width: 400px;
    padding: 10px;
    margin-left: auto;
    margin-right: auto;
  }
  .is-xl {
    font-size: 1.7rem;
  }
</style>
