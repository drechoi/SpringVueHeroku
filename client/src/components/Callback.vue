<template>
  <div class="callback">
    <p>Logging in.. Please wait</p>
  </div>

</template>

<script>
export default {
  created() {
    console.log('callback create');

    this.$store.dispatch('handleWebAuth')
      .then(result => {
        console.log('Callback then, target');
        console.log(result);
        this.$router.push(result.appState.target || '/');
      })
      .catch(error => {
        console.log('Call back error: ');
        console.log(error);
      });

    // this.$auth.handleAuthentication();
  },
  methods: {
    handleLoginEvent(data) {
      console.log('callback handle login event');
      this.$router.push(data.state.target || '/');
    }
  },
};
</script>
