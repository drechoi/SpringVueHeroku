<template>
  <div class="callback">
    <p>Logging in.. Please wait</p>
  </div>

</template>

<script>
export default {
  created() {
    this.$store.dispatch('handleWebAuth')
      .then(result => {
        this.$router.push(result.appState.target || '/');
      })
      .catch(error => {
        console.log('Call back error: ');
        console.log(error);
      });

    // this.$auth.handleAuthentication();
  },
  // methods: {
  //   handleLoginEvent(data) {
  //     this.$router.push(data.state.target || '/');
  //   }
  // },
};
</script>
