<template>
  <div>
    This is Home...
    <b-card-group>
      <b-card title="store.state">
        {{$store.state}}
      </b-card>
      <b-card title="store.state.wish">
        {{$store.state.wish}}
      </b-card>
      <b-card title="Local">
        <p>local: {{ tmpValue }}</p>
        <p>Value: {{ $store.state.someValue }}</p>
        <p>Value minus ten: {{ $store.getters.someValueMinusTen }}</p>
        <b-button @click="increment">increment</b-button>
        <b-button @click="showAlert">Click</b-button>
      </b-card>
      <b-card title="$auth">
        {{$auth}}
      </b-card>
    </b-card-group>
  </div>
</template>

<script>

export default {
  data() {
    return {
      tmpValue: this.$store.state.someValue
    };
  },
  methods: {
    showAlert() {
      this.$store.dispatch('test');
      this.tmpValue++;
    },
    increment() {
      this.$store.commit('increment');
    }
  }
};
</script>
