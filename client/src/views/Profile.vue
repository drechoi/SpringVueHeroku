<!-- src/views/Profile.vue -->

<template>
  <div v-if="profile">
    <div>
      <div>
        <img :src="profile.picture">
      </div>
      <div>
        <h2>{{ profile.name }}</h2>
        <p>{{ profile.email }}</p>
      </div>
    </div>
    <div>
      <pre>{{ JSON.stringify(profile, null, 2) }}</pre>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      profile: this.$store.state.auth.profile
    };
  },
  methods: {
    handleLoginEvent(data) {
      this.profile = data.profile;
    }
  },
  computed: {
    // profile: $store.state.auth.profile
  }
};
</script>
<style module>
  .tmp {
    color: orange;
  }
</style>
