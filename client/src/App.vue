<template>
  <div id="app">
    <topNav :app-name="appName" />
    <router-view/>
  </div>
</template>

<script>
import topNav from '@/components/TopMenu';

export default {
  name: 'App',
  components: {
    topNav,
  },
  data() {
    return {
      appName: 'Unicorn',
    };
  },
  async created() {
    try {
      // await this.$auth.renewTokens();
      await this.$store.dispatch('renewTokens')
        .catch(e => {
          if (e.message === 'Not logged in') {
            console.log('not logged in~');
          } else {
            console.log(e);
          }
        });
    } catch (e) {
      console.log(e);
    }
  },
  methods: {
    login() {
      // this.$auth.login();
      this.$store.dispatch('webAuthLogin');
    },
    logout() {
      this.$auth.logOut();
    },
    handleLoginEvent(data) {
      this.isAuthenticated = data.loggedIn;
      this.profile = data.profile;
    }
  }
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
